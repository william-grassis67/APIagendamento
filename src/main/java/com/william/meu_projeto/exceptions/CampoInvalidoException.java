package com.william.meu_projeto.exceptions;

import java.lang.String;

public class CampoInvalidoException extends RuntimeException {
    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
