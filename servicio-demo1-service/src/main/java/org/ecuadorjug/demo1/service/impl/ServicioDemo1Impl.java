package org.ecuadorjug.demo1.service.impl;

import org.ecuadorjug.demo1.service.model.Ciudadano;
import org.ecuadorjug.demo1.service.model.CiudadanoException;
import org.apache.camel.Body;
import org.apache.camel.Exchange;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementacion del Servcio
 * Created by kleber on 11/9/16.
 */
public class ServicioDemo1Impl {


    public static final String ERR_CIUDADANO_X_NOT_FOUND = "Ciudadano %s not found";

    Map<String, Ciudadano> ciudadanosMap = new HashMap<>();

    //dummy list de ciudadanos
    public void init() {
        Ciudadano ciudadano1 = new Ciudadano("1571600SC", "Christin", "Pablo", "Paredez", "Prescott");
        Ciudadano ciudadano2 = new Ciudadano("171308LP", "Foo", "Bar", "Olenick", "Gephart");
        Ciudadano ciudadano3 = new Ciudadano("170163LP", "Beatris", "Lauretta", "Rotz", "Denmon");
        Ciudadano ciudadano4 = new Ciudadano("1461103SC", "Pricilla", "Eldora", "Gaxiola", "Hinnenkamp");



        ciudadanosMap.put(ciudadano1.getCiudadanoId(), ciudadano1);
        ciudadanosMap.put(ciudadano2.getCiudadanoId(), ciudadano2);
        ciudadanosMap.put(ciudadano3.getCiudadanoId(), ciudadano3);
        ciudadanosMap.put(ciudadano4.getCiudadanoId(), ciudadano4);
    }

    public void getCiudadano(@Body String id, Exchange exchange) {
        Ciudadano result = ciudadanosMap.get(id);
        checkResult(id, exchange, result);
    }

    public Ciudadano putCiudadano(Ciudadano ciudadano) {

        ciudadanosMap.put(ciudadano.getCiudadanoId(), ciudadano);
        return ciudadano;
    }

    public void deleteCiudadano(@Body String id, Exchange exchange) {
        Ciudadano result = ciudadanosMap.remove(Integer.parseInt(id));
        checkResult(id, exchange, result);
    }


    private void checkResult(String id, Exchange exchange, Ciudadano result) {
        if (result == null) {
            exchange.getOut().setFault(true);
            exchange.getOut().setBody(new CiudadanoException(String.format(ERR_CIUDADANO_X_NOT_FOUND, id), id));
        } else {
            exchange.getOut().setBody(result);
        }
    }
}
