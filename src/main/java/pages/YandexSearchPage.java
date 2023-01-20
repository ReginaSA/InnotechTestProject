package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@UrlPath("https://ya.ru/")
public class YandexSearchPage extends BasePage<YandexSearchPage>{

    private final SelenideElement searchLine = $x("//input[@id='text']");
    private final SelenideElement searchButton = $x("//button[text()='Найти']");

    @Step("Вводим запрос {request} в поисковой строке и нажимаем Найти")
    public YandexSearchPage getRequestInSearchLine(String request) {
        searchLine.sendKeys(request);
        searchButton.click();
        return this;
    }

    @Step("Ищем ссылку для перехода на сайт gismeteo")
    public GismeteoPage goToSiteFromResult(String value) {
        $(By.xpath("//b[contains(text(), '" + value + "')]")).click();
        switchTo().window(1);
        return new GismeteoPage();
    }
}