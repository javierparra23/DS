/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
        
import Vista.EmpresaIG;
import Modelo.Empresa;
import Modelo.EmpresaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class empresaController {
    
private EmpresaIG vista;
private EmpresaDao modelo;

    public empresaController(EmpresaIG vista, EmpresaDao modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ActorListener());
        this.vista.addListenerBtnModificar(new ActorListener());
        this.vista.addListenerBtnBorrar(new ActorListener());
        this.vista.addListenerBtnCerrar(new ActorListener());
        
        ArrayList<Empresa> listadoEmpresas;
        listadoEmpresas = this.modelo.readEmpresa("0");
        this.vista.cargarEmpresas(listadoEmpresas);
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
            if (vista.getNit().equals("")) {
                vista.gestionMensajes("Ingrese el Nit del empresa",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getNombre().equals("")) {
                vista.gestionMensajes("Ingrese el nombre de la empresa",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getDireccion().equals("")) {
                vista.gestionMensajes("Ingrese la direccion de la empresa",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            } else if (vista.getDescripcion().equals("")) {
                vista.gestionMensajes("Ingrese una descripcion de la empresa",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
            return verificar;
        }

        private void registrar() {
            try {
                if (camposVacios()) {
                    Empresa empresa = new Empresa();

                    empresa.setNit(vista.getNit());
                    empresa.setNombre(vista.getNombre());
                    empresa.setDireccion(vista.getDireccion());
                    empresa.setDescripcion(vista.getDescripcion());

                    int tamaño;
                    tamaño = modelo.readEmpresa(empresa.getNit()).size();

                    if (tamaño == 0) {
                        int resultado = 0;
                        resultado = modelo.createEmpresa(empresa);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Grabado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            ArrayList<Empresa> listadoEmpresas;
                            listadoEmpresas = modelo.readEmpresa("0");
                            vista.cargarEmpresas(listadoEmpresas);
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al grabar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        vista.gestionMensajes("Nit ya está registrado",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ep) {
                 vista.gestionMensajes("Error al ingreso de datos. Verifique el Nit de la Empresa.",
                                "Error de entrada: " + ep.getMessage(),
                                JOptionPane.ERROR_MESSAGE);
            }

        }

        private void borrar() {
           String nit = "";
           nit = vista.getNit();
                    if (!nit.isEmpty()) {

                        int resultado = 0;
                        resultado = modelo.deleteEmpresa(vista.getNit());
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro Borrado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            ArrayList<Empresa> listadoEmpresas;
                            listadoEmpresas = modelo.readEmpresa("0");
                            vista.cargarEmpresas(listadoEmpresas);
                        }
                    } else {
                        vista.gestionMensajes("La lista esta vacia no se puede borrar.",
                                "Confirmación",
                                JOptionPane.ERROR_MESSAGE);
                    }

        }

        private void actualizar() {
           
                    Empresa empresa = new Empresa();

                    empresa.setNit(vista.getNit());
                    empresa.setNombre(vista.getNombre());
                    empresa.setDireccion(vista.getDireccion());
                    empresa.setDescripcion(vista.getDescripcion());

                        int resultado = 0;
                        resultado = modelo.updateEmpresa(empresa);
                        if (resultado == 1) {
                            vista.gestionMensajes("Registro actualizado con éxito",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            ArrayList<Empresa> listadoEmpresas;
                            listadoEmpresas = modelo.readEmpresa("0");
                            vista.cargarEmpresas(listadoEmpresas);
                            vista.activarControles(false);
                            vista.nuevoAction();
                        } else {
                            vista.gestionMensajes("Error al actualizar",
                                    "Confirmación", JOptionPane.ERROR_MESSAGE);
                        }
                    
        }

    }
    
}
