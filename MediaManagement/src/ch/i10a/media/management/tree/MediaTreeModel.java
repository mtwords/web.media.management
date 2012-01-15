package ch.i10a.media.management.tree;

import java.io.File;

import org.zkoss.zul.AbstractTreeModel;

public class MediaTreeModel extends AbstractTreeModel {

	public MediaTreeModel(Object root) {
		super(root);
	}

	@Override
	public boolean isLeaf(Object node) {
		return !((File) node).isDirectory();
	}

	@Override
	public Object getChild(Object parent, int index) {
		File file = (File) parent;
		File[] files = file.listFiles();
		return files[index]; 
	}

	@Override
	public int getChildCount(Object parent) {
		File file = (File) parent;
		File[] files = file.listFiles();
		if (files != null) {
			return files.length; 
		} else {
			return 0;
		}
	}

}
