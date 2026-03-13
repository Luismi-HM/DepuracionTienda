public class InventarioTienda {

    private Producto[] productos;
    private int contador; // número real de productos ocupados en el array

    public InventarioTienda(int capacidadMaxima) {
        productos = new Producto[capacidadMaxima];
        contador = 0;
    }


    public void insertarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador] = producto;
            contador++;
        } else {
            System.out.println("No hay espacio para más productos.");
        }
    }


    public void actualizarStock(String nombreProducto, int nuevoStock) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getNombre().equals(nombreProducto)) {
                productos[i].setStock(nuevoStock);
                // supondremos que solo hay un producto con ese nombre
                break;
            }
        }
    }


    public double calcularValorTotalStock() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            if (productos[i] != null && productos[i].getStock() > 0) {
                total += productos[i].getPrecio() * productos[i].getStock();
            }
        }
        return total;
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i] != null && productos[i].getNombre().equalsIgnoreCase(nombreProducto)) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contador - 1] = null;
                contador--;
                System.out.println("Producto '" + nombreProducto + "' eliminado y lista compactada.");
                return;
            }
        }
        System.out.println("No se encontró el producto a eliminar.");
    }

    public void listarProductos() {
        System.out.println("Listado de productos:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Posición " + i + ": " + productos[i]);
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getContador() {
        return contador;
    }
}
