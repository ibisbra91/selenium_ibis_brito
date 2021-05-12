package com.selenium.myapp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class registrationFacebookTest {

            /*  9. ************************* Ejercicio GIT **************************

            Crear una nueva branch llamada prácticoSelenium y subir una clase llamada
            registrationFacebookTest, con el siguiente ejercicio:
            Crear un método de test llamado fullRegistrationTest
            Ir a Facebook https://www.facebook.com/
            Completar los campos de registro con los siguientes valores:
            First Name: “John”
            Last Name: “Smith”
            Mobile: “5555555”
            New Password: “123456789”
            Birthday: Jun 26 1980
            Gender: Male
            */

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.partialLinkText("nueva")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("5555555");
        driver.findElement(By.cssSelector("#password_step_input")).sendKeys("123456789");

        WebElement dayComboBox = driver.findElement(By.cssSelector("#day"));
        Select daySelect = new Select(dayComboBox);
        daySelect.selectByValue("26");
        WebElement monthComboBox = driver.findElement(By.cssSelector("#month"));
        Select monthSelect = new Select(monthComboBox);
        monthSelect.selectByVisibleText("jun");
        WebElement yearComboBox = driver.findElement(By.cssSelector("#year"));
        Select yearSelect = new Select(yearComboBox);
        yearSelect.selectByValue("1998");

        driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).click();

       // driver.findElement(By.xpath("//button[@type='submit'][@name='websubmit']")).click();

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }
}
