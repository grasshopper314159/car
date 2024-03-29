package src;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class BrakeManager {

	private EventListenerList listenerList = new EventListenerList();
	private static BrakeManager instance;

	private BrakeManager() {
	}

	public static BrakeManager instance() {
		if (instance == null) {
			instance = new BrakeManager();
		}
		return instance;
	}

	public void addBrakeListener(BrakeListener listener) {
		listenerList.add(BrakeListener.class, listener);
	}

	public void removeBrakeListener(BrakeListener listener) {
		listenerList.remove(BrakeListener.class, listener);
	}

	public void processEvent(BrakeEvent event) {
		EventListener[] listeners = listenerList.getListeners(BrakeListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((BrakeListener) listeners[index]).brake(event);
		}
	}
}
