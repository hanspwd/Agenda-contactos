package dao;

import model.Contacto;

import java.lang.invoke.ConstantCallSite;
import java.sql.SQLException;
import java.util.List;

public interface ICrud<T> {
    //crud
    void create(T t) throws SQLException, Exception;
    List<Contacto> readAll() throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    Contacto read(int id) throws Exception;

}
