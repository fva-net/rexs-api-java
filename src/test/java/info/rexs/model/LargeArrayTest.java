package info.rexs.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Random;

import org.json.JSONArray;
import org.junit.Test;

import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsFileWriter;
import info.rexs.model.jaxb.Array;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Components;
import info.rexs.model.jaxb.Model;

public class LargeArrayTest
{
	private static final Random random = new Random();
	private static final double rangeMin = 0.0;
	private static final double rangeMax = 1000.0;

	@Test
	public void testWriteLargeArrays() throws Exception
	{
		double[] array = generateTestArray();

		System.out.println("rexs standard:");
		Path path = Paths.get("C:/temp/test_standard.rexs");
		writeRexsFile(path, convertArrayToRexsStandard(array));
		Model model = readRexsFile(path);
		assertThat(parseRexsStandardToArray(model)).isEqualTo(array);

		System.out.println();

		System.out.println("base64:");
		path = Paths.get("C:/temp/test_base64.rexs");
		writeRexsFile(path, convertArrayToBase64(array));
		model = readRexsFile(path);
		assertThat(parseBase64ToArray(model)).isEqualTo(array);

		System.out.println();

		System.out.println("json:");
		path = Paths.get("C:/temp/test_json.rexs");
		writeRexsFile(path, convertArrayToJson(array));
		model = readRexsFile(path);
		assertThat(parseJsonToArray(model)).isEqualTo(array);
	}

	private void writeRexsFile(Path pathToRexsFile, Object arrayObject) throws Exception
	{
		Instant start = Instant.now();

		Attribute attribute = new Attribute();
		attribute.setId("bla_bla");
		attribute.getContent().add(arrayObject);

		Component component = new Component();
		component.getAttribute().add(attribute);
		Components components = new Components();
		components.getComponent().add(component);
		Model model = new Model();
		model.setComponents(components);

		RexsFileWriter rexsFileWriter = new RexsFileWriter(pathToRexsFile);
		rexsFileWriter.writeRawModel(model);

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- write file: " + getTimeFromDuration(duration));
	}

	private Model readRexsFile(Path pathToRexsFile) throws Exception
	{
		Instant start = Instant.now();

		RexsFileReader rexsFileReader = new RexsFileReader(pathToRexsFile);
		Model model = rexsFileReader.readRawModel();

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- read file: " + getTimeFromDuration(duration));

		return model;
	}

	private double[] generateTestArray()
	{
//		double[] array = new double[280000];
		double[] array = new double[5000000];

		for (int i=0; i<array.length; i++)
		{
			double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
			array[i] = randomValue;
		}

		return array;
	}

	private Array convertArrayToRexsStandard(double[] array)
	{
		Instant start = Instant.now();

		Array rexsArray = new Array();

		for (double arrayValue : array)
		{
			rexsArray.getC().add(arrayValue + "");
		}

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- convert array: " + getTimeFromDuration(duration));

		return rexsArray;
	}

	private double[] parseRexsStandardToArray(Model model)
	{
		Instant start = Instant.now();

		Array rexsArray = (Array)model.getComponents().getComponent().get(0).getAttribute().get(0).getContent().get(1);
		double[] array = new double[rexsArray.getC().size()];

		for (int i = 0; i < rexsArray.getC().size(); i++)  {
			array[i] = Double.parseDouble(rexsArray.getC().get(i));
		}

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- parse array: " + getTimeFromDuration(duration));

		return array;
	}

	private String convertArrayToBase64(double[] array)
	{
		Instant start = Instant.now();

		String rexsArray = encodeLocation(array);

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- convert array: " + getTimeFromDuration(duration));

		return rexsArray;
	}

	private double[] parseBase64ToArray(Model model)
	{
		Instant start = Instant.now();

		String content = (String)model.getComponents().getComponent().get(0).getAttribute().get(0).getContent().get(0);
		double[] array = decodeLocation(content);

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- parse array: " + getTimeFromDuration(duration));

		return array;
	}

	private String convertArrayToJson(double[] array)
	{
		Instant start = Instant.now();

		JSONArray jsonArray = new JSONArray(array);
		String rexsArray = jsonArray.toString();

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- convert array: " + getTimeFromDuration(duration));

		return rexsArray;
	}

	private double[] parseJsonToArray(Model model)
	{
		Instant start = Instant.now();

		String content = (String)model.getComponents().getComponent().get(0).getAttribute().get(0).getContent().get(0);
		JSONArray jsonArray = new JSONArray(content);
		double[] array = new double[jsonArray.length()];

		for (int i = 0; i < jsonArray.length(); i++)  {
			array[i] = jsonArray.getDouble(i);
		}

		Instant end = Instant.now();
		Duration duration = Duration.between(start, end);
		System.out.println("- parse array: " + getTimeFromDuration(duration));

		return array;
	}

	private String getTimeFromDuration(Duration duration)
	{
		return String.format("%s s, %s ns", duration.getSeconds(), duration.getNano());
	}

	private static String encodeLocation(double[] doubleArray) {
        return Base64.getEncoder().encodeToString(doubleToByteArray(doubleArray));
    }
    private static double[] decodeLocation(String base64Encoded) {
        return byteToDoubleArray(Base64.getDecoder().decode(base64Encoded));
    }
    private static byte[] doubleToByteArray(double[] doubleArray) {
        ByteBuffer buf = ByteBuffer.allocate(Double.SIZE / Byte.SIZE * doubleArray.length);
        buf.asDoubleBuffer().put(doubleArray);
        return buf.array();
    }
    private static double[] byteToDoubleArray(byte[] bytes) {
        DoubleBuffer buf = ByteBuffer.wrap(bytes).asDoubleBuffer();
        double[] doubleArray = new double[buf.limit()];
        buf.get(doubleArray);
        return doubleArray;
    }
}
