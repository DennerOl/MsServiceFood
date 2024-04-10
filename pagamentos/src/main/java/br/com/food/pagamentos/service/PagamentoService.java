package br.com.food.pagamentos.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.food.pagamentos.dto.PagamentoDto;
import br.com.food.pagamentos.model.Pagamento;
import br.com.food.pagamentos.model.Status;
import br.com.food.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

  @Autowired
  private PagamentoRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  public Page<PagamentoDto> obterTodos(Pageable paginacao) {
    return repository.findAll(paginacao)
        .map(p -> modelMapper.map(p, PagamentoDto.class));
  }

  public PagamentoDto obterPorId(Long id) {
    Pagamento pagamento = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException());

    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public PagamentoDto criarPagamento(PagamentoDto dto) {
    Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
    pagamento.setStatus(Status.CRIADO);
    repository.save(pagamento);

    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
    Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
    pagamento.setId(id);
    pagamento = repository.save(pagamento);
    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public void excluirPagamento(Long id) {
    repository.deleteById(id);
  }
}
