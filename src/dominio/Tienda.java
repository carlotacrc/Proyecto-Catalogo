// Version: 1.0
package dominio;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que contiene la tienda
 */
public class Tienda implements Serializable{
   
    /**
    * Atributos de la clase Tienda
    */
    private ArrayList<Producto> productos;

    /**
     * Constructor de la clase Tienda
     */
    public Tienda() {
        productos = new ArrayList<>();
    }

    /**
     * Método que añade un producto a la tienda
     * @param producto
     */
    public void annadirProducto (Producto producto) {
        productos.add(producto);
    }

    /**
     * Método que muestra los productos de la tienda
     */
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda");
        }
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Método que actualiza un producto de la tienda
     * @param talla
     * @param precio
     * @param color
     * @param nombre
     */
    public void actualizarProducto(String talla, double precio, String color, String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                if (!color.equals("")) {
                    producto.setColor(color);
                }
                if (precio > 0) {
                    producto.setPrecio(precio);
                }
                if (!talla.equals("")) {
                    producto.setTalla(talla);
                }
                return;
            }
        }
    }

    /**
     * Método que borra un producto de la tienda
     * @param nombre
     */
    public void borrarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                return;
            }
        }
        System.out.println("No se ha encontrado el producto"+ " " + nombre + " " + "en la tienda");
    }

    /**
     * Método que calcula el total de la tienda
     * @return
     */
    public double calcularTotalTienda() {
        double totalTienda = 0;
        for (Producto producto : productos) {
            totalTienda += producto.getPrecio();
        }
        System.out.println("El total de la tienda es: " + " " + totalTienda + "");
        return totalTienda;
    }
      
   /**
    * Método que busca un producto en la tienda
    * @param nombre
    */ 
    public void buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                System.out.println(producto);
                return;
            }
        }
        System.out.println("No se ha encontrado el producto" + " " + nombre + " " + "en la tienda");
    }
}
    
    
