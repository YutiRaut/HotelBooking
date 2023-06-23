package Operations;

import View.MenuCollection;
import common.MenuInput;

public class CustomerOprations {
        MenuCollection menuCollection = new MenuCollection();
        public void getState(){
                menuCollection.customerMenu();
                int choice= MenuInput.takeNumberInput();
                switch (choice){
                        case 1:
                                //search hotel
                        case 2:
                                //view profile
                        case 3:
                                //update profile
                }
        }
}
