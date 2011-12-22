package ch.i10a.media.management;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class NavigationComposer extends GenericForwardComposer {

	Textbox searchBox;
	Combobox categorieChooser;
	Button searchBtn;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	public void onClick$searchBtn() {
		
	}

}
