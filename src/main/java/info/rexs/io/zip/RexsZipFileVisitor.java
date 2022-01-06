/*******************************************************************************
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
 ******************************************************************************/
package info.rexs.io.zip;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import info.rexs.io.RexsIoFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RexsZipFileVisitor extends SimpleFileVisitor<Path> {

	private final Path root;

	@Getter
	private Path foundRexsFile = null;

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if (dir.toString().equals(root.toString()))
			return FileVisitResult.CONTINUE;
		// ignore directory - rexs file has to be located in the root directory of the zip archive
		return FileVisitResult.SKIP_SUBTREE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (RexsIoFormat format : RexsIoFormat.values()) {
			if (file.toString().endsWith("." + format.getEnding())) {
				foundRexsFile = file;
				return FileVisitResult.TERMINATE;
			}
		}
		return FileVisitResult.CONTINUE;
	}
}
