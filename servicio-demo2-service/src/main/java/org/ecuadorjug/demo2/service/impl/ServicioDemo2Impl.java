package org.ecuadorjug.demo2.service.impl;

import org.apache.camel.Body;
import org.apache.camel.Exchange;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface para consultar, informacion en ASFI
 * Created by kleber on 11/8/16.
 */

public class ServicioDemo2Impl {


    public static final String ERR_CIUDADANO_X_NOT_FOUND = "Ciudadano %s not found";

    Map<String, String> ciudadanosMap = new HashMap<>();

    //dummy list de ciudadanos
    public void init() {

        ciudadanosMap.put("1571600SC", "OK");
        ciudadanosMap.put("171308LP", "OK");
        ciudadanosMap.put("170163LP", "OK");
        ciudadanosMap.put("1461103SC", "OK");
        ciudadanosMap.put("12454545", "OK");

    }


    public void checkCiudadano(@Body String id, Exchange exchange) {
        String result = ciudadanosMap.get(id);
        checkResult(id, exchange, result);
    }

    private void checkResult(String id, Exchange exchange, String result) {
        if (result == null) {
            exchange.getOut().setFault(true);
            exchange.getOut().setBody(String.format(ERR_CIUDADANO_X_NOT_FOUND, id));
        } else {
            exchange.getOut().setBody(result);
        }
    }
}
