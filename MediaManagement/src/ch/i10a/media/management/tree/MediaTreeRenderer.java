package ch.i10a.media.management.tree;

import java.io.File;

import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

public class MediaTreeRenderer implements TreeitemRenderer {

	@Override
	public void render(Treeitem item, Object data) throws Exception {
		File file = (File) data;
		Treecell cell = new Treecell(file.getName());
		Treerow tr = null;
		if (item.getTreerow() == null) {
			tr = new Treerow();
			tr.setParent(item);
		} else {
			tr = item.getTreerow();
			tr.getChildren().clear();
		}
		cell.setParent(tr);
		item.setOpen(false);
	}

}
