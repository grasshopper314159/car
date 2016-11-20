
package src;
public class DriveButton extends GUIButton {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string
	 *            the text to be put
	 */
	public DriveButton(String string) {
		super(string);
	}

	/**
	 * Create the DoorOpenEvent and tell the manager that the button has been
	 * clicked.
	 */
	@Override
	public void inform(AutomobileDisplay source) {
		// DoorOpenManager.instance().processEvent(new DoorOpenEvent(source));
	}
}