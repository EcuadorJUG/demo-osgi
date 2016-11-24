package org.ecuadorjug.demo1.service.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kleber on 11/8/16.
 */
@XmlRootElement
public class Ciudadano {

    private String ciudadanoId;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;


    public Ciudadano(String ciudadanoId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.ciudadanoId = ciudadanoId;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;

    }

    public Ciudadano() {
        //por defecto
    }


    public String getCiudadanoId() {
        return ciudadanoId;
    }

    public void setCiudadanoId(String ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ciudadano ciudadano = (Ciudadano) o;

        if (!ciudadanoId.equals(ciudadano.ciudadanoId)) {
            return false;
        }
        return true;
    }
}
