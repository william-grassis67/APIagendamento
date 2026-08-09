package com.william.meu_projeto.exceptions;

public class AgendamentoExistenteException extends RuntimeException {
    public AgendamentoExistenteException(String mensagem) {
        super(mensagem);
    }
}
