package Clase3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    * **************************** Ejercicio GIT ****************************
    Ejercicio. 7
    Crear una clase llamada SpotifyWithCssSelectorTest
    Crear un método llamado spotifyByPlaceHolderTest
    Ingresar al sitio: https://www.spotify.com/uy/signup/
    Completar todos los campos con Css Selector placeholder
    Crear una rama partiendo de dev llamada practico11/ejercicio7 y subir los cambios del archivo
    */
    @Test
    public void spotifyByPlaceHolderTest() {
        WebDriver driver = getDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test123@gmail.com");
        driver.findElement(By.cssSelector("input#confirm")).sendKeys("test123@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("passw123");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Amaya");
        driver.findElement(By.cssSelector("input#day")).sendKeys("12");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='month']")));
        month.selectByValue("12");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1991");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[6]/div/label/span[1]")).click();

    }
}
