package Manager;

import Dao.Exceptions.DAOException;
import Dao.UserDao;
import Model.User;
import View.LoginView;
import common.CurrentUser;
import common.MenuInput;
import common.PrintMessage;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Scanner;


public class LoginManager {
    private UserDao userDao = new UserDao();
    private PrintMessage message = new PrintMessage();
    private RoleManager roleManager = new RoleManager();
    private int count = 0;
    private int target = 3;
    Scanner scan = new Scanner(System.in);

    public void loginManager() throws DAOException, SQLException, MessagingException {
        User user1;
        MenuInput menuInput = new MenuInput();
        do {
            LoginView ld = new LoginView();
            User user = ld.loginInput();
            user1 = userDao.checkUserCredentials(user.getEmail(), user.getPassword());
            if (user1 == null) {
                message.displayMessage("INVALID CREDENTIALS ENTERED");
            } else if (!user1.isVerified()) {
                do {
                    System.out.println("Enter otp:- ");
                    String otp = menuInput.takeStringInput(false);
                    if (otp.equals(user1.getVerificationCode())) {
                        userDao.updateUserIsVerified(user1.setVerified(true), user.getEmail());
                        message.displayMessage("Now You Are Verified user");
                        message.displayMessage(" Login Success!!!" + "\n\tWelcome " + user1.getName());
                        CurrentUser.setCurrentUser(user1);
                        roleManager.displayMenuByRole();
                        break;
                    } else {
                        message.displayMessage("InValid Otp Entered");
                    }

                } while (!user.isVerified());
            } else {
                message.displayMessage(" Login Success!!!" + "\n\tWelcome " + user1.getName());
                CurrentUser.setCurrentUser(user1);
                roleManager.displayMenuByRole();
            }
            count++;
        } while ((user1 == null) && (count < target));
    }
}
