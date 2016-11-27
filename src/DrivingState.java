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
 * Represents the cooking state.
 *
 */
public class DrivingState extends AutomobileState implements DriveRequestListener, BrakeListener, AccelerateListener,
		ParkListener, PowerOnListener, PowerOffListener {
	private static DrivingState instance;

	/**
	 * Private for the singleton pattern
	 */
	private DrivingState() {
		instance = this;
	}

	/**
	 * Removes as a listener from all managers
	 * 
	 */
	@Override
	public void leave() {
		DriveRequestManager.instance().removeDriveRequestListener(this);
		PowerOnManager.instance().removePowerOnListener(this);
		PowerOffManager.instance().removePowerOffListener(this);
		// TimerRanOutManager.instance().removeTimerRanOutListener(this);
		// TimerTickedManager.instance().removeTimerTickedListener(this);
		AcceleratorManager.instance().removeAccelerateListener(this);
		ParkManager.instance().removeParkListener(this);
		// BrakeManager.instance().removeBrakeListener(this);
		// ParkManager.instance().removeParkListener(this);
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static DrivingState instance() {
		if (instance == null) {
			instance = new DrivingState();
		}
		return instance;
	}

	/**
	 * Process Cook request
	 */
	@Override
	public void driveRequested(DriveRequestEvent event) {
		// Timer.instance().addTimeValue(10);

	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * dosplays
	 * 
	 */
	@Override
	public void brake(BrakeEvent event) {
		// TODO Auto-generated method stub
		context.changeCurrentState(BrakeState.instance());
	}

	@Override
	public void accelerate(AccelerateEvent event) {
		// TODO Auto-generated method stub
		context.changeCurrentState(AcceleratorState.instance());

	}

	@Override
	public void park(ParkEvent event) {
		// TODO Auto-generated method stub
		context.changeCurrentState(ParkState.instance());
	}

	@Override
	public void powerOff(PowerOffEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void powerOn(PowerOnEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		Timer.instance().setTimeValue(0);
		AcceleratorManager.instance().addAccelerateListener(this);
		BrakeManager.instance().addBrakeListener(this);
		ParkManager.instance().addParkListener(this);
		display.gearInDrive();

	}

}