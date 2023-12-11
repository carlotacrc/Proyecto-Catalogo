package dominio;
import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{
   
    //////atributos//////
    private ArrayList<Producto> productos;

    ///////constructores//////
    public Tienda() {
        productos = new ArrayList<>();
    }

    ///////metodos//////
    public void annadirProducto (Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda");
        }
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

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

    public void borrarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productos.remove(producto);
                return;
            }
        }
        System.out.println("No se ha encontrado el producto"+ " " + nombre + " " + "en la tienda");
    }

    public double calcularTotalTienda() {
        double totalTienda = 0;
        for (Producto producto : productos) {
            totalTienda += producto.getPrecio();
        }
        System.out.println("El total de la tienda es: " + " " + totalTienda + "");
        return totalTienda;
    }

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
    
    
