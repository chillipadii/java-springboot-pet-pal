package sg.com.petpal.petpal.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import sg.com.petpal.petpal.exception.ChatRoomNotFoundException;
import sg.com.petpal.petpal.model.ChatRoom;
import sg.com.petpal.petpal.repository.ChatRoomRepository;
import sg.com.petpal.petpal.service.ChatRoomService;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public List<ChatRoom> findAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    @Override
    public ChatRoom findChatRoomById(UUID id) {
        return chatRoomRepository.findById(id).orElseThrow(() -> new ChatRoomNotFoundException(id));
    }

    @Override
    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public ChatRoom updateChatRoomById(UUID id, ChatRoom chatRoom) {
        ChatRoom chatRoomToUpdate = chatRoomRepository.findById(id).orElseThrow(() -> new ChatRoomNotFoundException(id));
        chatRoomToUpdate.setOwners(chatRoom.getOwners());
        chatRoomToUpdate.setChatMessages(chatRoom.getChatMessages());
        return chatRoomRepository.save(chatRoomToUpdate);
    }

    @Override
    public void deleteChatRoomById(UUID id) {
        chatRoomRepository.deleteById(id);
    }
    
}
