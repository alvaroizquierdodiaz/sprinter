package com.challenge.sprinter.service;


import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.exception.ResourceNotFoundException;
import com.challenge.sprinter.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductoService {

  private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

  @Autowired
  private ProductoRepository productoRepository;

  public List<Producto> obtenerTodos() {
    try {
      logger.info("Entrando al método obtenerTodos de la clase " +logger.getName());
      var lista = productoRepository.findAll();
      logger.info("Devolviendo lista de productos: " +lista);
      return lista;
    } catch (ResourceNotFoundException r){
      r.printStackTrace();
      logger.error("Excepción en método obtenerTodos: " +r.getMessage());
    }
    return null;
  }

  public Producto obtenerProductoPorId(Integer id) {
    logger.info("Entrando al método obtenerProductoPorId de la clase " +logger.getName());
    return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
  }

  public Producto crearProducto(Producto producto) {
    try {
      logger.info("Entrando al método crearProducto de la clase " +logger.getName());
      var productoNuevo = productoRepository.save(producto);
      logger.info("Producto "+productoNuevo.toString()+ "guardado en la base de datos");
      return productoRepository.save(producto);
    } catch (ResourceNotFoundException r){
      r.printStackTrace();
      logger.error("Excepción en método crearProducto: " +r.getMessage());
    }
    return null;
  }

  public Object borrarProducto(Integer id) {
    try {
      logger.info("Entrando al método borrarProducto de la clase " +logger.getName());
      var productoEncontrado = productoRepository.findById(id);
      if (!productoEncontrado.isPresent()){
        logger.error("Producto con id " +id+ " no se encuentra en la base de datos: " +  HttpStatus.NOT_FOUND);
        return new ResponseEntity<String>(new String("Producto no se encuentra en la base de datos"), HttpStatus.NOT_FOUND);
      } else {
        productoRepository.deleteById(id);
        logger.info("Producto con id " +id+ " eliminado: " +  HttpStatus.OK);
        return new ResponseEntity<>(new String("Producto eliminado"), HttpStatus.OK);
      }
    } catch (ResourceNotFoundException r){
      r.printStackTrace();
    }
    return null;
  }

  public Producto actualizarProducto(Producto producto, Integer id) {
    try {
      logger.info("Entrando al método actualizarProducto de la clase " +logger.getName());
      var productoEncontrado = productoRepository.findById(id);
      var productoNuevo = new Producto();

      if(productoEncontrado.isPresent()) {
        logger.info("Producto " +producto+ "encontrado en la base de datos");
        productoNuevo = producto;
        productoNuevo.setId(id);
        productoNuevo = productoRepository.save(productoNuevo);
        logger.info("Producto " +producto+ "actualizado. Nuevo producto: " +productoNuevo);
        return productoNuevo;
      }
    } catch (ResourceNotFoundException r){
      r.printStackTrace();
      logger.error("Excepción en método actualizarProducto: " +r.getMessage());
    }
    return null;
   }
}
