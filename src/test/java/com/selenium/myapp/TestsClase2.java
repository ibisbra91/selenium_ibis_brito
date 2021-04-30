package com.selenium.myapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestsClase2 {

    /* 1.
    Crear un método de test llamado forgotAccountTest
    Ir a Facebook https://www.facebook.com/
    Validar que el título sea “Facebook - Inicia sesión o regístrate”
    Hacer click en Forgot account?
    Validar que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar sesión |
    Facebook”
    Validar que la url sea diferente a “https://www.facebook.com/”
     */

    @Test
    public void forgotAccountTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Assert.assertEquals(driver.getTitle(), "Facebook - Entrar o registrarse");
        driver.findElement(By.partialLinkText("olvidado")).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "Cambió la URL porque el click guió a una nueva página");
        Thread.sleep(3000);
        driver.close();
    }

    /*2.
    Crear un método de test llamado forgotAccountPartialLinkTest
    Ir a Facebook https://www.facebook.com/
    Hacer click en “¿Olvidaste” utilizando el partialLink
    Agregar un assert que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar
    sesión | Facebook”
    */
    @Test
    public void forgotAccountPartialLinkTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Has olvidado")).click();
        //System.out.print(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "¿Has olvidado la contraseña? | No puedo entrar | Facebook");
        Thread.sleep(3000);
        driver.close();
    }

    /* 3.
    Crear un método de test llamado customSalesforceLink
    Acceder a: https://login.salesforce.com/
    Hacer click en el link “User a Custom Domain”
    Completar el custom domain con “as”
    Hacer click en botón Continue
    Completar el campo de email con “test@test.com”  // cuando lo corro no hay campo email, entonces no puedo automatizar esa última instrucción del ejercicio
    */
    @Test
    public void customSalesforceLink() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.linkText("Utilizar dominio personalizado")).click();
        driver.findElement(By.id("mydomain")).sendKeys("as");
        driver.findElement(By.name("Continue")).click();
        Thread.sleep(5000);
        driver.close();
    }

    /* 4.  Crear un método de test llamado checkBoxAndComboboxTest
    Ir a Facebook https://www.facebook.com/
    Hacer click en “Crear cuenta nueva”
    Completar el nombre con Ibis
    Completar el apellido con Brito
    Setear el combo para seleccionar el sexo en Custom
    Completar la fecha de nacimiento con 4 de abril del 2012.
    Utilizar selectByValue, selectByVisibleText y selectByIndex.

    */
    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Ibis");
        driver.findElement(By.name("lastname")).sendKeys("Brito");


        driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='sex'][@value='-1']")).click();

        WebElement dayComboBox = driver.findElement(By.cssSelector("#day"));
        Select daySelect = new Select(dayComboBox);
        daySelect.selectByIndex(3);

        WebElement monthComboBox = driver.findElement(By.cssSelector("#month"));
        Select monthSelect = new Select(monthComboBox);
        monthSelect.selectByVisibleText("abr");

        WebElement yearComboBox = driver.findElement(By.cssSelector("#year"));
        Select yearSelect = new Select(yearComboBox);
        yearSelect.selectByValue("2012");

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }

    //Nota: El PDF del práctico2, se salta en la numeración de los ejercicios, el número 5.
    //Salta del ejercicio 4 al ejercicio 6.   (Cosas del Orinoco...)  :)

    /*  6. 		Crear un método de test llamado birthdateTest
		Ir a Facebook https://www.facebook.com/
		Setear la fecha de nacimiento para el 12 de diciembre de 1991
    */

    @Test
    public void birthdateTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Ibis");
        driver.findElement(By.name("lastname")).sendKeys("Brito");

        driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='sex'][@value='-1']")).click();

        WebElement dayComboBox = driver.findElement(By.cssSelector("#day"));
        Select daySelect = new Select(dayComboBox);
        daySelect.selectByIndex(12);

        WebElement monthComboBox = driver.findElement(By.cssSelector("#month"));
        Select monthSelect = new Select(monthComboBox);
        monthSelect.selectByVisibleText("dic");

        WebElement yearComboBox = driver.findElement(By.cssSelector("#year"));
        Select yearSelect = new Select(yearComboBox);
        yearSelect.selectByValue("1991");

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }

        /*  7. 		Crear un método de test llamado comboboxTest
        Ir a Facebook https://www.facebook.com/
        Obtener todos los meses disponibles por su nombre
        Validar que la lista no esté vacía
        Seleccionar el elemento de enero, febrero y por último marzo
        Validar que se encuentre el elemento “jun”
        */

    @Test
    public void comboboxTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.partialLinkText("nueva")).click();
        Thread.sleep(1000);

        //Obtener todos los meses disponibles por su nombre
        WebElement selectMonth = driver.findElement(By.name("birthday_month"));
        Select optionsSelectMonths = new Select(selectMonth);
        List<WebElement> optionsMonths = optionsSelectMonths.getOptions();
        Assert.assertNotEquals(0, optionsMonths.size());

        //Seleccionar el elemento de enero
        WebElement eneroElement = driver.findElement(By.cssSelector("#month"));
        Select monthSelect = new Select(eneroElement);
        monthSelect.selectByVisibleText("ene");
        //febrero
        Thread.sleep(1000);
        monthSelect.selectByVisibleText("feb");
        // y por último marzo
        Thread.sleep(1000);
        monthSelect.selectByVisibleText("mar");
        //Validar que se encuentre el elemento “Jun”
        boolean changed = false;
        for (WebElement i : optionsMonths) {
            System.out.println(" ☆☆ Month: " + i.getText() + " ☆☆");
            if (i.getText().contentEquals("jun")) {
                changed = true;
                break;
            }
        }
        Assert.assertTrue(changed);

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }
        /*  8. Crear un método privado llamado setBirthdate
        que reciba como parámetro el driver, el dia, el mes y el año.
         Debe setear la fecha de nacimiento de la persona que está completando el formulario.
         Utilizar el método en la clase completeRegistration
         */

    private void setBirthdate(WebDriver driver, String day, String month, String year) {
        WebElement selectDia = driver.findElement(By.cssSelector("#day"));
        Select dia = new Select(selectDia);
        dia.selectByVisibleText(day);

        WebElement selectMes = driver.findElement(By.xpath("//select[@title='Mes']"));
        Select mes = new Select(selectMes);
        mes.selectByVisibleText(month);

        WebElement selectAnno = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select anno = new Select(selectAnno);
        anno.selectByVisibleText(year);
    }

    @Test
    public void completeRegistration() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.partialLinkText("nueva")).click();
        Thread.sleep(1000);

        //Debe setear la fecha de nacimiento de la persona que está completando el formulario
        setBirthdate(driver,"25","jun","1997");

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }

}


