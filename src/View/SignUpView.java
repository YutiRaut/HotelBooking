package View;

import Dao.Exceptions.DAOException;
import Dao.UserDao;
import Model.User;
import Validations.EmailValidation;
import common.MenuInput;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.InputMismatchException;


public class SignUpView {

    public User startSignupInput() throws MessagingException, SQLException, DAOException {
        MenuInput menuInput = new MenuInput();
        User user = new User();

        System.out.println("-------To Create Your Account!!!-------");

        do {
            System.out.println("\nEnter your Name:- ");
            user.setName(menuInput.takeStringInput(false));
        } while (user.getName().trim().isEmpty());

        do {
            System.out.println("Enter your email:- ");
            user.setEmail(menuInput.takeStringInput(false));
            if (!(EmailValidation.validate(user.getEmail())) || UserDao.checkEmailExists(user.getEmail())) {
                System.out.println("Invalid Mail!!! or Email already existed");
            }
        } while ((!EmailValidation.validate(user.getEmail())) || (UserDao.checkEmailExists(user.getEmail())));

        do {
            System.out.println("Enter your Contact Number:- ");
            user.setContact(menuInput.takeStringInput());
        } while (user.getContact().trim().length() != 10);

        do {
            System.out.println("Enter your Password:- ");
            user.setPassword(menuInput.takeStringInput());
        } while (user.getPassword().trim().isEmpty());

        try {
            System.out.println("Your Role(1.System Admin,2.Customer,3.Hotel Admin):- ");
            user.setRole(menuInput.takeNumberInput());
        } catch (InputMismatchException e) {
            throw new DAOException("Enter number only ", e);
        }
        return user;
    }


}




