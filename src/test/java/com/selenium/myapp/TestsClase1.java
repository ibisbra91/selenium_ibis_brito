package com.selenium.myapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;


public class TestsClase1 {

    //1. Crear un método que abra el browser y muestre el explorador de google con chrome
    @Test
    public void getGoogle() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

    }

    // 2. Crear un método llamado mostrarTituloTest, que muestre el título del sitio web
    @Test
    public void mostrarTituloTest() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/browse");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

    /* ejercicio 3.
     Crear un método llamado bbcMundTest
     Ingresar al sitio https://www.bbc.com/mundo
     Mostrar la cantidad de <h1>
     Imprimir títulos h1
     Mostrar la cantidad de <h2>
     Imprimir títulos h2
 */
    @Test
    public void bbcMundTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        System.out.println("*** Contando etiquetas H1 *** ");
        List<WebElement> lista_H1 = driver.findElements(By.tagName("h1"));
        //driver.close();

        System.out.println("\t");
        System.out.println("Hay " + lista_H1.size() + " título(s) H1 en la página");
        System.out.println(lista_H1);
        System.out.println("\t");

        System.out.print(" *** Contando etiquetas H2 *** ");
        System.out.println("\t");

        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));
        System.out.println("\t");
        System.out.print("Hay" + listaH2.size() + " H2 en la página");
        System.out.println("\t");
        System.out.print(listaH2);
        System.out.println("\t");
        System.out.println("\t");
        System.out.print(" *** It's Done! *** ");
        System.out.println("\t");
    }

    /* 4.
    Crear un método llamado bbcMundoLinks
    Ingresar al sitio https://www.bbc.com/mundo
    Mostrar el texto de cada link uno a uno
    * */
    @Test
    public void bbcMundoLinks() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        System.out.println("\t");
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("*** Mostrando la lista de links de Facebook actualmente *** ");

        for (WebElement i : linksList) {
            System.out.println("\t");
            System.out.print("Links list: " + i.getText());

        }
        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");

    }

    /* 5.
    * Crear un método llamado bbcMundoListas
     Ingresar al sitio https://www.bbc.com/mundo
     Mostrar todos los elementos li y su texto
    * */
    @Test
    private void bbcMundoListas() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");


        List<WebElement> liList = driver.findElements(By.tagName("li"));
        System.out.println("\t");
        System.out.print(" *** Mostrando todos los elementos li existentes en la página *** ");
        System.out.println("\t");
        System.out.println(liList);

        System.out.println("\t");
        System.out.print(" *** Mostrando los elementos li con el texto de cada uno*** ");
        System.out.println("\t");
        for (WebElement j : liList) {
            System.out.println("\t");
            System.out.print("<li> element: " + j.getText());
            System.out.println("\t");

        }
        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }

   /* 6. Crear un método llamado spotifyTitleTest
    Debe inicializar https://www.spotify.com
    Validar que el título del sitio sea XXXXXXX (ver PDF de clase1)
    Si lo es, debe indicar “Test
    Passed!!” sino, debe mostrar “Test failed” */

    @Test
    private void spotifyTitleTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com");

        String title = "Escuchar es todo - Spotify.";
        if (title.equals(driver.getTitle())) {
            System.out.println("\t");
            System.out.print(" * Test passed !!! * ");
            System.out.println("\t");
        } else {
            System.out.println("\t");
            System.out.print(" * The title is different from the specified title * :(  ");
            System.out.println("\t");
            System.out.print(" * The specified title is: " + title + " but the real title of this page is: " + driver.getTitle()+" *");
        }
        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }
    /* 7. Crear un método llamado getWindowsSizeTest
    Abrir el explorador con google.com
    Obtener y mostrar el ancho y alto de la página
    Setear un nuevo tamaño de pantalla 1024x768
    */

    @Test
    private void getWindowsSizeTest() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        //Obtener y mostrar el ancho y alto de la página
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int heigth = size.getHeight();
        System.out.println("El width inicial de la página es: " + width);
        System.out.println("El heigth inicial de la página es: " + heigth);
        System.out.println("****");
        System.out.println("\t");

        // Setear un nuevo tamaño de pantalla 1024x768
        Dimension dimension = new Dimension(1024, 768);
        driver.manage().window().setSize(dimension);
        size = driver.manage().window().getSize();

        width = size.getWidth();
        heigth = size.getHeight();
        System.out.println("El nuevo width de la página es: " + width);
        System.out.println("El nuevo heigth de la página es: " + heigth);

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");

    }

    /* 8 Crear un método llamado getGoogleDriver que inicialice un sitio web www.google.com.
         Debe retornar un objeto de tipo Webdriver
    */
    private WebDriver getGoogleDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        return driver;
    }


    /* 9 Crear un método llamado getDriver que inicialice un sitio web que recibe por parámetro.
         Debe retornar un objeto de tipo Webdriver
    */
    @Test
    private WebDriver getDriver(String sitio) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(sitio);

        return driver;
    }

    /* 10 Crear un método llamado searchInGoogle . Acceder a google.com
       Ingresar en el buscador la palabra “WebElement” y presionar enter
    */
    @Test
    private void searchInGoogle() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("WebElement" + ENTER);

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }

    /* 11 Crear un método llamado searchInGoogleAndGoBack
          Acceder a google.com
          Imprimir el título del sitio
          Buscar: WebElement y presionar ENTER
          Volver atras
          Refrescar la página
          Ir hacia adelante
    */
    @Test
    private void searchInGoogleAndGoBack() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("\t");
        System.out.print("El título del sitio es: " + driver.getTitle());
        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");

        driver.findElement(By.name("q")).sendKeys("WebElement" + ENTER);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }


    /* 12 Crear un método llamado facebookPageTest
          Abrir un navegador con facebook: https://www.facebook.com/
          Mostrar la cantidad de div que existen (utilizando tagname)
          Mostrar el texto de todos los tipos a (hipervínculos)
          Mostrar la cantidad de botones que tiene la página
          Mostrar los textos de los botones que se encuentran en la página
    */
    @Test
    private void facebookPageTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        int cant = 0;
        List<WebElement> divList = driver.findElements(By.tagName("div"));
        cant = divList.size();
        System.out.println("\t");
        System.out.println("Hay " + cant + " etiquetas <div> en la página " + driver.getCurrentUrl());
        System.out.println("\t");

        System.out.println(" *** Mostrando el texto no vacío de cada etiqueta <a> en la página " + driver.getCurrentUrl() + " *** ");
        List<WebElement> aTexts = driver.findElements(By.tagName("a"));


        for (WebElement i : aTexts) {
            if (!i.getText().isEmpty()) {
                System.out.println(" Enlace: " + i.getText());
            }

        }

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println("\t");
        System.out.println("Hay " + buttonList.size() + " boton(es) en la página " + driver.getCurrentUrl());
        System.out.println("\t");

        for (WebElement i : buttonList) {
            System.out.println(" Texto de Botón: " + i.getText());
        }
        /* cacharreando fuera del ejercicio, dentro de él :)
        List<WebElement> lista = driver.findElements(By.xpath("//*[@id=\"u_0_2_pp\"][@role='button']"));
        for (WebElement i : lista) {
            System.out.println(i);
        }*/

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");

    }

    /* 13 Crear un método de test llamado sendKeysToFacebook
          Ir a Facebook https://www.facebook.com/
          Completar el email y contraseña con los datos: test@test.com y holamundo respectivamente
          Hacer click en login */

    @Test
    private void sendKeysToFacebook() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("holamundo");
        driver.findElement(By.linkText("Entrar")).click();

        Thread.sleep(3000);
        driver.close();

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");

    }

        /* 14 Crear un método con un nombre a seleccionar
              Acceder a Netflix: https://www.netflix.com/uy/
              Mostrar los elementos h1 y h2 que hay en el sitio
              Refrescar la página
              Mostrar el texto de los botones que se encuentran en la página
              Mostrar la cantidad de elementos div que contiene el sitio
              Obtener y mostrar el título de la página
              Mostrar la cantidad de elementos de tipos link */

    @Test
    private void ejercicioNetflx() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");

        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        System.out.println("\t");
        System.out.println(" ☆☆☆ Mostrando elementos <h1> de la página: " + driver.getCurrentUrl() + " ☆☆☆ ");
        for (WebElement i : h1List) {
            System.out.println("Elemento <h1>: " + i);
        }
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        System.out.println("\t");
        System.out.println(" ☆☆☆ Mostrando elementos <h2> de la página: " + driver.getCurrentUrl() + " ☆☆☆ ");
        for (WebElement i : h2List) {
            System.out.println("Elemento <h2>: " + i.getText());
        }
        driver.navigate().refresh();

        //Mostrar el texto de los botones que se encuentran en la página
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println("\t");
        System.out.println(" ☆☆☆ Mostrando el texto de los botones de la página: " + driver.getCurrentUrl() + " ☆☆☆ ");
        for (WebElement i : buttonList) {
            System.out.println("Botón: " + i.getText());
        }

        //Mostrar la cantidad de elementos div que contiene el sitio
        List<WebElement> cantDiv = driver.findElements(By.tagName("div"));
        System.out.println("\t");
        System.out.print(" ☆☆☆ El sitio contiene: " + cantDiv.size() + " elementos <div> ☆☆☆ ");
        System.out.println("\t");
        //Obtener y mostrar el título de la página
        System.out.println(" ☆☆☆ La URL del sitio es: " + driver.getCurrentUrl() + " ☆☆☆ ");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.netflix.com/uy/");

        // Mostrar la cantidad de elementos de tipos link
        List<WebElement> elemLinks = driver.findElements(By.tagName("a"));
        System.out.println("\t");
        System.out.println(" ☆☆☆ Mostrando los links no vacíos en la página ☆☆☆ ");
        for (WebElement i : elemLinks) {
            if (i.getText().isEmpty() == false) {
                System.out.println("Elemento <a>: " + i.getText());
            }

        }

        Thread.sleep(2000);
        driver.close();

        System.out.println("\t");
        System.out.print(" ☆☆☆ It's Done! ☆☆☆ ");
        System.out.println("\t");
    }
}











