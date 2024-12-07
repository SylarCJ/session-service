package ust.augury.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ust.augury.interview.entity.Session;
import ust.augury.interview.service.SessionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionDetailsById(@PathVariable String sessionId) throws IOException {

        return ResponseEntity.ok(sessionService.getSessionDetailsById(sessionId));
    }

    @GetMapping("/machine/{machineId}")
    public ResponseEntity<List<Session>> getSessionDetailsByMachineId(@PathVariable String machineId) throws IOException {

        return ResponseEntity.ok(sessionService.getSessionDetailsByMachineId(machineId));
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessionsDetails() throws IOException {

        return ResponseEntity.ok(sessionService.getAllSessionsDetails());
    }
}
