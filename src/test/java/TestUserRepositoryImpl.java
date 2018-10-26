import junit.framework.TestCase;
import mainSystem.dao.userRepository.UserRepositoryImpl;


public class TestUserRepositoryImpl extends TestCase {

    public void testGetUserNameById(){
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        String name = userRepository.getUserNameById(1);
        assertEquals("Den",name);
    }
}
