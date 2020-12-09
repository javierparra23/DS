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
public class TipoPortatil {
    
    private String serial;
    private String serialMouse;
    private String serialBandejaRefri;

    public TipoPortatil() {
    }

    public TipoPortatil(String serial, String serialMouse, String serialBandejaRefri) {
        this.serial = serial;
        this.serialMouse = serialMouse;
        this.serialBandejaRefri = serialBandejaRefri;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSerialMouse() {
        return serialMouse;
    }

    public void setSerialMouse(String serialMouse) {
        this.serialMouse = serialMouse;
    }

    public String getSerialBandejaRefri() {
        return serialBandejaRefri;
    }

    public void setSerialBandejaRefri(String serialBandejaRefri) {
        this.serialBandejaRefri = serialBandejaRefri;
    }
    
    
    
}
