/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Controlador;

import Vista.AplicacionesIG;
import Modelo.Aplicaciones;
import Modelo.AplicacionesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class aplicacionesController {
    
private AplicacionesIG vista;
private AplicacionesDao modelo;
private ArrayList<Aplicaciones> listadoAplicaciones;

    public aplicacionesController(AplicacionesIG vista, AplicacionesDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        cargarAplicaciones();
    }
    
    public void cargarAplicaciones(){
        listadoAplicaciones = this.modelo.readAplicacion("");
        this.vista.cargarEquipos(listadoAplicaciones);
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
            if (vista.getSerialEquipo().equals("")) {
                vista.gestionMensajes("Ingrese el Serial del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getAplicacionesInstaladas().equals("")) {
                vista.gestionMensajes("Ingrese las aplicaciones instaladas en el equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    Aplicaciones aplicaciones = new Aplicaciones();

                    aplicaciones.setSerialEquipo(vista.getSerialEquipo());
                    aplicaciones.setAplicacionesInstaladas(vista.getAplicacionesInstaladas());

                    int tamaño;
                    tamaño = modelo.readAplicacion(aplicaciones.getSerialEquipo()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createAplicacion(aplicaciones);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarAplicaciones();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al grabar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("Serial ya está registrado",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ep) {
                 vista.gestionMensajes("Error al ingreso de datos. Verifique el serial del Equipo.",
                                "Error de entrada: " + ep.getMessage(),
                                JOptionPane.ERROR_MESSAGE);
            }

        }

        private void borrar() {
            try {
                if (camposVacios()) {
                    if (!listadoAplicaciones.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteAplicacion(vista.getSerialEquipo());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarAplicaciones();
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
                    if (!listadoAplicaciones.isEmpty()) {
                        Aplicaciones aplicaciones = new Aplicaciones();

                    aplicaciones.setSerialEquipo(vista.getSerialEquipo());
                    aplicaciones.setAplicacionesInstaladas(vista.getAplicacionesInstaladas());

                        int resultado = 0;
                        resultado = modelo.updateAplicacion(aplicaciones);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarAplicaciones();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al actualizar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("El Serial ya está registrado",
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