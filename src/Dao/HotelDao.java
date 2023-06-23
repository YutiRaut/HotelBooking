package Dao;

import Dao.Exceptions.DAOException;
import Model.Address;
import Model.Hotels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDao {
    public void addHotelAdmin(int userId,Hotels hotels,int addressId) throws DAOException {
        try {
            String addQuery = "INSERT INTO hotel(hotel_name,licence_no,star_rating,GST_No,permites,user_id,address_id) values(?,?,?,?,?,?,?)";
            PreparedStatement stmt1;
            stmt1 = MainConnection.getInstance().getMainConnection().prepareStatement(addQuery);

            stmt1.setString(1, hotels.getHotelName());
            stmt1.setInt(2, hotels.getLicenceNo());
            stmt1.setInt(3, hotels.getStarRating());
            stmt1.setString(4, hotels.getGstNo());
            stmt1.setString(5, hotels.getPermits());
            stmt1.setInt(6,userId);
            stmt1.setInt(7,addressId);
            stmt1.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }

    }

    public int updateHotelQuery(Hotels updatehotel) throws DAOException {
        try {
            String updateAllDetails = "UPDATE hotel SET hotel_name=?,licence_no=?,star_rating=?,GST_No=?,permites=? where hotel_name=?";
            PreparedStatement stmt4;
            stmt4 = MainConnection.getInstance().getMainConnection().prepareStatement(updateAllDetails);
            stmt4.setString(1, updatehotel.getHotelName());
            stmt4.setInt(2, updatehotel.getLicenceNo());
            stmt4.setInt(3, updatehotel.getStarRating());
            stmt4.setString(4, updatehotel.getGstNo());
            stmt4.setString(5, updatehotel.getPermits());
            stmt4.setString(6, updatehotel.getExistingHotelName());
            return stmt4.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }
    }

    public int updateNameQuery(Hotels name) throws DAOException {
        try {
            String updateHotelName = "UPDATE hotel SET hotel_name=? where hotel_name=?";
            PreparedStatement stmt6;
            stmt6 = MainConnection.getInstance().getMainConnection().prepareStatement(updateHotelName);
            stmt6.setString(1, name.getHotelName());
            stmt6.setString(2, name.getExistingHotelName());
            return stmt6.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }
    }


    public int updateLicenceNoQuery(Hotels licence) throws DAOException {
        try {
            String updateLicence = "UPDATE hotel SET licence_no=? where hotel_name=?";
            PreparedStatement stmt5;
            stmt5 = MainConnection.getInstance().getMainConnection().prepareStatement(updateLicence);
            stmt5.setInt(1,licence.getLicenceNo());
            stmt5.setString(2, licence.getExistingHotelName());
            return stmt5.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }


    }

    public int updateRatingQuery(Hotels rating) throws DAOException {
        try {
            String starRating = "UPDATE hotel SET star_rating=?  where hotel_name=?";
            PreparedStatement stmt7;
            stmt7 = MainConnection.getInstance().getMainConnection().prepareStatement(starRating);
            stmt7.setInt(1, rating.getStarRating());
            stmt7.setString(2, rating.getExistingHotelName());
            return stmt7.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }

    }


    public int updateGSTQuery(Hotels gst) throws DAOException {
        try {
            String GST = "UPDATE hotel SET GST_No=?  where hotel_name=?";
            PreparedStatement stmt7;
            stmt7 = MainConnection.getInstance().getMainConnection().prepareStatement(GST);
            stmt7.setString(1, gst.getGstNo());
            stmt7.setString(2, gst.getExistingHotelName());
            return stmt7.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }

    }
    public int updatePermitesQuery(Hotels permite) throws DAOException {
        try {
            String permites = "UPDATE hotel SET permites=?  where hotel_name=?";
            PreparedStatement stmt7;
            stmt7 = MainConnection.getInstance().getMainConnection().prepareStatement(permites);
            stmt7.setString(1,permite.getPermits() );
            stmt7.setString(2, permite.getExistingHotelName());
            return stmt7.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }
    }
    public int deleteHotelQuery(Hotels deleteRecord) throws DAOException {
        try {
            String delete = "Delete FROM hotel where hotel_name=?";
            PreparedStatement stmt7;
            stmt7 = MainConnection.getInstance().getMainConnection().prepareStatement(delete);
            stmt7.setString(1, deleteRecord.getHotelName());
            return stmt7.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Opps something went wrong...", ex);
        } catch (Exception ex) {
            throw new DAOException("Opps something went wrong...", ex);
        }
    }
}
