package uitest;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YandexSearchPage;

public class CheckWeatherForecastTest {


    @Test
    @Description("Тест выполняет  поиск и переход на сайт gismeteo" +
            "и переходит на страницу прогноза погоды по заданному городу ")
    public void checkWeatherForecastOnGismeteoTest() {
        YandexSearchPage yaPage = new YandexSearchPage();

        String headerFromGisPage = yaPage
                .open()
                .getRequestInSearchLine("gismeteo")
                .goToSiteFromResult("gismeteo.ru")
                .searchLocation("Россия, Кировская область, Киров (городской округ)")
                .getHeaderPage();

        Assert.assertEquals(headerFromGisPage, "Погода в Кирове сегодня",
                "Скорее всего мы находимся не на той странице, актуальный заголовок: " + headerFromGisPage);
    }
}
