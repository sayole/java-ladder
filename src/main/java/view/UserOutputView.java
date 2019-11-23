package view;

import model.LadderResult;
import model.User;

import java.util.List;

public class UserOutputView {
    public static void printName(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder = OutputView.printStringLine(stringBuilder, user.getName());
        }
        System.out.println(stringBuilder);
    }
}
