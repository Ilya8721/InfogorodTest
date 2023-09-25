package Page;

import Helper.Screenshot;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private SelenideElement title = $x("//h1[contains(text(), 'ЭКОЛОГИЧЕСКАЯ СИТУАЦИЯ')]");
    private SelenideElement button1 = $x("//table//div[contains(text(), 'Вопрос 1/5')]/following-sibling::div/button");
    private SelenideElement questionTitle2 = $x("//table//div[contains(text(), 'Вопрос 2/5')]");
    private SelenideElement button2 = $x("//table//div[contains(text(), 'Вопрос 2/5')]/following-sibling::div/button");
    private SelenideElement questionTitle3 = $x("//table//div[contains(text(), 'Вопрос 3/5')]");
    private SelenideElement button3 = $x("//table//div[contains(text(), 'Вопрос 3/5')]/following-sibling::div/button");
    private SelenideElement questionTitle4 = $x("//table//div[contains(text(), 'Вопрос 4/5')]");
    private SelenideElement button4 = $x("//table//div[contains(text(), 'Вопрос 4/5')]/following-sibling::div/button");
    private SelenideElement questionTitle5 = $x("//table//div[contains(text(), 'Вопрос 5/5')]");


    private SelenideElement addressField = $x("//table//div[contains(text(), 'Вопрос 1/5')]/following-sibling::div//input");
    private SelenideElement dateField = $x("//table//div[contains(text(), 'Вопрос 3/5')]/following-sibling::div//input[@id='report-date']");
    private SelenideElement timeIntervalsField = $("div.multi-selector-input");

    private SelenideElement addressFromTheList1 = $("li.ui-menu-item:first-child");

    private ElementsCollection smellsCollection = $$x("//table//div[contains(text(), 'Вопрос 2/5')]/following-sibling::div//table//input[@type='radio']");
    private ElementsCollection smellCheckBoxes = $$x("//table//div[contains(text(), 'Вопрос 2/5')]/following-sibling::div//table//span[@class='checkmark']");
    private ElementsCollection datesCollection = $$x("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']");
    private ElementsCollection timeIntervalsCollection = $$x("//div[@class='multi-selector-input']/following-sibling::div//span[@class='checkmark']");
    private ElementsCollection frequencyOfSmellsCheckBoxes = $$x("//table//div[contains(text(), 'Вопрос 4/5')]/following-sibling::div//span[@class='checkmark']");


    public MainPage() {
        Screenshot screenshot = new Screenshot();
        Allure.step("Проверяем заголовок главной страницы", () -> {
            title
                    .shouldBe(visible)
                    .shouldHave(text("ЭКОЛОГИЧЕСКАЯ СИТУАЦИЯ"));
            screenshot.addScreenshotStep("Проверяем заголовок главной страницы");
        });
    }

    public void enteringIntoTheAddressField() {
        addressField.setValue("Москва");
    }

    public void addressFromTheList1() {
        addressFromTheList1.click();
    }

    public void transitionToTheSecondTab() {
        button1.click();
        questionTitle2
                .shouldBe(visible)
                .shouldHave(text("Вопрос 2/5"));
    }

    public List<String> getReversedValues() {
        List<SelenideElement> smellsList = new ArrayList<>(smellsCollection);
        List<String> reversedSmells = new ArrayList<>();

        for (SelenideElement smellElement : smellsList) {
            String smell = smellElement.getAttribute("value");
            String reversedSmell = new StringBuilder(smell).reverse().toString();
            reversedSmells.add(reversedSmell);
        }
        return reversedSmells;
    }

    public void selectingTheFirstSmellCheckbox() {
        smellCheckBoxes.first().click();
    }

    public void transitionToTheThirdTab() {
        button2.click();
        questionTitle3
                .shouldBe(visible)
                .shouldHave(text("Вопрос 3/5"));
    }

    public void selectingTheFirstAvailableDateFromTheCalendar() {
        dateField.click();
        datesCollection.first().click();
    }

    public void selectingTheFirstAvailableTimeInterval() {
        timeIntervalsField.click();
        timeIntervalsCollection.first().click();
    }

    public void transitionToTheFourthTab() {
        button3.click();
        questionTitle4
                .shouldBe(visible)
                .shouldHave(text("Вопрос 4/5"));
    }

    public void selectingFrequencyOfSmellsCheckBoxes() {
        frequencyOfSmellsCheckBoxes.first().click();
    }

    public void transitionToTheFifthTab() {
        button4.click();
        questionTitle5
                .shouldBe(visible)
                .shouldHave(text("Вопрос 5/5"));
    }
}
