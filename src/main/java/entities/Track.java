package entities;
import javax.persistence.*;

@NamedQueries( {
        @NamedQuery(name = "Track.findAll", query = "select o from Track o"),
        @NamedQuery(name = "Track.findByID", query = "select o from Track o where o.track_id=:track_id"),
        @NamedQuery(name = "Track.findByLibrary", query = "select o from Track o where o.library=:library"),
})

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int track_id;

    private String artist;

    private String song_name;
    private String album;
    private String genre;

    @ManyToOne
    private Library library;

    public Track() {
    }

    public Track(int track_id, String artist, String song_name, String album, String genre, Library library) {
        this.track_id = track_id;
        this.artist = artist;
        this.song_name = song_name;
        this.album = album;
        this.genre = genre;
        this.library = library;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getAlbum() { return album; }

    public void setAlbum(String album) { this.album = album; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre;}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
