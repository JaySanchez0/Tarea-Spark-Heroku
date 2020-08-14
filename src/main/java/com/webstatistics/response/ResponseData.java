package com.webstatistics.response;

public class ResponseData {
    private double average;
    private double deviation;

    /**
     *
     * @param average - Promedio a reponder por el servicio web
     * @param deviation - desviacion estandar a reponder por el servicio web
     */
    public ResponseData(double average,double deviation){
        this.average = average;
        this.deviation = deviation;
    }

    /**
     *
     * @return devuelve la representacion del objeto como string
     */
    @Override
    public String toString(){
        return "{\"average\":"+average+",\"deviation\":"+deviation+"}";
    }
}
