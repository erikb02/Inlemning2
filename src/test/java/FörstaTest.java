import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FörstaTest extends TestBase {

    @Test
            void test(){
        String MainPage = "https://www.hemkop.se/";
        page.navigate(MainPage);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

            Locator svgIcon = page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Till sortimentet"));
            svgIcon.click();

            Locator message = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Alltid bra pris"));
            assertThat(message).containsText("Alltid bra pris");

        }



    }





}
