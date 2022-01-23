package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import pages.components.AddLanguageComponent;
import pages.components.SwitchPrivateDataSendComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GettingStartedScreens {

    private final String first_screen_text = "The Free Encyclopedia …in over 300 languages",
            second_screen_text = "New ways to explore",
            third_screen_text = "Reading lists with sync",
            fourth_screen_text = "Send anonymous data";

    public final String language = "Russian",
            datasendstatus = "Send usage data OFF";

    private SelenideElement
            primaryTextView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            stepForward = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            switchView = $(MobileBy.id("org.wikipedia.alpha:id/switchView"));

    public AddLanguageComponent addLanguage = new AddLanguageComponent();
    public SwitchPrivateDataSendComponent SwitchPrivateDataSend = new SwitchPrivateDataSendComponent();

    public GettingStartedScreens firstScreenCheck() {
        step("Проверяем, что первый экран содержит контент", () ->
                primaryTextView.shouldHave(text(first_screen_text)));

        return this;
    }

    public GettingStartedScreens openNextScreen() {
        step("Переходим на следующий экран", () ->
                stepForward.click());

        return this;
    }

    public GettingStartedScreens secondScreenCheck() {
        step("Проверяем, что второй экран содержит контент", () ->
                primaryTextView.shouldHave(text(second_screen_text)));

        return this;
    }

    public GettingStartedScreens thirdScreenCheck() {
        step("Проверяем, что третий экран содержит контент", () ->
                primaryTextView.shouldHave(text(third_screen_text)));

        return this;
    }

    public GettingStartedScreens fourthScreenCheck() {
        step("Проверяем, что четвертый экран содержит контент", () ->
                primaryTextView.shouldHave(text(fourth_screen_text)));

        return this;
    }

}
