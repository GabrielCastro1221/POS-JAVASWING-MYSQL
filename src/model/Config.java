package model;

public class Config {

    private int id;
    private String nombre_empresa;
    private long ruc;
    private String telefono;
    private String direccion;
    private String razon_social;
    private java.sql.Timestamp fecha;

    public Config() {
    }

    public Config(int id, long ruc, String nombre, String telefono, String direccion, String razon_social) {
        this.id = id;
        this.ruc = ruc;
        this.nombre_empresa = nombre;
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
        return nombre_empresa;
    }

    public void setNombre(String nombre) {
        this.nombre_empresa = nombre;
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

    public java.sql.Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Timestamp fecha) {
        this.fecha = fecha;
    }
}
