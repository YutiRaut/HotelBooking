package Manager;

import Dao.Exceptions.DAOException;
import Dao.UserDao;
import Model.User;
import View.SignUpView;
import common.MailService;
import common.OTPGenerater;
import common.PrintMessage;

import javax.mail.MessagingException;
import java.sql.SQLException;

public class SignUpManager {

    private UserDao userDao = new UserDao();
    private MailService sendMail = new MailService();
    private OTPGenerater sendOtp = new OTPGenerater();
    private PrintMessage message = new PrintMessage();

    public void signUpManager() throws DAOException, MessagingException, SQLException {
        SignUpView signUpView = new SignUpView();

        User user = signUpView.startSignupInput();
        String verificationCode = sendOtp.generatesOtp();
        user.setVerificationCode(verificationCode);
        userDao.addUser(user);
        sendMail(user);
       // sendMail.sendsOtp(user.getEmail(), verificationCode);
        message.displayMessage("Account Created");
    }
    private void sendMail(User user) throws MessagingException {
        StringBuilder mailContent = new StringBuilder();
        mailContent.append("<H1>")
                .append("Hi, ").append(user.getName()).append(" ")
                .append("</H1>")
                .append("Your verification code :").append(user.getVerificationCode());
        sendMail.sendsOtp(user.getEmail(), "Zoom Car:Account verification code", mailContent.toString());
    }

}
