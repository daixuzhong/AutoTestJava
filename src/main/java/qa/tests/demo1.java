package qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class demo1 {

    private static Logger logger = LoggerFactory.getLogger(demo1.class);

    private static String nameInput = "#LoginName";
    private static String passwordInput = "#Password";
    private static String loginBtn = "#btnLogin";

    private static String userName = "admin";
    private static String password = "123@qwe";

    public static void main(String[] args) {
        try {
            openChrome();
        } catch (Exception e) {
            logger.error("执行失败" + e.getStackTrace());
        }
    }

    /**
     * 打开chrome
     */
    public static void openChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D://Future//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://47.100.40.166:8060/portal/Account/Login?ReturnUrl=%2Fportal%2F");
        driver.manage().window().maximize();

        if (!ElementExist(driver, nameInput) || !ElementExist(driver, passwordInput)) {
            logger.error("元素不存在");
            throw new Exception("元素不存在");
        }

        driver.findElement(By.cssSelector(nameInput)).sendKeys(userName);
        driver.findElement(By.cssSelector(passwordInput)).sendKeys(password);
        driver.findElement(By.cssSelector(loginBtn)).click();

        Thread.sleep(2000);

        driver.quit();

    }

    /**
     * 校验页面元素是否存在
     * @param driver
     * @param locator
     * @return
     */
    public static boolean ElementExist(WebDriver driver,String locator)
    {
        try {
            driver.findElement(By.cssSelector(locator));
            return true;
        } catch (Exception e) {
            logger.error("找不到该元素：" + locator);
            return false;
        }

    }


}
