package ch.i10a.media.management.util;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;

public class MediaManagementUtil {

	public static void updateMainContent() {
		Executions.createComponents("/pages/mainStartContent.zul", Path.getComponent("//desktop/main/mainContent"), null);
	}
}
