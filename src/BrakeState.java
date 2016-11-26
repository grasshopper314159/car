//**
// * 
// * @author Brahma Dathan and Sarnath Ramnath
// * @Copyright (c) 2010
// 
// * Redistribution and use with or without
// * modification, are permitted provided that the following conditions
// * are met:
// *
// *   - the use is for academic purpose only
// *   - Redistributions of source code must retain the above copyright
// *     notice, this list of conditions and the following disclaimer.
// *   - Neither the name of Brahma Dathan or Sarnath Ramnath
// *     may be used to endorse or promote products derived
// *     from this software without specific prior written permission.
// *
// * The authors do not make any claims regarding the correctness of the code in this module
// * and are not responsible for any loss or damage resulting from its use.  
// */
//
///**
// * Represents the door opened state
// *
// */
//public class BrakeState extends MicrowaveState implements DoorCloseListener {
//	private static BrakeState instance;
//
//	private BrakeState() {
//		instance = this;
//	}
//
//	public void leave() {
//		DoorCloseManager.instance().removeDoorCloseListener(this);
//	}
//
//	/**
//	 * For the singleton pattern
//	 * 
//	 * @return the object
//	 */
//	public static BrakeState instance() {
//		if (instance == null) {
//			instance = new BrakeState();
//		}
//		return instance;
//	}
//
//	/**
//	 * Process door closed event
//	 */
//	@Override
//	public void doorClosed(DoorCloseEvent event) {
//		context.changeCurrentState(DoorClosedState.instance());
//
//	}
//
//	/**
//	 * Initialize the state
//	 */
//	public void run() {
//		AccelerateManager.instance().addAccelerateListener(this);
//		//display.turnLightOn();
//		//display.notCooking();
//		display.Brake();
//		display.displayTimeRemaining(0);
//	}
//
//}
