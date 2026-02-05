package es.uni.pat.carrito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/carritos")
public class ControladorRest {
    private final Map<Long, Carrito> carritos = new HashMap<>();

    // CREATE, siempre poner también ResponseStatus
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito crearCarrito(@RequestBody Carrito nuevo) {

        if (carritos.containsKey(nuevo.getIdCarrito())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El carrito ya existe");
        }

        carritos.put(nuevo.getIdCarrito(), nuevo);
        return nuevo;
    }

    // Añadir artículos
    @PostMapping("/{id}/articulos")
    public Carrito añadirArticulo(@PathVariable Long id,
                                  @RequestBody Articulo articulo) {

        Carrito carrito = carritos.get(id);
        if (carrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }

        carrito.getArticulos().add(articulo);
        return carrito;
    }


    // READ
    @GetMapping("/{id}")
    public Carrito obtenerCarrito(@PathVariable Long id) {

        Carrito carrito = carritos.get(id);
        if (carrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }

        return carrito;
    }


    // UPDATE
    @PutMapping("/{id}")
    public Carrito actualizarCarrito(@PathVariable Long id,
                                     @RequestBody Carrito actualizado) {

        if (!carritos.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }

        actualizado.setIdCarrito(id);
        carritos.put(id, actualizado);
        return actualizado;
    }


    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCarrito(@PathVariable Long id) {

        if (!carritos.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado");
        }

        carritos.remove(id);
    }
}



