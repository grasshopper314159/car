package src;

import java.util.EventListener;

public interface BrakeListener extends EventListener {
	// This is where guiMethods that change the display are handled.
	public void brake(BrakeEvent event);
}
