import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Leverans extends TestBase{

    @Test
    void Leverans(){

        page.navigate("https://www.hemkop.se/");

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }

        page.getByLabel("openDeliveryModal").click();
        page.getByText("Hemleverans").click();
        page.getByLabel("Adress*").fill("Tomtebodavägen 3A 17165 Solna");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");

        page.getByText("Bekräfta").click();

        Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Boka tid för leverans"));
        assertThat(message).containsText("Boka tid för leverans");



    }
}
