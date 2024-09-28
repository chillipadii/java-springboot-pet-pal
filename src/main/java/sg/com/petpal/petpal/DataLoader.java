package sg.com.petpal.petpal;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.com.petpal.petpal.model.ChatMessage;
import sg.com.petpal.petpal.model.ChatRoom;
import sg.com.petpal.petpal.model.Gender;
import sg.com.petpal.petpal.model.Owner;
import sg.com.petpal.petpal.model.Pet;
import sg.com.petpal.petpal.model.PetData;
import sg.com.petpal.petpal.model.OwnerAuth;
import sg.com.petpal.petpal.repository.ChatMessageRepository;
import sg.com.petpal.petpal.repository.ChatRoomRepository;
import sg.com.petpal.petpal.repository.OwnerRepository;
import sg.com.petpal.petpal.repository.PetDataRepository;
import sg.com.petpal.petpal.repository.PetRepository;

@Component
public class DataLoader {

    private PetRepository petRepository;
    private PetDataRepository petDataRepository;
    private ChatRoomRepository chatRoomRepository;
    private ChatMessageRepository chatMessageRepository;
    private PasswordEncoder passwordEncoder;

    public DataLoader(PetRepository petRepository, PetDataRepository petDataRepository,
        ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository,
        PasswordEncoder passwordEncoder) {
            this.petRepository = petRepository;
            this.petDataRepository = petDataRepository;
            this.chatRoomRepository = chatRoomRepository;
            this.chatMessageRepository = chatMessageRepository;
            this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void loadData() {

        deleteAllExistingData();

        List<Owner> newOwners = loadOwnersData(3);
        List<Pet> newPets = loadPetInfo(newOwners);
        List<PetData> petDataList = loadPetDataInfo(newPets);
        ChatRoom newChatRoom = loadChatRoomData(newOwners);
        List<ChatMessage> newChatMessages = loadChatMessagesData(3, newChatRoom, newOwners.get(0));
        
        // petRepository.saveAll(newPets);
        petDataRepository.saveAll(petDataList);
        chatRoomRepository.save(newChatRoom);
        chatMessageRepository.saveAll(newChatMessages);
        
    }

    private void deleteAllExistingData() {
        petRepository.deleteAll();
        petDataRepository.deleteAll();
        chatRoomRepository.deleteAll();
        chatMessageRepository.deleteAll();
    }

    // Create 3 owners
    private List<Owner> loadOwnersData(int quantity) {
        List<Owner> owners = new ArrayList<>();
        Owner owner = Owner.builder()
                .name("Tom")
                .areaLocation("NTU Street 1")
                .build();
        OwnerAuth ownerAuth = OwnerAuth.builder()
                .email("tom@test.com")
                .password(passwordEncoder.encode("tompass"))
                .build();
        owner.setOwnerAuth(ownerAuth);
        ownerAuth.setOwner(owner);
        owners.add(owner);

        Owner owner2 = Owner.builder()
                .name("Dick")
                .areaLocation("NTU Street 2")
                .build();
        OwnerAuth ownerAuth2 = OwnerAuth.builder()
                .email("dick@test.com")
                .password(passwordEncoder.encode("dickpass"))
                .build();
        owner2.setOwnerAuth(ownerAuth2);
        ownerAuth2.setOwner(owner2);
        owners.add(owner2);

        Owner owner3 = Owner.builder()
                .name("Harry")
                .areaLocation("NTU Street 2")
                .build();
        OwnerAuth ownerAuth3 = OwnerAuth.builder()
                .email("harry@test.com")
                .password(passwordEncoder.encode("harrypass"))
                .build();
        owner3.setOwnerAuth(ownerAuth3);
        ownerAuth3.setOwner(owner3);
        owners.add(owner3);

        return owners;
    }

    private List<Pet> loadPetInfo(List<Owner> owners) {
        List<Pet> pets = new ArrayList<>();
        if (owners.size() == 3) {
            for (int i = 0; i < owners.size(); i++) {
                switch (i) {
                    case 1: {
                        Pet pet1 = new Pet();
                        pet1.setName("Buddy");
                        pet1.setGender(Gender.MALE);
                        pet1.setAge(2);
                        pet1.setNeutered(true);
                        pet1.setOwner(owners.get(i));
                        pets.add(pet1);
                        break;
                    }
                    case 2: {
                        Pet pet2 = new Pet();
                        pet2.setName("Happy");
                        pet2.setGender(Gender.FEMALE);
                        pet2.setAge(3);
                        pet2.setNeutered(false);
                        pet2.setOwner(owners.get(i));
                        pets.add(pet2);
                        break;
                    }
                    case 3: {
                        Pet pet3 = new Pet();
                        pet3.setName("Charlie");
                        pet3.setGender(Gender.MALE);
                        pet3.setAge(2);
                        pet3.setNeutered(false);
                        pet3.setOwner(owners.get(i));
                        pets.add(pet3);
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        return pets;
    }

    private List<PetData> loadPetDataInfo(List<Pet> pets) {
        List<PetData> petDataList = new ArrayList<>();
        PetData petData1 = PetData.builder()
            .breed("Golden Retriever")
            .animalGroup("Dog")
            // .pets(pets)
            .build();
        petDataList.add(petData1);

        PetData petData2 = PetData.builder()
            .breed("Maltipoo")
            .animalGroup("Dog")
            .build();
        petDataList.add(petData2);

        PetData petData3 = PetData.builder()
            .breed("Chow Chow")
            .animalGroup("Dog")
            .build();
        petDataList.add(petData3);

        PetData petData4 = PetData.builder()
            .breed("Green Cheek Conure")
            .animalGroup("Parrot")
            .build();
        petDataList.add(petData4);

        PetData petData5 = PetData.builder()
            .breed("Red-sided Eclectus")
            .animalGroup("Parrot")
            .build();
        petDataList.add(petData5);

        return petDataList;
    }

    // Create 1 chat room
    private ChatRoom loadChatRoomData(List<Owner> owners) {
        return ChatRoom.builder()
            .owners(owners)
            .build();
    }

    // Create 3 chat messages for 1 owner, 1 chat room
    private List<ChatMessage> loadChatMessagesData(int quantity, ChatRoom newChatRoom, Owner newOwner) {
        List<ChatMessage> chatMessages = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            ChatMessage newChatMessage = ChatMessage.builder()
                .createdTimestamp(LocalDateTime.now())
                .updatedTimestamp(LocalDateTime.now())
                .message("Chat Message " + i)
                .owner(newOwner)
                .chatRoom(newChatRoom)
                .build();
            chatMessages.add(newChatMessage);
        }
        return chatMessages;
    }
}
