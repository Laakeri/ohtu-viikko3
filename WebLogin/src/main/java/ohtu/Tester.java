package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
    
    private static void tryLogin(WebDriver driver, String username, String password) {
        WebElement element;
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); 
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        Random r = new Random();
        
        sleep(1);
        tryLogin(driver, "pekka", "lol");
        sleep(1);
        tryLogin(driver, "pelle" + r.nextInt(100000), "5ala5ana");
        sleep(1);
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pelle" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("5ala5ana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("5ala5ana");
        element = driver.findElement(By.name("signup"));
        sleep(1);
        element.submit();
        sleep(1);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(1);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
