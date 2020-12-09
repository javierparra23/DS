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
public class Informe {
    
    private String idInforme;
    private String fechaReporte;
    private String idEmpleado;
    private String tipoInforme;
    private String nitEmpresa;

    public Informe() {
    }

    public Informe(String idInforme, String fechaReporte, String idEmpleado, String tipoInforme, String nitEmpresa) {
        this.idInforme = idInforme;
        this.fechaReporte = fechaReporte;
        this.idEmpleado = idEmpleado;
        this.tipoInforme = tipoInforme;
        this.nitEmpresa = nitEmpresa;
    }

    public String getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(String idInforme) {
        this.idInforme = idInforme;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
    
    
    
}
