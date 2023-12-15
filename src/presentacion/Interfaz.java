// Version: 1.0
package presentacion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import dominio.Producto;
import dominio.Tienda;

/**
 * Clase que contiene la interfaz de la aplicación
 */
public class Interfaz {

    /**
     * Atributos de la clase Interfaz
     */
    private Tienda tienda;
    private Scanner scanner;

    /**
     * Constructor de la clase Interfaz
     */
    public Interfaz() 
    {
        tienda = new Tienda();
        scanner = new Scanner(System.in);
    }

    /**
     * Método que muestra el menú del dueño
     */
    public void menuDuenno() 
    {
        System.out.println("========= Menú del Dueño =========");
        System.out.println("|1. Agregar Producto             |");
        System.out.println("|2. Borrar Producto              |");
        System.out.println("|3. Actualizar Producto          |");
        System.out.println("|4. Mostrar la Tienda            |");
        System.out.println("|5. Precio total Tienda          |");
        System.out.println("|6. Salir                        |");
        System.out.print("Elige una opción: ");
    }

    /**
     * Método que muestra el menú del cliente
     */
    public void menuCliente() 
    {
        System.out.println("========= Menú del Cliente ========");
        System.out.println("|1. Comprar Producto               |");
        System.out.println("|2. Buscar Producto               |");
        System.out.println("|3. Mostrar la Tienda             |");
        System.out.println("|4. Salir                         |");
        System.out.print("Elige una opción: ");
    }

    /**
     * Método que inicia la aplicación
     */
    public void iniciar() 
    {
        int opc;
        System.out.println("Si eres dueño 1 y si eres cliente 2:");
        int escribir = scanner.nextInt();
        cargar();
        do {
            if (escribir == 1) {
                menuDuenno();
                opc = scanner.nextInt();
                scanner.nextLine();
                comandosDuenno(opc);
            } else if (escribir == 2) {
                menuCliente();
                opc = scanner.nextInt();
                scanner.nextLine();
                comandoCliente(opc);
            } else {
                System.out.println("Tipo de usuario no válido, solo puedes ser dueño o cliente.");
                break;
            }
        } while ((escribir == 1 && opc != 6) || (escribir == 2 && opc != 4));
    }

    /**
     * Método que ejecuta los comandos del dueño
     * @param opcion
     */
    private void comandosDuenno(int opcion) 
    {
        if (opcion == 1) {
            annadirProducto();
        } else if (opcion == 2) {
            borrarProducto();
            System.out.println("Producto retirado de la tienda");
        } else if (opcion == 3) {
            actualizarProducto();
        } else if (opcion == 4) {
            mostrarTienda();
        } else if (opcion == 5) {
            calcularTotalTienda();
        } else if (opcion == 6) {
            grabar();
            System.out.println("Saliendo del menú como dueño.");
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

    /**
     * Método que ejecuta los comandos del cliente
     * @param opcion
     */

    private void comandoCliente(int opcion) 
    {
        if (opcion == 1) {
            comprarProducto();
            System.out.println("Has comprado el producto exitosamente.");
        } else if (opcion == 2) {
            buscarProducto();
        } else if (opcion == 3) {
            mostrarTienda();
        } else if (opcion == 4) {
            grabar();
            System.out.println("Saliendo del menú como cliente.");
        } else {
            System.out.println("Opción incorrecta.");
        }
    }

    /**
     * Método que ejecuta los comandos del dueño
     * @param opcion
     */
    private void comprarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere comprar?: ");
        String nombre = scanner.nextLine();
        tienda.borrarProducto(nombre);
    }

    /**
     * Método que añade un producto a la tienda
     */
    private void annadirProducto() 
    {
        System.out.print("Nombre del producto que quiere añadir: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("¿Cúal es la talla del producto?: ");
        String talla = scanner.nextLine();
        System.out.print("¿Cúal es el color del producto?: ");
        String color = scanner.nextLine();

        Producto producto = new Producto(talla, precio, color, nombre);
        tienda.annadirProducto(producto);

        System.out.println("Producto añadido.");

    }
    
    /**
     * Método que borra un producto de la tienda
     */
    private void borrarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere borrar?: ");
        String nombre = scanner.nextLine();
        tienda.borrarProducto(nombre);
    }

    /**
     * Método que busca un producto en la tienda
     */
    private void buscarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere buscar?: ");
        String nombre = scanner.nextLine();
        tienda.buscarProducto(nombre);
    }

    /**
     * Método que muestra los productos de la tienda
     */
    private void mostrarTienda() {
        tienda.mostrarProductos();
    }

    /**
     * Método que actualiza un producto de la tienda
     */
    private void actualizarProducto() {
        System.out.println("Nombre de los productos que quiere actualizar");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo color del producto (o deje en blanco para mantener el actual): ");
        String nuevoColor = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio de la zapatilla (o ponga -1 para mantener el actual): ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese la nueva talla del producto (o deje en blanco para mantener el actual): ");
        String nuevaTalla = scanner.nextLine();

        tienda.actualizarProducto(nuevaTalla, nuevoPrecio, nuevoColor, nombre);

    }
    
    /**
     * Método que calcula el total de la tienda
     */
    private void calcularTotalTienda() {
        tienda.calcularTotalTienda();
    }

    /**
     * Método que graba la tienda
     */
    public void grabar() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("tienda.dat"))) 
        {
            obj.writeObject(tienda);
            System.out.println("La tienda se ha grabado correctamente.");
        } catch (IOException e) 
        {
            System.out.println("Error al grabar la tienda: " );
        }
    }

    /**
     * Método que carga la tienda
     */
    public void cargar() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("tienda.dat"))) 
        {
            tienda = (Tienda) obj.readObject();
            System.out.println("La tienda se ha cargado correctamente.");
        } catch (IOException e) 
        {
            System.out.println("Error al cargar la tienda: " );
        } catch (ClassNotFoundException e) 
        {
            System.out.println("Error al cargar la tienda: " );
        }
    }
}