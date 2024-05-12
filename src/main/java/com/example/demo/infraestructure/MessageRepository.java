package com.example.demo.infraestructure;

import com.example.demo.domain.MessageEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends ListCrudRepository<MessageEntity, UUID> {
}
