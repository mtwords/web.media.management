package ch.i10a.media.common;

import java.sql.SQLException;



import org.zkoss.util.resource.Labels;

public class DBException extends Throwable {

	String translatedMessage;

	/**
	 * Constructor for Database Exception
	 * @param messageKey: original messagekey for translating
	 */
	public DBException(String messageKey) {
		translatedMessage = Labels.getLabel(messageKey);
	}

	/**
	 * Constructor for Database Exception
	 * @param messageKey: original messagekey for translating
	 * @param ex: Exception object 
	 */
	public DBException(String messageKey, SQLException ex) {
		super(ex);
		translatedMessage = Labels.getLabel(messageKey);
	}

	@Override
	/**
	 * Method to return the translated message
	 */
	public String getLocalizedMessage() {
		return translatedMessage;
	}
}
