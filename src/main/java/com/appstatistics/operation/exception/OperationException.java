package com.appstatistics.operation.exception;

public class OperationException extends Exception{

    public static final String unvalidDivision = "No se puede operar un arreglo vacio";
    public static final String notDeviation= "No se puede calcular a desviacion";

    public OperationException(String msg){
        super(msg);
    }

}