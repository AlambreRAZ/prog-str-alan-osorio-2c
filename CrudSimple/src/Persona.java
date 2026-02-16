public class Persona {
    //Atributos
    public int id;
    public String nombre;
    public boolean activa;

    //DATOS
    public Persona() {
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;

    }

    public int getId() {
        return id;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActive() {
        return activa;
    }

    public void setActive(boolean active) {
        this.activa = active;
    }
}