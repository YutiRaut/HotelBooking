import Manager.LoginManager;
import Manager.SignUpManager;
import View.MenuCollection;
import common.Constants;
import common.MenuInput;


public class HotelBooking {
    public static void main(String[] args) {

        try {
            //1. Display menu
            //2. Input
            //3. Validate
            //4. Business logic
            //5. DATABASE ops
         int choice;
            do {
                MenuCollection mainMenu = new MenuCollection();
                LoginManager login = new LoginManager();
                MenuInput menuInput = new MenuInput();
                mainMenu.mainMenu();
                choice = menuInput.takeNumberInput();
                SignUpManager signUpManager = new SignUpManager();
                switch (choice) {
                    case Constants.SIGNUP:
                        signUpManager.signUpManager();
                        break;
                    case Constants.LOGIN:
                        login.loginManager();
                        break;
                    case Constants.EXIT:
                        System.exit(0);
                    default:
                        System.out.println("Please Enter Valid NO!!!");
                }
            } while (!(choice == 3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}