package model;

import java.util.List;

public class User {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MINIMUM_USERS = 2;
    private String name;

    public User(String userName) {
        this.name = userName;
    }

    public static void addIfGoodInput(String userName, List<User> users) {
        if(userName.equals(""))
            return;
        if (userName.length() > MAX_NAME_LENGTH) {
            userName = makeValidName(userName);
        }
        User user = new User(userName);
        users.add(user);
    }

    private static String makeValidName(String nameInput) {
        return nameInput.substring(0, MAX_NAME_LENGTH);
    }

    public String getName() {
        return name;
    }

    public boolean isSelected(String selectedUser) {
        if (name.equals(selectedUser)) {
            return true;
        }
        return false;
    }
}
