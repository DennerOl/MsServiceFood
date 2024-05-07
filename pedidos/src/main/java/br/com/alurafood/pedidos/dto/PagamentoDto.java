package br.com.alurafood.pedidos.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDto {

  private Long id;
  private BigDecimal valor;
  private String nome;
  private String numero;
  private String expiracao;
  private String codigo;
  private StatusPagamento status;
  private Long formaDePagamentoId;
  private Long pedidoId;

}
