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

public class TimerRanOutManager {
	private EventListenerList listenerList = new EventListenerList();
	private static TimerRanOutManager instance;

	private TimerRanOutManager() {
	}

	public static TimerRanOutManager instance() {
		if (instance == null) {
			instance = new TimerRanOutManager();
		}
		return instance;
	}

	public void addTimerRanOutListener(TimerRanOutListener listener) {
		listenerList.add(TimerRanOutListener.class, listener);
	}

	public void removeTimerRanOutListener(TimerRanOutListener listener) {
		listenerList.remove(TimerRanOutListener.class, listener);
	}

	public void processEvent(TimerRanOutEvent event) {
		EventListener[] listeners = listenerList.getListeners(TimerRanOutListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((TimerRanOutListener) listeners[index]).timerRanOut(event);
		}
	}
}
