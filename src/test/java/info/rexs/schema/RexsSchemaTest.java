package info.rexs.schema;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

public class RexsSchemaTest {

	@Test
	public void openInputStream_everySchemaHasContent() throws Exception {
		for (RexsSchema rexsSchema : RexsSchema.values()) {
			try (InputStream input = rexsSchema.openInputStream()) {
				assertThat(input.available()).isPositive();
			}
		}
	}
}
