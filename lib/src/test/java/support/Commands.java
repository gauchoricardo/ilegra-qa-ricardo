package support;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunBase;

public class Commands extends RunBase {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public static void clickElement(By element) {
        try {
            System.out.println("####################");
            System.out.println("**Irá clicar no elemento**" + element);
            waitElementBeClickable(element, 2000);
            getDriver().findElement(element).click();
            System.out.println("**Clicou no elemento**" + element);

        } catch (Exception error) {
            System.out.println("**Erro ao clicar no elemento**" + element);
            System.out.println(error);
        }
    }
    public static void fillField(By element, String value ) {
        try {
            System.out.println("####################");
            System.out.println("**Irá preencher o campo**" + element);
            waitElementBeVisible(element, 2000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("**Preencheu o campo**" + element);

        } catch (Exception error) {
            System.out.println("**Erro ao tentar preencher o elemento**" + element);

        }
    }
    public static void checkMensagem(By element, String expectedMessage) {
        String actualMessage = "";
        System.out.println("####################");
        System.out.println("**Irá verificar a mensagem**" + expectedMessage);
        waitElementBeVisible(element ,10000);
        actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals("Erro ao validar mensagem!",expectedMessage, actualMessage);
        System.out.println("**Validou a mensagem**" + expectedMessage);
        System.out.println("####################");
    }
}