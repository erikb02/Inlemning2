import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Loggin extends TestBase{


    @Test
    void Login(){

        String loinUrl ="https://www.hemkop.se/anvandare/inloggning";
        page.navigate(loinUrl);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

        }
        //kåden funkar men behöver ett gilitit conto för att låga in och vill inte skriv in mitt parsonliga konto

        page.getByText("Lösenord", new Page.GetByTextOptions()).click();

        page.getByLabel("Person- eller medlemsnummer").fill("TBA");

        page.getByLabel("Lösenord").fill("TBA");

        Locator svgIcon = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Logga in"));
        svgIcon.click();

        Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Logga in privat"));
        assertThat(message).containsText("Logga in privat");

    }
}
