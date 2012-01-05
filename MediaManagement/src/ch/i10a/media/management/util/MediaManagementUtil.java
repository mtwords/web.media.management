package ch.i10a.media.management.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zul.Div;

import ch.i10a.media.common.ISystemConst;

public class MediaManagementUtil {

	public static void updateMainContent() {
		updateMainContent(ISystemConst.PAGE_MAIN_START_CONTENT, null);
	}
	public static void updateMainContent(String sitePath) {
		updateMainContent(sitePath, null);
	}
	public static void updateMainContent(String sitePath, String param) {
		Div mainContent = (Div) Path.getComponent(ISystemConst.PATH_MAIN_CONTENT);
		if (mainContent != null) {
			removeAllChildren(mainContent);
		}
		HashMap<String, String> params = null;
		if (param != null) {
			params = new HashMap<String, String>();
			params.put(ISystemConst.PARAM_MEDIA_NAME, param);
		}
		Executions.createComponents(sitePath, Path.getComponent("//desktop/main/mainContent"), params);
	}

	private static void removeAllChildren(Component comp) {
		List<Component> children = comp.getChildren();
		for (int i = 0; i < children.size(); i++) {
			Component child = children.get(i);
			child.setId(null);
			child.setParent(null);
			child.detach();
			child = null;
		}
	}
}
