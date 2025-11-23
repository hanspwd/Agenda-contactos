/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
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

    public ContactoController(Contacto modelo, ContactoView vista) throws Exception{
        this.modelo = modelo;
        this.vista = vista;
        init();
    }

    private void init() throws Exception {
        vista.setVisible(true);
        listar();

        vista.getBtnAgendar().addActionListener((e) -> {
            try {
                agendar();
                Alerta.mensaje("Contacto " + modelo.getNombre() + " agregado con éxito!", "Operación exitosa", 1);
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "ERROR", 0);
            }
        });

        vista.getBtnListar().addActionListener((e) -> {
            try {
                listar();
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
        listar();
    }

    public void listar() throws Exception {

        List<Contacto> lista = modelo.listarContactos();

        // Obtener el modelo de la tabla
        DefaultTableModel tabla = (DefaultTableModel) vista.getTblContactos().getModel();

        // Limpiar filas previas
        tabla.setRowCount(0);

        // Llenar tabla
        for (Contacto c : lista) {
            tabla.addRow(new Object[]{
                c.getId(),
                c.getNombre(),
                c.getApellido(),
                c.getEmail(),
                c.getTelefono()
            });
        }
    }

}
