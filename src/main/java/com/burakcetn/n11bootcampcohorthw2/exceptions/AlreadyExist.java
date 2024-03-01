package com.burakcetn.n11bootcampcohorthw2.exceptions;

import com.burakcetn.n11bootcampcohorthw2.errorHandler.BaseErrorMessage;
import com.burakcetn.n11bootcampcohorthw2.errorHandler.BussinesException;

public class AlreadyExist extends BussinesException {

    public AlreadyExist(BaseErrorMessage message) {
        super(message);
    }
}
