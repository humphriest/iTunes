package DAO;

import entities.Playlist;
import persistence.persistenceUtil;

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


    public static Playlist findPlaylistByUsername(int playlist_id){

        EntityManager em = emf.createEntityManager();
        List<Playlist> playlists = (List<Playlist>)
                em.createNamedQuery("Playlist.findById").
                        setParameter("playlist_id", playlist_id).getResultList();
        em.close();

        if (playlists.size() == 0)
            return null;
        else
            return playlists.get(0);
    }*/

    public static void createPlaylist(Playlist playlist){
        persistenceUtil.persist(playlist);
    }
}
