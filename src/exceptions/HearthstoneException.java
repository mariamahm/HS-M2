package exceptions;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class HearthstoneException extends Exception {
	public HearthstoneException() {
		super();
	}

	public HearthstoneException(String message)

	{
		JOptionPane.showMessageDialog(null, message);
	}
}
