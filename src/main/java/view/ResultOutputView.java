package view;

import model.LadderResult;
import model.User;
import model.UserResult;

import java.util.List;

public class ResultOutputView {
    public static void printResult(List<LadderResult> results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderResult result : results) {
            OutputView.printStringLine(stringBuilder, result.getResult());
        }
        System.out.println(stringBuilder);
    }

    public static void printSelectedResult(String selectedResult) {
        System.out.println("\n실행결과");
        System.out.println(selectedResult);
    }

    public static void printAllResult(List<User> users, List<UserResult> userResults) {
        System.out.println("\n실행결과");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName() + " : " + userResults.get(i).getResult());
        }
    }
}
