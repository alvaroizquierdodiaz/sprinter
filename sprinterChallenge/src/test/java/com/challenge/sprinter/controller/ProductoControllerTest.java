package com.challenge.sprinter.controller;

import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.service.ProductoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

  @InjectMocks
  private ProductoController productoController;

  @Mock
  ProductoService productoService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldReturnListOfProducts() throws Exception {
    //GIVEN
    Mockito.when(productoService.obtenerTodos()).thenReturn(new ArrayList<Producto>());

    try {
      //WHEN
      var actualResult = productoService.obtenerTodos();
      var expectedResult = new ArrayList<Producto>();

      //THEN
      productoController.obtenerTodos();
      assertNotNull(actualResult);
      assertEquals(actualResult, expectedResult);
      verify(productoService, atMost(2)).obtenerTodos();

    } catch(Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldReturnProductById() throws Exception {
    //GIVEN
    var id = 1;
    Mockito.when(productoService.obtenerProductoPorId(Mockito.any())).thenReturn(new Producto());

    try {
      //WHEN
      var actualResult = productoService.obtenerProductoPorId(1);
      var expectedResult = new Producto();

      //THEN
      productoController.obtenerProductoPorId(Mockito.any());
      assertNotNull(actualResult);
      assertEquals(actualResult, expectedResult);
      verify(productoService, atMost(1)).obtenerProductoPorId(id);

    } catch(Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldCreateProduct() throws Exception {
    //GIVEN
    Mockito.when(productoService.crearProducto(Mockito.any())).thenReturn(new Producto());

    try {
      //WHEN
      var actualResult = productoService.crearProducto(new Producto());
      var expectedResult = new Producto();

      //THEN
      productoController.crearProducto(Mockito.any());
      assertNotNull(actualResult);
      assertEquals(actualResult, expectedResult);
      verify(productoService, atMost(1)).crearProducto(new Producto());

    } catch(Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldDeleteProduct() throws Exception {
    //GIVEN
    var id = 1;
    Mockito.when(productoService.borrarProducto(Mockito.any())).thenReturn(new Producto());

    try {
      //WHEN
      var actualResult = productoService.borrarProducto(1);

      //THEN
      productoController.borrarProducto(1);
      assertNotNull(actualResult);
      verify(productoService, atMost(2)).borrarProducto(id);

    } catch(Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldUpdateProduct() throws Exception {
    //GIVEN
    Mockito.when(productoService.actualizarProducto(Mockito.any(), Mockito.any())).thenReturn(new Producto());

    try {
      //WHEN
      var actualResult = productoService.actualizarProducto(Mockito.any(), Mockito.any());
      var expectedResult = new Producto();

      //THEN
      productoController.actualizarProducto(Mockito.any(), Mockito.any());
      assertNotNull(actualResult);
      assertEquals(actualResult, expectedResult);
      verify(productoService, atMost(2)).actualizarProducto(Mockito.any(), Mockito.any());

    } catch(Exception e){
      Assert.fail();
    }
  }

}
