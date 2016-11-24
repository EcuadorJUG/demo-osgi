package org.ecuadorjug.demo2.route.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by kleber on 11/9/16.
 */
@WebService(serviceName = "ServicioDemo2")
public interface ServicioDemo2 {

    String checkCiudadano(@WebParam(name = "identificacion") String identificacion);

}
