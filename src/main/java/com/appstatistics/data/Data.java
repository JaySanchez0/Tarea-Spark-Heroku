package com.appstatistics.data;

import com.appstatistics.collection.LinkedListImp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Data {
    /**
     *
     * @param file archivo de donde se desean calcular los datos
     * @return una lista de reales
     */
    public LinkedListImp getData(File file){
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            String data;
            LinkedListImp list = new LinkedListImp();
            while((data= read.readLine())!=null){
                list.add(Double.parseDouble(data));
            }
            read.close();
            return list;
        }catch(Exception e){
            System.out.println("error "+e.getMessage());

        }
        return null;
    }

}