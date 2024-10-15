/*
 * Copyright (C) 2024 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.rexs.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import info.rexs.schema.RexsSchemaRegistry;
import info.rexs.schema.IRexsSchemaRegistry;
import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsRelationRole;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.jaxb.AllowedCombinationRole;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;

/**
 * This implementation of {@link IRexsRelationValidator} validates the basic structure of a REXS relation
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardRelationValidator extends DefaultRexsRelationValidator {

	protected final IRexsSchemaRegistry rexsSchemaRegistry;

	protected final RexsVersion rexsVersion;

	public RexsStandardRelationValidator(RexsVersion rexsVersion) {
		this(rexsVersion, RexsSchemaRegistry.getInstance());
	}

	public RexsStandardRelationValidator(RexsVersion rexsVersion, IRexsSchemaRegistry rexsSchemaRegistry) {
		Objects.nonNull(rexsSchemaRegistry);
		this.rexsVersion = rexsVersion;
		this.rexsSchemaRegistry = rexsSchemaRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsRelation rexsRelation, RexsModel rexsModel) {
		RexsValidationResult validationResult = super.validate(rexsRelation, rexsModel);

		validationResult.add(checkIfRolesAreValidForTheRelationType(rexsRelation));

		if (rexsVersion == null)
			return validationResult;

		if (rexsSchemaRegistry.hasRelationTypes(rexsVersion))
			validationResult.add(checkIfIsAllowedCombination(rexsRelation, rexsModel));

		return validationResult;
	}

	private RexsValidationResult checkIfIsAllowedCombination(RexsRelation rexsRelation, RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		try {
			List<List<AllowedCombinationRole>> listOfAllowedCombinations = rexsSchemaRegistry.getAllowedCombinationsForRelation(rexsVersion, rexsRelation.getType());

			Map<RexsRelationRole, RexsComponentType> mapRoleToComponentType = new HashMap<>();
			for (RexsRelationRef ref : rexsRelation.getRefs())
				mapRoleToComponentType.put(ref.getRole(), rexsModel.getComponent(ref.getId()).getType());

			for (List<AllowedCombinationRole> allowedCombination : listOfAllowedCombinations) {
				if (allowedCombinationMatches(allowedCombination, mapRoleToComponentType))
					return validationResult;
			}

			validationResult.addError(RexsValidationResultMessageKey.RELATION_NOT_ALLOWED_COMBINATION, String.valueOf(rexsRelation.getId()), rexsRelation.getType().getKey(), translateRelationForMessage(rexsRelation, rexsModel));
		}
		catch (IllegalArgumentException ex) {
			validationResult.addError(RexsValidationResultMessageKey.CAUGHT_EXCEPTION, ex.getMessage());
		}

		return validationResult;
	}

	private String translateRelationForMessage(RexsRelation rexsRelation, RexsModel rexsModel) {
		StringBuilder builder = new StringBuilder();
		for (RexsRelationRef ref : rexsRelation.getRefs()) {
			builder.append(ref.getRole());
			builder.append("=");
			builder.append(rexsModel.getComponent(ref.getId()).toString());
			builder.append(";  ");
		}
		return builder.toString();
	}

	private boolean allowedCombinationMatches(List<AllowedCombinationRole> allowedCombination, Map<RexsRelationRole, RexsComponentType> mapRoleToComponentType) {
		for (RexsRelationRole role : mapRoleToComponentType.keySet()) {
			Optional<String> allowedComponentTypeForRole = allowedCombination.stream().filter(a -> a.getRoleId().equals(role.getKey())).map(a -> a.getComponentId()).findFirst();
			if (allowedComponentTypeForRole.isEmpty() || !allowedComponentTypeForRole.get().equals(mapRoleToComponentType.get(role).getId()))
				return false;
		}
		return true;
	}

	private RexsValidationResult checkIfRolesAreValidForTheRelationType(RexsRelation rexsRelation) {
		RexsValidationResult validationResult = new RexsValidationResult();

		List<RexsRelationRole> rolesOfRelation = rexsRelation.getType().getRoles();
		for (RexsRelationRef ref : rexsRelation.getRefs()) {
			if (!rolesOfRelation.contains(ref.getRole()))
				validationResult.addError(RexsValidationResultMessageKey.RELATION_ROLE_INVALID_FOR_RELATION_TYPE, ref.getRole().getKey(), rexsRelation.getType().getKey());
		}

		return validationResult;
	}
}
