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

/**
 * Represents the door opened state
 *
 */
public class AcceleratorState extends AutomobileState implements AccelerateListener {
	private static AcceleratorState instance;

	private AcceleratorState() {
		instance = this;
	}

	@Override
	public void leave() {
		AcceleratorManager.instance().removeAccelerateListener(this);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static AcceleratorState instance() {
		if (instance == null) {
			instance = new AcceleratorState();
		}
		return instance;
	}

	/**
	 * Process door closed event
	 */
	@Override
	public void accelerate(AccelerateEvent event) {
		context.changeCurrentState(AcceleratorState.instance());

	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		AcceleratorManager.instance().addAccelerateListener(this);
		display.gearInPark();
		display.stopped();
		display.powerOff();
		display.displayTimeRemaining(0);
	}

}
