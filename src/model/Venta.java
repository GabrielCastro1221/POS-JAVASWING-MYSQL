package model;

public class Venta {

    private int id;
    private int cliente_id;
    private int vendedor;
    private double total;
    private java.sql.Timestamp fecha;
    ;
    private String nombreCliente;
    private String nombreVendedor;

    public Venta() {
    }

    public Venta(int id, int cliente_id, int vendedor_id, double total, String fecha) {
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

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor_id) {
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
}
