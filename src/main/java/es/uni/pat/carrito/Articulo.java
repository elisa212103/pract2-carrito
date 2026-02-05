package es.uni.pat.carrito;

public class Articulo {

    private Long idArticulo;
    private String descripcion;
    private int unidades;
    private double precioUnitario;

    public Articulo() {}

    public Articulo(Long idArticulo, String descripcion, int unidades, double precioUnitario) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return unidades * precioUnitario;
    }
}

