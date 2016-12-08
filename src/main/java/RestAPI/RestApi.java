package RestAPI;

import DAO.LibraryDAO;
import DAO.PlaylistDAO;
import DAO.UserDAO;
import entities.Library;
import entities.Playlist;
import entities.Track;
import entities.User;
import parser.XMLParser;
import persistence.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import DAO.TrackDAO;

@Path("/api")
public class RestApi {

    private TrackDAO trackDao = new TrackDAO();
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private UserDAO userDAO = new UserDAO();
    private LibraryDAO libraryDAO = new LibraryDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parse")
    public String parse(){
        XMLParser xmlParser = new XMLParser();
        User user = new User();
        user.setUsername("tim");
        user.setPassword("tim");
        userDAO.createUser(user);

        Library libPersist = xmlParser.getLibrary();
        libPersist.setUser(user);
        libraryDAO.createLibrary(libPersist);

        List<Track> trackList = xmlParser.getTracks();

        for (Track aTrackList : trackList) {
            aTrackList.setLibrary(libPersist);
            trackDao.createTrack(aTrackList);
        }
        List<Track> trackslist = trackDao.findByLibray(libPersist);
        List<Playlist> playlistList = xmlParser.getPlaylists(trackslist);
        for(Playlist p : playlistList){
            p.setLibrary(libPersist);
            playlistDAO.mergePlaylist(p);
        }



        return "Parsed";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello(){
        return "Hello";
    }

    /*public static void main(String[] args) {

        XMLParser.getTracks();
        ArrayList<Track> tracks = new ArrayList<>();
        Track track = new Track();
        for(Track track1: tracks) persistenceUtil.persist(track1);

    }*/

    /*uSER,
    lib.setUser
    * persist library,
    * p.setLibrary
    * */

}
