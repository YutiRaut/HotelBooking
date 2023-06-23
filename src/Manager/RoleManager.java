package Manager;

import Dao.Exceptions.DAOException;
import Model.User;
import View.MenuCollection;
import common.Constants;
import Operations.HotelOperations;
import common.CurrentUser;

public class RoleManager {
    HotelOperations hotelOperations = new HotelOperations();
    MenuCollection menuCollection= new MenuCollection();

    public void displayMenuByRole() throws DAOException {

        if (CurrentUser.getCurrentUser().getRole() == Constants.SYSTEM_ADMIN) {
          menuCollection.displaySystemAdminHotelMenu();
        } else if ( CurrentUser.getCurrentUser().getRole()== Constants.CUSTOMER) {
            menuCollection.customerMenu();
        } else if (CurrentUser.getCurrentUser().getRole() == Constants.HOTEL_ADMIN) {
            hotelOperations.hotelOperations();
        }
    }
}
