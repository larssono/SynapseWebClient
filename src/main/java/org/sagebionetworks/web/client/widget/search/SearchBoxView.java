package org.sagebionetworks.web.client.widget.search;

import org.sagebionetworks.web.client.PlaceChanger;
import org.sagebionetworks.web.client.widget.SynapseWidgetView;

import com.google.gwt.user.client.ui.IsWidget;

public interface SearchBoxView extends IsWidget, SynapseWidgetView {

	/**
	 * Set the presenter.
	 * @param presenter
	 */
	public void setPresenter(Presenter presenter);

	/**
	 * resets the view to default state
	 */
	public void clear();

	/**
	 * Presenter interface
	 */
	public interface Presenter {

		void search(String value);
		
	}


}
