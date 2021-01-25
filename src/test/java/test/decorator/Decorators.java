package test.decorator;

import decorator.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    public static void shouldDisplay(List<WebElement> elements){
        elements.forEach(el -> Assert.assertTrue(el.isDisplayed()));
    }

    public static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(el -> Assert.assertFalse(el.isDisplayed()));
    }

    private static final Consumer<DashboardPage> isAdminPresent = (dp) -> shouldDisplay(dp.getAdminComponent());
    private static final Consumer<DashboardPage> isAdminHidden = (dp) -> shouldNotDisplay(dp.getAdminComponent());
    private static final Consumer<DashboardPage> isSuperUserPresent = (dp) -> shouldDisplay(dp.getSuperUserComponent());
    private static final Consumer<DashboardPage> isSuperUserHidden = (dp) -> shouldNotDisplay(dp.getSuperUserComponent());
    private static final Consumer<DashboardPage> isGuestPresent = (dp) -> shouldDisplay(dp.getGuestComponent());
    private static final Consumer<DashboardPage> isGuestHidden = (dp) -> shouldNotDisplay(dp.getGuestComponent());

    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> superUserSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(isGuestPresent).andThen(isSuperUserHidden)
            .andThen(isAdminHidden);
    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(isGuestPresent).andThen(isSuperUserPresent)
            .andThen(isAdminHidden);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(isGuestPresent).andThen(isSuperUserPresent)
            .andThen(isAdminPresent);

}
