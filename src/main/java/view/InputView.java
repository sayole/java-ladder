package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUsers() {
        return scanner.nextLine();
    }

    public static int getLadderHeight() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getSelectedResult() {
        return scanner.nextLine();
    }

    public static String getResults() {
        return scanner.nextLine();
    }
}