package e2e.support;

import java.util.ResourceBundle;

public final class TestConstants {

    //property file
    private static ResourceBundle propFile = ResourceBundle.getBundle("testData");

    //journey constants
    public static final String URI_FOR_CHECK = propFile.getString("journey.additionalUrlToCheck");

    //merchandising directory container's constants
    public static final String DIR_LIST_ITEM_LOGO = propFile.getString("journey.merchandising.dirListItem.logo");
    public static final String DIR_LIST_ITEM_ALT_LOGO_TEXT = propFile.getString("journey.merchandising.dirListItem.altLogoText");
    public static final String DIR_LIST_ITEM_CALL_TO_ACTION = propFile.getString("journey.merchandising.dirListItem.callToActionText");
    public static final String DIR_LIST_ITEM_BODY_TITLE = propFile.getString("journey.merchandising.dirListItem.bodyTitle");
    public static final String DIR_LIST_ITEM_BODY_CONTENT = propFile.getString("journey.merchandising.dirListItem.bodyContent");
    public static final String CALL_TO_ACTION_TITLE = propFile.getString("journey.merchandising.callToAction.title");
    public static final String CALL_TO_ACTION_PANEL_TITLE = propFile.getString("journey.merchandising.callToAction.panelTitle");
    public static final String CALL_TO_ACTION_ALT_TEXT = propFile.getString("journey.merchandising.callToAction.altText");
    public static final String CALL_TO_ACTION_BUTTON = propFile.getString("journey.merchandising.callToAction.button");
    public static final String CALL_TO_ACTION_IMG = propFile.getString("journey.merchandising.callToAction.img");
    public static final String CROSS_SELL_TITLE = propFile.getString("journey.merchandising.crossSellItem.title");
    public static final String CROSS_SELL_SUBTITLE= propFile.getString("journey.merchandising.crossSellItem.subTitle");
    public static final String CROSS_SELL_TEXT = propFile.getString("journey.merchandising.crossSellItem.textToDisplay");
    public static final String CROSS_SELL_IMG = propFile.getString("journey.merchandising.crossSellItem.img");
    public static final String PROMOTION_TITLE = propFile.getString("journey.merchandising.promotion.title");
    public static final String PROMOTION_PANEL_TITLE= propFile.getString("journey.merchandising.promotion.panelTitle");
    public static final String PROMOTION_PANEL_TEXT = propFile.getString("journey.merchandising.promotion.panelText");
    public static final String PROMOTION_ALT_TEXT = propFile.getString("journey.merchandising.promotion.altText");
    public static final String PROMOTION_IMG = propFile.getString("journey.merchandising.promotion.img");
    public static final String TOP_DEALS_TITLE = propFile.getString("journey.merchandising.topDeals.title");
    public static final String TOP_DEALS_PANEL_TITLE= propFile.getString("journey.merchandising.topDeals.panelTitle");
    public static final String TOP_DEALS_PANEL_TEXT= propFile.getString("journey.merchandising.topDeals.panelText");
    public static final String TOP_DEALS_PRICE_OFFER = propFile.getString("journey.merchandising.topDeals.priceOfferText");
    public static final String TOP_DEALS_BUTTON = propFile.getString("journey.merchandising.topDeals.button");
    public static final String TOP_DEALS_BACKGROUND_IMG = propFile.getString("journey.merchandising.topDeals.backGroungImg");
    public static final String TOP_DEALS_IMG = propFile.getString("journey.merchandising.topDeals.img");


    //SEO directory container's constants data
    public static final String DEST_LIST_ITEM_TITLE = propFile.getString("journey.seo.destListItem.itemTitle");
    public static final String DEST_LIST_ITEM_DISPLAYED_TITLE = propFile.getString("journey.seo.destListItem.displayedTitle");
    public static final String BLOG_POST_ARTICLE_TITLE = propFile.getString("journey.seo.blogPostArt.artTitle");
    public static final String BLOG_POST_ARTICLE_CONTENT = propFile.getString("journey.seo.blogPostArt.content");
    public static final String BLOG_POST_ARTICLE_IMG = propFile.getString("journey.seo.blogPostArt.img");
    public static final String RICH_TEXT_ARTICLE_TITLE = propFile.getString("journey.seo.richTextArt.artTitle");
    public static final String RICH_TEXT_ARTICLE_CONTENT = propFile.getString("journey.seo.richTextArt.content");

    //Directory Containers
    public static final String SEO_DIR_CONT_TITLE = propFile.getString("journey.containers.seo.seoDirContTitle");
    public static final String MERCH_DIR_CONT_TITLE = propFile.getString("journey.containers.seo.merchDirContTitle");

    //Text Containers
    public static final String HOME_TITLE = propFile.getString("journey.text.staticTextEditor.homeTitle");
    public static final String CONTENT_TEXT = propFile.getString("journey.text.staticTextEditor.contentText");
    public static final String CONCERTINA_TITLE = propFile.getString("journey.text.concertinaTextEditor.title");
    public static final String CONCERTINA_ITEM_TITLE = propFile.getString("journey.text.concertinaTextEditor.itemTitle");
    public static final String CONCERTINA_ITEM_SUB_TITLE = propFile.getString("journey.text.concertinaTextEditor.itemSubTitle");
    public static final String CONCERTINA_ITEM_BODY_TEXT = propFile.getString("journey.text.concertinaTextEditor.itemTextBody");
    public static final String RICH_BODY_TEXT = propFile.getString("journey.text.richTextEditor.textBody");
    public static final String TICK_ITEM = propFile.getString("journey.text.tickList.textItem");

    //Image Containers
    public static final String PROVIDER_HOLIDAY_LOGO = propFile.getString("journey.image.providerLogo.mediumLogo");



    //Page constants
    public static final String PAGE_BREADCRUMB_LOUP_ITEM = propFile.getString("journey.page.breadcrumbTrail.loupItem");
    public static final String PAGE_DISCLAIMBER_TEXT = propFile.getString("journey.page.disclaimer.text");

    //Auxiliary constants
    public static final String AUXILIARY_NAVIGATION_TITLE = propFile.getString("journey.auxiliary.navigationTopicList.title");
    public static final String AUXILIARY_NAVIGATION_FIRST_ITEM = propFile.getString("journey.auxiliary.navigationTopicList.firstItem");
    public static final String AUXILIARY_SITEMAP_TITLE = propFile.getString("journey.auxiliary.sitemapTopicList.title");
    public static final String AUXILIARY_SITEMAP_FIRST_ITEM = propFile.getString("journey.auxiliary.sitemapTopicList.firstItem");

    //Advertising constants
    public static final String ADVERTISING_THIRD_PARTY_PICTURE_NAME = propFile.getString("journey.advertising.thirdPartyControler.pictureName");
    public static final String ADVERTISING_THIRD_PARTY_PICTURE_URL = propFile.getString("journey.advertising.thirdPartyControler.pictureUrl");
    public static final String ADVERTISING_THIRD_PARTY_VIDEO_NAME = propFile.getString("journey.advertising.thirdPartyControler.videoName");
    public static final String ADVERTISING_THIRD_PARTY_VIDEO_CODE = propFile.getString("journey.advertising.thirdPartyControler.videoCode");
}
