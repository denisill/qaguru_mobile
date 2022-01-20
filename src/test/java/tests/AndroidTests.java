package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Поиск в Wikipedia")
    void searchTest() {
        step("Кликаем в поле поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });

        step("Вводим BrowserStack", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Проверяем наличие контента", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Проверка наличия раздела 'About' в настройках")
    void searchAboutInSettingsTest() {
        step("Открываем меню", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click()
        );

        step("Открываем настройки", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click()
        );

        step("Проверяем наличие 'About'", () -> {
            $(MobileBy.xpath(("//*[@text='About']"))).shouldBe(visible);
        });
    }
}
