/**
 *
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010

 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - the use is for academic purpose only
 * - Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * - Neither the name of Brahma Dathan or Sarnath Ramnath
 * may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in
 this module
 * and are not responsible for any loss or damage resulting from its use.
 */

/**
 * Represents the door opened state
 *
 */
public class BrakeState extends AutomobileState implements AccelerateListener, ParkListener {
	private static BrakeState instance;

	private BrakeState() {
		instance = this;
	}

	public void leave() {
		AcceleratorManager.instance().removeAccelerateListener(instance);
		// change parameter to AccelerateListener in ln 51 from
		// acceleratormanager.java
		ParkManager.instance().removeParkListener(instance);
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static BrakeState instance() {
		if (instance == null) {
			instance = new BrakeState();
		}
		return instance;
	}

	/**
	 * handle accelerate event
	 * 
	 */
	@Override
	public void accelerate(AccelerateEvent event) {
		context.changeCurrentState(AcceleratorState.instance());
	}

	/**
	 * handle park event
	 * 
	 */
	@Override
	public void park(ParkEvent event) {
		context.changeCurrentState(ParkState.instance());
	}

	/**
	 * Initialize the state
	 */
	public void run() {
		BrakeManager.instance().addBrakeListener(this);
		// display.turnLightOn();
		// display.notCooking();
		display.powerOn();
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

}

// TEST
