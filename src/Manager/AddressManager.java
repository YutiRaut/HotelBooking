package Manager;

import Dao.AddressDao;
import Dao.Exceptions.DAOException;
import Dao.HotelDao;
import Model.Address;
import View.AddressView;

import java.sql.SQLException;
import java.util.List;

public class AddressManager {
    AddressDao addressDao = new AddressDao();
    AddressView addressView= new AddressView();
    int cityId;
    public int getAddressId() throws DAOException, SQLException {
        Address address = addressDao.getAddress();
        return  address.getAddress_id();
    }

    /*public void stateDetails() throws DAOException, SQLException {
        List<Address> addressList = addressDao.getState();
        addressView.stateDisplayDetails(addressList);
        cityDetails();
    }

    public void cityDetails() throws DAOException, SQLException {
        List<Address> addressList = addressDao.getCity(addressView.displayState());
        addressView.cityDisplayDetails(addressList);
        cityId = addressView.displayCity();
        addressDetails();

    }
    public void addressDetails() throws DAOException, SQLException {
        Address address = addressView.displayAddress();
        addressDao.addAddress(address,cityId);
    }
    public int getAddressDetails() throws DAOException, SQLException {
       Address address = addressDao.getAddress();
        return address.getAddress_id();
    }*/
}
