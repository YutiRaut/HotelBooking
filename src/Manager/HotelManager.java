package Manager;

import Dao.AddressDao;
import Dao.Exceptions.DAOException;
import Dao.HotelDao;
import Model.Hotels;
import Operations.HotelOperations;
import View.HotelsView;
import common.CurrentUser;
import common.PrintMessage;

import java.sql.SQLException;

public class HotelManager {
    PrintMessage message = new PrintMessage();
    AddressManager addressManager = new AddressManager();

    public void addHotel() throws SQLException, DAOException {
        HotelDao hotelDao = new HotelDao();
        HotelsView hotelsView = new HotelsView();
        Hotels hotels = hotelsView.addDetails();
        hotelDao.addHotelAdmin(CurrentUser.getCurrentUser().getUserId(), hotels,addressManager.getAddressId());
        message.displayMessage("----Details Added Successfully----");
    }


    public void hotelUpdate() throws DAOException, SQLException {
        HotelOperations updatesAll = new HotelOperations();
            updatesAll.updateHotelDetails();
    }

    public void deleteHotelRecords() {
        HotelDao hotelDao = new HotelDao();
        HotelsView deletes = new HotelsView();
        Hotels delete = deletes.deleteHotelRecord();
        try {
            hotelDao.deleteHotelQuery(delete);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        message.displayMessage("-----Record Deleted Successfully-----");
    }
}
