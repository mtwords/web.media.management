package ch.i10a.media.management;

import java.util.Map;

import org.zkoss.image.Image;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Combobox;

import ch.i10a.media.common.DBException;
import ch.i10a.media.common.ISystemConst;
import ch.i10a.media.database.MediaDTO;
import ch.i10a.media.database.dao.DaoFactory;
import ch.i10a.media.database.dao.IDao;
import ch.i10a.media.management.util.MediaManagementUtil;

/**
 * Class to handle, render and manage the site holding details about a media.
 * @author PK, OA
 *
 */
public class MediaDetailComposer extends GenericForwardComposer {

	// Components
	Iframe thumbnail;
	Label mediaName;
	Label mediaShortInfo;
	Textbox description;
	Textbox comment;
	Button edit;
	Label ratings;
	Combobox rateIt;
	Button playIt;
	MediaDTO mediaDTO;
	byte[] thumbnailByte;

	// Data
	

	public MediaDetailComposer() throws DBException {
		// TODO: Laden des entsprechenden Films
		Map<String, String> arguments = Executions.getCurrent().getArg();
		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		mediaDTO = (MediaDTO) dao.load(arguments.get(ISystemConst.PARAM_MEDIA_NAME));
		
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO: Initialisations
		mediaName.setValue(mediaDTO.getMovieRec().getTitle());
		description.setText(mediaDTO.getMovieRec().getDescription());
		thumbnailByte = mediaDTO.getMovieRec().getThumbnail();
		mediaShortInfo.setValue("Kategorie: " + mediaDTO.getMovieRec().getGenre() + "  " + 
				"Spieldauer: " + mediaDTO.getMovieRec().getDuration() + " min");
	}
	
	public void onClick$mediaDelete(){
		
		
	}
	
	public void onClick$edit(){
		
		MediaManagementUtil.updateMainContent(ISystemConst.PAGE_MAIN_ADDMEDIA_CONTENT, 
				mediaDTO.getMovieRec().getTitle());
		
	}
}
