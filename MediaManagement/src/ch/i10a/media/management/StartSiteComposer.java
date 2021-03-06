package ch.i10a.media.management;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.api.Grid;

import ch.i10a.media.management.util.MediaManagementUtil;

public class StartSiteComposer extends GenericForwardComposer {

	/*
	 * Definition der Komponenten. Name muss sich mit der jeweiligen "id" des Elements decken. 
	 */
	Grid stateGrid;
	Label numOfMovies;
	Label numOfSeries;
	Label numOfEpisodes;
	Grid historyGrid;

	// Data
	

	public StartSiteComposer() {
		/*
		 * Hier kann noch nicht auf GUI-Komponenten zugegriffen werden, 
		 * da diese noch nicht erstellte wurden!
		 * Siehe doAfterCompose(...)
		 * Daten hingegen sollten hier geladen / initialisiert werden.
		 */
	}

	/*
	 * Ab hier wurden die Komponenten initialisiert und es kann darauf zugegriffen
	 * werden. Des Weiteren wurden bereits EventListener hinzugefügt.
	 * Z.B. muss bei einem Button NICHT wie bei Swing zuerst addActionListener()
	 * aufgerufen werden.
	 * @see org.zkoss.zk.ui.util.GenericForwardComposer#doAfterCompose(org.zkoss.zk.ui.Component)
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		MediaManagementUtil.updateMainContent();
	}

	/*
	 * Events können wie folgt behandelt werden. Je nach Komponente
	 * existieren logischerweise andere Events wie onSelect, onChange, ...
	 * Der Ausdruck nach dem $-Zeichen muss sich mit der "id" der Komponente
	 * decken!
	 */
	public void onClick$button(Event e) {
	}
}
