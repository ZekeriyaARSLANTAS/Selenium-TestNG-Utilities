package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract  class TestBaseBeforeClassAfterClass {
    protected static WebDriver driver;
    protected static String tarih;
    // dinamik tarih tanımlama icin
    // TestNG framework'unde @Before QAfter notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    // çalışmaprensibi JUnitteki @Before, @After ile aynıdır
    @BeforeClass(groups = {"gp1","gp2"})
    public static void setUp(){
        // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'teki gibi static yapmaya gerek yoktur
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyyMMddHH");
        tarih = date.format(formater);
    }

    @AfterClass (groups = {"gp1","gp2"})
    public static void tearDown() throws InterruptedException {


       // driver.quit();
    }
}
