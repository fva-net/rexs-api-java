/*******************************************************************************
 * Copyright (C) 2023 FVA GmbH
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
 ******************************************************************************/
package info.rexs.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ByteArrayResource implements Resource {

	private final byte[] byteArray;

	private final String filename;

	@Override
	public InputStream openInputStream() throws IOException {
		return new ByteArrayInputStream(this.byteArray);
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public long getContentLength() throws IOException {
		return this.byteArray.length;
	}

	@Override
	public String getFilename() {
		return filename;
	}
}
