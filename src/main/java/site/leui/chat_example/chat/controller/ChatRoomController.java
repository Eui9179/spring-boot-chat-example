package site.leui.chat_example.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.leui.chat_example.chat.dto.ChatRoom;
import site.leui.chat_example.chat.service.ChatRoomService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/rooms")
    public String getRooms(Model model) {
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute(chatRooms);
        return "/chat/rooms";
    }

    @PostMapping("room")
    public String createRoom(@RequestParam String name) {
        chatRoomService.createRoom(name);
        return "redirect:/chat/rooms";
    }

    @GetMapping("/room/{roomId}")
    public String getRoom(Model model, @PathVariable String roomId) {
        ChatRoom chatRoom = chatRoomService.findRoomById(roomId);
        model.addAttribute(chatRoom);
        return "/chat/room";
    }
}
