package util;

import exceptions.ElementoNaoEncontradoException;
import exceptions.UrlInvalidaException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtil {
    public static void navegar(WebDriver webDriver, String url) throws UrlInvalidaException {
        try {
            webDriver.navigate().to(url);
        }
        catch (InvalidArgumentException e) {
            throw new UrlInvalidaException(url);
        }
    }

    public static WebElement aguardarElementoVisivel(WebDriver webDriver,
                                              int tempoMaximoEspera,
                                              By identificadorElemento) throws ElementoNaoEncontradoException {
        try {
            return new WebDriverWait(webDriver, Duration.ofSeconds(tempoMaximoEspera))
                    .until(ExpectedConditions.visibilityOfElementLocated(identificadorElemento));

        } catch (Exception ex) {
            throw new ElementoNaoEncontradoException("aguardar elemento visível", identificadorElemento);
        }
    }

    public static WebElement aguardarElementoClicavel(WebDriver webDriver,
                                               int tempoMaximoEspera,
                                               By identificadorElemento) throws ElementoNaoEncontradoException {
        try {
            return new WebDriverWait(webDriver, Duration.ofSeconds(tempoMaximoEspera))
                    .until(ExpectedConditions.elementToBeClickable(identificadorElemento));

        } catch (Exception ex) {
            throw new ElementoNaoEncontradoException("aguardar elemento clicável", identificadorElemento);
        }
    }

    public static List<WebElement> aguardarElementosVisiveis(WebDriver webDriver,
                                                      int tempoMaximoEspera,
                                                      By identificadorElemento) throws ElementoNaoEncontradoException {
        try {
            return new WebDriverWait(webDriver, Duration.ofSeconds(tempoMaximoEspera))
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(identificadorElemento));

        } catch (Exception ex) {
            throw new ElementoNaoEncontradoException("aguardar elementos visíveis", identificadorElemento);
        }
    }

    public static void moverParaElemento(WebDriver webDriver, int tempoMaximoEspera, By identificadorElemento) throws ElementoNaoEncontradoException {
        Actions action = new Actions(webDriver);

        WebElement webElement = aguardarElementoVisivel(webDriver, tempoMaximoEspera, identificadorElemento);
        action.moveToElement(webElement).perform();
    }
}