package dominio;
public  class Producto {

    //////atributos//////
    private String talla;
     private double precio;
    private String color;
    private String nombre;

    ///////constructores//////
    public Producto(double precio,String talla,String color, String nombre) {
        this.talla = talla;
        this.precio = precio;
        this.color = color;
    this.nombre = nombre;
    }

    ///////getters y setters//////
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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

    ///////metodos//////
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

    public void actualizar(String nombre, String color, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
    }

    public String toString(){
        return "Nombre: " + " , Color: " + " , Talla: " + " , Precio: " + precio;
    }

}
