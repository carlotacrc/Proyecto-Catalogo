package dominio;
import java.util.ArrayList;
public class Tienda {
   
    private ArrayList<Producto> productos;

    public Tienda() {
        productos = new ArrayList<>();
    }

    public void annadirProducto (Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void actualizarProducto(String nombre, double precio, String color) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                if (!color.equals("")) {
                    producto.setColor(color);
                }
                if (precio != -1) {
                    producto.setPrecio(precio);
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
}
    
    
