package contactoclasses;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // crear contactos
        Contact Juan = new Contact("Juan Perez", "123456789", "juan@gmail.com");
        Contact Maria = new Contact("Maria Lopez", "987654321", "maria@gmail.com");
        Contact Flor = new Contact("Flor Gomez", "555666777", "flor@gmail.com");

        Contact Ana = new Contact();
        Contact Luis = new Contact();

        // agregar contactos
        agenda.addContact(Juan.getNombre(), Juan.getTelefono(), Juan.getEmail());
        agenda.addContact(Maria.getNombre(), Maria.getTelefono(), Maria.getEmail());
        agenda.addContact(Flor.getNombre(), Flor.getTelefono(), Flor.getEmail());

        agenda.addContact(Ana.getNombre(), Ana.getTelefono(), Ana.getEmail());
        agenda.addContact(Luis.getNombre(), Luis.getTelefono(), Luis.getEmail());

        agenda.addContact("Felipe Ramirez", "444555666", "felipe@gmail.com" );
        agenda.addContact("Sofia Martinez", "333222111", "sofia@gmail.com" );

        // estado actual de la agenda
        System.out.println("Estado actual de la agenda: add contactos");
        for (Contact contact : agenda.getAllContacts()) {
            System.out.println(contact);
        }

        // actualizar contacto
        Boolean updatedA = agenda.updateContact("Maria Lopez", "Maria Rodriguez", "987654321", "maria@gmail.com");
        Boolean UpdatedB = agenda.updateContact("Juan Perez", "Carlos Sanchez", "111222333", "juan@gmail.com");

        // estado actual de la agenda
        System.out.println("Estado actual de la agenda:update contactos");
        for (Contact contact : agenda.getAllContacts()) {
            System.out.println(contact);
        }
        
        // eliminar contacto
        Boolean deletedA = agenda.deleteContact("Flor Gomez");
        Boolean deletedB = agenda.deleteContact("Ana");

        // estado actual de la agenda
        System.out.println("Estado actual de la agenda: delete contactos ");
        for (Contact contact : agenda.getAllContacts()) {
            System.out.println(contact);
        }
    
    }
}
