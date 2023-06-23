package View;


public class MenuCollection {

    public void mainMenu() {
        System.out.println("\t\t\t\n------Welcome to Traveller------");
        System.out.println("\n1.Sign up");
        System.out.println("2.login");
        System.out.println("3.Exit");
        System.out.println("\nPlease Enter a number:- ");
    }

    public void displayHotelAdminHotelMenu() {
        System.out.println("Select Oprations");
        System.out.println("1.Add HotelDetails");
        System.out.println("2.Update HotelDetails");
        System.out.println("3.Delete HotelDetails");
        System.out.println("Please select your choice:");
    }

    public void displaySystemAdminHotelMenu() {
        System.out.println("Select Oprations");
        System.out.println("1.Add HotelDetails");
        System.out.println("2.Update HotelDetails");
        System.out.println("3.Delete HotelDetails");
        System.out.println("Please select your choice:");
    }

    public void updateDetails() {
        System.out.println("Select the details you want to Update");
        System.out.println("1.Hotel Name");
        System.out.println("2.Hotel Licence No");
        System.out.println("3.Star Rating");
        System.out.println("4.GST NO");
        System.out.println("5.Permites");
        System.out.println("6.Update All");
        System.out.println("Your Choice:- ");
    }
    public void customerMenu(){
        System.out.println("1.Search Hotel");
        System.out.println("2.View Account Details");
        System.out.println("3.Update Profile");
        System.out.println("Please select an Option:- ");
    }
}
