package model;

public class Venta {

    private int id;
    private String cliente_id;
    private String vendedor_id;
    private double total;
    private java.sql.Timestamp fecha;

    public Venta() {
    }

    public Venta(int id, String cliente, String vendedor, double total, String fecha) {
        this.id = id;
        this.cliente_id = cliente;
        this.vendedor_id = vendedor;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente_id;
    }

    public void setCliente(String cliente) {
        this.cliente_id = cliente;
    }

    public String getVendedor() {
        return vendedor_id;
    }

    public void setVendedor(String vendedor) {
        this.vendedor_id = vendedor;
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
}
