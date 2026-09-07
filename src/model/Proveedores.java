package model;

public class Proveedores {

    private int id;
    private long ruc;
    private String nombre;
    private String vendedor;
    private String telefono;
    private String direccion;
    private String razon_social;

    public Proveedores() {
    }

    public Proveedores(int id, long ruc, String nombre, String vendedor, String telefono, String direccion, String razon_social) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razon_social = razon_social;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

}
