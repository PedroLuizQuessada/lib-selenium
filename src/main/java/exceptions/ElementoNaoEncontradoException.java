package exceptions;

import org.openqa.selenium.By;

public class ElementoNaoEncontradoException extends Exception {
    public ElementoNaoEncontradoException(String metodo, By identificadorElemento) {
        super(String.format("Falha ao %s usando xpath %s", metodo, identificadorElemento));
    }
}
