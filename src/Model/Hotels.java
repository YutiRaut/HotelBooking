package Model;

public class Hotels {

    private String hotelName;
    private int licenceNo;
    private int starRating;
    private String gstNo;
    private String permits;
    private String existingHotelName;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(int licenceNo) {
        this.licenceNo = licenceNo;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPermits() {
        return permits;
    }

    public void setPermits(String permits) {
        this.permits = permits;
    }

    public String getExistingHotelName() {
        return existingHotelName;
    }

    public void setExistingHotelName(String existingHotelName) {
        this.existingHotelName = existingHotelName;
    }
}
