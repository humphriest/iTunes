package DAO;

import entities.Playlist;
import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Tim on 05/12/2016.
 */
public class PlaylistDAO {

    /*public static List<Playlist> findAllPlaylists(){

        EntityManager em = emf.createEntityManager();
        List<Playlist> playlists = (List<Playlist>)
                em.createNamedQuery("Playlist.findAll").getResultList();
        em.close();

        return playlists;

    }


    public static Playlist findPlaylistById(int playlistId){

         EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dt354jdbc");

        EntityManager em = emf.createEntityManager();
        List<Playlist> playlists = (List<Playlist>)
                em.createNamedQuery("Playlist.findById").
                        setParameter("playlistId", playlistId).getResultList();
        em.close();

        if (playlists.size() == 0)
            return null;
        else
            return playlists.get(0);
    }*/

    public void mergePlaylist(Playlist playlist){
        persistenceUtil.merge(playlist);
    }

    public void createPlaylist(Playlist playlist){
        persistenceUtil.persist(playlist);
    }
}
