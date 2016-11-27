/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * 
 *            Redistribution and use with or without modification, are permitted
 *            provided that the following conditions are met:
 *
 *            - the use is for academic purpose only - Redistributions of source
 *            code must retain the above copyright notice, this list of
 *            conditions and the following disclaimer. - Neither the name of
 *            Brahma Dathan or Sarnath Ramnath may be used to endorse or promote
 *            products derived from this software without specific prior written
 *            permission.
 *
 *            The authors do not make any claims regarding the correctness of
 *            the code in this module and are not responsible for any loss or
 *            damage resulting from its use.
 */
public class CookButton extends GUIButton {
	/**
	 * The button for cooking
	 * 
	 * @param string
	 */
	public CookButton(String string) {
		super(string);
	}

	/**
	 * Creates a CookRequestEvent, so the interested states can get it. Call the
	 * manager, so it can forward it
	 */
	public void inform(MicrowaveDisplay source) {
		CookRequestManager.instance().processEvent(new CookRequestEvent(source));
	}
}