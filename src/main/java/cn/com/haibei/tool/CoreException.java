package cn.com.haibei.tool;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CoreException extends RuntimeException {

	private static final long serialVersionUID = -2147060242508040145L;

	private Throwable throwable;

	public CoreException(Throwable throwable) {
		super(throwable.getMessage());
		this.throwable = throwable;
	}

	public CoreException(String message, Throwable throwable) {
		this(message);
		this.throwable = throwable;
	}

	public CoreException(SQLException exception) {
		super(String.valueOf(exception.getErrorCode()));
		this.throwable = exception;
	}

	public CoreException(String message) {

		super(message);
	}

	public String getMessage() {
		if (throwable != null)
			return throwable.getMessage();
		return super.getMessage();
	}

	public void printStackTrace() {
		this.printStackTrace(System.err);
	}

	public void printStackTrace(PrintStream s) {
		if (throwable != null)
			throwable.printStackTrace(s);
		else
			super.printStackTrace(s);
	}

	public void printStackTrace(PrintWriter s) {
		if (throwable != null)
			throwable.printStackTrace(s);
		else
			super.printStackTrace(s);
	}
}
