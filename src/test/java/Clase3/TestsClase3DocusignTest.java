package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestsClase3DocusignTest {

    /* 1. Crear un método llamado completeDocusignRegistrationForm
    Ingresar al sitio: https://go.docusign.com/o/trial/
    Completar todos los campos con xpath name
    * */
    @Test
    public void completeDocusignRegistrationForm() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Irma");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Amaya");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mom@hotmail.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+598 95 654 321");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("la mejor Mami del Mundo Mundial");
        WebElement industrySelect = driver.findElement(By.xpath("//select[@name='ds_industry']"));
        Select option = new Select(industrySelect);
        option.selectByVisibleText("Life Sciences");
        Thread.sleep(3000);
        driver.close();
    }

        /* 2. Crear un método llamado defaultxPath
        Ingresar al sitio: https://go.docusign.com/o/trial/
        Completar todos los campos usando el xpath sugerido por el explorador
        */
    @Test
    public void defaultxPath() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input")).sendKeys("Victor");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input")).sendKeys("Brito");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input")).sendKeys("dad@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Job_Title\"]/input")).sendKeys("lawyer");
        Select option=new Select(driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Industry\"]/select")));
        option.selectByVisibleText("Legal");
        Thread.sleep(3000);
        driver.close();
    }
}

