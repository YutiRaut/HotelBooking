package common;

import Model.User;

public class CurrentUser {
    private static User currentUser=null;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser.currentUser = currentUser;
    }
}
