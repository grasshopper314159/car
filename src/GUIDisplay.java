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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends AutomobileDisplay implements ActionListener {
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
		private AcceleratorButton acceleratorPresser = new AcceleratorButton("accelerator");
		private BrakeButton brakePresser = new BrakeButton("brake");
		private OnButton onButton = new OnButton("On");
		private OffButton offButton = new OffButton("Off");
		private DriveButton driveButton = new DriveButton("drive");
		private ParkButton parkButton = new ParkButton("park");
		private JLabel powerStatus = new JLabel("Power Off");
		private JLabel timerValue = new JLabel("            ");
		private JLabel gearStatus = new JLabel("Park");
		private JLabel drivingStatus = new JLabel("Stopped");

		/**
		 * Sets up the interface
		 */
		private SimpleDisplay() {
			super("Automobile");
			getContentPane().setLayout(new FlowLayout());
			getContentPane().add(powerStatus);
			getContentPane().add(gearStatus);
			getContentPane().add(timerValue);
			getContentPane().add(drivingStatus);
			getContentPane().add(onButton);
			getContentPane().add(offButton);
			getContentPane().add(acceleratorPresser);
			getContentPane().add(brakePresser);
			getContentPane().add(driveButton);
			getContentPane().add(parkButton);
			onButton.addActionListener(GUIDisplay.this);
			offButton.addActionListener(GUIDisplay.this);
			driveButton.addActionListener(GUIDisplay.this);
			// acceleratorPresser.addActionListener(GUIDisplay.this);
			// brakePresser.addActionListener(GUIDisplay.this);
			pack();
			setVisible(true);
		}
	}

	/**
	 * Handles the clicks
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		((GUIButton) event.getSource()).inform(this);
	}

	/**
	 * Indicate that the light is on
	 */
	@Override
	public void gearInDrive() {
		frame.gearStatus.setText("Drive");
	}

	/**
	 * Indicate that the light is off
	 */
	@Override
	public void gearInPark() {
		frame.gearStatus.setText("Park");
	}

	/**
	 * Indicate that the door is closed
	 */
	@Override
	public void powerOn() {
		frame.powerStatus.setText("Power On");
	}

	/**
	 * Indicate that the door is opened
	 */
	@Override
	public void powerOff() {
		frame.powerStatus.setText("Power Off");
	}

	/**
	 * display the remaining time
	 * 
	 * @param the
	 *            value remaining
	 */
	@Override
	public void displayTimeRemaining(int value) {
		frame.timerValue.setText(" " + value);
	}

	/**
	 * Indicate that it is cooking
	 */
	@Override
	public void startDriving() {
		frame.drivingStatus.setText("Cooking");
	}

	/**
	 * Indicate that cooking is done
	 */
	@Override
	public void stopped() {
		frame.drivingStatus.setText("Stopped");
	}

	/**
	 * The main method. Creates the interface
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		AutomobileDisplay display = new GUIDisplay();
	}
}