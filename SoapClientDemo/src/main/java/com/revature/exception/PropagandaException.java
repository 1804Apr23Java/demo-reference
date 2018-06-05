package com.revature.exception;

public class PropagandaException extends Exception {

	public PropagandaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropagandaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}


	public PropagandaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}


	public PropagandaException(String message) {
		super(message);
	}


	public PropagandaException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -2178902898742999006L;
	
	
	private String message = "Communist propaganda";
	
	
	
}
