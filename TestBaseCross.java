package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseCross {
    protected static WebDriver driver;
    protected static String tarih;
    // dinamik tarih tanımlama icin
    // TestNG framework'unde @Before QAfter notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    // çalışmaprensibi JUnitteki @Before, @After ile aynıdır
    @Parameters("browser")
    @BeforeClass
    public static void setUp(@Optional String browser){
        // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'teki gibi static yapmaya gerek yoktur

        driver=CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyyMMddHH");
        tarih = date.format(formater);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {


        // driver.quit();
    }

}
