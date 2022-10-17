package com.challenge.sprinter.service;

import com.challenge.sprinter.repository.ProductoRepository;
import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.util.enums.Moneda;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {

  @Mock
  private ProductoRepository productoRepository;

  @InjectMocks
  private ProductoService productoService;

  @Test
  public void shouldReturnListOfProducts() {
    try {
      //WHEN
     when(productoRepository.findAll()).thenReturn(new ArrayList<Producto>());
     var productos = productoService.obtenerTodos();
      assertNotNull(productos);

    } catch (Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldReturnProductById() {
    try {
      //GIVEN
      var id = 1;

      //WHEN
      when(productoRepository.findById(id)).thenReturn(java.util.Optional.of(new Producto()));

      var actualResult = productoService.obtenerProductoPorId(id);
      var expectedResult = new Producto();

      assertNotNull(actualResult);
      assertEquals(actualResult, expectedResult);

    } catch (Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldCreateProduct() {
    try {
      //GIVEN
      var producto = new Producto();
      producto.setId(1);
      producto.setDescripcion("prueba");
      producto.setPrecio(44.55);
      producto.setMoneda(Moneda.USD);

      //WHEN
      when(productoRepository.save(any(Producto.class))).thenReturn(producto);

      var actualResult = productoService.crearProducto(producto);

      assertNotNull(actualResult);
      assertEquals(actualResult, producto);

    } catch (Exception e){
      Assert.fail();
    }
  }

  @Test
  public void shouldUpdateProduct() {
    try {
      //GIVEN
      var producto = new Producto();
      producto.setId(1);
      producto.setDescripcion("prueba");
      producto.setPrecio(44.55);
      producto.setMoneda(Moneda.USD);

      productoRepository.save(producto);

      //WHEN
      when(productoRepository.findById(1)).thenReturn(java.util.Optional.of(producto));
      when(productoRepository.save(any(Producto.class))).thenReturn(producto);

      var actualResult = productoService.actualizarProducto(producto, producto.getId());

      assertNotNull(actualResult);
      assertEquals(actualResult, producto);

    } catch (Exception e){
      Assert.fail();
    }
  }


}
