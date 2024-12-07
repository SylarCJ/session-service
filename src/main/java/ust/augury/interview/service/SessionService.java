package ust.augury.interview.service;

import ust.augury.interview.entity.Session;

import java.io.IOException;
import java.util.List;

public interface SessionService {
    Session getSessionDetailsById(String sessionId) throws IOException;

    List<Session> getAllSessionsDetails() throws IOException;

    List<Session> getSessionDetailsByMachineId(String machineId) throws IOException;
}
