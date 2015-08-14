import com.company.model.User;
import com.company.model.UserCreateForm;
import com.company.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Services test
 */
public class TestServices {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateAndFindUser() throws Exception {
        String userName = "test";
        String userPassword = "qwerty2";
        User user = new User(userName, userPassword);
        UserCreateForm form = new UserCreateForm();
        form.setName(userName);
        form.setPassword(userPassword);

        User userFromDB = userService.createUser(form);
        assertNotNull(userFromDB);
        userFromDB = userService.findUser(userName);
        assertNotNull(userFromDB);
        assertEquals(user, userFromDB);
    }
}
