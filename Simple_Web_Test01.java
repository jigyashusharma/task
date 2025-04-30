package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class Simple_Web_Test01 {

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();

        // Implicit wait applied to all element searches
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.intervue.io/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a[@id='products']//span[contains(text(),'Products')]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='solutions']//span[contains(text(),'Solutions')]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='iv-homepage-navbar-tabs']//span[normalize-space()='Pricing']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='resources']//span[contains(text(),'Resources')]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='contact-us']//span[contains(text(),'Contact us')]"))).perform();

        driver.findElement(By.xpath("//div[@id='iv-homepage-login']//div//span[contains(text(),'Login')]")).click();

        // Switch to new tab (access account)
        Set<String> handleValues = driver.getWindowHandles();
        for (String hv : handleValues) {
            driver.switchTo().window(hv);
            String url = driver.getCurrentUrl();
            if (url.equalsIgnoreCase("https://www.intervue.io/access-account")) {
                break;
            }
        }

        driver.findElement(By.xpath("//a[@href='/login']//div[contains(text(),'Login')]")).click();

        // Zoom out using Robot
        Robot robot = new Robot();
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000); // Short sleep for keypress effect
        }

        driver.findElement(By.name("email")).sendKeys("neha@intervue.io");
        driver.findElement(By.id("login_password")).sendKeys("Ps@neha@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Explicit wait for search icon after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='search_placeholder']")));
             JavascriptExecutor js=(JavascriptExecutor)driver;
              js.executeScript("arguments[0].click();", searchIcon); 
             Thread.sleep(8000);
        driver.findElement(By.xpath("//input[@class='SearchBox__StyledInput-ctnsh0-4 lhwsuL']")).sendKeys("hello");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='SearchThrough__PlaceholderText-sc-8f4vh4-0 fEvpzS']")).click();

        driver.findElement(By.xpath("//div[@class='ant-dropdown-link ProfileHeader__StyedDropdownHoverLink-sc-1gwp6c1-3 cwhrSp']//i[@class='anticon']//*[name()='svg']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Billing']"))).perform();
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Teams']"))).perform();
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Integrations']"))).perform();
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Settings']"))).perform();

        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        driver.quit();
    }
}

