package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfileTests extends AppManager {
    BoardsPage boardsPage;
    @BeforeMethod
    public void login(){
        User user = new User("tatianapqatest@gmail.com","Password123!QA");
        logger.info("login test with user"+ user.getEmail()+"  "+user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void changeProfilePhoto(){
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));

    }
}
