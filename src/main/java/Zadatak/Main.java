package Zadatak;

//Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
// izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),
// kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje da se klikne),
// kliknuti na Električni (mozete hardcodovati).
// Ostati na toj strani kao kraj zadatka.
// Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.

//
//Obratiti paznju na "ad" koji kaze da se registrujete.
// Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

import static org.openqa.selenium.By.*;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tilma\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/");

        driver.manage().window().maximize();

        driver.findElement(By.className("fc-button-label")).click();
        driver.findElement(By.className("kpBoxCloseButton")).click();


        List<WebElement> links = driver.findElements(By.id("category-tree-content-goods"));


        for (int i = 0; i<links.size(); i++) {
            WebElement link = links.get(i);
            System.out.println(link.getText());

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement bicikli = driver.findElement(By.xpath("//*[@id=\"category-tree-content-goods\"]/a[10]"));
        bicikli.click();


        WebElement elektricni = driver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));
        elektricni.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();


    }
}
