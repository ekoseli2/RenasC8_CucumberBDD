package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    /*
    this is a pool of drivers to run parallel tests. Unlike TestNG, Cucumber will not be limited to
    a single webdriver (per thread). Remember Singleton approach from TestNG.
    Also, Cucumber will request more instances of the webdriver as needed by the step definitions.
    */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();
    private Driver() {}

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            // this block will assign one driver to each test scenario in order to run them in parallel
            synchronized (Driver.class) {
                switch (PropertiesReader.getProperties("browser")) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;
                    default:
                        System.out.println("Undefined browser type");
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if(driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
