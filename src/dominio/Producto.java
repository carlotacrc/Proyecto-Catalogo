// Version: 1.0
package dominio;
import java.io.Serializable;

/**
 * Clase que contiene la tienda
 */
public  class Producto implements Serializable {

    /**
     * Atributos de la clase Tienda
     */
    private String talla;
    private double precio;
    private String color;
    private String nombre;

    /**
     * Constructor de la clase Tienda
     */
    public Producto(String talla, double precio, String color, String nombre) {
        this.talla = talla;
        this.precio = precio;
        this.color = color;
        this.nombre = nombre;
    }

    /**
     * Getter y Setter de la clase Tienda
     */ 
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que compara dos productos de la tienda
     */
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto producto = (Producto) obj;
        return nombre != null ? nombre.equals(producto.nombre) : producto.nombre == null;
    }

    /**
     * Método que actualiza un producto de la tienda
     */
    public void actualizar(double precio, String talla, String color, String nombre){
        this.talla = talla;
        this.precio = precio;
        this.color = color;
        this.nombre = nombre;
    }

    /**
     * Método que muestra los productos de la tienda
     */
    public String toString(){
        return "Nombre: " + nombre + " " + "Precio: " + precio + " " + "Talla: " + talla + " " + "Color: " + color;
    }

}
