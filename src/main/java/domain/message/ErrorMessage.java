package domain.message;

public enum ErrorMessage {
    EMPTY_VALUE("null 이나 빈 문자열을 입력할 수 없습니다.");
    
    private String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
