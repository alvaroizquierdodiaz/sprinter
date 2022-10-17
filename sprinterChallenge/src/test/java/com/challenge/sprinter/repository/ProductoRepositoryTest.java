package com.challenge.sprinter.repository;

import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.util.enums.Moneda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoRepositoryTest {


  @Autowired
  ProductoRepository productoRepository;

  @Test
  public void should_store_a_product() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");

    assertThat(productoRepository.save(prod)).isNotNull();
  }

  @Test
  public void should_find_all_products() {
    assertThat(productoRepository.findAll()).isNotNull();
  }

  @Test
  public void should_find_product_by_id() {
    var productoEncontrado = productoRepository.getReferenceById(1);
    assertThat(productoEncontrado).isNotNull();
  }

  @Test
  public void should_delete_producto_by_id() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");

    var prod2 = new Producto();
    prod2.setId(2);
    prod2.setMoneda(Moneda.EUR);
    prod2.setPrecio(48.0);
    prod2.setDescripcion("Zapatillas");

    productoRepository.save(prod);
    productoRepository.save(prod2);

    productoRepository.deleteById(prod.getId());

    var productos = productoRepository.findAll();

    assertThat(productos).hasSize(1).contains(prod2);
  }

}
