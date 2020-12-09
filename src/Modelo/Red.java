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
public class Red {
    
    private String ipEquipo;
    private String serialEquipo;
    private String permisosIp;

    public Red() {
    }

    public Red(String ipEquipo, String serialEquipo, String permisosIp) {
        this.ipEquipo = ipEquipo;
        this.serialEquipo = serialEquipo;
        this.permisosIp = permisosIp;
    }

    public String getIpEquipo() {
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    public String getPermisosIp() {
        return permisosIp;
    }

    public void setPermisosIp(String permisosIp) {
        this.permisosIp = permisosIp;
    }
    
    
    
}
