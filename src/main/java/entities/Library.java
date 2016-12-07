package entities;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String libraryPersistenceId;

    @ManyToOne
    public User user;

    public Library() {
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public String getLibraryPersistenceId() {
        return libraryPersistenceId;
    }

    public void setLibraryPersistenceId(String libraryPersistenceId) {
        this.libraryPersistenceId = libraryPersistenceId;
    }


    public User getUser(){ return user;}

    public void setUser(User user){ this.user = user;}




}
