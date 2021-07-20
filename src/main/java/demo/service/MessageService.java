package demo.service;

import demo.entity.Message;
import demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Mono<Integer> saveMessage(Message message) {
        return messageRepository.save(message)
                .map(Message::getId);
    }
}
