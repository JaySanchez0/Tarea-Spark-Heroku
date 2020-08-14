package com.appstatistics.operation;

import com.appstatistics.collection.LinkedListImp;
import com.appstatistics.collection.exceptions.ListException;
import com.appstatistics.operation.exception.OperationException;

public class Operation {

    private static double sum(LinkedListImp list) throws ListException {
        double acum = 0;
        for (int i = 0; i < list.length(); i++) {
            double val = list.removeFirst();
            acum += val;
            list.add(val);
        }
        return acum;
    }

    /**
     *
     * @param list El conjunto de datos sobre el cual se va a calcular el promedio
     * @return el promedio de los datos
     * @throws OperationException si no hay datos
     */
    public static double average(LinkedListImp list) throws OperationException{
        if(list.length()==0)
            throw new OperationException(OperationException.unvalidDivision);
        try {
            return sum(list) / list.length();
        }catch (ListException e){
            return -1;
        }
    }

    /**
     *
     * @param list conjunto de elementos sobre los cuales calcular la desviacion
     * @return la desviacion estandar entre la muestra
     * @throws OperationException si el numero de elemento no es minimo 2
     */
    public static double deviation(LinkedListImp list) throws OperationException {
        if(list.length()<2) throw new OperationException(OperationException.notDeviation);
        try{
            double av = average(list);
            LinkedListImp me = list.apply((xi)-> Math.pow(xi-av,2));
            double subt = sum(me);
            return Math.sqrt(subt/(list.length()-1));
        } catch(ListException e){
            return 0;
        }
    }

}