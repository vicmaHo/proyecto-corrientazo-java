package co.com.victorhernandez.model;

public class Adicional {
    // Asociacion

    // Atributos
    private String nombre;
    private Integer precio;
    
    public Adicional(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }


}
