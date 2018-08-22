package page;

import com.company.LeanFtTest;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import unittesting.UnitTestClassBase;

import java.util.concurrent.TimeUnit;


public class YouTubeTest extends UnitTestClassBase {

    WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @Before
    public void setUpBefore() {

        //прописываем путь к драйверу браузера
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ATkachev\\IdeaProjects\\YouTube\\chromedriver.exe");
        driver = new ChromeDriver();

        //Установим ожидание на поиск элемента в 10 секунд.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Задаем размер окна браузера во весь экран
        driver.manage().window().maximize();

    }

    @Test
    public void testYouTube() throws ReportException {

        YouTubePage youTubePage = new YouTubePage(driver);

        driver.get(youTubePage.YOUTUBEURL);
        Reporter.reportEvent("Выполнил вход на главную страницу", "Passed");

        youTubePage.buttonLogin.click();

        Assert.assertTrue(youTubePage.headingLogin.isDisplayed());

        youTubePage.inputLogin.sendKeys(youTubePage.LOGIN);
        youTubePage.buttonNext.click();

        youTubePage.inputPassword.sendKeys(youTubePage.PASSWORD);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        youTubePage.buttonNext.click();

        youTubePage.butttonCreateVideo.click();
        youTubePage.butttonAddVideo.click();

        youTubePage.addFile.sendKeys("C:\\Users\\ATkachev\\IdeaProjects\\YouTube\\resources\\TestRecord.MP4");
        youTubePage.inputDescription.sendKeys("MyVideo22211");

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()",  youTubePage.buttonFinish );*/
        youTubePage.buttonFinish.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.reportEvent("Загрузка файла завершена", "Passed");
        //youTubePage.buttonMain.click();
        driver.get(youTubePage.YOUTUBEURL);

        youTubePage.inputSearsh.sendKeys("TestRecordMyVideo22211");
        youTubePage.buttonSearsh.click();

        Assert.assertTrue(youTubePage.content.isEnabled());
        Reporter.reportEvent("Тест выполнен", "Passed");
    }

    @After
    public void tearDownAfter() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }
}

