/*
 * Copyright (C) 2020 FVA GmbH
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
package info.rexs.model.transformer;

import info.rexs.model.RexsModel;

/**
 * This interface describes a transformer between a REXS model as {@link RexsModel} and any other model.
 *
 * @author FVA GmbH
 */
public interface IRexsModelTransformer<E> {

	/**
	 * Transforms a REXS model as {@link RexsModel} to a foreign model.
	 *
	 * @param model
	 * 				The REXS model to transform as a {@link RexsModel}.
	 *
	 * @return
	 * 				The REXS model in the foreign model.
	 */
	public E transform(RexsModel model);

	/**
	 * Transforms a foreign model to a REXS model.
	 *
	 * @param model
	 * 				The foreign model to transform.
	 *
	 * @return
	 * 				The REXS model as a {@link RexsModel}.
	 */
	public RexsModel transform(E model);
}
