package Larionov.dao;

import Larionov.entities.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RentDAO {
    private final EntityManager em;

    public RentDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Rent articolo){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(articolo);

        transazione.commit();

        System.out.println("L'articolo " + articolo.getId() + " è stato inserito con successo");
    };
    public Rent getById(long id){
        Rent found = em.find(Rent.class, id);
        return found;
    };

    public void findByIdAndDelete(long id){
        Rent found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Rent " + " è stato rent cancellato");

        } else {
            System.out.println("L'articolo non trovato");
        }

    };
}
