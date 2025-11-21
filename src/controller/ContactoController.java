/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Contacto;
import view.Alerta;
import view.ContactoView;

/**
 *
 * @author Hans
 */

public class ContactoController {

    private Contacto modelo;
    private ContactoView vista;

    public ContactoController() {
    }

    public ContactoController(Contacto modelo, ContactoView vista) {
        this.modelo = modelo;
        this.vista = vista;
        init();
    }

    private void init() {
        vista.setVisible(true);

        vista.getBtnAgendar().addActionListener((e) -> {
            try {
                agendar();
                Alerta.mensaje("Contacto " + modelo.getNombre() + " agregado con exito!", "Operación exitosa", 1);
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "ERROR", 0);
            }
        });
    }
    
    public void agendar() throws Exception {
        
        String nombre = vista.getTxtNombre().getText();
        String apellido = vista.getTxtApellido().getText();
        String email = vista.getTxtEmail().getText();
        String numero = vista.getTxtNumeroTelefono().getText();
        
        modelo = new Contacto(nombre, apellido, email, numero);
        modelo.crearContacto();
        
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtEmail().setText("");
        vista.getTxtNumeroTelefono().setText("");
    }



}
