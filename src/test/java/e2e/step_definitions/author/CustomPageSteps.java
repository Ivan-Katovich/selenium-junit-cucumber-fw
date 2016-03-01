package e2e.step_definitions.author;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import e2e.Browser;
import e2e.base.Admin;
import e2e.support.Helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static e2e.support.TestConstants.*;

public class CustomPageSteps {


    @When("^I add Merchandising and SEO items to the custom list items page$")
    public void fillListItemsPageWithMerchandisingAndSEOContainers() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addContainerIntoField(1, "Merchandising", "Directory List Item");
        System.out.println("\nMerchandising Directory List Item added\n");
        Admin.customPage.addMerchandisingDirListItem();
        assertTrue(Admin.customPage.getMerchandisingDirListItemText()+"' not contains '"+DIR_LIST_ITEM_CALL_TO_ACTION,Admin.customPage.getMerchandisingDirListItemText().contains(DIR_LIST_ITEM_CALL_TO_ACTION));
        assertTrue(Admin.customPage.getMerchandisingDirListItemText()+"' not contains '"+DIR_LIST_ITEM_BODY_TITLE,Admin.customPage.getMerchandisingDirListItemText().contains(DIR_LIST_ITEM_BODY_TITLE));
        assertTrue(Admin.customPage.getMerchandisingDirListItemText()+"' not contains '"+DIR_LIST_ITEM_BODY_CONTENT,Admin.customPage.getMerchandisingDirListItemText().contains(DIR_LIST_ITEM_BODY_CONTENT));
        System.out.println("\nMerchandising Directory List Item filled\n");

        Admin.customPage.addContainerIntoField(1, "Editorial Elements", "SEO Destination List Item");
        System.out.println("\nSEO Destination List Item added\n");
        Admin.customPage.addDestinationListItem();
        assertTrue(Admin.customPage.getDestinationListItemText()+"' not contains '"+DEST_LIST_ITEM_DISPLAYED_TITLE,Admin.customPage.getDestinationListItemText().contains(DEST_LIST_ITEM_DISPLAYED_TITLE));
        System.out.println("\nSEO Destination List Item filled\n");

        Admin.customPage.addContainerIntoField(1, "Merchandising", "Call to Action Panel");
        System.out.println("\nCall to Action Panel added\n");
        Admin.customPage.addCallToActionPannel();
        assertTrue(Admin.customPage.getCallToActionPanelText()+"' not contains '"+CALL_TO_ACTION_PANEL_TITLE.toUpperCase(),Admin.customPage.getCallToActionPanelText().contains(CALL_TO_ACTION_PANEL_TITLE.toUpperCase()));
        assertTrue(Admin.customPage.getCallToActionPanelText()+"' not contains '"+CALL_TO_ACTION_BUTTON.toUpperCase(),Admin.customPage.getCallToActionPanelText().contains(CALL_TO_ACTION_BUTTON.toUpperCase()));
        System.out.println("\nCall To Action Panel filled\n");

        Admin.customPage.addContainerIntoField(1, "Merchandising", "Cross Sell Item");
        System.out.println("\nCross Sell Item added\n");
        Admin.customPage.addCrossSellItem();
        assertTrue(Admin.customPage.getCrossSellItemText()+"' not contains '"+CROSS_SELL_TITLE,Admin.customPage.getCrossSellItemText().contains(CROSS_SELL_TITLE));
        assertTrue(Admin.customPage.getCrossSellItemText()+"' not contains '"+CROSS_SELL_SUBTITLE,Admin.customPage.getCrossSellItemText().contains(CROSS_SELL_SUBTITLE));
        assertTrue(Admin.customPage.getCrossSellItemText()+"' not contains '"+CROSS_SELL_TEXT,Admin.customPage.getCrossSellItemText().contains(CROSS_SELL_TEXT));
        System.out.println("\nCross Sell Item filled\n");

        Admin.customPage.addContainerIntoField(1, "Merchandising", "Promotion Panel");
        System.out.println("\nPromotion Panel added\n");
        Admin.customPage.addPromotionPanel();
        assertTrue(Admin.customPage.getPromotionPanelText()+"' not contains '"+PROMOTION_PANEL_TITLE,Admin.customPage.getPromotionPanelText().contains(PROMOTION_PANEL_TITLE));
        assertTrue(Admin.customPage.getPromotionPanelText()+"' not contains '"+PROMOTION_PANEL_TEXT,Admin.customPage.getPromotionPanelText().contains(PROMOTION_PANEL_TEXT));
        System.out.println("\nPromotion Panel filled\n");

