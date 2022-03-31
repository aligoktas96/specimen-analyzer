package nl.specimen.analyzer.common.exception;

public enum ExceptionCode {
    CODE_NOT_FOUND(1000, "Code not found.");

    private final Integer code;
    private final String message;

    ExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
