package e2e.step_definitions.publish;


import cucumber.api.java.en.Then;
import e2e.Browser;
import e2e.base.Admin;

import static org.junit.Assert.assertEquals;
import static e2e.support.TestConstants.*;
import static org.junit.Assert.assertTrue;

public class PublishCustomPageSteps {

    @Then("^Publish custom page should contains correct directory containers$")
    public void isPublishCustomPageDirectoryContainersCorrect() throws Throwable {
        assertEquals(SEO_DIR_CONT_TITLE, Admin.publishCustomPage.getSEODirContHeader());
        assertEquals(DEST_LIST_ITEM_DISPLAYED_TITLE, Admin.publishCustomPage.getSEODirContLinkText());
        assertTrue(Admin.publishCustomPage.getSEODirContLinkUri()+"' not contains '"+URI_FOR_CHECK,Admin.publishCustomPage.getSEODirContLinkUri().contains(URI_FOR_CHECK));
        System.out.println("\nSEO directory container data is correct\n");

        assertEquals(MERCH_DIR_CONT_TITLE, Admin.publishCustomPage.getMerchDirContHeader());
        assertTrue(Admin.publishCustomPage.getMerchDirContImageSrc()+"' not contains '"+DIR_LIST_ITEM_LOGO,Admin.publishCustomPage.getMerchDirContImageSrc().contains(DIR_LIST_ITEM_LOGO));
        assertTrue(Admin.publishCustomPage.getMerchDirContLinkUri()+"' not contains '"+URI_FOR_CHECK,Admin.publishCustomPage.getMerchDirContLinkUri().contains(URI_FOR_CHECK));
        assertEquals(DIR_LIST_ITEM_BODY_TITLE, Admin.publishCustomPage.getMerchDirContBodyTitle());
        assertEquals(DIR_LIST_ITEM_BODY_CONTENT, Admin.publishCustomPage.getMerchDirContBodyText());
        System.out.println("\nMerchandising directory container data is correct\n");

        System.out.println("\nAll data is correct!\n");
    }

    @Then("^Publish custom page should contains correct text content$")
    public void isPublishCustomPageTextCorrect() throws Throwable {
        assertEquals(HOME_TITLE, Admin.publishCustomPage.getStaticText(0));
        assertEquals(CONTENT_TEXT, Admin.publishCustomPage.getStaticText(1));
        System.out.println("\nStatic text is correct\n");

        assertTrue(Admin.publishCustomPage.getLogoSrc()+"' not contains '"+PROVIDER_HOLIDAY_LOGO,Admin.publishCustomPage.getLogoSrc().contains(PROVIDER_HOLIDAY_LOGO));
        System.out.println("\nLogo is correct\n");

        assertEquals(Admin.publishCustomPage.getConcertinaItemTitle(), CONCERTINA_ITEM_TITLE);
        assertEquals(Admin.publishCustomPage.getConcertinaItemSubTitle(), CONCERTINA_ITEM_SUB_TITLE);
        assertEquals(Admin.publishCustomPage.getConcertinaItemText(),CONCERTINA_ITEM_BODY_TEXT);
        System.out.println("\nConcertina data is correct\n");

        assertEquals(Admin.publishCustomPage.getRichText(), RICH_BODY_TEXT);
        System.out.println("\nRich text is correct\n");

        assertEquals(Admin.publishCustomPage.getTickListText(), TICK_ITEM);
        System.out.println("\nTick List is correct\n");

        System.out.println("\nAll data is correct!\n");
    }

