package ch.i10a.media.management;

import java.io.File;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;

import ch.i10a.media.common.ISystemConst;
import ch.i10a.media.management.tree.MediaTreeModel;
import ch.i10a.media.management.tree.MediaTreeRenderer;
import ch.i10a.media.management.util.MediaManagementUtil;

public class MediaTreeComposer extends GenericForwardComposer {

	// Components
	Tree mediaTree;

	// Data
	String rootPath;

	public MediaTreeComposer() {
		rootPath = Labels.getLabel(ISystemConst.APP_PROP_MEDIA_ROOT_DIR);
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		mediaTree.setModel(new MediaTreeModel(new File(rootPath)));
		mediaTree.setItemRenderer(new MediaTreeRenderer());
	}

	// ---------------- listeners ----------------
	public void onSelect$mediaTree(SelectEvent selectEvent) {
		Treeitem selectedItem = mediaTree.getSelectedItem();
		String mediaName = selectedItem.getLabel();
		MediaManagementUtil.updateMainContent(ISystemConst.PAGE_MAIN_MEDIA_CONTENT, mediaName);
	}
}
