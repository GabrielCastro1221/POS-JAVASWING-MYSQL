package model;

public class Productos {

    private int id;
    private String codigo;
    private String nombre;
    private int proveedor_id;
    private int stock;
    private double precio_neto;
    private double precio_bruto;
    private int categoria_id;
    private java.sql.Timestamp fecha;

    public Productos() {
    }

    public Productos(int id, String codigo, String nombre, int proveedor_id, int stock, double precio_neto,
            double precio_bruto, int categoria_id) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor_id = proveedor_id;
        this.stock = stock;
        this.precio_neto = precio_neto;
        this.precio_bruto = precio_bruto;
        this.categoria_id = categoria_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_neto() {
        return precio_neto;
    }

    public void setPrecio_neto(double precio_neto) {
        this.precio_neto = precio_neto;
    }

    public double getPrecio_bruto() {
        return precio_bruto;
    }

    public void setPrecio_bruto(double precio_bruto) {
        this.precio_bruto = precio_bruto;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public java.sql.Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Timestamp fecha) {
        this.fecha = fecha;
    }
}
