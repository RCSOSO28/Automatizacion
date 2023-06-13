import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.Normalizer;
import java.util.concurrent.TimeUnit;

public class PruebaTest {

    public WebDriver driver;

    @Test
    public void hacer_una_busqueda(){
        //configuramos el driver
        WebDriverManager.firefoxdriver().setup();

        //instanciamos el driver
        driver = new FirefoxDriver();

        //colocamos la pantalla en maximize
        driver.manage().window().maximize();

        //definimos un tiempo de espera
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //abrimos una url
        driver.get("https://www.google.com/");

        //encontrar e interactuar con los elementos
        //ingresar el texto en el buscador
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Cuantos paises tiene america saber es practico");

        //presinar la tecla enter
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);

        //hacer click sobre el link deseado
        driver.findElement(By.xpath("//h3[contains(text(),'capitales')]")).click();

        //creamos un elemento web para poder hacer acciones avanzadas
        WebElement subtitulo = driver.findElement(By.id("listado"));

        //verificamos que la cantidad de países en America siga siendo 35
        Assertions.assertTrue(subtitulo.getText().contains("35"));
    }

    @Test
    public void hacer_otra_prueba(){
        //configuramos el driver
        WebDriverManager.firefoxdriver().setup();

        //instanciamos el driver
        driver = new FirefoxDriver();

        //colocamos la pantalla en maximize
        driver.manage().window().maximize();

        //definimos un tiempo de espera
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //abrimos una url
        driver.get("https://www.google.com/");

        //encontrar e interactuar con los elementos
        //ingresar el texto en el buscador
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Cuantos paises tiene america saber es practico");

        //presinar la tecla enter
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);

        String text = "Países y capitales de América - Saber es práctico";
        String string = Normalizer.normalize(text, Normalizer.Form.NFD);

        String normalString = string.replaceAll("[^\\p{ASCII}]", "");
        System.out.println(normalString);

        /*
        //hacer click sobre el link deseado
        driver.findElement(By.xpath("//h3[contains(text(),'capitales')]")).click();

        //creamos un elemento web para poder hacer acciones avanzadas
        WebElement subtitulo = driver.findElement(By.id("listado"));

        //verificamos que la cantidad de países en America siga siendo 35
        Assertions.assertTrue(subtitulo.getText().contains("35"));

         */
    }
}
