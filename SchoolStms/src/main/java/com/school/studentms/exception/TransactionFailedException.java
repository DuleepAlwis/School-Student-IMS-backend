package com.school.studentms.exception;

public class TransactionFailedException extends RuntimeException {

	public TransactionFailedException(String message) {
        super(message);
    }
}
