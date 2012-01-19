package ch.i10a.media.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Class for general and reusable helpers.
 * 
 * @author oliver
 */
public class UtilLib {

	/**
	 * Converts a string array to one string
	 * @param String Array for conversion
	 * @return converted String
	 */
	public static String convertArrayToString(String[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i < (array.length - 1)) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	/**
	 * Converts a string to a String Array. Uses ',' as a delimiter
	 * @param String to convert
	 * @return String array delimited by ','
	 */
	public static String[] convertStringToArray(String s) {
		return s.split(",");
	}

	/**
	 * Converts a string from UTF to ISO codepage
	 * @param s String to convert
	 * @return ISO converted string
	 * @throws UnsupportedEncodingException
	 */
	public static String convertUTFStringToISO(String s) throws UnsupportedEncodingException {
		Charset iso88591charset = Charset.forName("ISO-8859-1");

		String isoString = new String(s.getBytes(iso88591charset), iso88591charset);
		// Finally remove UTF-16-BOM which was replaced by '?'!
		return isoString.substring(1);
	}

	/**
	 * Converts a string a byte array
	 * @param filePath String to convert
	 * @return converted byte array
	 * @throws IOException
	 */
	public static byte[] convertToByteArray(String filePath) throws IOException {
		return convertToByteArray(new FileInputStream(new File(filePath)));
	}
	/**
	 * Converts an InputStream to a byte array
	 * @param fileIs Inputstream for reading
	 * @return converted byte array
	 * @throws IOException
	 */
	public static byte[] convertToByteArray(InputStream fileIs) throws IOException {
		ByteArrayOutputStream byteArrOs = new ByteArrayOutputStream();

		byte[] buffer = new byte[16384];
		for (int len = fileIs.read(buffer); len > 0; len = fileIs
				.read(buffer)) {
			byteArrOs.write(buffer, 0, len);
		}
		fileIs.close();

		return byteArrOs.toByteArray();
	}

}
