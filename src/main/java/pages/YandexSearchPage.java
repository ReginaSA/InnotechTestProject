package pages;

import annotations.UrlPath;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

@UrlPath("https://ya.ru/")
public class YandexSearchPage extends BasePage<YandexSearchPage>{

    private final SelenideElement searchLine = $x("//input[@id='text']");
    private final SelenideElement searchButton = $x("//button[text()='Найти']");
    private final SelenideElement linkToSite = $x("//*[contains(text(), 'Погода в России, прогноз погоды на сегодня')]");

    public YandexSearchPage searchString(String request) {
        searchLine.sendKeys(request);
        searchButton.click();
        return this;
    }

    public GismeteoPage goToSiteFromResult() {
        linkToSite.click();
        return new GismeteoPage();
    }

}