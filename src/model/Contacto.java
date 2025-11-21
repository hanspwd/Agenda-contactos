package model;

import dao.ContactoDao;

public final class Contacto {

    private  int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String email, String telefono) throws Exception{
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setTelefono(telefono);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception{  
        if(!nombre.isBlank() && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
        else {
            throw new Exception("El nombre no puede estar vacio.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido)throws Exception{
        if(!apellido.isBlank() && !apellido.isEmpty()) {
            this.apellido = apellido;
        } else {
            throw new Exception("El apellido no puede estar vacio.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception{
        if(!email.isBlank() && !email.isEmpty()) {
            this.email = email;
        } else {
            throw new Exception("El email no puede estar vacio.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws Exception{
        if(!telefono.isBlank() && !telefono.isEmpty()) {
            this.telefono = telefono;
        } else {
            throw new Exception("El telefono no puede estar vacio.");
        }
    }

    public void crearContacto() throws Exception {
        ContactoDao dao = new ContactoDao();
        dao.create(this);
    }
}
