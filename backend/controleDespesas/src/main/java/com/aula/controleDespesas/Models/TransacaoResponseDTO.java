package com.aula.controleDespesas.Models;

import java.math.BigDecimal;

public record TransacaoResponseDTO(Long id, String descricao, BigDecimal valor, String tipo) {
    public TransacaoResponseDTO(Transacao transacao){
        this(transacao.getId(), transacao.getDescricao(), transacao.getValor(), transacao.getTipo());
    }
}
