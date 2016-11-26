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

public class AcceleratorManager {
	private EventListenerList listenerList = new EventListenerList();
	private static AcceleratorManager instance;

	private AcceleratorManager() {
	}

	public static AcceleratorManager instance() {
		if (instance == null) {
			instance = new AcceleratorManager();
		}
		return instance;
	}

	public void addAccelerateListener(AccelerateListener listener) {
		listenerList.add(AccelerateListener.class, listener);
	}

	public void processEvent(AccelerateEvent event) {
		EventListener[] listeners = listenerList.getListeners(AccelerateListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((AccelerateListener) listeners[index]).Accelerate(event);
		}
	}

	public void removeAccelerateListener(AcceleratorState listener) {
		// TODO Auto-generated method stub
		listenerList.remove(AccelerateListener.class, listener);
	}
}
