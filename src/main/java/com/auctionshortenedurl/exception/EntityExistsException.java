package com.auctionshortenedurl.exception;

import javax.persistence.PersistenceException;

public class EntityExistsException extends PersistenceException {

    public EntityExistsException(String message) {
        super(message);
    }

}
