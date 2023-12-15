package Larionov;


import Larionov.dao.CatalogoBibliotecarioDAO;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L5-Exam");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogoBibliotecarioDAO cbd = new CatalogoBibliotecarioDAO(em);
        Faker faker = new Faker();


        em.close();
        emf.close();
    }
}
