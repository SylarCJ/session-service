package ust.augury.interview.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ust.augury.interview.entity.Session;
import ust.augury.interview.exception.SessionDetailsNotFoundException;
import ust.augury.interview.service.SessionService;

import java.io.IOException;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final ObjectMapper mapper;

    @Autowired
    public SessionServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Session> getAllSessionsDetails() throws IOException {
        // Deserialize the JSON file into a list of Session objects
        return mapper.readValue(
                new ClassPathResource("sessions.json").getInputStream(),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Session getSessionDetailsById(String sessionId) throws IOException {
        List<Session> sessions = getAllSessionsDetails();

        // Find the session details with the specified ID
        return sessions.stream()
                .filter(sessionDetails -> sessionDetails.getId().equals(sessionId))
                .findFirst()
                .orElseThrow(() -> new SessionDetailsNotFoundException(sessionId));
    }

    @Override
    public List<Session> getSessionDetailsByMachineId(String machineId) throws IOException {
        List<Session> sessions = getAllSessionsDetails();

        // Filter sessions by machine ID and collect them into a list
        List<Session> sessionList = sessions.stream()
                .filter(sessionDetails -> sessionDetails.getMachineId() != null &&
                        machineId.equals(sessionDetails.getMachineId()))
                .toList();

        if (sessionList.isEmpty()) {
            throw new SessionDetailsNotFoundException(machineId);
        }

        return sessionList;
    }
}
