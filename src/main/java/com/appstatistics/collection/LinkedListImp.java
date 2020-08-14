package com.appstatistics.collection;

import com.appstatistics.collection.exceptions.ListException;
import java.util.function.Function;

public class LinkedListImp {

    private ListNode fNode;

    private ListNode lNode;

    private int count;

    /**
     * Lista de numeros reales vacia
     */
    public LinkedListImp(){
        count =0;
    }

    /**
     *
     * @param value valor a ser ubicado al final de la coleccion
     */
    public void add(double value){
        ListNode node = new ListNode(value);
        if(fNode==null)
            fNode = node;
        else
            lNode.addNode(node);
        lNode = node;
        count+=1;
    }

    /**
     *
     * @return el numero de datos almacenados en la coleccion
     */
    public int length(){
        return count;
    }

    /**
     *
     * @return devuelve el valor del primer elemento de la colleccion
     * @throws ListException si no existen elementos en la colleccion
     */
    public double removeFirst() throws ListException{
        if(fNode==null)
            throw new ListException(ListException.emptyListInvalidRemove);
        count-=1;
        if(count==0) lNode=null;
        double value = fNode.getValue();
        fNode = fNode.getChild();
        return value;
    }

    /**
     *
     * @param value valor a buscar dentro de la coleccion
     * @return devuelve si el dato se encuentra almacenado dentro de la coleccion
     */
    public boolean contains(double value){
        return fNode.contain(value);
    }

    /**
     *
     * @param function operacion a aplicar sobre todos los elementos de la coleccion
     * @return una coleccion con la propiedad customer aplicada
     */
    public LinkedListImp apply(Function<Double,Double> function){
        LinkedListImp list = new LinkedListImp();
        for(int i=0;i<length();i++){
            try{
                double val = removeFirst();
                list.add(function.apply(val));
                add(val);
            }catch (ListException e){}
        }
        return list;
    }

    /**
     *
     * @param string - La lista en representacion a manera de String de la lista
     * @return la lista de doubles
     */
    public static LinkedListImp getList(String string){
        String[] arr = string.replace("[","").replace("]","").replace("\"","").split(",");
        LinkedListImp list = new LinkedListImp();
        //System.out.println(string);
        for(String s:arr){
            list.add(Double.parseDouble(s.replace(" ","")));
        }
        return list;
    }

}