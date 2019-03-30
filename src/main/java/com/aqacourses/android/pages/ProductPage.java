package com.aqacourses.android.pages;

import com.aqacourses.android.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 30.03.2019.
 */
public class ProductPage extends AbstractPage {

    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/bottom_bar_tv_buy']")
    private WebElement buyNowButton;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click to button Buy Product
     *
     * @return
     */
    public CheckoutPage clickBuyProduct() {
        testClass.waitTillElementIsVisible(buyNowButton);

        buyNowButton.click();

        return new CheckoutPage(testClass);
    }
}
