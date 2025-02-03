package org.koreait.example.chat_example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @GetMapping("/writeMessage")
    @ResponseBody
    public String writeMessage() {
        return "메시지 작성됨";
    }
}
