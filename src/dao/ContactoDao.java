package dao;

import config.Conexion;
import dao.ICrud;
import model.Contacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactoDao implements ICrud<Contacto> {

    @Override
    public void create(Contacto o) throws SQLException, Exception {
        Conexion cnx = new Conexion();

        PreparedStatement pst;
        try (Connection con = cnx.conectar()) {

            String query = "INSERT INTO `agenda` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, ?, ?, ?, ?);";
            pst = con.prepareStatement(query);
        }

        pst.setString(1, o.getNombre());
        pst.setString(2, o.getApellido());
        pst.setString(3, o.getEmail());
        pst.setString(4, o.getTelefono());

        int resultado = pst.executeUpdate();
        if (resultado == 0) {
            throw new Exception("Ocurrió un error al ingresar los datos.");
        }
    }

    @Override
    public List<Contacto> readAll() throws SQLException, Exception {
        Conexion cnx = new Conexion();
        PreparedStatement pst;

        try (Connection con = cnx.conectar()) {

            String query = "SELECT * FROM agenda";
            pst = con.prepareStatement(query);
        }
        ResultSet rs = pst.executeQuery();

        List<Contacto> lista = new ArrayList<>();

        while (rs.next()) {
            Contacto c = new Contacto(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono")
            );
            c.setId(rs.getInt("id"));
            lista.add(c);
        }

        return lista;
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
