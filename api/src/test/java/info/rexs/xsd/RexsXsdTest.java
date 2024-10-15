package info.rexs.xsd;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

public class RexsXsdTest {

	@Test
	public void openInputStream_everySchemaHasContent() throws Exception {
		for (RexsXsd rexsXsd : RexsXsd.values()) {
			try (InputStream input = rexsXsd.openInputStream()) {
				assertThat(input.available()).isPositive();
			}
		}
	}
}
