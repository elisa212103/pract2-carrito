package es.uni.pat.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private Long idCarrito;
    private List<Articulo> articulos = new ArrayList<>();

    public Carrito() {}

    public Carrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public double getPrecioFinal() {
        return articulos.stream()
                .mapToDouble(Articulo::getSubtotal)
                .sum();
    }
}
