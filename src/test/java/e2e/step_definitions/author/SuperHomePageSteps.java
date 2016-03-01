package e2e.step_definitions.author;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import e2e.base.Admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuperHomePageSteps {

    @Then("^SuperHomePage first screen components should displayed correctly$")
    public void checkSuperHomePageComponents() throws Throwable {
        assertTrue(Admin.superHomePage.isSidekickVisible());
        System.out.println("Sidekick is present on the page and visible");

        Admin.superHomePage.switchToCFFrame();

        assertTrue(Admin.superHomePage.getLogoLink().contains("msm-travel-header-logo"));
        System.out.println("\nMain Logo is displayed correctly\n");

        assertTrue(Admin.superHomePage.getWebElementText("heroIF").contains("Welcome to our new home"));
        assertTrue(Admin.superHomePage.getWebElementText("heroIF").contains("Plan your ideal holiday today"));
        System.out.println("\nHero message is displayed correctly\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("searchGadgetIF"));
        System.out.println("\nSearch gadget is present and visible\n");

        assertEquals(Admin.superHomePage.getWebElementText("navigationMenuIF"), "Menu");
        System.out.println("\nNavigation menu is visible\n");

        System.out.println("\nAll data on first screen are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }

    @Then("^SuperHomePage properties should contains Search Gadget tab$")
    public void checkSuperHomePageGadgetProperties() throws Throwable {
        Admin.superHomePage.goToPageProperties();

        Admin.superHomePage.switchToCFFrame();

        assertTrue(Admin.superHomePage.checkPagePropertiesFromSidekick());
        System.out.println("\nSearch gadget redactor is present\n Search Gadget Tab is present\n Generic Search gadget is selected\n");

        System.out.println("\nSearch gadget and properties tabs is OK !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }

    @Then("^SuperHomePage navigation section should works correctly$")
    public void checkSuperHomeNavigationSection() throws Throwable {
        Admin.superHomePage.switchToCFFrame();

        assertTrue(Admin.superHomePage.isWebElementVisible("searchGadgetIF"));
        System.out.println("\nMain screen appears\n");

        Admin.superHomePage.switchToScreen(1);
        assertTrue(Admin.superHomePage.isWebElementVisible("carouselIF"));
        System.out.println("\nSecond screen appears\n");

        Admin.superHomePage.switchToScreen(2);
        assertTrue(Admin.superHomePage.isWebElementVisible("directoryContainerIF"));
        System.out.println("\nThird screen appears\n");

        Admin.superHomePage.switchToScreen(3);
        assertTrue(Admin.superHomePage.isWebElementVisible("superCompaignContainerIF"));
        System.out.println("\nFourth screen appears\n");

        Admin.superHomePage.switchToScreen(0);
        assertTrue(Admin.superHomePage.isWebElementVisible("searchGadgetIF"));
        System.out.println("\nReturned to the Main screen\n");

        System.out.println("\nAll navigation screens are present !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }

    @Then("^SuperHomePage second screen components should displayed correctly$")
    public void checkSecondScreenComponents() throws Throwable {
        Admin.superHomePage.switchToCFFrame();
        Admin.superHomePage.switchToScreen(1);
        System.out.println("\nSwitched to the second screen\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("carouselIF"));

        String carouselTitleText = Admin.superHomePage.getWebElementText("descriptionIC","carouselIF");
        assertTrue(carouselTitleText.contains("Summer 2016"));
        assertTrue(carouselTitleText.contains("You’re one of those people aren’t you?"));
        System.out.println("\nCarousel message is displayed correctly\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("mainLogoIF"));
        System.out.println("\nMain logo is displayed\n");

        String promoText = Admin.superHomePage.getWebElementText("promoCategoryIC","carouselIF");
        assertTrue(promoText.contains("Summer 2016"));
        assertTrue(promoText.contains("City breaks"));
        assertTrue(promoText.contains("All inclusive"));
        assertTrue(promoText.contains("Family holidays"));
        assertTrue(promoText.contains("Flights"));
        assertTrue(promoText.contains("Hotels"));
        assertTrue(promoText.contains("Car hire"));
        System.out.println("\nPromo category section is displayed correctly\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("arrowLeftIC", "carouselIF"));
        assertTrue(Admin.superHomePage.isWebElementVisible("arrowRightIC", "carouselIF"));
        assertTrue(Admin.superHomePage.isWebElementVisible("trackIC", "carouselIF"));
        System.out.println("\nPSlider section is displayed correctly\n");

        System.out.println("\nAll components on the second screen are displayed correctly !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }

    @Then("^SuperHomePage third screen components should displayed correctly$")
    public void checkThirdScreenComponents() throws Throwable {
        Admin.superHomePage.switchToCFFrame();
        Admin.superHomePage.switchToScreen(2);
        System.out.println("\nSwitched to the third screen\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("mainLogoIF"));
        System.out.println("\nMain logo is displayed\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("directoryContainerIF"));
        assertTrue(Admin.superHomePage.isWebElementVisible("destinationSectionIDC", "directoryContainerIF"));
        assertTrue(Admin.superHomePage.isWebElementVisible("directionSignIDC", "directoryContainerIF"));
        assertTrue(Admin.superHomePage.getWebElementText("destinationListLinksIDC",0, "directoryContainerIF").contains("Algarve holidays"));
        assertTrue(Admin.superHomePage.getWebElementAttribute("destinationListLinksIDC", 0, "directoryContainerIF", "href").contains("/en-gb/holidays/portugal/algarve/"));
        System.out.println("\nDestination list is displayed correctly\n");

        System.out.println("\nAll components on the third screen are displayed correctly !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }

    @Then("^SuperHomePage fourth screen components should displayed correctly$")
    public void checkFourthScreenComponents() throws Throwable {
        Admin.superHomePage.switchToCFFrame();
        Admin.superHomePage.switchToScreen(3);
        System.out.println("\nSwitched to the fourth screen\n");

        assertTrue(Admin.superHomePage.isWebElementVisible("mainLogoIF"));
        System.out.println("\nMain logo is displayed\n");

        assertTrue(Admin.superHomePage.getSuperCompaignDialogueTitle().contains("Super Campaign"));
        System.out.println("\nSuper compaign dialogue is displayed correctly\n");

        System.out.println("\nAll components on the fourth screen are displayed correctly !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
    }
}
