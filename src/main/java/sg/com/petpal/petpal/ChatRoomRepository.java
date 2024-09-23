package sg.com.petpal.petpal;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {
    
}
