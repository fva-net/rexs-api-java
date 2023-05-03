package info.rexs.cli;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.internal.Console;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final String PROGAM_NAME = "java -jar rexs-api.jar";

	@Autowired private MessageSource messageSource;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		var globalOptions = new GlobalOptions();

		var jcommander = JCommander.newBuilder()
			.addObject(globalOptions)
			.programName(PROGAM_NAME)
			.build();

		try
		{
			jcommander.parse(args);

			if (globalOptions.version)
				printVersionInfo(jcommander.getConsole());

			if (globalOptions.help || args == null || args.length < 1)
				jcommander.usage();
		}
		catch (ParameterException ex)
		{
			jcommander.getConsole().println(ex.getMessage());
			jcommander.getConsole().println("\n");
			jcommander.usage();
		}
	}

	static class GlobalOptions {

		@Parameter(names = {"--help", "-help", "-h", "-?"}, description = "Prints the usage of the application")
		public boolean help = false;

		@Parameter(names = {"--version", "-version"}, description = "Prints the version of the application")
		public boolean version = false;
	}

	private void printVersionInfo(Console console) {
		Locale currentLocale = LocaleContextHolder.getLocale();

		String name = messageSource.getMessage("application.name", null, currentLocale);
		String version = messageSource.getMessage("application.version", null, currentLocale);
		String vendor = messageSource.getMessage("application.vendor", null, currentLocale);
		String revision = messageSource.getMessage("application.revision", null, currentLocale);
		String buildDate = messageSource.getMessage("application.buildDate", null, currentLocale);

		String versionText = messageSource.getMessage("version.text", new String[] {name, version, vendor, revision, buildDate}, currentLocale);
		console.println(versionText);
	}
}