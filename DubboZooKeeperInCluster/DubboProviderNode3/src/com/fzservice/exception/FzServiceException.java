package com.fzservice.exception;

@SuppressWarnings("serial")
public class FzServiceException extends Exception  {
	public FzServiceException() {
	}

	public FzServiceException(String message) {
		super(message);
	}

	public FzServiceException(Throwable cause) {
		super(cause);
	}

	public FzServiceException(String className, Throwable cause) {
		super(cause.getMessage(), cause);
	}
}
