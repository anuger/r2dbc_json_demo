package demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("message_test")
public class Message {

    @Id
    private Integer id;

    private MessageBody body;
}
