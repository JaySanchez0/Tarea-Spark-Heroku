package com.appstatistics.operation;

import com.appstatistics.collection.LinkedListImp;
import com.appstatistics.data.Data;
import com.appstatistics.operation.exception.OperationException;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class OperationTest {
    /**
     * Valida que un conjunto valido le pueda ser calculado el promedio
     * @throws OperationException si no es posible calcular el promedio
     */
    @Test
    public void wouldCalculateTheAverage() throws OperationException {
        LinkedListImp list = new LinkedListImp();
        list.add(2.0);
        list.add(3.0);
        list.add(10.0);
        double val = Operation.average(list);
        double expected = 5.0;
        assertEquals(val,expected,0.0);
    }

    /**
     * Valida que una lista vacia no le pueda ser calculado el promedio
     */
    @Test
    public void shouldBeFailWithEmptySet(){
        LinkedListImp list = new LinkedListImp();
        try {
            System.out.println(Operation.average(list));
            fail();
        }catch(OperationException e){
            assertEquals(list.length(),0);
        }
    }

    /**
     * Verifica que el valor calclado sea igual al esperado
     * @throws OperationException si no es posible calcular la Desviación estándar
     */
    @Test
    public void wouldCalculateTheDeviation() throws OperationException {
        double x = 2.0;
        double y = 3.0;
        double av = 2.5;
        double num = Math.sqrt(Math.pow((x-av),2)+Math.pow((y-av),2));
        LinkedListImp list = new LinkedListImp();
        list.add(x);
        list.add(y);
        assertEquals(Operation.deviation(list),num,0.0);
    }

    /**
     * Columna 1 dada en el enunciado de ejemplo
     * @throws Exception si no es posible realizar alguna de las operaciones
     */
    @Test
    public void testCase01() throws Exception {
        File url = Paths.get(getClass().getClassLoader().getResource("test.txt").toURI()).toFile();
        LinkedListImp list =new Data().getData(url);
        assertEquals(Operation.average(list),550.6,0.05);
        assertEquals(Operation.deviation(list),572.03,0.005);
    }

    /**
     * Columna 2 dada en el enunciado de ejemplo
     * @throws Exception si no es posible realizar alguna de las operaciones
     */
    @Test
    public void testCase02() throws Exception {
        File url = Paths.get(getClass().getClassLoader().getResource("test2.txt").toURI()).toFile();
        LinkedListImp list =new Data().getData(url);
        assertEquals(Operation.average(list),60.32,0.005);
        assertEquals(Operation.deviation(list),62.26,0.005);
    }
}