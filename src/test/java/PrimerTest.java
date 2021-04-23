import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PrimerTest {

    @Test
    public void googleTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.close();
    }

    @Test
    public void netflixTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com");

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de h1s es: " + listaH1s.size());

        for (WebElement h1 : listaH1s) {
            System.out.println("--> H1: " + h1.getText());
        }

        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de h2s es: " + listaH2s.size());

        for (WebElement h2 : listaH2s) {
            System.out.println("--> H2: " + h2.getText());
        }

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de links son: " + listaLinks.size());

        int contadorLinksValidos = 0;

        for (WebElement link : listaLinks) {
            if (link.getText().isEmpty() == false) {
                System.out.println("Link: --> " + link.getText());
                contadorLinksValidos++;
            }
        }

        System.out.println("La cantidad de links con texto son " + contadorLinksValidos);

        WebElement iniciaSesion = listaLinks.get(0);
        iniciaSesion.click();

        WebElement emailInputField = driver.findElement(By.name("userLoginId"));
        emailInputField.sendKeys("testing@test.com");
    }

    @Test
    public void netflixButtonsTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com");

        List<WebElement> listaButtons = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones es " + listaButtons.size());

        for (WebElement botonDeNetflix: listaButtons) {
            System.out.println("Boton: " + botonDeNetflix.getText());
        }

        WebElement botonCuantoCuesta = listaButtons.get(2);
        System.out.println("Boton 2: " + botonCuantoCuesta.getText());
        botonCuantoCuesta.click();
    }



}