package com.webstatistics;

import com.appstatistics.collection.LinkedListImp;
import com.appstatistics.operation.Operation;
import com.webstatistics.response.ResponseData;
import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

/**
 * Hello world!
 *
 */
public class App
{
    /**
     * Ofrece los servicos de la aplicacion
     * @param args
     */
    public static void main( String[] args ) {
        port(getPort());
        staticFiles.location("/public");
        post("/calcular",((request, response) ->{
            LinkedListImp li = LinkedListImp.getList(request.body());
            return new ResponseData(Operation.average(li),Operation.deviation(li)).toString();
        }));
    }

    /**
     *
     * @return numero de puerto por el cual se entregara el servicio
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
