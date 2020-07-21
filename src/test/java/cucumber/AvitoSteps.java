package cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AvitoSteps {
    WebDriver driver;

    @Before
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
    }

    @ParameterType(".*")
    public Category category(String category) {
        return Category.valueOf(category);
    }

    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(Category category) throws InterruptedException {
        driver.findElement(By.id("category")).click();
        driver.findElement(By.xpath(category.value)).click();
    }

    @И("^в поле поиска введено значение (.*)")
    public void inputPrinter(String request) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("search")).sendKeys(request);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        Thread.sleep(1000);
    }

    @Тогда("^в поле регион введено значение (.*)")
    public void вПолеРегионВведеноЗначениеВладивосток(String city) throws InterruptedException {
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys(city);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
    }


    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        Thread.sleep(1000);
    }

    @Тогда("^открылась страница результаты по запросу (.*)")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер(String name) throws InterruptedException {
        driver.findElement(By.xpath("//h1[@data-marker='page-title/text']")).getText();
        Thread.sleep(1000);
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() throws InterruptedException {
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']/.."));
        if (!checkBox.isSelected()) {
            checkBox.click();
            driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
            Thread.sleep(1000);
        }
    }

    @ParameterType(".*")
    public Prise prise(String prise) {
        return Prise.valueOf(prise);
    }

    @И("в выпадающем списке сортировка выбрано значение {prise}")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(Prise prise) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/select")).click();
        driver.findElement(By.xpath(prise.value)).click();
        Thread.sleep(1000);
    }

    @И("^в консоль выведено значение названия и цены (\\d+) первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныПервыхТоваров(Integer quantity) {
        List<WebElement> printers = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
        for (int i = 0; i < quantity; i++) {
            System.out.println("Принтер №" + (i + 1));
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price ']")).getText());
        }
    }

    @Тогда("закрыть браузер")
    public void закрытьБраузер() {
        driver.quit();
    }
}
