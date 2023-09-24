package Helper;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Screenshot {
    public static void addScreenshotStep(String stepName) {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        Allure.addAttachment(stepName, new ByteArrayInputStream(decoded));
    }

}
