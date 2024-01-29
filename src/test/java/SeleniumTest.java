import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    public static WebDriver driver;

    @BeforeTest
    void Setup(){

        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

    }

    @Test
    void testSteps(){

        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu\"]/a[2]/li")));
        signIn.click();

        driver.findElement(By.id("usr")).sendKeys("Test");
        driver.findElement(By.id("pwd")).sendKeys("test");

        driver.findElement(By.cssSelector(".btn.btn-info")).click();

        WebDriverWait waitAgain = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement formalShoes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ShoeType")));

        String actualText = formalShoes.getText();
        String expectedText = "Formal Shoes";

        Assert.assertEquals(actualText,expectedText);

        driver.quit();



    }
}
