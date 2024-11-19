package info.rexs.validation;

import java.util.ArrayList;
import java.util.List;

import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.schema.IRexsSchemaRegistry;
import info.rexs.schema.constants.RexsRelationRole;
import info.rexs.schema.constants.RexsVersion;

public class RexsModellingGuidelineQuasistaticRelationValidator extends RexsStandardRelationValidator {

	public RexsModellingGuidelineQuasistaticRelationValidator(RexsVersion rexsVersion) {
		super(rexsVersion);
	}

	public RexsModellingGuidelineQuasistaticRelationValidator(RexsVersion rexsVersion, IRexsSchemaRegistry rexsSchemaRegistry) {
		super(rexsVersion, rexsSchemaRegistry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsRelation rexsRelation, RexsModel rexsModel) {
		RexsValidationResult validationResult = super.validate(rexsRelation, rexsModel);
		List<RexsRelationRole> rolesOfRelationType = rexsRelation.getType().getRoles();
		int numRefs = rexsRelation.getRefs().size();
		int numRoles = rolesOfRelationType.size();
		if (numRefs!=numRoles) {
			List<RexsRelationRole> rolesInRelation = rexsRelation.getRefs().stream().map(RexsRelationRef::getRole).toList();
			List<String> messageList = new ArrayList<>();
			messageList.add(String.valueOf(rexsRelation.getId()));
			messageList.addAll(rolesOfRelationType.stream().filter(r -> !rolesInRelation.contains(r)).map(RexsRelationRole::getKey).toList());
			String[] additionalMessages = new String[messageList.size()];
			for (int i=0; i<messageList.size(); i++)
				additionalMessages[i] = messageList.get(i);
			validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_RELATION_MISSING_ROLES, additionalMessages);
		}

		return validationResult;
	}
}
