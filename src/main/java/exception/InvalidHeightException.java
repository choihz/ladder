package exception;

public class InvalidHeightException extends RuntimeException {
    public InvalidHeightException() {
        super("1 이상의 적절한 숫자를 입력하세요.");
    }
}
