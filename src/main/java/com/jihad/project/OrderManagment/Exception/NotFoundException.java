package com.jihad.project.OrderManagment.Exception;

/**
 * Exception thrown when a resource is not found.
 */
@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

	/**
	 * Constructs a new NotFoundException with the specified detail message.
	 *
	 * @param message the detail message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructs a new NotFoundException with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message
	 * @param cause   the cause of the exception
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
