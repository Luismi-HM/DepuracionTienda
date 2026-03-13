import java.util.Arrays;

public class MainInventario {
    public static void main(String[] args) {
        InventarioTienda inventario = new InventarioTienda(5);

        // Datos iniciales
        Producto p1 = new Producto("Teclado", 20.0, 10, 10.0);
        Producto p2 = new Producto("Raton", 15.0, 5, 0.0);
        Producto p3 = new Producto("Monitor", 150.0, 2, 20.0);

        inventario.insertarProducto(p1);
        inventario.insertarProducto(p2);
        inventario.insertarProducto(p3);

        System.out.println("Precio final teclado (esperado 18.0): " + p1.calcularPrecioFinal());
        System.out.println("Precio final monitor (esperado 120.0): " + p3.calcularPrecioFinal());

        Producto p4 = new Producto("Altavoces", 30.0, 4, 5.0);
        inventario.insertarProducto(p4);

        Producto p5 = new Producto("Webcam", 40.0, 3, 0.0);
        inventario.insertarProducto(p5);

        System.out.println("Webcam insertada");
        inventario.listarProductos();


        System.out.println("Actualizado el stock del monitor a 5");
        inventario.actualizarStock("Monitor", 5);
        inventario.listarProductos();

        System.out.println("Actualizado el stock de un producto que no existe (RAM) a 7. No debería actualizarm pero tampoco dar error");
        inventario.actualizarStock("RAM", 7);
        inventario.listarProductos();

        // Manipulamos datos “erróneos” para el valor total
        // Introducimos stock negativo a propósito
        p2.setStock(-3);


        double valorTotal = inventario.calcularValorTotalStock();
        System.out.println("Valor total de stock: " + valorTotal);

        // Eliminación para ver comportamiento con huecos null
        inventario.eliminarProducto("Raton");
        inventario.listarProductos();

        // intentando actualizar el stock del producto eliminado
        System.out.println("Intentando actualizar el stock del producto eliminado... ");
       // inventario.actualizarStock("Raton", 5);


        double valorTotal2 = inventario.calcularValorTotalStock();
        System.out.println("Valor total de stock tras eliminar ratón: " + valorTotal2);
    }
}
