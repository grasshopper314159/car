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
public class DrivingState extends AutomobileState
		implements DriveRequestListener, TimerRanOutListener, TimerTickedListener, PowerOffListener {
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
	public void leave() {
		DriveRequestManager.instance().removeDriveRequestListener(this);
		TimerRanOutManager.instance().removeTimerRanOutListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
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
	public void driveRequested(DriveRequestEvent event) {
		Timer.instance().addTimeValue(10);
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process door open request
	 */
	public void powerOff(PowerOffEvent event) {
		context.changeCurrentState(PowerOffState.instance());
	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void timerTicked(TimerTickedEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void timerRanOut(TimerRanOutEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
		context.changeCurrentState(PowerOnState.instance());
	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * dosplays
	 * 
	 */
	public void run() {
		PowerOffManager.instance().addPowerOffListener(this);
		DriveRequestManager.instance().addDriveRequestListener(this);
		TimerRanOutManager.instance().addTimerRanOutListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		display.turnLightOn();
		Timer.instance().setTimeValue(10);
		display.startCooking();
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}
}