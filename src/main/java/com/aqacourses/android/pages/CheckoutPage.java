package com.aqacourses.android.pages;

import com.aqacourses.android.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 30.03.2019.
 */
public class CheckoutPage extends AbstractPage {

    private static final String MESSAGE_EMPTY_CART = "Корзина пуста";

    // Web Elements
    @FindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement backIcon;

    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/iv_cart_offer_item_menu']")
    private WebElement cartOfferMenu;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='ua.com.rozetka.shop:id/title' and @text='Удалить из корзины']")
    private WebElement deleteProduct;

    @FindBy(xpath = "//android.widget.TextView[@text='Корзина пуста']")
    private WebElement messageEmptyCart;

    /**
     * Constructor
     *
     * @param testClass
     */
    public CheckoutPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click Back
     */
    public void clickBack() {
        testClass.waitTillElementIsVisible(backIcon);

        backIcon.click();
    }

    /**
     * Click Cart Offer Menu
     */
    public void clickCartOfferMenu() {
        testClass.waitTillElementIsVisible(cartOfferMenu);

        cartOfferMenu.click();
    }

    /**
     * Click Delete Product
     */
    public void clickDeleteProduct() {
        testClass.waitTillElementIsVisible(deleteProduct);

        deleteProduct.click();
    }

    /**
     * Click Empty Cart
     */
    public void checkEmptyCart() {
        testClass.waitTillElementIsVisible(messageEmptyCart);

        Assert.assertEquals(MESSAGE_EMPTY_CART, messageEmptyCart.getText());
    }


}
