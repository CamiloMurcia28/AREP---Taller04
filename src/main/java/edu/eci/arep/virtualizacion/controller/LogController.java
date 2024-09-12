package edu.eci.arep.virtualizacion.controller;

import edu.eci.arep.virtualizacion.model.Message;
import edu.eci.arep.virtualizacion.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/log/messages")
public class LogController {
    private static final Logger LOGGER = Logger.getLogger(LogController.class.getName());
    private final LogRepository logRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LogController(MongoTemplate mongoTemplate, LogRepository logRepository) {
        this.mongoTemplate = mongoTemplate;
        this.logRepository = logRepository;
    }

    @PostMapping
    public ResponseEntity<?> logMessage(@RequestBody String message) {
        try {
            LOGGER.info("Received message: " + message);
            Message msg = new Message(message, LocalDateTime.now());
            logRepository.save(msg);
            LOGGER.info("Saved entry: " + msg);
            List<Message> recentMessages = logRepository.findTop10ByOrderByTimestampDesc();
            return ResponseEntity.ok(recentMessages);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing message", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error processing message: " + e.getMessage() + ". Cause: " + e.getCause());
        }
    }

    @GetMapping
    public ResponseEntity<?> getEntries() {
        try {
            List<Message> messages = logRepository.findTop10ByOrderByTimestampDesc();
            return ResponseEntity.ok(messages);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving messages", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error retrieving messages: " + e.getMessage() + ". Cause: " + e.getCause());
        }
    }
}