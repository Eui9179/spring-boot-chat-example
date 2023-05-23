package site.leui.chat_example.bounded_context.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;

    public static ChatMessage of(String roomId, String sender, String message) {
        return ChatMessage.builder()
                .roomId(roomId)
                .sender(sender)
                .message(message)
                .build();
    }
}
