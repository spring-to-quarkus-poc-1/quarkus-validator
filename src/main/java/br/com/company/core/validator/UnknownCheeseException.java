package br.com.company.core.validator;

public class UnknownCheeseException extends RuntimeException{
    
    private final String name;

    public UnknownCheeseException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
