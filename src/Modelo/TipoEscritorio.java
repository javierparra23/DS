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
public class TipoEscritorio {
    
    private String serial;
    private String serialPantalla;
    private String serialMouse;
    private String serialTeclado;
    private String serialParlantes;

    public TipoEscritorio() {
    }

    public TipoEscritorio(String serial, String serialPantalla, String serialMouse, String serialTeclado, String serialParlantes) {
        this.serial = serial;
        this.serialPantalla = serialPantalla;
        this.serialMouse = serialMouse;
        this.serialTeclado = serialTeclado;
        this.serialParlantes = serialParlantes;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSerialPantalla() {
        return serialPantalla;
    }

    public void setSerialPantalla(String serialPantalla) {
        this.serialPantalla = serialPantalla;
    }

    public String getSerialMouse() {
        return serialMouse;
    }

    public void setSerialMouse(String serialMouse) {
        this.serialMouse = serialMouse;
    }

    public String getSerialTeclado() {
        return serialTeclado;
    }

    public void setSerialTeclado(String serialTeclado) {
        this.serialTeclado = serialTeclado;
    }

    public String getSerialParlantes() {
        return serialParlantes;
    }

    public void setSerialParlantes(String serialParlantes) {
        this.serialParlantes = serialParlantes;
    }
    
    
    
}
