package controller;

import model.Ladder;
import model.LadderResult;
import model.User;
import model.UserResult;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    public static int LADDER_HEIGHT;
    private final static List<User> users = new ArrayList<>();
    private final static List<LadderResult> ladderResults = new ArrayList<>();
    private final static List<UserResult>  userResults = new ArrayList<>();
    private static Ladder ladder;

    public void runLadder(){
        setUsers();
        setLadder();
        setLadderResultsUserResults();
        OutputView.showLadder(ladder, users, ladderResults);
        String selectedResult = "";
        while(!(selectedResult.equals("stop"))){
            OutputView.printSelectUserResult();
            selectedResult = InputView.getSelectedResult();
            showResult(selectedResult);
        }
    }

    private void setUsers() {
        OutputView.printGetUserNames();
        String usernames = InputView.getUsers();
        for (String username : usernames.split(",")) {
            User user = new User(username);
            users.add(user);
        }
    }

    private void setLadder() {
        OutputView.printGetLadderHeight();
        LADDER_HEIGHT = InputView.getLadderHeight();
        ladder = new Ladder(LADDER_HEIGHT, users.size());
    }

    private void setLadderResultsUserResults() {
        OutputView.printGetResults();
        String stringResults = InputView.getResults();
        setLadderResults(stringResults);
        setUserResults(stringResults);
    }

    private void setLadderResults(String stringResults){
        for (String result : stringResults.split(",")) {
            LadderResult ladderResult = new LadderResult(result);
            ladderResults.add(ladderResult);
        }
    }

    private void setUserResults(String stringResults) {
        String[] results = stringResults.split(",");
        UserResult.makeUserResults(userResults, results, ladder);
    }

    private void showResult(String selectedResult) {
        if (selectedResult.equals("all")) {
            OutputView.printAllResult(users, userResults);
            return;
        }
        showUserResult(selectedResult);
    }

    private void showUserResult(String selectedUser) {
        boolean selected = false;
        int index;
        for (index = 0; index < users.size() && selected != true; index++) {
            selected = users.get(index).isSelected(selectedUser);
        }
        if (selected == true)
            OutputView.printSelectedResult(userResults.get(index - 1).getResult());
    }
}
