package cl.samueltoloza.challenge.util;

import cl.samueltoloza.challenge.exception.ProductNotFoundException;

public final class Validation {

    public static <T> T checkProductNull(final T resource) throws ProductNotFoundException {
        if(resource==null){
            throw new ProductNotFoundException();
        }
        return resource;
    }


}
