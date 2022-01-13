package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryTest {

    @Test
    public <gradlew> void shouldSendForm() {
        Configuration.holdBrowserOpen = true; Configuration.headless = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").val("Омск");
        $("div[class='popup__content'] span").click();
        $("[data-test-id='name'] input").val("Иван Петров");
        $(byName("phone")).setValue("+79054711111");
        $(byClassName("checkbox__box")).click();
        $(withText("Забронировать")).click();
        $("[data-test-id='notification']").shouldHave(text("Успешно!"), Duration.ofSeconds(15));
    }
}
