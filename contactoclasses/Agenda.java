package contactoclasses;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    
    // lista para almacenamiento de contactos
    private List<Contact> contactList = new ArrayList<>();

    // crear y agregar contacto 
    public void addContact(String nombre, String telefono, String email){

        Contact newContact = new Contact(nombre, telefono, email);
        contactList.add(newContact);

    }

    // actualizar contacto
    public Boolean updateContact(String currentName, String newName, String telefono, String email) {

        for (Contact contact : contactList) {
            if (currentName.equals(contact.getNombre())) {
                contact.setNombre(newName);
                contact.setTelefono(telefono);
                contact.setEmail(email);
                return true;
            }
        }
        return false;
    }
    
    // eliminar contacto
    public Boolean deleteContact(String currentName) {

        if (contactList.stream().noneMatch(contact -> currentName.equals(contact.getNombre()))) {
            return true;
        }
        return false;
    }

    // todos los contactos
    public List<Contact> getAllContacts() {
        return contactList;
    }
}

    


