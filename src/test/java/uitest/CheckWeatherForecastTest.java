package uitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YandexSearchPage;

public class CheckWeatherForecastTest {


    @Test
    public void checkWeatherForecastOnGismeteoTest() {
        YandexSearchPage yaPage = new YandexSearchPage();
        Assert.assertTrue(
        yaPage
                .open()
                .searchString("gismeteo")
                .goToSiteFromResult()
                .searchLocation("Россия, Кировская область, Киров (городской округ)")
                .getHeaderPage("Погода в Кирове"), "");
    }
}
