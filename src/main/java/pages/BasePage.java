package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public abstract class BasePage<T>{
        private String getUrlPath() {
        UrlPath urlPath = getClass().getAnnotation(UrlPath.class);
        if(urlPath != null) {
            return urlPath.value();
        }

        return "";
    }

    @Step
    public T open() {
        Selenide.open(getUrlPath());

        return (T)this;
    }
}
