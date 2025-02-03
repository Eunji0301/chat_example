package org.koreait.example.chat_example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class chatMessage {
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    private String authorName;
    private String content;

    public chatMessage(String authorName, String content) {
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content);
    }
}

class ChatMessageIdGenerator {

    private static long id = 0;

    public static long getNextId() {
        return ++id;
    }
}
