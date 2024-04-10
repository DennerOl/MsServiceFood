package br.com.food.pagamentos.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Positive
  private BigDecimal valor;

  @NotBlank
  @Size(max = 100)
  private String nome;

  @NotBlank
  @Size(max = 19)
  private String numero;

  @NotBlank
  @Size(max = 7)
  private String expiracao;

  @NotBlank
  @Size(min = 3, max = 3)
  private String codigo;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;

  @NotNull
  private Long pedidoId;

  @NotNull
  private Long formaDePagamentoId;

}
