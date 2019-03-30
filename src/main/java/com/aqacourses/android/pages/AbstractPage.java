package com.aqacourses.android.pages;

import com.aqacourses.android.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marina on 19.02.2019.
 */
public class AbstractPage {

    // Web Elements
    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/menu_item_header_tv_sign_in']")
    private WebElement signInLink;

    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/main_tv_to_catalog']")
    private WebElement catalogButton;

    // Instances of BaseTest
    protected BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click to Sign In Link
     *
     * @return Login Page
     */
    public MainMenuPage clickToSignInLink() {
        testClass.waitTillElementIsVisible(signInLink);
        signInLink.click();
        return new MainMenuPage(testClass);
    }

    /**
     * click to Catalog
     *
     * @return ProductListPage
     */
    public ProductListPage clickToCatalog() {
        testClass.waitTillElementIsVisible(catalogButton);
        catalogButton.click();
        return new ProductListPage(testClass);
    }

}
