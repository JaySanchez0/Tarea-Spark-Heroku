package com.appstatistics.collection;

public class ListNode {

    private ListNode child;

    private double valueData;

    /**
     *
     * @param valueData Real a guardar
     */
    public ListNode(double valueData){
        this.valueData = valueData;
    }

    /**
     *
     * @return el valor correspondiente al nodo actual
     */
    public double getValue(){
        return valueData;
    }

    /**
     *
     * @param data alamacena el valor al final de la lista
     */
    public void addNode(ListNode data){
        if(child==null)
            child=data;
        else
            child.addNode(data);
    }

    /**
     *
     * @return devuelve el nodo hijo
     */
    public ListNode getChild() {
        return child;
    }

    /**
     *
     * @param value valor a buscar dentro del este nodo o un nodo externo
     * @return devuelve si mi nodo tiene este valor o un nodo hijo
     */
    public boolean contain(double value) {
        if(child==null)
            return valueData==value;
        else
            return value==valueData || child.contain(value);
    }

}