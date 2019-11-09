import controller.LadderController;
import view.InputView;
import view.OutputView;

public class LadderApplication {
        private static boolean power = true;
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.setUsers();
        ladderController.setLadder();
        ladderController.setResults();
        ladderController.showLadder();
        String selectedUser = " ";
        while(!(selectedUser.equals("all"))){
            OutputView.printSelectUserResult();
            selectedUser = InputView.getSelectedResult();
            ladderController.showResult(selectedUser);
        }
    }
}
