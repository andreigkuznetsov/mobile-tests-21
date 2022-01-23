package tests;

import org.junit.jupiter.api.Test;

public class AndroidTests extends TestBase {
    @Test
    void checkContentTest() {

        GettingStartedScreens.firstScreenCheck();

        GettingStartedScreens.addLanguage.setRuLang(TestData.LANGUAGE);

        GettingStartedScreens.openNextScreen()
                        .secondScreenCheck()
                        .openNextScreen()
                        .thirdScreenCheck()
                        .openNextScreen()
                        .fourthScreenCheck();
        GettingStartedScreens.SwitchPrivateDataSend.switchPrivateDataSend(TestData.DATASENDSTATUS);

    }

}
