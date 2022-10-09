package br.com.company.core.validator;

public class ExceptionResponse {
    
    private final String message;

    private final String customCode;

    public ExceptionResponse(String message, String customCode) {
        this.message = message;
        this.customCode = customCode;
    }

    public String getMessage() {
        return message;
    }

    public String getCustomCode() {
        return customCode;
    }

    
    
}
