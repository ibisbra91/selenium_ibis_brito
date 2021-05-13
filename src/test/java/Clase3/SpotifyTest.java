package Clase3;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.ElementNotInteractableException;

import java.util.List;

public class SpotifyTest {

    /*Ejercicio 3 (práctico 3)
     Crear un método llamado spotifyByNameTest
     Ingresar al sitio: https://www.spotify.com/uy/signup/
     Completar todos los campos con xpath name
     */
    private WebDriver getDriver() {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void spotifyByNameTest() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@type='email'][@id='email']")).sendKeys("testibis@gmail.com");
        driver.findElement(By.xpath("//*[@type='email'][@id='confirm']")).sendKeys("testibis@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//input[@type='text'][@placeholder='Introduce un nombre de perfil.']")).sendKeys("Me");
        driver.findElement(By.xpath("//*[@id='day']")).sendKeys("12");
        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@id='month']")));
        selectMonth.selectByValue("12");
        driver.findElement(By.xpath("//*[@id='year']")).sendKeys("1991");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[6]/div/label/span[1]")).click();
    }

    /*Ejercicio 4
     Crear un método llamado spotifyByPlaceHolder
     Ingresar al sitio: https://www.spotify.com/uy/signup/
     Completar todos los campos con xpath placeholder
     */
    @Test
    public void spotifyByPlaceHolder() {
        WebDriver driver = getDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        driver.findElement(By.xpath("//input[@placeholder='Introduce tu correo electrónico.']")).sendKeys("placeholder");
    }

    /*Ejercicio 5
     Crear un método llamado spotifyByName
     Ingresar al sitio: https://www.spotify.com/uy/signup/
     Completar todos los campos con Css Selector name
    */
    @Test
    public void spotifyByName() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("ibrito@test.com");
        driver.findElement(By.cssSelector("input[id='confirm']")).sendKeys("ibrito@test.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password123");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Ibita");
        driver.findElement(By.cssSelector("#day")).sendKeys("12");
        Select sexSelect = new Select(driver.findElement(By.cssSelector("#month")));
        sexSelect.selectByValue("12");
        driver.findElement(By.cssSelector("#year")).sendKeys("1991");
        Thread.sleep(2000);
        driver.close();
    }

    /*Ejercicio 6
     Crear un método de test llamado checkBoxTest
     Ir a Facebook https://www.facebook.com/
     Validar que no haya valor seleccionado en el checkbox Gender
     Mostrar un mensaje en pantalla y agregar un assert para validar que no está seleccionado
     Hacer click en el checkbox de Male
     Mostrar si está seleccionado
     Agregar un assert que valide que realmente esté seleccionado
     */
    @Test
    public void checkBoxTest() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("nueva")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();

        //Validar que no haya valor seleccionado en el checkbox Gender
        //Mostrar un mensaje en pantalla y agregar un assert para validar que no está seleccionado
        if (driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).isSelected() || driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).isSelected() || driver.findElement(By.xpath("//input[@name='sex'][@value='-1']")).isSelected()) {
            Assert.assertTrue(false, "Alguno esta marcado y por eso no puede avanzar. Se corta el test.");
        }
        System.out.println("No hay sexo seleccionado");

        System.out.println("\t");
        System.out.print(" ☆☆☆ ☆☆☆  ☆☆☆ ☆☆☆  ☆☆☆ ☆☆☆   ☆☆☆ ☆☆☆");
        System.out.println("\t");
       /* or
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).isSelected(), false);
        */
        /* Hacer click en el checkbox de Male
        Mostrar si está seleccionado
        Agregar un assert que valide que realmente esté seleccionado
        */
        driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).click();
        if(driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).isSelected()){
            System.out.println("Ahora está seleccionado el sexo Hombre");
        }
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).isSelected(),true);

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done!! ☆☆☆");
        System.out.println("\t");
    }

}


