import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Yt extends TestBase{
    @Test
    void Yt(){

        page.navigate("https://www.hemkop.se/");

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        page.getByLabel("Youtube").click();

        Locator Cookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Godkänn alla"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

            Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("videor"));
            assertThat(message).containsText("videor");
        }

    }
}
