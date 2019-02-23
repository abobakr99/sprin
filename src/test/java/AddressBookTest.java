import app.AddressBook;
import app.BodyInfo;
import org.junit.Test;
//import sun.jvm.hotspot.debugger.Address;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    @Test
    public void addBody() {
        AddressBook ad = new AddressBook();
        BodyInfo b = new BodyInfo("ee", 123);
        ad.addBody(b);
        assertEquals(1,ad.size());
    }
    @Test
    public  void performJP(){
        AddressBook ab = new AddressBook();
        ab.setId(1);

        BodyInfo b1 = new BodyInfo("James", 1234);
        BodyInfo b2 = new BodyInfo("Kent", 4566);
        BodyInfo b3 = new BodyInfo("Lisa",  1020);

        b1.setId(1);
        b2.setId(2);
        b3.setId(3);


        ab.addBody(b1);
        ab.addBody(b2);
        ab.addBody(b3);


        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();
        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        // Persist app.BodyInfo Objects

        tx.begin();
        // Persisting the product entity objects
        //em.persist(b1);
        //em.persist(b2);
       // em.persist(b3);

        em.persist(ab);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT aBook FROM AddressBook aBook ");

        @SuppressWarnings("unchecked")

        List<AddressBook> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (AddressBook a : results) {

            System.out.println(" app.AddressBook ID: (id=" + a.getId() + ")" );
            System.out.println(" app.AddressBook Details : \n" + a);
        }

        // Closing connection
        em.close();

        emf.close();


    }

}