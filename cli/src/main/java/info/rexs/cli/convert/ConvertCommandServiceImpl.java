package info.rexs.cli.convert;

import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Console;

@Service
public class ConvertCommandServiceImpl {

	public void convert(Console console, ConvertOptions options) {
		console.println("convert " + options.getFile());
		console.println(" Version: " + options.getTargetVersion());
	}
}
