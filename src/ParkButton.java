package src;

public class ParkButton extends GUIButton {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string
	 *            the text to be put
	 */
	public ParkButton(String string) {
		super(string);
	}

	/**
	 * Create the DoorOpenEvent and tell the manager that the button has been
	 * clicked.
	 */
	@Override
	public void inform(AutomobileDisplay source) {
		PowerOnManager.instance().processEvent(new PowerOnEvent(source));
		// brings back onto "power on, park" state
	}
}