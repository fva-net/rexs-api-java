package info.rexs.validation;

import java.util.ArrayList;
import java.util.List;

import info.rexs.db.IDbModelRegistry;
import info.rexs.db.constants.RexsRelationRole;
import info.rexs.db.constants.RexsVersion;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;

public class RexsModellingGuidelineQuasistaticRelationValidator extends RexsStandardRelationValidator {

	public RexsModellingGuidelineQuasistaticRelationValidator(RexsVersion rexsVersion) {
		super(rexsVersion);
	}

	public RexsModellingGuidelineQuasistaticRelationValidator(RexsVersion rexsVersion, IDbModelRegistry dbModelRegistry) {
		super(rexsVersion, dbModelRegistry);
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
			List<RexsRelationRole> rolesInRelation = rexsRelation.getRefs().stream().map(r -> r.getRole()).toList();
			List<String> messageList = new ArrayList<>();
			messageList.add(String.valueOf(rexsRelation.getId()));
			messageList.addAll(rolesOfRelationType.stream().filter(r -> !rolesInRelation.contains(r)).map(r -> r.getKey()).toList());
			String[] additionalMessages = new String[messageList.size()];
			for (int i=0; i<messageList.size(); i++)
				additionalMessages[i] = messageList.get(i);
			validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_RELATION_MISSING_ROLES, additionalMessages);
		}

		return validationResult;
	}
}
