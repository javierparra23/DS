/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Controlador;

import Vista.EmpleadoIG;
import Modelo.Empleado;
import Modelo.EmpleadoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class empleadoController {
    
private EmpleadoIG vista;
private EmpleadoDao modelo;
private ArrayList<Empleado> listadoEmpleados;

    public empleadoController(EmpleadoIG vista, EmpleadoDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        cargarEmpleados();
    }
    
    public void cargarEmpleados(){
        listadoEmpleados = this.modelo.readEmpleado("");
        this.vista.cargarEmpleados(listadoEmpleados);
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
            if (vista.getIdEmpleado().equals("")) {
                vista.gestionMensajes("Ingrese el ID del empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getNombre().equals("")) {
                vista.gestionMensajes("Ingrese el nombre del empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getApellido().equals("")) {
                vista.gestionMensajes("Ingrese el apellido del empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getArea().equals("")) {
                vista.gestionMensajes("Ingrese el area a la que pertenece el empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getSerialEquipo().equals("")) {
                vista.gestionMensajes("Ingrese el serial del equipo asignado al empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getTipoEmpelado().equals("")) {
                vista.gestionMensajes("Ingrese el tipo de empleado, que es el empelado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getNitEmpresa().equals("")) {
                vista.gestionMensajes("Ingrese el el nit de la empresa a la que pertenece el empleado",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    Empleado empleado = new Empleado();

                    empleado.setIdEmpelado(vista.getIdEmpelado());
                    empleado.setNombre(vista.getNombre());
                    empleado.setApellido(vista.getApellido());
                    empleado.setArea(vista.getArea());
                    empleado.setSerialEquipo(vista.getSerialEquipo());
                    empleado.setTipoEmpelado(Integer.parseInt(vista.getTipoEmpleado()));
                    empleado.setNitEmpresa(vista.getNitEmpresa());

                    int tamaño;
                    tamaño = modelo.readEmpleado(empleado.getIdEmpleado()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createEmpleado(empleado);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEmpleados();
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
                    if (!listadoEmpleados.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteEmpelado(vista.getIdEmpelado());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEmpleados();
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
                    if (!listadoEmpleados.isEmpty()) {
                        Empleado empleado = new Empleado();

                    empleado.setIdEmpelado(vista.getIdEmpelado());
                    empleado.setNombre(vista.getNombre());
                    empleado.setApellido(vista.getApellido());
                    empleado.setArea(vista.getArea());
                    empleado.setSerialEquipo(vista.getSerialEquipo());
                    empleado.setTipoEmpelado(Integer.parseInt(vista.getTipoEmpleado()));
                    empleado.setNitEmpresa(vista.getNitEmpresa());

                        int resultado = 0;
                        resultado = modelo.updateEmpleado(empleado);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            cargarEmpleados();
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al actualizar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("ID ya está registrado",
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