package model;

public class Clientes {

    private String dni;
    private String nombre;
    private String email;
    private String telefono; //telefono como String ya que no nos hace falta para operaciones

    public Clientes(String dni, String nombre, String email, String telefono){
        //utilizamos setters por ser más seguros que "this.atributo = parámetro"
        setDni(dni);
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
    }

    public String getDni(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setDni(String dni) {
        String regex = "[0-9]{8}[A-Z]"; //define los parametros de la expresión regular
    
        // Comprobamos si el DNI recibido coincide con el patrón
        if (dni != null && dni.matches(regex)) {
            this.dni = dni;
        } else {
            // Error controlado con IllegalArgumentException si el formato no se cumple
            throw new IllegalArgumentException("Formato de DNI inválido. Debe ser: 8 números y 1 letra mayúscula.");
        }
    
    }

    public void setNombre(String nombre) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$";

        // Comprobación primera si nombre está vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        // Segundo si cumple con el patrón establecido
        if (!nombre.matches(regex)) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }

    this.nombre = nombre.trim();
    }

    public void setEmail(String email){
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}$"; //define los parametros de la expresión regular
        
        //Comprobamos si el email recibido coincide con el patrón de regex
        if (email != null && email.matches(regex)){
            this.email = email;
        } else {
            // Error controlado con IllegalArgumentException si el formato no se cumple
            throw new IllegalArgumentException("Formato de EMAIL inválido. Debe contener: un @ y un .\n Ejemplo: cliente@gmail.com o clienta@hotmail.com");
        }
    }

    public void setTelefono(String telefono){
        String regex = "(\\+?[0-9]{2,3})?[0-9]{9}"; //define los parametros de la expersión regluar

        if (telefono != null && telefono.matches(regex)){
            this.telefono = telefono;
        } else {
            // Error controlado con IllegalArgumentException si el formato no se cumple
            throw new IllegalArgumentException("Formato de número de teléfono inválido. Debe ser: Prefijo (opcional) y 9 números");
        }
    }
}
