import junit.framework.TestCase;
import org.junit.Test;
import ru.vsu.cs.nexnon.database.DAO;
import ru.vsu.cs.nexnon.entity.Application;
import ru.vsu.cs.nexnon.entity.Direction;
import ru.vsu.cs.nexnon.entity.Entrant;

import java.util.List;


public class TestDAO extends TestCase {

    private static Entrant entrant = new Entrant("Олег", "oleg@mail.ru", "1234", 234);
    private static Direction direction = new Direction("ИБ", 6);
    private static Application application = new Application(entrant, direction);

    @Test
    public void testSaveData(){
        DAO userDAO = new DAO();

        int startSize = userDAO.findAllEntrants().size();
        userDAO.saveEntrant(entrant);
        int endSize = userDAO.findAllEntrants().size();
        assertEquals(endSize - startSize, 1);

        startSize = userDAO.findAllDirections().size();
        userDAO.saveDirection(direction);
        endSize = userDAO.findAllDirections().size();
        assertEquals(endSize - startSize, 1);

        startSize = userDAO.findAllApplications().size();
        userDAO.saveApplication(application);
        endSize = userDAO.findAllApplications().size();
        assertEquals(endSize - startSize, 1);



    }

    @Test
    public void testGet(){
        DAO userDAO = new DAO();

        List<Entrant> entrantList = userDAO.findAllEntrants();
        List<Direction> directionList = userDAO.findAllDirections();
        List<Application> applicationList = userDAO.findAllApplications();

        assertNotNull(entrantList);
        assertNotNull(applicationList);
        assertNotNull(directionList);
    }

    @Test
    public void testDeleteData(){
        DAO userDAO = new DAO();

        int startSize = userDAO.findAllApplications().size();
        userDAO.deleteApplication(application);
        int endSize = userDAO.findAllApplications().size();
        assertEquals(endSize - startSize, -1);

        startSize = userDAO.findAllEntrants().size();
        userDAO.deleteEntrant(entrant);
        endSize = userDAO.findAllEntrants().size();
        assertEquals(endSize - startSize, -1);

        startSize = userDAO.findAllDirections().size();
        userDAO.deleteDirection(direction);
        endSize = userDAO.findAllDirections().size();
        assertEquals(endSize - startSize, -1);
    }
}
