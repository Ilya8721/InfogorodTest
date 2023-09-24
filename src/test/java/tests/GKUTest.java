package tests;

import Helper.Screenshot;
import Page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class GKUTest {
    Screenshot screenshot = new Screenshot();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    @Test
    void mosecomSurvey() {
        Configuration.browserSize = "1920x1080";
        Allure.step("Открываем сайт", () -> {
            open("https://mosecom.mos.ru/");
            screenshot.addScreenshotStep("Открываем сайт");
        });

        MainPage mainPage = new MainPage();

        Allure.step("Вводим в поле адреса", () -> {
            mainPage.enteringIntoTheAddressField();
            screenshot.addScreenshotStep("Вводим в поле адреса");
        });
        Allure.step("Выбираем первый адрес в списке", () -> {
            mainPage.addressFromTheList1();
            screenshot.addScreenshotStep("Выбираем первый адрес в списке");
        });
        Allure.step("Нажимаем ответить", () -> {
            mainPage.transitionToTheSecondTab();
            screenshot.addScreenshotStep("Нажимаем ответить");
        });


        Allure.step("Запахи в обратном порядке", () -> {
            Allure.addAttachment("Запахи в обратном порядке", String.join("\n", mainPage.getReversedValues()));
        });


        Allure.step("Выбираем первый чек-бокс запаха", () -> {
            mainPage.selectingTheFirstSmellCheckbox();
            screenshot.addScreenshotStep("Выбираем первый чек-бокс запаха");
        });
        Allure.step("Нажимаем ответить", () -> {
            mainPage.transitionToTheThirdTab();
            screenshot.addScreenshotStep("Нажимаем ответить");
        });


        Allure.step("Выбираем первую доступную дату из календаря", () -> {
            mainPage.selectingTheFirstAvailableDateFromTheCalendar();
            screenshot.addScreenshotStep("Выбираем первую доступную дату из календаря");
        });
        Allure.step("Выбираем первый доступный интервал", () -> {
            mainPage.selectingTheFirstAvailableTimeInterval();
            screenshot.addScreenshotStep("Выбираем первый доступный интервал");
        });
        Allure.step("Нажимаем ответить", () -> {
            mainPage.transitionToTheFourthTab();
            screenshot.addScreenshotStep("Нажимаем ответить");
        });


        Allure.step("Выбираем первый вариант периодичности", () -> {
            mainPage.selectingFrequencyOfSmellsCheckBoxes();
            screenshot.addScreenshotStep("Выбираем первый вариант периодичности");
        });
        Allure.step("Нажимаем ответить", () -> {
            mainPage.transitionToTheFifthTab();
            screenshot.addScreenshotStep("Нажимаем ответить");
        });
    }
}