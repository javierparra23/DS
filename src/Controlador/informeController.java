/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Controlador;

import Vista.InformeIG;
import Modelo.Informe;
import Modelo.InformeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class informeController {
    
private InformeIG vista;
private InformeDao modelo;
private ArrayList<Informe> listadoInformes;

    public informeController(InformeIG vista, InformeDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        cargarInformes();
    }
    
    public void cargarInformes(){
        listadoInformes = this.modelo.readInforme("");
        this.vista.cargarInformes(listadoInformes);
    }
    
    class ActorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("nuevo")) {
                vista.nuevoAction();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                vista.nuevoAction();
            } else if (e.getActionCommand().equalsIgnoreCase("modificar")) {
                vista.modificarAction();
            } else if (e.getActionCommand().equalsIgnoreCase("salir")) {
                vista.cerrarAction();
            } else if (e.getActionCommand().equalsIgnoreCase("grabar")) {
                registrar();
            } else if (e.getActionCommand().equalsIgnoreCase("borrar")) {
                borrar();
            } else if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
                actualizar();
            }
        }

        private boolean camposVacios() {
            boolean verificar = true;
            if (vista.getIdInforme().equals("")) {
                vista.gestionMensajes("Ingrese el id del informe",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getIdEmpleado().equals("")) {
                vista.gestionMensajes("Ingrese el id del empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getTipoEmpleado().equals("")) {
                vista.gestionMensajes("Ingrese el tipo de empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getNitEmpresa().equals("")) {
                vista.gestionMensajes("Ingrese el nit de la empresa",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    Informe informe = new Informe();

                    informe.setIdInforme(vista.getIdInforme());
                    informe.setFechaReporte(vista.getFechaReporte());
                    informe.setIdEmpleado(vista.getIdEmpleado());
                    informe.setTipoInforme(vista.getTipoEmpleado());
                    informe.setNitEmpresa(vista.getNitEmpresa());

                    int tamaño;
                    tamaño = modelo.readInforme(informe.getIdInforme()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createInforme(informe);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarInformes();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al grabar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("Id de Informe ya está registrado",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ep) {
                 vista.gestionMensajes("Error al ingreso de datos. Verifique el id del informe.",
                                "Error de entrada: " + ep.getMessage(),
                                JOptionPane.ERROR_MESSAGE);
            }

        }

        private void borrar() {
            try {
                if (camposVacios()) {
                    if (!listadoInformes.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteInforme(vista.getIdInforme());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarInformes();
                        }
                    } else {
                        vista.gestionMensajes("La lista esta vacia no se puede borrar.",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex + ex.getMessage());
            }

        }

        private void actualizar() {
            try {
                if (camposVacios()) {
                    if (!listadoInformes.isEmpty()) {
                        Informe informe = new Informe();

                    informe.setIdInforme(vista.getIdInforme());
                    informe.setFechaReporte(vista.getFechaReporte());
                    informe.setIdEmpleado(vista.getIdEmpleado());
                    informe.setTipoInforme(vista.getTipoEmpleado());
                    informe.setNitEmpresa(vista.getNitEmpresa());

                        int resultado = 0;
                        resultado = modelo.updateInforme(informe);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarInformes();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al actualizar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("Id ya está registrado",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex + ex.getMessage());
            }
        }

    }
}
*/