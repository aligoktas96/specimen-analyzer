package nl.specimen.analyzer.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(ExceptionCode exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
    }
}
