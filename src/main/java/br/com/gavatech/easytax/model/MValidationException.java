package br.com.gavatech.easytax.model;
public class MValidationException extends MException{

    public MValidationException() {
        super();
    }

    public MValidationException(String mensagem) {
        super(mensagem);
    }

    public MValidationException(Throwable t) {
        super(t);
    }

    public MValidationException(String mensagem, Throwable t) {
        super(mensagem, t);
    }
}
