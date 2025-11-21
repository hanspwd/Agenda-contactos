package agendacontactos;

import controller.ContactoController;
import dao.ContactoDao;
import model.Contacto;
import view.ContactoView;

public class Main {
    public static void main(String[] args) {
        
        Contacto m = new Contacto();
        ContactoView v = new ContactoView();

        ContactoController cController = new ContactoController(m, v);
        
    }
    
}
