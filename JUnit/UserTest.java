import com.example.sjsuwebsite.model.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserPassword()
    {
        Users user = new Users();

        user.setPassword("1234");

        assertEquals(user.getPassword(),"1234", "Password is supposed to be 1234");

    }
}
