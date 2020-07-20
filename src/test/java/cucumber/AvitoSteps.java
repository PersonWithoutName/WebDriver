package cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }
    @ParameterType(".*")
    public Category category(String category) {
        return Category.valueOf(category);
    }
    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(Category category) {
        driver.findElement(By.id("category")).click();
        driver.findElement(By.xpath(category.value)).click();
    }

    @И("в поле поиска введено значение принтер")
    public void вПолеПоискаВведеноЗначениеПринтер() {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() {

    }

    @Тогда("в поле регион введено значение Владивосток")
    public void вПолеРегионВведеноЗначениеВладивосток() {

    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {

    }

    @Тогда("открылась страница результаты по запросу принтер")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер() {

    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() {

    }

    @И("в выпадающем списке сортировка выбрано значение Дороже")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже() {

    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныПервыхТоваров(int arg0) {
    }
}
