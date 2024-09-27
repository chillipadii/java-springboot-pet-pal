package sg.com.petpal.petpal.exception;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(Long id) {
        super("Could not find owner with id: " + id);
    }
}