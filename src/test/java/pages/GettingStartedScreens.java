package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import pages.components.AddLanguageComponent;
import pages.components.SwitchPrivateDataSendComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GettingStartedScreens {

    private final String FIRST_SCREEN_TEXT = "The Free Encyclopedia …in over 300 languages",
            SECOND_SCREEN_TEXT = "New ways to explore",
            THIRD_SCREEN_TEXT = "Reading lists with sync",
            FOURTH_SCREEN_TEXT = "Send anonymous data";

    public final String LANGUAGE = "Russian",
            DATASENDSTATUS = "Send usage data OFF";

    private SelenideElement
            primaryTextView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            stepForward = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            switchView = $(MobileBy.id("org.wikipedia.alpha:id/switchView"));

    public AddLanguageComponent addLanguage = new AddLanguageComponent();
    public SwitchPrivateDataSendComponent SwitchPrivateDataSend = new SwitchPrivateDataSendComponent();

    public GettingStartedScreens firstScreenCheck() {
        step("Проверяем, что первый экран содержит контент", () ->
                primaryTextView.shouldHave(text(FIRST_SCREEN_TEXT)));

        return this;
    }

    public GettingStartedScreens openNextScreen() {
        step("Переходим на следующий экран", () ->
                stepForward.click());

        return this;
    }

    public GettingStartedScreens secondScreenCheck() {
        step("Проверяем, что второй экран содержит контент", () ->
                primaryTextView.shouldHave(text(SECOND_SCREEN_TEXT)));

        return this;
    }

    public GettingStartedScreens thirdScreenCheck() {
        step("Проверяем, что третий экран содержит контент", () ->
                primaryTextView.shouldHave(text(THIRD_SCREEN_TEXT)));

        return this;
    }

    public GettingStartedScreens fourthScreenCheck() {
        step("Проверяем, что четвертый экран содержит контент", () ->
                primaryTextView.shouldHave(text(FOURTH_SCREEN_TEXT)));

        return this;
    }

}
