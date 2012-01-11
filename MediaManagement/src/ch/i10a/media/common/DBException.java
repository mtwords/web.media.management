package ch.i10a.media.common;

import org.zkoss.util.resource.Labels;

public class DBException extends Throwable {

	String translatedMessage;

	public DBException(String messageKey) {
		translatedMessage = Labels.getLabel(messageKey);
	}

	@Override
	public String getLocalizedMessage() {
		return translatedMessage;
	}
}
