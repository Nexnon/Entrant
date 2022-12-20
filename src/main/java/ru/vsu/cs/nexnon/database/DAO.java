package ru.vsu.cs.nexnon.database;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.vsu.cs.nexnon.entity.Application;
import ru.vsu.cs.nexnon.entity.Direction;
import ru.vsu.cs.nexnon.entity.Entrant;

import java.util.List;

public class DAO {

    public Entrant findByToken(String token) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Entrant.class, token);
    }

    public Entrant findByEmail(String email1) {
        List list = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Entrant where email = :email2").setParameter("email2", email1).list();
        if(list.isEmpty()){
            return null;
        }
        return (Entrant) list.get(0);
    }

    public void saveEntrant(Entrant entrant) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entrant);
        tx1.commit();
        session.close();
    }

    public void saveApplication(Application application) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(application);
        tx1.commit();
        session.close();
    }

    public void saveDirection(Direction direction) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(direction);
        tx1.commit();
        session.close();
    }

    public void deleteEntrant(Entrant entrant) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("delete from Entrant where token = :t").setParameter("t", entrant.getToken()).executeUpdate();
        tx1.commit();
        session.close();
    }

    public void deleteApplication(Application application) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(application);
        tx1.commit();
        session.close();
    }

    public void deleteDirection(Direction direction) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(direction);
        tx1.commit();
        session.close();
    }

    public Direction findDirectionById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Direction.class, id);
    }

    public List<Application> findAllApplications() {
        return (List<Application>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Application").list();
    }

    public List<Direction> findAllDirections() {
        return (List<Direction>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Direction").list();
    }

    public List<Entrant> findAllEntrants() {
        return (List<Entrant>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Entrant").list();
    }
}
