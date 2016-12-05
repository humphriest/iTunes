package RestAPI;

import entities.Track;
import parser.XMLParser;
import persistence.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import DAO.TrackDAO;

@Path("/api")
public class RestApi {

    //private static SessionFactory sessionFactory;
    TrackDAO trackDao = new TrackDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parse")
    public String parse(){
        XMLParser xmlParser = new XMLParser();
        List<Track> trackArrayList = xmlParser.getTracks();

        for(Track track: trackArrayList){
            TrackDAO.createTrack(track);
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

}
