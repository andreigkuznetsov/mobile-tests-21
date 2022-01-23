package tests;

import org.junit.jupiter.api.Test;

public class AndroidTests extends TestBase {
    @Test
    void checkContentTest() {

        GettingStartedScreens.firstScreenCheck();

        GettingStartedScreens.addLanguage.setRuLang(GettingStartedScreens.language);

        GettingStartedScreens.openNextScreen()
                        .secondScreenCheck()
                        .openNextScreen()
                        .thirdScreenCheck()
                        .openNextScreen()
                        .fourthScreenCheck();
        GettingStartedScreens.SwitchPrivateDataSend.switchPrivateDataSend(GettingStartedScreens.datasendstatus);

    }

}
