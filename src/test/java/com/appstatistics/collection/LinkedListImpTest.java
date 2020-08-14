package com.appstatistics.collection;

import com.appstatistics.collection.exceptions.ListException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LinkedListImpTest{
    /**
     * Valida si que se añadan elementos en la lista
     */
    @Test
    public void shouldHaveElementsTheList(){
        LinkedListImp list = new LinkedListImp();
        list.add(12.0);
        list.add(13.0);
        assertTrue(list.length()==2 && list.contains(12.0) && list.contains(13.0));
    }

    /**
     * Valida que se remuevan los elementos y sus valores correspondan a los esperados
     * @throws ListException
     */
    @Test
    public void shouldBeRemoveElement() throws ListException {
        LinkedListImp list = new LinkedListImp();
        list.add(15.0);
        list.add(12.0);
        assertEquals(list.length(),2);
        double value = list.removeFirst();
        assertTrue(value==15.0 && list.length()==1);
        value = list.removeFirst();
        assertTrue(value==12.0 && list.length()==0);
    }

    /**
     * Valida que falle si se intenta remover un elemento de una lista vacia
     */
    @Test
    public void shouldBeFailWithEmptyListRemove(){
        LinkedListImp list = new LinkedListImp();
        try{
            double val = list.removeFirst();
            assertTrue(false);
        }catch (ListException e){
            assertEquals(list.length(),0);
        }
    }
}
