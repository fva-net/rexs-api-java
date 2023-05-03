package info.rexs.cli.global;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Console;

@Service
public class VersionOptionServiceImpl {

	@Autowired private MessageSource messageSource;

	public void printVersionInfo(Console console) {
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
