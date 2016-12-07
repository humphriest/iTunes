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
        List<Playlist> playlistList = xmlParser.getPlaylists();


        for(Playlist p : playlistList){
            p.setLibrary(libPersist);
//            System.out.println(p.getPlaylistPersistenceId() + "Bemi was here");
//            ArrayList<Track> toBeRemoved = new ArrayList<>();
//            for(Track pt: p.getTracks()){
//                for(Track t: trackList){
//                    if(pt.getTrack_id() == t.getTrack_id()){
//                        toBeRemoved.add(t);
//                    }
//                }
//                pt.setLibrary(libPersist);
//            }
//            trackList.removeAll(toBeRemoved);
            playlistDAO.createPlaylist(p);
        }
        for (Track aTrackList : trackList) {
            trackDao.createTrack(aTrackList);
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
