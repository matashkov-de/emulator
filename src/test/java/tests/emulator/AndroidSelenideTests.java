package tests.emulator;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends AndroidTestBase
{

        @Test
        void searchTest() {
            step("Skip first screen", () ->
                    $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());

            step("Type search", () -> {
                $(AppiumBy.accessibilityId("Search Wikipedia")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
            });
            step("Verify content found", () ->
                    $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
        }
    }
