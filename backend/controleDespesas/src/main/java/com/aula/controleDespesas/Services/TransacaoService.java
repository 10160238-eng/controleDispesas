package com.aula.controleDespesas.Services;

import com.aula.controleDespesas.Models.Transacao;
import com.aula.controleDespesas.Models.TransacaoRepository;
import com.aula.controleDespesas.Models.TransacaoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoResponseDTO> findAll(){
        return repository.findAll().stream().map(TransacaoResponseDTO::new).toList();
    }

    public TransacaoResponseDTO create(Transacao transacao){
        Transacao novaTransacao = repository.save(transacao);
        return new TransacaoResponseDTO(novaTransacao);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Transação não encontrada!");
        }
        repository.deleteById(id);
    }
}
