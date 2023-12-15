package Larionov;


import Larionov.dao.CatalogoBibliotecarioDAO;
import Larionov.dao.RentDAO;
import Larionov.dao.UtenteDAO;
import Larionov.entities.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L5-Exam");

    public static void main(String[] args) {

        //********************************LE RIVISTE NON SONO ANCORA ARRIVARE PER ADESSO AFFITTIMAMO SOLO LIBRI*************************

        EntityManager em = emf.createEntityManager();
        CatalogoBibliotecarioDAO cbd = new CatalogoBibliotecarioDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        RentDAO rd = new RentDAO(em);
        Faker faker = new Faker();

        //********************************CREAZIONE UTENTE*************************

        Utente userUno = new Utente("Paolo","Spada", LocalDate.of(1991,2,2),123456);
//        ud.save(userUno);

        //********************************REGISTRAZIONE DEI LIBRI NEL CATALOGO*************************

        Libro libroUno = new Libro("Amore Profondo",1800,30,"Mozart", GENERE.MYSTERY);
//        cbd.save(libroUno);

        Libro libroDue = new Libro("Amore Profondo 2",1810,200,"Mozart", GENERE.MYSTERY);
//        cbd.save(libroDue);

        //********************************RENT*************************

        Rent rentUno = new Rent(userUno,libroDue);
//        rd.save(rentUno);
        Rent rentDue = new Rent(userUno, libroUno);
//        rd.save(rentDue);



//         cbd.rimuoviElementoPerISBN(38);

        System.out.printf("***********************CERCA PER L'ANNO*********************");

        cbd.cercaPerAnnoPubblicazione(1800).forEach(System.out::println);

        System.out.printf("*****************CERCA PER AUTORE******************");
        
        cbd.cercaPerAutore("Mozart").forEach(System.out::println);


        em.close();
        emf.close();
    }
}
