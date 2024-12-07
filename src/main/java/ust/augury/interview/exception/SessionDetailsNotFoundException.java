package ust.augury.interview.exception;

public class SessionDetailsNotFoundException extends RuntimeException {
    public SessionDetailsNotFoundException(String sessionId) {
        super("Session Details not found for ID: " + sessionId);
    }
}
