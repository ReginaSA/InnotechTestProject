package pages;

import annotations.UrlPath;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@UrlPath("https://www.gismeteo.ru/")
public class GismeteoPage extends BasePage<GismeteoPage>{

    private final SelenideElement searchLine = $x("//input[@type='search']");
    private final SelenideElement pageHeader = $x("//div[@class='page-title']");

    @Step("Ищем локацию {location} в строке поиска")
    public GismeteoPage searchLocation(String location) {
        searchLine.sendKeys(location);
        $(By.xpath("//div[contains(@class, 'city') and normalize-space(text())='" + location + "']")).click();
        return this;
    }

    @Step("Берем текст заголовка страницы")
    public String getHeaderPage() {
        return  pageHeader.getText();
    }

}
