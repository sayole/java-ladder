package view;

public class ErrorOutputView {
    public static void badInputWithUserNumber() {
        System.out.println("두명 이상의 사용자 이름을 입력해 주세요.");
    }

    public static void badInputWithLadderHeight() {
        System.out.println("0보다 큰 정수의 높이를 입력해주세요.");
    }

    public static void badInputWithResultNumber() {
        System.out.println("사용자의 숫자와 결과의 갯수가 일치하지 않습니다.");
    }
}
