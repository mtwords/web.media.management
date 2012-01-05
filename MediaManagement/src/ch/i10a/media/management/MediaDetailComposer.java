package ch.i10a.media.management;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.api.Combobox;

import ch.i10a.media.database.dao.DaoFactory;
import ch.i10a.media.database.dao.IDao;

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

	// Data
	

	public MediaDetailComposer() {
		// TODO: Laden des entsprechenden Films
		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.load();
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// TODO: Initialisations
	}
}
