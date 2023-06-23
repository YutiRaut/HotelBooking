package Operations;

import Dao.Exceptions.DAOException;
import Dao.HotelDao;
import Manager.HotelManager;
import Model.Hotels;
import View.HotelsView;
import View.MenuCollection;
import common.Constants;
import common.MenuInput;
import common.PrintMessage;

import java.sql.SQLException;
import java.util.Scanner;

public class HotelOperations {
    PrintMessage printMessage = new PrintMessage();

    public void hotelOperations() {
        try {
            MenuCollection mainMenu = new MenuCollection();
            mainMenu.displayHotelAdminHotelMenu();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            HotelManager actions = new HotelManager();
            switch (num) {
                case Constants.MENU_ADD_HOTEL:
                    actions.addHotel();
                    break;
                case Constants.MENU_UPDATE_HOTEL:
                    actions.hotelUpdate();
                    break;
                case Constants.MENU_DELETE:
                    actions.deleteHotelRecords();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHotelDetails() throws DAOException, SQLException {
        HotelDao updates = new HotelDao();
        MenuCollection updateMenu = new MenuCollection();
        updateMenu.updateDetails();
        int choice = MenuInput.takeNumberInput();

        switch (choice) {

            case Constants.MODIFY_NAME:
                HotelsView modifyName = new HotelsView();
                Hotels updateName = modifyName.updateHotelName();
                updates.updateNameQuery(updateName);
                printMessage.displayMessage("-----Name Updated Successfully-----");
                break;

            case Constants.MODIFY_LICENCE_NO:
                HotelsView modifyLicenceNo = new HotelsView();
                Hotels updateLicenceNo = modifyLicenceNo.updateLicenceNo();
                updates.updateLicenceNoQuery(updateLicenceNo);
                printMessage.displayMessage("----Licence No Updated Successfully----");
                break;

            case Constants.MODIFY_STAR_RATING:
                HotelsView modifyStarRating = new HotelsView();
                Hotels updateStarRating = modifyStarRating.updateStarRating();
                updates.updateRatingQuery(updateStarRating);
                printMessage.displayMessage("----Star Rating Updated Successfully----");
                break;

            case Constants.MODIFY_GST_NO:
                HotelsView modifyGstNo = new HotelsView();
                Hotels updateGstNo = modifyGstNo.updateGstNo();
                updates.updateGSTQuery(updateGstNo);
                printMessage.displayMessage("----Gst No Updated Successfully----");
                break;

            case Constants.MODIFY_PERMITES:
                HotelsView modifyPermites = new HotelsView();
                Hotels updatePermites = modifyPermites.updatePermites();
                updates.updatePermitesQuery(updatePermites);
                printMessage.displayMessage("----Permites Updated Successfully----");
                break;

            case Constants.MODIFY_ALL:
                HotelsView modifyAll = new HotelsView();
                Hotels updatesAll = modifyAll.updatesAll();
                updates.updateHotelQuery(updatesAll);
                printMessage.displayMessage("----Details Updated Successfully----");
                break;
            default:
                System.out.println("Please Enter Valid Choice!!!");

        }
    }
}
