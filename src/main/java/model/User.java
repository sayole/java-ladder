package model;

public class User {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;
    private String name;
    public User(String nameInput){
        correctIfNoValidName(nameInput);
    }

    private void correctIfNoValidName(String nameInput) {
        if(nameInput.length() > MAX_NAME_LENGTH) {
            makeValidName(nameInput);
            return;
        }
        name = nameInput;
    }

    private void makeValidName(String nameInput) {
        name = nameInput.substring(0,MAX_NAME_LENGTH);
    }

    public String getName() {
        return name;
    }

    public boolean isSelected(String selectedUser){
        if(name.equals(selectedUser)){
            return true;
        }
        return false;
    }
}
