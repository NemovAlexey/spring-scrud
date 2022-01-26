package crud.dao;

import crud.model.User;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final EntityManagerFactory entityManagerFactory;

    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(long id, User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
