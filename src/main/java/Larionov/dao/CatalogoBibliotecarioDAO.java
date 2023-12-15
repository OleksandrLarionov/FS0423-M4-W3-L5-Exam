package Larionov.dao;

import Larionov.entities.CatalogoBibliotecario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class CatalogoBibliotecarioDAO {
    private final EntityManager em;

    public CatalogoBibliotecarioDAO(EntityManager em) {
        this.em = em;
    }
    public void save(CatalogoBibliotecario articolo){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(articolo);

        transazione.commit();

        System.out.println("L'articolo " + articolo.getTitolo() + " è stato inserito con successo");
    };
    public CatalogoBibliotecario getById(long id){
        CatalogoBibliotecario found = em.find(CatalogoBibliotecario.class, id);
        return found;
    };

    public void findByIdAndDelete(long id){
        CatalogoBibliotecario found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("L'articolo " + " è stato cancellato cancellato");

        } else {
            System.out.println("L'articolo non trovato");
        }

    };

}
