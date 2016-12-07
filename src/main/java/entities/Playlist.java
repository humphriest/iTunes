package entities;

/**
 * Created by Tim on 05/12/2016.
 */
import javax.persistence.*;
import java.util.List;


@NamedQueries( {
        @NamedQuery(name = "playlist.findAll", query = "select o from Playlist o"),
        @NamedQuery(name = "playlist.findByPlaylistName", query = "select o from Playlist o where o.playlistName=:playlistName"),
})

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private int playlistId;
    private String playlistPersistenceId;
    private String playlistName;


    @ManyToMany
    private List<Track> tracks;

    public Playlist(){

    }

    public Playlist(int playlistId, String playlistPersistenceId, String playlistName, List<Track> tracks) {
        this.playlistId = playlistId;
        this.playlistPersistenceId = playlistPersistenceId;
        this.playlistName = playlistName;
        this.tracks = tracks;
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


}

