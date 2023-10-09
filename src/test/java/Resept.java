import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static junit.framework.Assert.assertTrue;

public class Resept extends TestBase{

    @Test
    void test() {
        String MainPage = "https://www.hemkop.se/";
        page.navigate(MainPage);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

        }

        page.getByText("Kanelbullar").click();


        Locator checkButton = page.getByRole(AriaRole.CHECKBOX).and(page.getByLabel("Mellanmjölk 1,5%"));
        checkButton.check();
        assertThat(checkButton).isEnabled();
    }
}