        Admin.customPage.addContainerIntoField(1, "Merchandising", "Top Deals Panel");
        System.out.println("\nTop Deals Panel added\n");
        Admin.customPage.addTopDealsPanel();
        assertTrue(Admin.customPage.getTopDealsPanelText()+"' not contains '"+TOP_DEALS_PANEL_TITLE,Admin.customPage.getTopDealsPanelText().contains(TOP_DEALS_PANEL_TITLE));
        assertTrue(Admin.customPage.getTopDealsPanelText()+"' not contains '"+TOP_DEALS_PANEL_TEXT,Admin.customPage.getTopDealsPanelText().contains(TOP_DEALS_PANEL_TEXT));
        assertTrue(Admin.customPage.getTopDealsPanelText()+"' not contains '"+TOP_DEALS_PRICE_OFFER,Admin.customPage.getTopDealsPanelText().contains(TOP_DEALS_PRICE_OFFER));
        assertTrue(Admin.customPage.getTopDealsPanelText()+"' not contains '"+TOP_DEALS_BUTTON,Admin.customPage.getTopDealsPanelText().contains(TOP_DEALS_BUTTON.toUpperCase()));
        System.out.println("\nTop Deals Panel filled\n");

        Admin.customPage.addContainerIntoField(1, "Editorial Elements", "SEO Related Blog Post Article");
        System.out.println("\nBlog Post Article added\n");
        Admin.customPage.addBlogPostArticle();
        assertTrue(Admin.customPage.getBlogPostArticleText()+"' not contains '"+BLOG_POST_ARTICLE_TITLE,Admin.customPage.getBlogPostArticleText().contains(BLOG_POST_ARTICLE_TITLE));
        assertTrue(Admin.customPage.getBlogPostArticleText()+"' not contains '"+BLOG_POST_ARTICLE_CONTENT,Admin.customPage.getBlogPostArticleText().contains(BLOG_POST_ARTICLE_CONTENT));
        System.out.println("\nBlog Post Article filled\n");

