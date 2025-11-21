package dao;

import config.Conexion;
import model.Contacto;
import view.ContactoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import view.Alerta;

public class ContactoDao implements ICrud<Contacto> {


    @Override
    public void create(Contacto o) throws SQLException, Exception {
        Conexion cnx = new Conexion();
        Connection con = cnx.conectar();

        String query = "INSERT INTO `agenda` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, ?, ?, ?, ?);";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, o.getNombre());
        pst.setString(2, o.getApellido());
        pst.setString(3, o.getEmail());
        pst.setString(4, o.getTelefono());
        
        int resultado = pst.executeUpdate();
        if(resultado == 0 ) {
            throw new Exception("Ocurrio un error al ingresar los datos.");
        }
    }

    @Override
    public List<Contacto> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Contacto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Contacto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contacto read(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
