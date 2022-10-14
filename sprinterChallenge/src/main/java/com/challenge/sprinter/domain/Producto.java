package com.challenge.sprinter.domain;

import com.challenge.sprinter.util.enums.Moneda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCTO")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "DESCRIPCION")
  @NotNull(message = "La descripción del producto es requerida")
  private String descripcion;

  @Column(name = "PRECIO")
  @NotNull(message = "El precio del producto es requerido")
  private Double precio;

  @Column(name = "URL_PRODUCTO")
  private String urlProducto;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "La moneda no puede ser nula")
  @Column(name = "MONEDA", length = 3)
  private Moneda moneda;

}
