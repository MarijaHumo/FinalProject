/*public class BaseTest {

    //Uvod: Tokom testiranja koristim IntelliJ Idea u kome kreiram Maven projekat iz razloga sto mi je lakse da ubacujem biblioteke preko pom fajla
    //Prilikom testiranja koristim POM jer je laksi za odrzavanje, lakse se prati rad i elementi se definisu na samo jednom mestu
    //Koristim i JUnit kako ne bih morao da ponavljam neke blokove koda i koristim Before, After i Test anotacije
    //Mogu i da koristim TestNG ali sam izabrao JUnit
    //Da izbegnem hardkodiranje koristim DataDrivenTesting kako lakse mogu da menjam/dodajem testne podatke ili uporedjujem dobijeni rezultat sa ocekivanim rezultatom
    //Testiranje vrsim na Chrome browseru jer prema izvoru Chrome koristi trenutno 67% korisnika na svetu preko Desktopa
    //Izvor: https://gs.statcounter.com/browser-market-share/desktop/worldwide
    //Ako bude potrebe da se testira i na drugim browserima samo treba zameniti driver i ubaciti u directory. Na primer gecko driver za Firefox.

    //U ovom ispod delu deklarisem driver, webdriverwait ako bude potrebe i sve stranice koje cu da testiram
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;

    //Da koristim TestNG ovde bih ubacio BeforeClass, taj deo koda se izvrsava samo jednom pre pocetka testiranja
//Before se izvrsava pre svakog testa i unutar te metode ubacujem sta ocekujem da se uradi pre svakog testa
@Before
public void setUp() throws IOException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wdwait = new WebDriverWait(driver, 20);
    //Putanja koju prosledjujem za citanje excel fajla je jedinstvena za moj racunar i mora se promeniti putanja ako se testiranje vrsi na drugom racunaru

    //Nazivi metoda u page klasama treba da budu opisane akcije koje radimo kako bi neko mogao da procita naredne linije i razume sta se radi

 //Sto vise assertova postavimo to je nas test pouzdaniji

 //Testiranjem da li su polja obavezno prvo odradim klik na dugme bez unosa i proverim da li sam na istoj stranici
//Nakon toga proveravam unos samo jednog polja pa unos samo drugog polja da se uverim da su oba polja obavezna
//Potencijalni bug je sto za dva razlicita elementa na aplikaciji je podesen isti ID - tekst koji se ispisuje iznad oba polja ima isti ID
//ID bi trebalo da sadrzi jedinstven naziv

public void logIn() { //Napravio sam metodu koja ce samo da se uloguje na nalog kako ne bih ponavljao ovaj blok koda u svakom testu
 */