    @Then("^Publish custom page should contains correct Page Items$")
    public void isPublishCustomPagePageItemsCorrect() throws Throwable {
        assertTrue(Admin.publishCustomPage.getBreadcrumbLogoItemLink()+"' not contains '"+Browser.options.homePageName,Admin.publishCustomPage.getBreadcrumbLogoItemLink().contains(Browser.options.homePageName));
        assertEquals(Admin.publishCustomPage.getBreadcrumbFirstItemText(), "GB Home");
        assertTrue(Admin.publishCustomPage.getBreadcrumbFirstItemLink()+"' not contains 'en-gb'",Admin.publishCustomPage.getBreadcrumbFirstItemLink().contains("en-gb"));
        assertEquals(Admin.publishCustomPage.getBreadcrumbSecondItemText(), Browser.options.homePageTitle);
        assertTrue(Admin.publishCustomPage.getBreadcrumbSecondItemLink()+"' not contains '"+Browser.options.homePageName,Admin.publishCustomPage.getBreadcrumbSecondItemLink().contains(Browser.options.homePageName));
        System.out.println("\nBreadcrumb data is correct\n");

        assertEquals(Admin.publishCustomPage.getDisclaimerText(), PAGE_DISCLAIMBER_TEXT);
        System.out.println("\nDisclaimer text is correct\n");

//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(1), "Legal");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(1).contains("legal.html"));
//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(2), "Contact Us");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(2).contains("contactus"));
//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(3), "Privacy");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(3).contains("privacypolicy"));
//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(4), "Terms & Conditions");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(4).contains("terms"));
//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(5), "Security");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(5).contains("security"));
//        assertEquals(Admin.publishCustomPage.getFooterNavigationLinkText(6), "Cookie");
//        assertTrue(Admin.publishCustomPage.getFooterNavigationLink(6).contains("cookie-policy"));
//        System.out.println("All footer links are correct");

        System.out.println("\nAll data is correct !!!!!!!\n");
    }

    @Then("^Publish custom page should contains correct auxiliary content$")
    public void isPublishCustomPageAuxiliaryCorrect() throws Throwable {
        assertEquals(AUXILIARY_NAVIGATION_TITLE, Admin.publishCustomPage.getNavigationTopicListTitleText());
        assertTrue(Admin.publishCustomPage.getNavigationTopicListTitleLink()+"' not contains 'superhomepage",Admin.publishCustomPage.getNavigationTopicListTitleLink().contains("superhomepage"));
        assertEquals(AUXILIARY_NAVIGATION_FIRST_ITEM, Admin.publishCustomPage.getNavigationTopicListItemText());
        assertTrue(Admin.publishCustomPage.getNavigationTopicListItemLink()+"' not contains 'superhomepage",Admin.publishCustomPage.getNavigationTopicListItemLink().contains("superhomepage"));
        System.out.println("\nNavigation Topic List data is correct\n");

        assertEquals(AUXILIARY_SITEMAP_TITLE, Admin.publishCustomPage.getSitemapTopicListTitleText());
        assertTrue(Admin.publishCustomPage.getSitemapTopicListTitleLink()+"' not contains 'superhomepage",Admin.publishCustomPage.getSitemapTopicListTitleLink().contains("superhomepage"));
        assertEquals(AUXILIARY_SITEMAP_FIRST_ITEM, Admin.publishCustomPage.getSitemapTopicListItemText());
        assertTrue(Admin.publishCustomPage.getSitemapTopicListItemLink()+"' not contains 'superhomepage",Admin.publishCustomPage.getSitemapTopicListItemLink().contains("superhomepage"));
        System.out.println("\nSitemap Topic List data is correct\n");

        System.out.println("\nAll data is correct!\n");
    }

    @Then("^Publish custom page should contains correct Third Party controllers$")
    public void isPublishCustomPageThirdPartyCorrect() throws Throwable {

        assertEquals(ADVERTISING_THIRD_PARTY_PICTURE_URL,Admin.publishCustomPage.getThirdPartyControlerIFrameSrc(0));
        System.out.println("\nPicture controller is correct\n");

        assertTrue(ADVERTISING_THIRD_PARTY_VIDEO_CODE+"' not contains '"+Admin.publishCustomPage.getThirdPartyControlerIFrameSrc(1),ADVERTISING_THIRD_PARTY_VIDEO_CODE.contains(Admin.publishCustomPage.getThirdPartyControlerIFrameSrc(1)));
        System.out.println("\nVideo controller is correct\n");

        System.out.println("\nAll data is correct!\n");
    }

}
