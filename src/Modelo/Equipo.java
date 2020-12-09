/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Jhon_kq
 */
public class Equipo {
    
    private String serial;
    private String marca;
    private String ip;
    private String estado;
    private String caracteristicas;
    private int idUsuario;
    private String area;
    private String tipo;
    private String fechaIngreso;
    
    public Equipo(){
    }

    public Equipo(String serial, String marca, String ip, String estado, String caracteristicas, int idUsuario, String area, String tipo, String fechaIngreso) {
        this.serial = serial;
        this.marca = marca;
        this.ip = ip;
        this.estado = estado;
        this.caracteristicas = caracteristicas;
        this.idUsuario = idUsuario;
        this.area = area;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
