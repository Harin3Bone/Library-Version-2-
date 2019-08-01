package Object.Library;

import java.util.UUID;

public class Librarian extends Person{
    public Librarian(){

    }

    public Librarian(UUID uuid, String firstName, String lastName, String identity, String password) {
        super(uuid, firstName, lastName, identity, password);
    }
}
