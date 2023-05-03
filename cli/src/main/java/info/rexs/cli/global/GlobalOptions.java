package info.rexs.cli.global;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalOptions {

	@Parameter(
		names = {"--help", "-help", "-h", "-?"},
		description = "Prints the usage of the application")
	private boolean help = false;

	@Parameter(
		names = {"--version", "-version"},
		description = "Prints the version of the application")
	private boolean version = false;
}
