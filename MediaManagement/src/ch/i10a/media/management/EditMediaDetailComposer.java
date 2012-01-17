package ch.i10a.media.management;

import java.io.IOException;
import java.util.Map;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;


import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Combobox;

import ch.i10a.media.common.DBException;
import ch.i10a.media.common.ISystemConst;
import ch.i10a.media.common.UtilLib;
import ch.i10a.media.database.MediaDTO;
import ch.i10a.media.database.MovieRec;
import ch.i10a.media.database.dao.DaoFactory;
import ch.i10a.media.database.dao.IDao;

public class EditMediaDetailComposer extends GenericForwardComposer {
	
	// Components
	Iframe thumbnail;
	Combobox categorieChooser2;
	Button uploadButton;
	Button mediaDelete;
	Textbox description;
	MediaDTO mediaDTO;
	MediaDTO mediaDTO2;
	Button mediaSave;
	Textbox mediaName;
	Textbox mediaNameOri;
	Intbox year;
	Intbox movieTime;
	Textbox comment;
	Textbox searchKeys;
	byte[] buffer;
	
	// Data
	
	public EditMediaDetailComposer() throws DBException, IOException {
		// TODO: Laden des entsprechenden Films
//		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
//		dao.load(null);
		Map<String, String> arguments = Executions.getCurrent().getArg();
		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		mediaDTO2 = new MediaDTO();
		mediaDTO2 = (MediaDTO) dao.load(arguments.get(ISystemConst.PARAM_MEDIA_NAME));
		
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO: Initialisations
		buffer = new byte[16384];
		ListModelList model = new ListModelList();
        model.add("Action");
        model.add("Comedie");
        model.add("Thriller");
        model.add("Horror");
        model.add("Comedy");
        categorieChooser2.setModel(model);
		description.setText(mediaDTO2.getMovieRec().getDescription());
		mediaName.setText(mediaDTO2.getMovieRec().getTitle());
		movieTime.setValue(mediaDTO2.getMovieRec().getDuration());
		mediaNameOri.setText(mediaDTO2.getMovieRec().getOriginalTitle());
		//searchKeys.setText(mediaDTO2.getMovieRec().getSearchTerms()[0]);
	}
	
	public void onClick$mediaSave() throws IOException, DBException{
		
		mediaDTO = new MediaDTO();
		mediaDTO.getMovieRec().setTitle(mediaName.getText());
		mediaDTO.getMovieRec().setOriginalTitle(mediaNameOri.getText());
		mediaDTO.getMovieRec().setDuration(movieTime.getValue());
		mediaDTO.getMovieRec().setIcon(buffer);
		mediaDTO.getMovieRec().setThumbnail(buffer);
		mediaDTO.getMovieRec().setGenre(categorieChooser2.getText());
		mediaDTO.getMovieRec().setSearchTerms(new String[] {searchKeys.getText()});
		mediaDTO.getMovieRec().setDescription(description.getText());
		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.save(mediaDTO);
		
		
	}
	
	public void onClick$mediaDelete(){
		
		
	}
	public void onUpload$uploadButton(UploadEvent event){
		
		Media media = event.getMedia();
		buffer =media.getByteData();
		thumbnail.setContent(media);
		
	}
}
