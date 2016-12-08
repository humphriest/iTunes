package entities;

/**
 * Created by Tim on 05/12/2016.
 */
import javax.persistence.*;
import java.util.List;


@NamedQueries( {
        @NamedQuery(name = "playlist.findAll", query = "select o from Playlist o"),
        @NamedQuery(name = "playlist.findById", query = "select o from Playlist o where o.playlistId=:playlistId"),
})

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    private List<Track> tracks;

    private int playlistId;
    private String playlistPersistenceId;
    private String playlistName;

    @ManyToOne
    private Library library;


    public Playlist() {
    }

    public Playlist(List<Track> tracks, int playlistId, String playlistPersistenceId, String playlistName, Library library) {
        this.tracks = tracks;
        this.playlistId = playlistId;
        this.playlistPersistenceId = playlistPersistenceId;
        this.playlistName = playlistName;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistPersistenceId() {
        return playlistPersistenceId;
    }

    public void setPlaylistPersistenceId(String playlistPersistenceId) {
        this.playlistPersistenceId = playlistPersistenceId;
    }


    public String getPlaylistName() {
        return playlistName;
    }
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }


    public List<Track> getTracks() {
        return tracks;
    }
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

}

