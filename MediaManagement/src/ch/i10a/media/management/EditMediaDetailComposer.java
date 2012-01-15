package ch.i10a.media.management;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;


import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Combobox;

import ch.i10a.media.common.DBException;
import ch.i10a.media.database.dao.DaoFactory;
import ch.i10a.media.database.dao.IDao;

public class EditMediaDetailComposer extends GenericForwardComposer {
	
	// Components
	Iframe thumbnail;
	Combobox categorieChooser2;
	Button uploadButton;
	Button mediaDelete;
	Textbox description;
	
	
	// Data
	
	public EditMediaDetailComposer() throws DBException {
		// TODO: Laden des entsprechenden Films
//		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
//		dao.load(null);
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO: Initialisations
		ListModelList model = new ListModelList();
        model.add("Action");
        model.add("Comedie");
        model.add("Thriller");
        model.add("Horror");
        model.add("Comedy");
        categorieChooser2.setModel(model);
	}
	
	public void onClick$mediaDelete(){
		description.setText("");
		
	}
	public void onUpload$uploadButton(UploadEvent event){
		Media media = event.getMedia();
		media.getByteData();
		thumbnail.setContent(media);
	}
		
		/* Media media = event.getMedia();
         if (media instanceof org.zkoss.image.Image) {
             org.zkoss.zul.Image image = new org.zkoss.zul.Image();
             image.setContent((Image) media);
             thumbnail.setParent(image);
             
         } else {
             Messagebox.show("Not an image: "+media, "Error", Messagebox.OK, Messagebox.ERROR);
             break;
         }
		*/
	
}
