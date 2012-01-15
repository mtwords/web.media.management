package ch.i10a.media.common;

import java.sql.SQLException;

import org.zkoss.util.resource.Labels;

public class DBException extends Throwable {

	String translatedMessage;

	public DBException(String messageKey) {
		translatedMessage = Labels.getLabel(messageKey);
	}

	public DBException(String messageKey, SQLException ex) {
		super(ex);
		translatedMessage = Labels.getLabel(messageKey);
	}

	@Override
	public String getLocalizedMessage() {
		return translatedMessage;
	}
}
