package DAO;

import entities.Library;
import persistence.persistenceUtil;

/**
 * Created by Tim on 06/12/2016.
 */
public class LibraryDAO {

    /*public static List<Playlist> findAllPlaylists(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = (List<Student>)
                em.createNamedQuery("Student.findAll").getResultList();
        em.close();

        return students;

    }


    public static Student findStudentByUsername(String username){

        EntityManager em = emf.createEntityManager();
        List<Student> students = (List<Student>)
                em.createNamedQuery("Student.findByUsername").
                        setParameter("username", username).getResultList();
        em.close();

        if (students.size() == 0)
            return null;
        else
            return students.get(0);
    }*/

    public static void createLibrary(Library library){
        persistenceUtil.persist(library);
    }
}
