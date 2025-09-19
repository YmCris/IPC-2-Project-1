package backend.user;

import backend.exceptions.ObjectAlredyExistException;
import dababase.creation.UserCreateDB;
import jakarta.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;

/**
 * Clase UserCreator es la clase encargada de crear usuarios mediante el request
 *
 * @author YmCris
 * @since Sep 18, 2025
 */
public class UserCreator {

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public User createUser(HttpServletRequest request) throws InvalidParameterException, ObjectAlredyExistException {
        UserCreateDB userDB = new UserCreateDB();
        User user = extract(request);
        if (userDB.userExist(user.getDpi())) {
            throw new ObjectAlredyExistException("The user already exist");
        }
        userDB.createUser(user);
        return user;
    }

    private User extract(HttpServletRequest request) throws InvalidParameterException {
        try {
            User user = new User(
                    request.getParameter("name"),
                    request.getParameter("dpi"),
                    request.getParameter("phoneNumber"),
                    request.getParameter("email"),
                    request.getParameter("password"),
                    "si",
                    request.getParameter("institution"),
                    Boolean.parseBoolean(request.getParameter("foreign")),
                    true);
            System.out.println(user.getName());
            System.out.println(user.getDpi());
            System.out.println(user.getPhoneNumber());
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getPhoto());
            System.out.println(user.getInstitutionName());
            System.out.println(user.isActive());
            System.out.println(user.isForeign());
            if (!user.parametersAreCorrect()) {
                throw new InvalidParameterException("Recive data failed");
            }
            return user;
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidParameterException("Recive data failed");
        }
    }
}
