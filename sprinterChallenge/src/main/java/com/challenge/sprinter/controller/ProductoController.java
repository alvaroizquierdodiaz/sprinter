package com.challenge.sprinter.controller;

import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/productos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @GetMapping(value = "/obtenerTodos")
  public ResponseEntity<List<Producto>> obtenerTodos() {
    return ResponseEntity.ok(productoService.obtenerTodos());
  }

  @GetMapping(value = "/obtener/{id}")
  public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id) {
    return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
  }

  @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto) {
    return ResponseEntity.ok(productoService.crearProducto(producto));
  }

  @DeleteMapping(value = "/borrar/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity borrarProducto(@PathVariable int id) {
    return ResponseEntity.ok(productoService.borrarProducto(id));
  }

  @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Producto> actualizarProducto(@Valid @RequestBody Producto producto, @PathVariable Integer id) {
    return ResponseEntity.ok(productoService.actualizarProducto(producto, id));
  }

}
