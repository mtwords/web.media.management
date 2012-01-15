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
	public static String[] convertStringToArray(String s) {
		return s.split(",");
	}

	public static String convertUTFStringToISO(String s) throws UnsupportedEncodingException {
		Charset iso88591charset = Charset.forName("ISO-8859-1");

		String isoString = new String(s.getBytes(iso88591charset), iso88591charset);
		// Finally remove UTF-16-BOM which was replaced by '?'!
		return isoString.substring(1);
	}

	public static byte[] convertToByteArray(String filePath) throws IOException {
		return convertToByteArray(new FileInputStream(new File(filePath)));
	}
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
