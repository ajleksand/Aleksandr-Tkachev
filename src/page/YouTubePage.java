package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubePage {

    private WebDriver driver;
    final String LOGIN = "bellintegrator007@gmail.com";
    final String PASSWORD = "qazWSXedc312";

   public YouTubePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    final String YOUTUBEURL = "https://www.youtube.com/";

    //Кнопка "Войти"
    @FindBy(xpath = "//div[@class=\"style-scope ytd-masthead\"]//*[text()=\"Войти\"]")
    WebElement buttonLogin;

    //Заголовок "Вход"
    @FindBy(xpath = "//*[text()=\"Вход\"]")
    WebElement headingLogin;

    //Поле ввода Логина
    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement inputLogin;

    //Поле ввода Пароля
    @FindBy(xpath = "//div[@class=\"Xb9hP\"]/input[@type = \"password\"]")
    WebElement inputPassword;

    //Кнопка далее
    @FindBy(xpath = "//div[@class=\"qhFLie\"]//div[@role]")
    WebElement buttonNext;

    //Кнопка создать видео
    @FindBy(xpath ="//button[@aria-label=\"Создать видео или запись\"]")
    WebElement butttonCreateVideo;

    //Кнопка добавить видео
    @FindBy(xpath ="//yt-formatted-string[text()=\"Добавить видео\"]")
    WebElement butttonAddVideo;

    //Окно загрузки файла
    @FindBy(xpath ="//div[@id=\"upload-prompt-box\"]/div/input")
    WebElement addFile;

    //Кнопка готово
    @FindBy(xpath ="//span[text()=\"Опубликовать\"]/..")
    WebElement buttonFinish;

    //Строка описания
    @FindBy(xpath ="//input[@class=\"yt-uix-form-input-text video-settings-title\"]")
    WebElement inputDescription;

    //Статус загрузки
    @FindBy(xpath ="//div[text()=\"Загрузка завершена!\"]")
    WebElement lodingComplete;

    //Строка поиска
    @FindBy(xpath ="//input[@id=\"search\"]")
    WebElement inputSearsh;

    //Кнопка поиска
    @FindBy(xpath ="//button[@id=\"search-icon-legacy\"]")
    WebElement buttonSearsh;

    @FindBy(xpath ="//span[@title=\"Главная страница YouTube\"]")
    WebElement buttonMain;

    @FindBy(xpath ="//div[@id=\"contents\"]//ytd-video-renderer")
    WebElement content;







}
