package ch.i10a.media.management.tree;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.zkoss.zul.DefaultTreeNode;

public class MediaTreeNode extends DefaultTreeNode {

	public MediaTreeNode(Object data) {
		super(data);
	}

	MediaTreeNode(Object data, Collection<File> children) {
		super(data, children);
	}

	@Override
	public List getChildren() {
		return super.getChildren();
	}
}