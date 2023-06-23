package Dao;

import Dao.Exceptions.DAOException;
import Model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    //selectState
    public List<Address> getState() throws DAOException, SQLException {
        List<Address> addresses = new ArrayList<>();
            Statement statement = MainConnection.getInstance().getMainConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * From state ");
            while (rs.next()) {
                Address address = new Address();
                address.setState_id(rs.getInt(1));
                address.setViewState(rs.getString(2));
                addresses.add(address);
            }
        return addresses;
    }

    public List<Address> getCity(int state_id) throws DAOException, SQLException {
        List<Address> addresses = new ArrayList<>();
        try {
            String viewCity = "Select * From city where state_id=?";
            PreparedStatement statement = MainConnection.getInstance().getMainConnection().prepareStatement(viewCity);
            statement.setInt(1, state_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setCity(resultSet.getInt(1));
                address.setViewCity(resultSet.getString(2));
                address.setState_id(resultSet.getInt(3));
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public Address addAddress(Address address, int id) throws SQLException {
        try {
            PreparedStatement statement = null;
            String insertAddress = "insert into address(address_line1,city_id,pincode) values(?,?,?)";
            statement = MainConnection.getInstance().getMainConnection().prepareStatement(insertAddress);
            statement.setString(1, address.getAddress());
            statement.setInt(2, id);
            statement.setInt(3, address.getPincode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    public Address getAddress() throws DAOException {
        Address address = new Address();
        try {
            String getAddressQuery = "select * from address";
            PreparedStatement statement = MainConnection.getInstance().getMainConnection().prepareStatement(getAddressQuery);
            ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
                address.setAddress_id(resultSet.getInt(1));
            }
        }catch (SQLException e){
            throw new DAOException("error occured",e);
        }

        return  address;
    }


}
