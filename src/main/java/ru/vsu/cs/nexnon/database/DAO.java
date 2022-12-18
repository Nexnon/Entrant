package ru.vsu.cs.nexnon.database;

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

    public Entrant findByEmail(String email) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Entrant.class, email);
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
        session.save(application);
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
        session.delete(entrant);
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
