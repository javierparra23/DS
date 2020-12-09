/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MICHAEL
 */
public class Aplicaciones {
    
    private String serialEquipo;
    private String aplicacionesInstaladas;

    public Aplicaciones() {
    }

    public Aplicaciones(String serialEquipo, String aplicacionesInstaladas) {
        this.serialEquipo = serialEquipo;
        this.aplicacionesInstaladas = aplicacionesInstaladas;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public String getAplicacionesInstaladas() {
        return aplicacionesInstaladas;
    }

    public void setAplicacionesInstaladas(String aplicacionesInstaladas) {
        this.aplicacionesInstaladas = aplicacionesInstaladas;
    }
    
    
    
}
