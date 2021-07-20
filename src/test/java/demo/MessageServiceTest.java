package demo;

import demo.entity.Message;
import demo.entity.MessageBody;
import demo.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testSave() {
        MessageBody body = new MessageBody();
        body.setMsg("test");
        Message message = new Message();
        message.setBody(body);
        messageService.saveMessage(message)
                .doOnSuccess(System.out::println)
                .block();
    }
}
