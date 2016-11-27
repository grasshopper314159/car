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
public class DrivingState extends AutomobileState implements DriveRequestListener, TimerRanOutListener,
		TimerTickedListener, PowerOffListener, BrakeListener, AccelerateListener {
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
		TimerRanOutManager.instance().removeTimerRanOutListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
		AcceleratorManager.instance().removeAccelerateListener(this);
		BrakeManager.instance().removeBrakeListener(this);
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
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process door open request
	 */
	@Override
	public void powerOff(PowerOffEvent event) {
		context.changeCurrentState(PowerOffState.instance());
	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	@Override
	public void timerTicked(TimerTickedEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	@Override
	public void timerRanOut(TimerRanOutEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
		context.changeCurrentState(PowerOnState.instance());
	}

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
	public void run() {
		// PowerOffManager.instance().addPowerOffListener(this);
		// DriveRequestManager.instance().addDriveRequestListener(this);
		AcceleratorManager.instance().addAccelerateListener(this);
		BrakeManager.instance().addBrakeListener(this);
		TimerRanOutManager.instance().addTimerRanOutListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		display.gearInDrive();
		// Timer.instance().setTimeValue(10);
		display.startDriving();
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

}