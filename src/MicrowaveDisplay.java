
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
import java.util.Observable;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public abstract class MicrowaveDisplay extends Observable {
	protected static MicrowaveContext context;
	protected static MicrowaveDisplay instance;

	/**
	 * Initializes the context and instance
	 */
	protected MicrowaveDisplay() {
		instance = this;
		context = MicrowaveContext.instance();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static MicrowaveDisplay instance() {
		return instance;
	}

	/**
	 * Do the initializations to make the context an observer
	 */
	public void initialize() {
		context.initialize();
	}

	public abstract void displayTimeRemaining(int time);

	/**
	 * Indicate that the light is on
	 */
	public abstract void turnLightOn();

	/**
	 * Indicate that the light is off
	 */
	public abstract void turnLightOff();

	/**
	 * Indicate that the door is now closed
	 */
	public abstract void doorClosed();

	/**
	 * Indicate that the door is now open
	 */
	public abstract void doorOpened();

	/**
	 * indicate that cooking has begun
	 */
	public abstract void startCooking();

	/**
	 * indicate that cooking has ended
	 */
	public abstract void notCooking();
}