package model;

public class Venta {

    private int id;
    private int cliente_id;
    private String vendedor;
    private double total;
    private java.sql.Timestamp fecha;
    private String nombreCliente;
    private String nombreVendedor;
    private Double subtotal;
    private Double iva_total;
    private double descuento_total;
    private String estado;
    private String forma_pago;
    private String numero_factura;

    public Venta() {
    }

    public Venta(int id, int cliente_id, String vendedor_id, double total, String fecha) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.vendedor = vendedor;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor_id) {
        this.vendedor = vendedor_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public java.sql.Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva_total() {
        return iva_total;
    }

    public void setIva_total(Double iva_total) {
        this.iva_total = iva_total;
    }

    public double getDescuento_total() {
        return descuento_total;
    }

    public void setDescuento_total(double descuento_total) {
        this.descuento_total = descuento_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }
}
