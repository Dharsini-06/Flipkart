package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.flipkart.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("Iphone 15 pro max");
        q.submit();
        driver.findElement(By.xpath("//div[text()='Apple iPhone 15 Pro Max (White Titanium, 1 TB)']")).click();
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String All : windowHandles)
        {
            if (All!=windowHandle){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println(windowHandles);
    }
}

