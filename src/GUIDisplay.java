
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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends MicrowaveDisplay implements ActionListener {
	private static SimpleDisplay frame;

	/**
	 * Makes it a singleton
	 */
	private GUIDisplay() {
		frame = new SimpleDisplay();
		initialize();
	}

	/**
	 * This class has most of the widgets
	 *
	 */
	private class SimpleDisplay extends JFrame {
		private DoorCloseButton doorCloser = new DoorCloseButton("close door");
		private DoorOpenButton doorOpener = new DoorOpenButton("open door");
		private CookButton cookButton = new CookButton("cook");
		private JLabel doorStatus = new JLabel("Door Closed");
		private JLabel timerValue = new JLabel("            ");
		private JLabel lightStatus = new JLabel("Light Off");
		private JLabel cookingStatus = new JLabel("Not cooking");

		/**
		 * Sets up the interface
		 */
		private SimpleDisplay() {
			super("Microwave");
			getContentPane().setLayout(new FlowLayout());
			getContentPane().add(doorStatus);
			getContentPane().add(lightStatus);
			getContentPane().add(timerValue);
			getContentPane().add(cookingStatus);
			getContentPane().add(doorCloser);
			getContentPane().add(doorOpener);
			getContentPane().add(cookButton);
			doorCloser.addActionListener(GUIDisplay.this);
			doorOpener.addActionListener(GUIDisplay.this);
			cookButton.addActionListener(GUIDisplay.this);
			pack();
			setVisible(true);
		}
	}

	/**
	 * Handles the clicks
	 */
	public void actionPerformed(ActionEvent event) {
		((GUIButton) event.getSource()).inform(this);
	}

	/**
	 * Indicate that the light is on
	 */
	public void turnLightOn() {
		frame.lightStatus.setText("Light On");
	}

	/**
	 * Indicate that the light is off
	 */
	public void turnLightOff() {
		frame.lightStatus.setText("Light Off");
	}

	/**
	 * Indicate that the door is closed
	 */
	public void doorClosed() {
		frame.doorStatus.setText("Door Closed");
	}

	/**
	 * Indicate that the door is opened
	 */
	public void doorOpened() {
		frame.doorStatus.setText("Door Opened");
	}

	/**
	 * display the remaining time
	 * 
	 * @param the
	 *            value remaining
	 */
	public void displayTimeRemaining(int value) {
		frame.timerValue.setText(" " + value);
	}

	/**
	 * Indicate that it is cooking
	 */
	public void startCooking() {
		frame.cookingStatus.setText("Cooking");
	}

	/**
	 * Indicate that cooking is done
	 */
	public void notCooking() {
		frame.cookingStatus.setText("Not cooking");
	}

	/**
	 * The main method. Creates the interface
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		MicrowaveDisplay display = new GUIDisplay();
	}
}