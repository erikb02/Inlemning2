import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Sök extends TestBase {

    @Test
            void Sök(){
        String MainPage = "https://www.hemkop.se/";
        page.navigate(MainPage);

        Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Acceptera alla cookies"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();

        }

        page.getByRole(AriaRole.TEXTBOX).fill("pepsi");

        Locator svgIcon = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Sök"));
        svgIcon.click();

        Locator searchResult = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Sökresultat"));

        assertThat(searchResult).hasText("Sökresultat");

    }



}
