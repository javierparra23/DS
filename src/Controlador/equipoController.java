/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.EquipoIG;
import Modelo.Equipo;
import Modelo.EquipoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public final class equipoController {
    
private EquipoIG vista;
private EquipoDao modelo;
private ArrayList<Equipo> listadoEquipos;

    public equipoController(EquipoIG vista, EquipoDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        cargarEquipos();
    }
    
    public void cargarEquipos(){
        listadoEquipos = this.modelo.readEquipo("");
        this.vista.cargarEquipos(listadoEquipos);
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
            if (vista.getSerial().equals("")) {
                vista.gestionMensajes("Ingrese el Serial del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getMarca().equals("")) {
                vista.gestionMensajes("Ingrese la marca del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getIp().equals("")) {
                vista.gestionMensajes("Ingrese la ip asignada del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getEstado().equals("")) {
                vista.gestionMensajes("Ingrese el Estado del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getCaracteristicas().equals("")) {
                vista.gestionMensajes("Ingrese las caracteristicas del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getArea().equals("")) {
                vista.gestionMensajes("Ingrese la area a la que fue asignado el equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getTipo().equals("")) {
                vista.gestionMensajes("Ingrese el tipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getFechaIngreso().equals("")) {
                vista.gestionMensajes("Ingrese la fecha de ingreso",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    Equipo equipo = new Equipo();

                    equipo.setSerial(vista.getSerial());
                    equipo.setMarca(vista.getMarca());
                    equipo.setIp(vista.getIp());
                    equipo.setEstado(vista.getEstado());
                    equipo.setCaracteristicas(vista.getCaracteristicas());
                    equipo.setIdUsuario(Integer.parseInt(vista.getIdUsuario()));
                    equipo.setArea(vista.getArea());
                    equipo.setTipo(vista.getTipo());
                    equipo.setFechaIngreso(vista.getFechaIngreso());
                    

                    int tamaño;
                    tamaño = modelo.readEquipo(equipo.getSerial()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createEquipo(equipo);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEquipos();
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
                 vista.gestionMensajes("Error al ingreso de datos. Verifique el codigo del Equipo.",
                                "Error de entrada: " + ep.getMessage(),
                                JOptionPane.ERROR_MESSAGE);
            }

        }

        private void borrar() {
            try {
                if (camposVacios()) {
                    if (!listadoEquipos.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteEquipo(vista.getSerial());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEquipos();
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
                    if (!listadoEquipos.isEmpty()) {
                        Equipo equipo = new Equipo();

                    equipo.setSerial(vista.getSerial());
                    equipo.setMarca(vista.getMarca());
                    equipo.setIp(vista.getIp());
                    equipo.setEstado(vista.getEstado());
                    equipo.setCaracteristicas(vista.getCaracteristicas());
                    equipo.setIdUsuario(Integer.parseInt(vista.getIdUsuario()));
                    equipo.setArea(vista.getArea());
                    equipo.setTipo(vista.getTipo());
                    equipo.setFechaIngreso(vista.getFechaIngreso());

                        int resultado = 0;
                        resultado = modelo.updateEquipo(equipo);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEquipos();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al actualizar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("Codigo ya está registrado",
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
