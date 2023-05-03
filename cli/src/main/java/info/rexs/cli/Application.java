package info.rexs.cli;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import info.rexs.cli.convert.ConvertCommandServiceImpl;
import info.rexs.cli.convert.ConvertOptions;
import info.rexs.cli.global.GlobalOptions;
import info.rexs.cli.global.VersionOptionServiceImpl;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final String PROGAM_NAME = "java -jar rexs-api.jar";
	private static final String COMMAND_CONVERT = "convert";

	@Autowired private VersionOptionServiceImpl versionOptionService;
	@Autowired private ConvertCommandServiceImpl convertCommandService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		var globalOptions = new GlobalOptions();
		var convertOptions = new ConvertOptions();

		var jcommander = JCommander.newBuilder()
			.addObject(globalOptions)
			.programName(PROGAM_NAME)
			.addCommand(COMMAND_CONVERT, convertOptions)
			.build();

		try
		{
			jcommander.parse(args);

			if (globalOptions.isVersion())
				versionOptionService.printVersionInfo(jcommander.getConsole());

			if (globalOptions.isHelp() || args == null || args.length < 1)
				jcommander.usage();

			if (StringUtils.equals(jcommander.getParsedCommand(), COMMAND_CONVERT))
				convertCommandService.convert(jcommander.getConsole(), convertOptions);
		}
		catch (ParameterException ex)
		{
			jcommander.getConsole().println(ex.getMessage());
			jcommander.getConsole().println("\n");
			jcommander.usage();
		}
	}
}