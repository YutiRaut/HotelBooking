package View;

import Dao.AddressDao;
import Dao.Exceptions.DAOException;
import Manager.AddressManager;
import Model.Address;
import Model.Hotels;
import common.MenuInput;

import java.sql.SQLException;
import java.util.List;

public class HotelsView {
    Hotels hotels = new Hotels();
    Address address = new Address();
    AddressDao addressDao = new AddressDao();
    AddressView addressView = new AddressView();
    AddressManager addressManager = new AddressManager();

    public Hotels addDetails() throws DAOException, SQLException {
        System.out.println("Enter your Hotel name:- ");
        hotels.setHotelName(MenuInput.takeStringInput());
        List<Address> statelist = addressDao.getState();
        addressView.stateDetails(statelist);
        System.out.println("Enter state no:-");
        int stateID = (MenuInput.takeNumberInput());
        address.setState_id(stateID);
        List<Address> cityList = addressDao.getCity(stateID);
        addressView.cityDetails(cityList);
        System.out.println("Enter City ID");
        int cityID = (MenuInput.takeNumberInput());
        address.setCity(cityID);
        System.out.println("Enter your Address:- ");
        address.setAddress(MenuInput.takeStringInput());
        System.out.println("Enter Pincode:- ");
        address.setPincode(MenuInput.takeNumberInput());
        addressDao.addAddress(address, address.getCity());
        System.out.println("Enter hotel licence no:-");
        hotels.setLicenceNo(MenuInput.takeNumberInput());
        System.out.println("Enter Star Rating:-");
        hotels.setStarRating(MenuInput.takeNumberInput());
        System.out.println("GST NO:- ");
        hotels.setGstNo(MenuInput.takeStringInput());
        System.out.println("Enter permits:- ");
        hotels.setPermits(MenuInput.takeStringInput());
        System.out.println("NO OF Rooms you wanted to list:- ");

        return hotels;

    }

    public Hotels updatesAll() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("Please Enter Name:- ");
        hotels.setHotelName(MenuInput.takeStringInput());
        System.out.println("Please Enter licence no:- ");
        hotels.setLicenceNo(MenuInput.takeNumberInput());
        System.out.println("Please Enter Star Rating:-");
        hotels.setStarRating(MenuInput.takeNumberInput());
        System.out.println("GST NO:- ");
        hotels.setGstNo(MenuInput.takeStringInput());
        System.out.println("Enter permits:- ");
        hotels.setPermits(MenuInput.takeStringInput());
        return hotels;
    }

    public Hotels updateHotelName() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("Please enter the name you want to hotels:- ");
        hotels.setHotelName(MenuInput.takeStringInput());
        return hotels;
    }

    public Hotels updateLicenceNo() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("Please Enter Licence no:- ");
        hotels.setLicenceNo(MenuInput.takeNumberInput());
        return hotels;
    }

    public Hotels updateStarRating() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("Please Enter Star Rating:- ");
        hotels.setStarRating(MenuInput.takeNumberInput());
        return hotels;
    }

    public Hotels updateGstNo() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("GST NO:- ");
        hotels.setGstNo(MenuInput.takeStringInput());
        return hotels;
    }

    public Hotels updatePermites() {
        System.out.println("Please Enter Existing Hotel Name:-");
        hotels.setExistingHotelName(MenuInput.takeStringInput());
        System.out.println("Enter permits:- ");
        hotels.setPermits(MenuInput.takeStringInput());
        return hotels;
    }

    public Hotels deleteHotelRecord() {
        System.out.println("Please Enter Hotel Name:-");
        hotels.setHotelName(MenuInput.takeStringInput());
        return hotels;
    }


}
