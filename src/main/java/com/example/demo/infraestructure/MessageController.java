package com.example.demo.infraestructure;

import com.example.demo.domain.MessageEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "message")
public class MessageController {
    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("save")
    public ResponseEntity<MessageEntity> save(@RequestHeader String text){
        MessageEntity message = repository.save(new MessageEntity(UUID.randomUUID(), text));

        return ResponseEntity.accepted().body(message);
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageEntity> getMessage(@PathVariable UUID messageId){
        return repository
                .findById(messageId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
