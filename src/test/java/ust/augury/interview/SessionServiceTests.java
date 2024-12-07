package ust.augury.interview;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ust.augury.interview.entity.Session;
import ust.augury.interview.exception.SessionDetailsNotFoundException;
import ust.augury.interview.service.impl.SessionServiceImpl;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SessionServiceTests {

    private final SessionServiceImpl service;

    public SessionServiceTests() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.service = new SessionServiceImpl(mapper);
    }

    @Test
    void testGetAllSessions() throws IOException {
        List<Session> sessions = service.getAllSessionsDetails();

        assertNotNull(sessions);
        assertFalse(sessions.isEmpty());
        assertEquals("6728144fb3b5c98d48b2d5da", sessions.getFirst().getId());
    }

    @Test
    void testGetSessionDetailsById() throws IOException {
        Session session = service.getSessionDetailsById("6728144fb3b5c98d48b2d5da");

        assertNotNull(session);
        assertEquals("6728144fb3b5c98d48b2d5da", session.getId());
        assertEquals("approved", session.getStatus());
    }

    @Test
    void testGetSessionDetailsByMachineId() throws IOException {
        List<Session> result = service.getSessionDetailsByMachineId("5f54dd217546020001758b7b");

        // Assert
        assertNotNull(result);
        assertTrue(result.stream().allMatch(session ->
                "5f54dd217546020001758b7b".equals(session.getMachineId())));
    }

    @Test
    void testGetSessionDetailsByIdNotFound() {
        Exception exception = assertThrows(
                SessionDetailsNotFoundException.class,
                () -> service.getSessionDetailsById("nonexistent-id")
        );

        assertEquals("Session Details not found for ID: nonexistent-id", exception.getMessage());
    }

    @Test
    void testGetSessionDetailsByMachineIdNotFound() {
        Exception exception = assertThrows(
                SessionDetailsNotFoundException.class,
                () -> service.getSessionDetailsByMachineId("nonexistent-id")
        );

        assertEquals("Session Details not found for ID: nonexistent-id", exception.getMessage());
    }

}
