package com.ApiComAi.AiAPI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    @RequestMapping("/{animal}")
    public String chat(@PathVariable String animal) {
        String pergunta = "Me de a REFICOFAGE (classificação taxonomica) desse animal: "+animal;
        return chatService.gerarResposta(pergunta);
    }
}