package com.challenge.sprinter.repository;

import com.challenge.sprinter.domain.Producto;
import com.challenge.sprinter.util.enums.Moneda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@WebMvcTest
public class ProductoRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private ProductoRepository repository;

  @Test
  public void should_find_no_products_if_repository_is_empty() {
    Iterable productos = repository.findAll();
    assertThat(productos).isEmpty();
  }

  @Test
  public void should_store_a_product() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");
    var producto = repository.save(prod);

    assertThat(producto).hasFieldOrPropertyWithValue("moneda", "EUR");
  }

  @Test
  public void should_find_all_products() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");
    entityManager.persist(prod);

    var prod2 = new Producto();
    prod2.setId(2);
    prod2.setMoneda(Moneda.EUR);
    prod.setPrecio(48.0);
    prod.setDescripcion("Zapatillas");
    entityManager.persist(prod2);

    var productos = repository.findAll();

    assertThat(productos).hasSize(2).contains(prod, prod2);
  }

  @Test
  public void should_find_product_by_id() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");
    entityManager.persist(prod);

    var productoEncontrado = repository.findById(prod.getId()).get();

    assertThat(productoEncontrado).isEqualTo(prod);
  }


  @Test
  public void should_delete_producto_by_id() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");
    entityManager.persist(prod);

    var prod2 = new Producto();
    prod2.setId(2);
    prod2.setMoneda(Moneda.EUR);
    prod.setPrecio(48.0);
    prod.setDescripcion("Zapatillas");
    entityManager.persist(prod2);

    repository.save(prod);
    repository.save(prod2);

    repository.deleteById(prod.getId());

    var productos = repository.findAll();

    assertThat(productos).hasSize(1).contains(prod2);
  }

  @Test
  public void should_update_producto_by_id() {
    var prod = new Producto();
    prod.setId(1);
    prod.setMoneda(Moneda.EUR);
    prod.setPrecio(25.0);
    prod.setDescripcion("Chaqueta");
    entityManager.persist(prod);

    var prod2 = new Producto();
    prod2.setId(1);
    prod2.setMoneda(Moneda.EUR);
    prod.setPrecio(99.0);
    prod.setDescripcion("Zapatillas");
    entityManager.persist(prod2);

    var producto = repository.findById(prod2.getId());

    assertThat(producto.get().getPrecio()).isEqualTo(99.0);
  }

}
