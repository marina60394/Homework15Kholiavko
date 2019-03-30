package com.aqacourses.android.pages;

import com.aqacourses.android.base.BaseTest;
import com.aqacourses.android.utils.YamlParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 30.03.2019.
 */
public class MainMenuPage extends AbstractPage {

    // Web Elements
    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/sign_in_et_login']")
    private WebElement emailInput;

    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/sign_in_et_password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//*[@resource-id='ua.com.rozetka.shop:id/ll_background']")
    private WebElement signInButton;


    /**
     * Constructor
     *
     * @param testClass
     */
    public MainMenuPage(BaseTest testClass) {
        super(testClass);
    }


    /**
     * Sign In with login and password
     *
     * @return
     */
    public MyAccountPage signIn() {
        testClass.waitTillElementIsVisible(emailInput);

        emailInput.sendKeys(YamlParser.getYamlData().getEmail());
        passwordInput.sendKeys(YamlParser.getYamlData().getPassword());
        testClass.getDriver().navigate().back();
        signInButton.click();
        return new MyAccountPage(testClass);

    }

}
