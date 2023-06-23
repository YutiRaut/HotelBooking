package View;
import Model.Address;
import java.util.List;

public class AddressView {
    public void stateDetails(List<Address> addresses) {
        System.out.println("Select State");
        for (Address address : addresses) {
            System.out.println(address.getState_id() + " " + address.getViewState());
        }
    }
    public void cityDetails(List<Address> addresses) {
        for (Address address : addresses) {
            System.out.println(address.getCity() + " " + address.getViewCity());
        }
    }

}



