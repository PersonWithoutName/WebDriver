import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestAvito {
    private WebDriver driver;

    @BeforeClass
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void testGetTheMostExpensivePrinters() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();

        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();

        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']/.."));
        if (!checkBox.isSelected()) {
            checkBox.click();
            WebElement allAds = driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']"));
            allAds.click();
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/select")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/select/option[3]")).click();

        Thread.sleep(1000);

        List<WebElement> printers = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
        for (int i = 0; i < 3; i++) {
            System.out.println("Принтер №" + (i + 1));
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price ']")).getText());
        }
    }

    @AfterTest
    public void clear() {
        driver.quit();
    }
}
