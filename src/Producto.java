public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private double descuento; // porcentaje entre 0 y 100

    public Producto(String nombre, double precio, int stock, double descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    // ERROR 1 (sencillo): cálculo de precio final con descuento mal implementado
    // Debería ser: precio * (1 - descuento/100)
    public double calcularPrecioFinal() {
        return precio * (1 - descuento/100); // ERROR: descuento tratado como cantidad fija
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", descuento=" + descuento +
                '}';
    }
}
