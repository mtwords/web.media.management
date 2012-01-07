package ch.i10a.media.management;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import ch.i10a.media.common.ISystemConst;
import ch.i10a.media.management.util.MediaManagementUtil;

public class NavigationComposer extends GenericForwardComposer {

	Textbox searchBox;
	Combobox categorieChooser;
	Button searchBtn;
	Toolbarbutton tbHistory;
	Toolbarbutton tbHome;
	Toolbarbutton tbMedia;
	Comboitem ciAction;
	
	

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		ListModelList model = new ListModelList();
        model.add("Action");
        model.add("Comedie");
        model.add("Thriller");
        model.add("Horror");
        model.add("Comedy");
        categorieChooser.setModel(model);
		
	}
	
	public void onClick$tbHome(){
		
		MediaManagementUtil.updateMainContent(ISystemConst.PAGE_MAIN_START_CONTENT);
	}
	
	public void onClick$tbMedia(){
		
		MediaManagementUtil.updateMainContent(ISystemConst.PAGE_MAIN_ADDMEDIA_CONTENT);
	}
	
	public void onClick$tbHistory(){
		
		MediaManagementUtil.updateMainContent(ISystemConst.PAGE_MAIN_START_CONTENT);
	}
	
	public void onClick$searchBtn() {
		
		searchBox.setText("Film wird gesucht. Kategorie: " + categorieChooser.getValue());
		
		//MediaManagementUtil.updateMainContent();
	}

}
