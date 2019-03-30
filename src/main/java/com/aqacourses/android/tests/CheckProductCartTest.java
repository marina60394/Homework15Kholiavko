package com.aqacourses.android.tests;

import com.aqacourses.android.enums.CatalogList;
import com.aqacourses.android.enums.GoalCategory;
import com.aqacourses.android.enums.SubCategoryList;
import com.aqacourses.android.base.BaseTest;
import com.aqacourses.android.pages.*;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by Marina on 27.03.2019.
 */
public class CheckProductCartTest extends BaseTest {

    /**
     * Open Rozetka application, log in, buy product and delete from product cart
     */
    @Test
    public void testApplicationTest() throws MalformedURLException {

        // Open Application
        HomePage homePage = openApplication();
        log("Opened application");

        // Click to SIgn In
        MainMenuPage mainMenuPage = homePage.clickToSignInLink();
        log("Clicked Sign In Link");

        // Sign In
        MyAccountPage myAccountPage = mainMenuPage.signIn();
        log("Signed In");

        // Click to Catalog
        ProductListPage productListPage = myAccountPage.clickToCatalog();
        log("Clicked Button Catalog");

        // Click to filter Laptop Category
        productListPage.clickToFilter(CatalogList.LaptopCategory.getName());
        log("Clicked to filter laptop category");

        // Click to filter Laptop SubCategory
        productListPage.clickToFilter(SubCategoryList.LaptopSubCategory.getName());
        log("Clicked to filter laptop subCategory");

        // Click to filter not hart tasks
        productListPage.clickToFilter(GoalCategory.NotHardTasks.getName());
        log("Clicked to filter not hard tasks");

        // Click to the first product
        ProductPage productPage = productListPage.clickToFirstProduct();
        log("Clicked to the first product");

        // Click to button Buy Product
        CheckoutPage checkoutPage = productPage.clickBuyProduct();
        log("Clicked to button Buy Product");

        // Click to Back
        checkoutPage.clickBack();
        log("Clicked to Back");

        // Click to cart offer menu
        checkoutPage.clickCartOfferMenu();
        log("Clicked to cart offer menu");

        // Click to delete product
        checkoutPage.clickDeleteProduct();
        log("Clicked to delete product");

        // Check empty cart
        checkoutPage.checkEmptyCart();
        log("Checked empty cart");

        // Close application
        closeApplication();
        log("Closed application");

    }
}

