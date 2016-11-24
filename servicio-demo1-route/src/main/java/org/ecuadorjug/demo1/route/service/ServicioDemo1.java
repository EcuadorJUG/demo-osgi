package org.ecuadorjug.demo1.route.service;


import org.ecuadorjug.demo1.service.model.Ciudadano;
import org.ecuadorjug.demo1.service.model.CiudadanoException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface para consultar, informacion en SEGIP
 * Created by kleber on 11/8/16.
 */
@WebService(serviceName = "ServicioDemo1")
public interface ServicioDemo1 {

    Ciudadano getCiudadano(@WebParam(name = "identificacion") String identificacion, @WebParam(name = "tipoID") String tipoID) throws CiudadanoException;

    Ciudadano putCiudadano(Ciudadano ciudadano);

    Ciudadano deleteCiudadano(@WebParam(name = "identificacion") String identificacion);
}
