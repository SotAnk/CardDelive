package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {
    String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    @Test
            public void shouldSuccessfulFormSubmission () {
            open("http://localhost:9999");
            $("[data-test-id=city] input").setValue("Омск");
            $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
            String verificationDate = LocalDate.now().plusDays(4)
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            $("[data-test-id=date] input").setValue(verificationDate);
            $("[data-test-id=name] input").setValue("Иван Петров");
            $("[data-test-id=phone] input").setValue("+79012345678");
            $("[data-test-id=agreement]").click();
            $(".button").shouldHave(Condition.text("Забронировать")).click();
            $("[data-test-id=notification]")
                    .shouldHave(Condition.text("Успешно! Встреча успешно забронирована на " + verificationDate),
                            Duration.ofSeconds(15));
        }
    }