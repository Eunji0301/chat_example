package org.koreait.example.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {

    chatMessage message = new chatMessage("김철수", "안녕");

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<chatMessage> writeMessage() {
        return new RsData<>("S-1", "메세지가 작성됨", message);
    }

}
