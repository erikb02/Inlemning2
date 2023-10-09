import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Hover extends TestBase{

    @Test

    void Hover(){

        String handla = "https://www.hemkop.se/handla";

        page.navigate(handla);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

        }

        page.getByText("Start").hover();

        page.getByText("Mina vanligaste varor").hover();

        page.getByText("Höstmat").hover();

        Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Veckans Erbjudanden"));
        assertThat(message).containsText("Veckans Erbjudanden");





    }
}
