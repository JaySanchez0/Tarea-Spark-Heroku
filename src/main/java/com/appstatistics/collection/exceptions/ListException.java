package com.appstatistics.collection.exceptions;

public class ListException extends Exception{

    public static final String emptyListInvalidRemove = "The list is empty not remove element";

    /**
     *
     * @param msg mensage de error
     */
    public ListException(String msg){
        super(msg);
    }

}