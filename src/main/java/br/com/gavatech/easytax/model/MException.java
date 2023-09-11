package br.com.gavatech.easytax.model;
public class MException extends Exception{
    public MException() {
        super();
    }

    public MException(String mensagem) {
        super(mensagem);
    }

    public MException(Throwable t) {
        super(t);
    }

    public MException(String mensagem, Throwable t) {
        super(mensagem, t);
    }

}