package View;

import Dao.Exceptions.DAOException;
import Model.User;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {

    public User loginInput() throws DAOException, MessagingException, SQLException {
        User user = new User();
        System.out.println("----Welcome to Login----");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your email:- ");
        user.setEmail(sc1.nextLine());
        do {
            if (!(user.getEmail().trim().isEmpty())) {
                break;
            } else {
                System.out.println("\tRequired!!!\nplease enter your Email:- ");
                user.setEmail(sc1.nextLine());
            }
        } while (user.getEmail().trim().isEmpty());

        System.out.println("Enter your password:- ");
        user.setPassword(sc1.nextLine());
        do {

            if (!user.getPassword().trim().isEmpty()) {
                break;
            } else {
                System.out.println("\tRequired!!!\n\nplease enter your Password:- ");
                user.setPassword(sc1.nextLine());
            }
        } while (user.getPassword().trim().isEmpty());
        return user;
    }

}





