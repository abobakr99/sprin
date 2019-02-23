import app.BodyInfo;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BodyInfoTest {

    @Test
    public void getName() {
        BodyInfo b = new BodyInfo("aa", 123);
        assertEquals("aa", b.getName());
    }

    @Test
    public void getPhoneNum() {
        BodyInfo b = new BodyInfo("aa", 123);
        assertEquals(123, b.getPhoneNum());
    }
    @Test
    public  void performJP(){
        // creatin body info obejcts
        BodyInfo b1 = new BodyInfo("James", 123);
        BodyInfo b2 = new BodyInfo("Kent", 4566);

        b1.setId(1);
        b2.setId(2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();
        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        // Persisting the product entity objects
        em.persist(b1);
        em.persist(b2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BodyInfo b");

        @SuppressWarnings("unchecked")

        List<BodyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BodyInfo b : results) {

            System.out.println(b.getName() + " (id=" + b.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();

    }
}