        Admin.customPage.addContainerIntoField(1, "Editorial Elements", "SEO Rich Text Article");
        System.out.println("\nRich Text Article added\n");
        Admin.customPage.addRichTextArticle();
        assertTrue(Admin.customPage.getRichTextArticleText()+"' not contains '"+RICH_TEXT_ARTICLE_TITLE,Admin.customPage.getRichTextArticleText().contains(RICH_TEXT_ARTICLE_TITLE));
        assertTrue(Admin.customPage.getRichTextArticleText()+"' not contains '"+RICH_TEXT_ARTICLE_CONTENT,Admin.customPage.getRichTextArticleText().contains(RICH_TEXT_ARTICLE_CONTENT));
        System.out.println("\nRich Text Article filled\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }


    @When("^I add custom Merchandising and SEO directory containers to the custom home page$")
    public void fillHomePageWithDirectoryContainers() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addContainerIntoField(1, "Directory Containers", "SEO Directory Content Container");
        System.out.println("\nSEO Container added\n");
        Admin.customPage.fillSEODirectoryContentContainer(SEO_DIR_CONT_TITLE, 1);
        assertTrue(Admin.customPage.getSEODirectoryContainerText()+"' not contains '"+SEO_DIR_CONT_TITLE,Admin.customPage.getSEODirectoryContainerText().contains(SEO_DIR_CONT_TITLE));
        System.out.println("\nSEO Container filled\n");

        Admin.customPage.addContainerIntoField(1, "Directory Containers", "Merchandising Directory Content Container");
        System.out.println("\nMerchendising Container added\n");
        Admin.customPage.fillMerchDirectoryContentContainer(MERCH_DIR_CONT_TITLE, 0);
        assertTrue(Admin.customPage.getMerchDirectoryContainerText()+"' not contains '"+MERCH_DIR_CONT_TITLE,Admin.customPage.getMerchDirectoryContainerText().contains(MERCH_DIR_CONT_TITLE));
        System.out.println("\nMerchendising Container filled\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }


    @When("^I add text items to the custom Home page$")
    public void fillHomePageTextFields() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addStaticText(0, HOME_TITLE);
        assertEquals(HOME_TITLE, Admin.customPage.getStaticText(0));
        System.out.println("\nHome title added\n");

        Admin.customPage.addStaticText(1, CONTENT_TEXT);
        assertEquals(CONTENT_TEXT, Admin.customPage.getStaticText(1));
        System.out.println("\nHome content text added\n");

        Admin.customPage.addContainerIntoField(1, "Image", "Provider Logos");
        System.out.println("\nLogo container added\n");
        Admin.customPage.addLogo();
        assertTrue(Admin.customPage.isLogoVisible());
        System.out.println("\nLogo is visible\n");

        Admin.customPage.addContainerIntoField(1, "Text", "Concertina Text Editor");
        System.out.println("\nConcertina Text Editor added\n");
        Admin.customPage.addConcertinaText();
        assertTrue(Admin.customPage.getConcertinaText()+"' not contains '"+CONCERTINA_ITEM_TITLE,Admin.customPage.getConcertinaText().contains(CONCERTINA_ITEM_TITLE));
        assertTrue(Admin.customPage.getConcertinaText()+"' not contains '"+CONCERTINA_ITEM_SUB_TITLE,Admin.customPage.getConcertinaText().contains(CONCERTINA_ITEM_SUB_TITLE));
        System.out.println("\nConcertina Text Editor filled\n");

        Admin.customPage.addContainerIntoField(1, "Text", "Rich Text Editor");
        System.out.println("\nRich Text Editor added\n");
        Admin.customPage.addRichText();
        assertEquals(Admin.customPage.getRichText(), RICH_BODY_TEXT);
        System.out.println("\nRich Text Editor filled\n");

        Admin.customPage.addContainerIntoField(1, "Text", "Tick List");
        System.out.println("\nTick List added\n");
        Admin.customPage.addTickList();
        assertEquals(Admin.customPage.getTickListText(), TICK_ITEM);
        System.out.println("\nTick List filled\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }

    @When("^I add Page items to the custom Home page$")
    public void fillHomePageWithPageContainers() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addContainerIntoField(1, "Page", "Disclaimer Text");
        System.out.println("\nPage Disclaimer Text added\n");
        Admin.customPage.addPageDisclaimerText();
        assertEquals(Admin.customPage.getDisclaimerText(), PAGE_DISCLAIMBER_TEXT);
        System.out.println("\nPage Disclaimer Text filled\n");

//        Admin.customPage.addContainerIntoField(1, "Page", "Footer Links");
//        System.out.println("Page Footer Links added");
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Legal"));
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Contact Us"));
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Privacy"));
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Terms & Conditions"));
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Security"));
//        assertTrue(Admin.customPage.getFooterLinksText().contains("Cookie"));
//        System.out.println("Page Footer Links filled");

        Admin.customPage.addContainerIntoField(1, "Page", "Breadcrumb Trail");
        System.out.println("\nPage breadcrumb Item added\n");
        Admin.customPage.addPageBreadcrumbTrail();
        assertTrue(Admin.customPage.getBreadcumbTrailItemText()+"' not contains '"+"GB Home",Admin.customPage.getBreadcumbTrailItemText().contains("GB Home"));
        assertTrue(Admin.customPage.getBreadcumbTrailItemText()+"' not contains '"+Browser.options.homePageTitle,Admin.customPage.getBreadcumbTrailItemText().contains(Browser.options.homePageTitle));
        System.out.println("\nPage breadcrumb Item filled\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }

    @When("^I add Auxiliary items to the custom navigation page$")
    public void fillHomePageWithAuxiliaryContainers() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addContainerIntoField(1, "Auxiliary", "Navigation Topic List");
        System.out.println("\nAuxiliary Navigation Topic List added\n");
        Admin.customPage.addNavigationTopicList();
        assertTrue(Admin.customPage.getNavigationTopicListText()+"' not contains '"+AUXILIARY_NAVIGATION_TITLE,Admin.customPage.getNavigationTopicListText().contains(AUXILIARY_NAVIGATION_TITLE));
        assertTrue(Admin.customPage.getNavigationTopicListText()+"' not contains '"+AUXILIARY_NAVIGATION_FIRST_ITEM,Admin.customPage.getNavigationTopicListText().contains(AUXILIARY_NAVIGATION_FIRST_ITEM));
        System.out.println("\nAuxiliary Navigation List filled\n");

        Admin.customPage.addContainerIntoField(1, "Auxiliary", "Sitemap Topic List");
        System.out.println("\nAuxiliary Navigation Topic List added\n");
        Admin.customPage.addSitemapTopicList();
        assertTrue(Admin.customPage.getSitemapTopicListText()+"' not contains '"+AUXILIARY_SITEMAP_TITLE,Admin.customPage.getSitemapTopicListText().contains(AUXILIARY_SITEMAP_TITLE));
        assertTrue(Admin.customPage.getSitemapTopicListText()+"' not contains '"+AUXILIARY_SITEMAP_FIRST_ITEM,Admin.customPage.getSitemapTopicListText().contains(AUXILIARY_SITEMAP_FIRST_ITEM));
        System.out.println("\nAuxiliary Navigation List filled\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }

    @When("^I add Advertising containers to the custom Home page$")
    public void fillHomePageWithAdvertisingContainers() throws Throwable {
        assertTrue(Admin.customPage.isSidekickVisible());
        System.out.println(" ... in author mod");
        Admin.customPage.switchToCFFrame();

        Admin.customPage.addContainerIntoField(1, "Advertising", "3rd Party Widget Controller");
        System.out.println("\n3rd Party Widget Controller added\n");
        Admin.customPage.addThirdPartyControlerPicture();
        System.out.println("\n3rd Party Widget Controller filled with picture\n");

        Admin.customPage.addContainerIntoField(1, "Advertising", "3rd Party Widget Controller");
        System.out.println("\n3rd Party Widget Controller added\n");
        Admin.customPage.addThirdPartyControlerVideo();
        System.out.println("\n3rd Party Widget Controller filled with Video\n");

        System.out.println("\nAll data are displayed correct !!!!!!!\n");
        Admin.customPage.switchToDefaultContent();
        String message = Admin.customPage.activatePageFromSidekick();
        assertEquals(message, "Page successfully activated");
        System.out.println("\nPage successfully activated\n");
    }


}
