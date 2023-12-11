# Proyecto-Catalogo
Programa que gestiona altas, bajas y modificaciones de productos de una tienda de ropa. 
Se puede acceder en modo dueño y en modo cliente.
En modo dueño se puede hacer altas, bajas y modificaciones del catalogo. 
En modo dueño se puede hacer una compra de los priductos del catalogo. 

# Version
Version 1.0 Diciembre del 2023. 

# Conservacion de datos
Al comenzar el programa se cargan los datos desde el fichero tienda.dat.
Si la primera vez que se ejecuta, el fichero no existe este se crea por primera vez. 
Al salir del programa los datos se guardan en el fichero. 

# Uso
Una vez que entras en el modo dueño o en el modo cliente, no puedes pasar de uno a otro. Tienes que volver a iniciar el programa.

En modo dueño:
    '''
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
    '''

    Si se elige la opción uno:
    Se pedirán los datos para añadir un nuevo producto, y lo añadira.
    '''
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
    '''

    Si eliges la opcion 2:
    Se pedira el nombre del producto y lo quitara del catalogo.
    '''
    private void borrarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere borrar?: ");
        String nombre = scanner.nextLine();
        tienda.borrarProducto(nombre);
    }
    '''

    Si eliges la opcion 3:
    Se pedira el nombre del producto, y te preguntara que quieres cambiar.
    '''
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
    '''

    Si eliges la opcion 4:
    Te mostrara todos los articulos disponibles de la tienda.
    '''
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda");
        }
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    '''

    Si eliges la opcion 5:
    Te calculara el total de los productos que hay disponibles en la tienda. 
    '''
    private void calcularTotalTienda() {
        tienda.calcularTotalTienda();
    }
    '''
    Si eliges la opción 6:
    Se cierra el programa y guarda los datos.



En modo cliente:
    '''
    public void menuCliente() 
    {
        System.out.println("========= Menú del Cliente ========");
        System.out.println("|1. Comprar Producto               |");
        System.out.println("|2. Buscar Producto               |");
        System.out.println("|3. Mostrar la Tienda             |");
        System.out.println("|4. Salir                         |");
        System.out.print("Elige una opción: ");
    }
    '''

    Si eliges la opcion 1:
    Te pedira los nombres de los productos que quieres comprar.
    '''
    private void comprarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere comprar?: ");
        String nombre = scanner.nextLine();
        tienda.borrarProducto(nombre);
    }
    '''
    Si eliges la opcion 2:
    Te pedira el nombre del productio que quieres buscar.
    '''
    private void buscarProducto() {
        System.out.println("¿Cúal es el nombre del producto que quiere buscar?: ");
        String nombre = scanner.nextLine();
        tienda.buscarProducto(nombre);
    }
    '''
    Si eliges la opcion 3:
    Te mostara los productos disponibles de la tienda.
    '''
    private void mostrarTienda() {
        tienda.mostrarProductos();
    }
    '''
    Si eliges la opcion 4:
    Se cierra el programa y guarda los datos.

# Contacto
Para consultas y comentarios contactar a Carlota Ruiz Campesino.
Correo: carlota.ruizcampesino@usp.ceu.es
Telefono: 628791353. 



