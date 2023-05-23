package site.leui.chat_example.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import site.leui.chat_example.bounded_context.dto.chat_message.ChatMessage;
import site.leui.chat_example.bounded_context.dto.chat_room.ChatRoom;
import site.leui.chat_example.bounded_context.service.ChatService;

@RequiredArgsConstructor
@Component
@Slf4j
public class WebSockChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info(payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom room = chatService.findRoomId(chatMessage.getRoomId());
        room.handleAction(session, chatMessage, chatService);

    }
}
