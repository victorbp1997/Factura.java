/**
 * Factura de compra online.
 * Este programa pretende emitir una factura de compra, en el cual se puede observar las diferentes,
 * constantes y variables de las unidades.
 * Se ha calculado la suma de las unidades, el subtotal, se ha realizado un descuento
 * tanto a un producto como a la compra general. A su vez, se le ha aplicado el IVA y
 * se han realizado los correspondientes cálculos junto a este.
 *
 * @author Víctor Bustamante Pérez
 * @version 1.0
 * @since 23/10/2026
 */
public class Factura {
    // --- Configuración fiscal ---
    public static final String NOMBRE_DE_LA_EMPRESA = "STEAM";
    // Tipo general de IVA aplicable a servicios digitales (21%).
    public static final double IVA_GENERAL = 0.21;
    // Descuento aplicado al total de la compra.
    public static final double DESCUENTO_COMPRA_GENERAL = 0.20;
    // Descuento por promoción en un videojuego.
    public static final double DESCUENTO_VIDEOJUEGO = 0.30;

    public static void main(String[] args) {

        // Código asociado al cliente
        String codigoCliente = "C0074";

        // --- Línea 1: Hogwarts Legacy (compra múltiple, copias para regalo) ---
        String productoUno = "Hogwarts Legacy";
        double precioProductoUno = 59.99;
        int cantidadProductoUno = 3;
        double importeProductoUno = precioProductoUno * cantidadProductoUno;

        // --- Línea 2: CyberPunk 2077 (compra múltiple, mismas condiciones que la línea 1) ---
        String productoDos = "CyberPunk 2077";
        double precioProductoDos = 59.99;
        int cantidadProductoDos = 4;
        double importeProductoDos = precioProductoDos * cantidadProductoDos;

        // --- Línea 3: Diablo IV (producto con descuento promocional) ---
        String productoTres = "Diablo IV";
        double precioProductoTres = 49.99;
        int cantidadProductoTres = 1;
        double descuentoProductoTres = precioProductoTres * DESCUENTO_VIDEOJUEGO;
        double precioFinalProductoTres = precioProductoTres - descuentoProductoTres;
        double importeProductoTres = precioFinalProductoTres * cantidadProductoTres;

        // --- Totales y liquidación
        // Se hace el cálculo del total antes de descuentos y reducciones.
        double subTotal = importeProductoUno + importeProductoDos + importeProductoTres;

        // Se le aplica un descuento por la compra de varios productos.
        double importeDescuento = subTotal * DESCUENTO_COMPRA_GENERAL;
        double baseImponible = subTotal - importeDescuento;

        // Cálculo de la cuota tributaria: se aplica el tipo impositivo del 21% sobre la base imponible acumulada
        double sumaIva = baseImponible * IVA_GENERAL;
        // Importe final de la transacción (base imponible neta + impuestos repercutidos obligatorios)
        double totalAPagar = baseImponible + sumaIva;
        // Se extrae la parte entera (euros) descartando los céntimos mediante un casteo.
        double totalEuros = (int) totalAPagar;

        // Se calcula la cantidad total de licencias adquiridas en el pedido.
        int unidadesVendidas = cantidadProductoUno + cantidadProductoDos + cantidadProductoTres;
        /*
         * Cálculo del coste medio (PVP prorrateado por licencia, incluyendo IVA).
         * Se realiza un casteo a double para evitar la división entera y conservar la
         * precisión decimal.
         */
        double pagoPorUnidad = totalAPagar / (double) unidadesVendidas;

        // ================================================================================
        //             GENERACIÓN DEL COMPROBANTE FISCAL / SALIDA POR CONSOLA
        // ================================================================================

        // 1. Cabecera comercial e identificación del cliente
        System.out.println("============================================");
        System.out.println("\t\t\t\t\t" + NOMBRE_DE_LA_EMPRESA + "\t\t\t\t");
        System.out.println("============================================");
        System.out.println("Cliente: " + codigoCliente);
        System.out.println();

        // 2. Detalle de líneas de pedido (artículo, volumen adquirido e importe)
        System.out.println(productoUno + "\t\t" + "x" + cantidadProductoUno + "\t\t\t" + precioProductoUno);
        System.out.println(productoDos + "\t\t" + "x" + cantidadProductoDos + "\t\t\t" + precioProductoDos);
        System.out.println(productoTres + "\t\t\t" + "x" + cantidadProductoTres + "\t\t\t" + precioFinalProductoTres);

        // 3. Liquidación económica (descuentos comerciales, base imponible y carga impositiva)
        System.out.println("--------------------------------------------");
        System.out.println("Subtotal " + "\t\t" + subTotal);
        System.out.println("Descuento (20%)" + "\t" + importeDescuento);
        System.out.println("Base Imponible" + "\t" + baseImponible);
        System.out.println("IVA (21%)" + "\t\t" + sumaIva);

        // 4. Cierre contable y métricas de facturación (importe neto y coste medio por licencia)
        System.out.println("============================================");
        System.out.println("TOTAL A PAGAR" + "\t" + totalAPagar);
        System.out.println("TOTAL EN EUROS" + "\t" + totalEuros + "€");
        System.out.println("============================================");
        System.out.println("Unidades vendidas: " + unidadesVendidas);
        System.out.println("Pago por unidad: " + pagoPorUnidad);
    }
}
