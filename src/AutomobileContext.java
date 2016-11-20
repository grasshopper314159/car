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
 * The context is an obserer for the clock and stores the context info for
 * states
 *
 */
public class AutomobileContext {
	private static AutomobileDisplay microwaveDisplay;
	private AutomobileState currentState;
	private static AutomobileContext instance;

	/**
	 * Make it a singleton
	 */
	private AutomobileContext() {
		instance = this;
		microwaveDisplay = AutomobileDisplay.instance();
		currentState = PowerOnState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static AutomobileContext instance() {
		if (instance == null) {
			instance = new AutomobileContext();
		}
		return instance;
	}

	/**
	 * lets door closed state be the starting state adds the object as an
	 * observable for clock
	 */
	public void initialize() {
		instance.changeCurrentState(PowerOffState.instance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentState(AutomobileState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.run();
	}

	/**
	 * Gets the display
	 * 
	 * @return the display
	 */
	public AutomobileDisplay getDisplay() {
		return microwaveDisplay;
	}
}