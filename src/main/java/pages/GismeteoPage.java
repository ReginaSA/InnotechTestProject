package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GismeteoPage extends BasePage<GismeteoPage>{

    private final SelenideElement searchLine = $x("//input[@type='search']");

    public GismeteoPage searchLocation(String location) {
        searchLine.sendKeys(location);
        $(By.xpath("//div[contains(@class, 'city') and normalize-space(text())='" + location + "']")).click();
        return this;
    }

    public boolean getHeaderPage(String headerValue) {
        String textHeader = $(By.xpath("//h1")).getText();
        return textHeader.contains(headerValue);
    }

}
