package com.fzweb.exception;

@SuppressWarnings("serial")
public class FzWebException extends Exception  {
	public FzWebException() {
	}

	public FzWebException(String message) {
		super(message);
	}

	public FzWebException(Throwable cause) {
		super(cause);
	}

	public FzWebException(String className, Throwable cause) {
		super(cause.getMessage(), cause);
	}
}
