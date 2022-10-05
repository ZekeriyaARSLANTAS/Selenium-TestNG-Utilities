package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {
    // diger classlardan buradan obje olusturulamasin diye (satrt degil)
    // Bu class'a inherit olanlar artık buradaki kodlari kullanabilecek

    protected WebDriver driver;
    protected Actions actions;
    protected String tarih;
    // dinamik tarih tanımlama icin
    // TestNG framework'unde @Before QAfter notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    // çalışma prensibi JUnitteki @Before, @After ile aynıdır

    @BeforeMethod(groups = {"gp1","gp2"})
    public void setUp() {
        // TestNG framework'unde @Before ve @After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
        //Çalışma prensibi JUnit deki Before,After ile aynıdır
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyyMMddHH");
        tarih = date.format(formater);
    }
    @AfterMethod(groups = {"gp1","gp2"})
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

      //  driver.quit();
    }
}
