import org.pnt.product.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Alexander on 08.06.2015.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("crm-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person p = new Person();

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
