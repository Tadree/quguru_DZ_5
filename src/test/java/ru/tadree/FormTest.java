package ru.tadree;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void positiveFillTest () {

        practiceFormPage.openPage();

        //заполнение формы
        practiceFormPage.typeFirstName("Elena")
                .typeLastName("Nikitina")
                .typeEmail("test@test.ru")
                .selectGender("Other")
                .typePhone("0123456789")
                .setDateOfBirth("01","January", "2000")
                .setSubject("Physics")
                .setHobby("Music")
                .uploadPicture("DZ2.png")
                .setCurrentAddress("test")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submit();

        //проверка введенных данных
        practiceFormPage.checkResultsValue("Elena" + " " + "Nikitina");
        $(".table-responsive").shouldHave(text("Elena Nikitina"), text("test@test.ru"),
                text("Other"), text("0123456789"), text("01 January,2000"), text("Physics"),
                text("Music"), text("DZ2.png"), text("test"), text("Uttar Pradesh Agra"));

    }
}
