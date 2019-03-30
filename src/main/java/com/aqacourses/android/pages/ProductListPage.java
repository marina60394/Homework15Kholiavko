package com.aqacourses.android.pages;

import com.aqacourses.android.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 30.03.2019.
 */
public class ProductListPage extends AbstractPage {

    String CATEGORY = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='ua.com.rozetka.shop:id/ll_root' and @index='0']")
    private WebElement firstProductThumbnail;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductListPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click to Filter
     *
     * @param category
     */
    public void clickToFilter(String category) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(String.format(CATEGORY, category))));

        testClass
                .getDriver()
                .findElement(By.xpath(String.format(CATEGORY, category)))
                .click();
    }

    /**
     * Click to the first product
     *
     * @return
     */
    public ProductPage clickToFirstProduct() {
        testClass.waitTillElementIsVisible(firstProductThumbnail);

        firstProductThumbnail.click();

        return new ProductPage(testClass);
    }
}
