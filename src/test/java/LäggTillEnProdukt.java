import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LäggTillEnProdukt extends TestBase{

    @Test
    void produkt(){

            String Kött_Fågel = "https://www.hemkop.se/sortiment/kott-och-fagel?sort=topRated&page=1";
            page.navigate(Kött_Fågel);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

        }

            page.getByText("Nöt & Grönt", new Page.GetByTextOptions()).click();
        page.getByText("Lägg i lista").click();

        Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Logga in privat"));
        assertThat(message).containsText("Logga in privat");

    }
}
