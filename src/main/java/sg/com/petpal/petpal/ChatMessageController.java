package sg.com.petpal.petpal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat-message")
public class ChatMessageController {

    @GetMapping({"", "/"})
    public ResponseEntity<ChatMessage> findAllChatMessage() {
        return ResponseEntity.ok(new ChatMessage());
    }
    
}
