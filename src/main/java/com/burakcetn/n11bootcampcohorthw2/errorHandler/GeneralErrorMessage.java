package com.burakcetn.n11bootcampcohorthw2.errorHandler;

public enum GeneralErrorMessage implements BaseErrorMessage{



    ALREADY_EXIST("already_exist");

    private final String message;

    GeneralErrorMessage(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
