package system.gui;

public class CancelOperationException extends Exception {

	public CancelOperationException() {
		super("Operation was canceled");
	}

}
