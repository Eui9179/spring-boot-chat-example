package site.leui.chat_example.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import site.leui.chat_example.chat.dto.ChatMessage;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void sendMessage(ChatMessage message) {
        System.out.println("getMessageType() " + message.getMessageType().toString());
        if (isJoin(message))
            message.setMessage(message.getSender() + "님이 입장하였습니다");

        System.out.println(message.getSender() + " - " + message.getMessage());
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    private boolean isJoin(ChatMessage messageType) {
        return messageType.getMessageType().equals(ChatMessage.MessageType.JOIN);
    }
}
