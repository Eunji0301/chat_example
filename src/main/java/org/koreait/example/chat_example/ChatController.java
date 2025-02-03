package org.koreait.example.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<chatMessage> chatMessages = new ArrayList<chatMessage>();

//    @AllArgsConstructor
//    @Getter
//    public static class writeChatMessageRequest {
//        private final String authorName;
//        private final String content;
//    }

    public record writeChatMessageRequest(String authorName, String content) {
    }

    public record writeChatMessageResponse(long id) {

    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<writeChatMessageResponse> writeMessage(@RequestBody writeChatMessageRequest req) {
        chatMessage message = new chatMessage(req.authorName(), req.content());
        chatMessages.add(message);
        return new RsData<>(
                "S-1",
                "메세지가 작성됨",
                new writeChatMessageResponse(message.getId())
        );
    }


    public record messagesResponse(List<chatMessage> messages, long count) {

    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<messagesResponse> messages() {
        return new RsData<>(
                "S-1",
                "메세지 리스트",
                new messagesResponse(chatMessages, chatMessages.size())
        );
    }

}
