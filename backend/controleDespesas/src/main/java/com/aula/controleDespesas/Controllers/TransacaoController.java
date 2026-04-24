package com.aula.controleDespesas.Controllers;

import com.aula.controleDespesas.Models.Transacao;
import com.aula.controleDespesas.Models.TransacaoResponseDTO;
import com.aula.controleDespesas.Services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransacaoResponseDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> create(@RequestBody Transacao dados){
        TransacaoResponseDTO novaTransacao = service.create(dados);
        return ResponseEntity.status(201).body(novaTransacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
