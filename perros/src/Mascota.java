/*
 * Alumno: Delgadillo-Barona Ethan Adrian
 * Fecha: 19/02/2026
 * Descripción:permite guardar la información
 *  para las mascotas se desea saber su nombre, tipo de mascota (gato, perro, etc.), raza, peso, altura y su edad.
 */
class Mascota {
    // Atributos privados (Encapsulamiento)
    private String nombre, tipo, raza;
    private double peso, altura;
    private int edad;

    public Mascota() {
        this.nombre = "Vacío";
        this.tipo = "N/A";
        this.raza = "N/A";
    }

    // --- SETTERS (Para modificar datos independientemente) ---
    public void setNombre(String n) { this.nombre = n; }
    public void setTipo(String t) { this.tipo = t; }
    public void setRaza(String r) { this.raza = r; }
    public void setPeso(double p) { this.peso = p; }
    public void setAltura(double a) { this.altura = a; }
    public void setEdad(int e) { this.edad = e; }

    // --- GETTERS (Para consultar datos) ---
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getRaza() { return raza; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return String.format("| %-10s | %-8s | %-10s | %5.2fkg | %5.2fcm | %2d años |",
                nombre, tipo, raza, peso, altura, edad);
    }
}