/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Controlador;

import Vista.TipoPortatilIG;
import Modelo.TipoPortatil;
import Modelo.TipoPortatilDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class tipoPortatilController {
    
private TipoPortatilIG vista;
private TipoPortatilDao modelo;
private ArrayList<TipoPortatil> listadoTipoPortatiles;

    public tipoPortatilController(TipoPortatilIG vista, TipoPortatilDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        cargarTipoPortatiles();
    }
    
    public void cargarTipoPortatiles(){
        listadoTipoPortatiles = this.modelo.readTipoPortatil("");
        this.vista.cargarEquipos(listadoTipoPortatiles);
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
            } else if (vista.getSerialMouse().equals("")) {
                vista.gestionMensajes("Ingrese el serial del mouse del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getSerialBandejaRefri().equals("")) {
                vista.gestionMensajes("Ingrese el serial de la bandeja refrigerante asignada del equipo",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    TipoPortatil tipoPortatil = new TipoPortatil();

                    tipoPortatil.setSerial(vista.getSerial());
                    tipoPortatil.setSerialMouse(vista.getSerialMouse());
                    tipoPortatil.setSerialBandejaRefri(vista.getSerialBandejaRefri());
                    

                    int tamaño;
                    tamaño = modelo.readTipoPortatil(tipoPortatil.getSerial()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createTipoPortatil(tipoPortatil);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarTipoPortatiles();
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
                    if (!listadoTipoPortatiles.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteTipoPortatil(vista.getSerial());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarTipoPortatiles();
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
                    if (!listadoTipoPortatiles.isEmpty()) {
                        TipoPortatil tipoPortatil = new TipoPortatil();

                    tipoPortatil.setSerial(vista.getSerial());
                    tipoPortatil.setSerialMouse(vista.getSerialMouse());
                    tipoPortatil.setSerialBandejaRefri(vista.getSerialBandejaRefri());

                        int resultado = 0;
                        resultado = modelo.updateTipoPortatil(tipoPortatil);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarTipoPortatiles();
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