package entities;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id=0;

    public Library() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private int libraryPersistenceId;

    public int getId() {
        return id;
    }

    public int getLibraryPersistenceId() {
        return libraryPersistenceId;
    }

    public void setLibraryPersistenceId(int libraryPersistenceId) {
        this.libraryPersistenceId = libraryPersistenceId;
    }


    @ManyToOne
    public User user;

    public User getUser(){ return user;}

    public void setUser(){ this.user = user;}




}
