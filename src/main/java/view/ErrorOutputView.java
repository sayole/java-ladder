package view;

public class ErrorOutputView {
    public static void badInputWithUserNumber() {
        System.out.println("\n!!두명 이상의 사용자 이름을 입력해 주세요!!");
    }

    public static void badInputWithLadderHeight() {
        System.out.println("\n!!0보다 큰 정수의 높이를 입력해주세요!!");
    }

    public static void badInputWithResultNumber() {
        System.out.println("\n!!사용자의 숫자와 결과의 갯수가 일치하지 않습니다!!");
    }

    public static void badInputWithUserName() {
        System.out.println("\n!!존재하지 않는 사용자 입니다!!");
    }
}
