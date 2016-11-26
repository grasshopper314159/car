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

public class DriveRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static DriveRequestManager instance;

	private DriveRequestManager() {
	}

	public static DriveRequestManager instance() {
		if (instance == null) {
			instance = new DriveRequestManager();
		}
		return instance;
	}

	public void addDriveRequestListener(DriveRequestListener listener) {
		listenerList.add(DriveRequestListener.class, listener);
	}

	public void removeDriveRequestListener(DriveRequestListener listener) {
		listenerList.remove(DriveRequestListener.class, listener);
	}

	public void processEvent(DriveRequestEvent event) {
		EventListener[] listeners = listenerList.getListeners(DriveRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((DriveRequestListener) listeners[index]).driveRequested(event);
		}
	}
}
