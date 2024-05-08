//package sit707_week2;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SeleniumOperations {
//
//    public static void sleep(int sec) {
//        try {
//            Thread.sleep(sec*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void BunnyLogin_page(String url) {
//        System.out.println("Fire up chrome browser.");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akshar Antala\\Desktop\\Jar\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        System.out.println("Driver info: " + driver);
//        sleep(2);
//        driver.get(url);
//        WebElement element = driver.findElement(By.id("firstname"));
//        System.out.println("Found element: " + element);
//        element.sendKeys("Ahsan");
//        // Write code for finding and populating other input fields
//        // ...
//        // Identify button 'Create account' and click to submit
//        WebElement createAccountButton = driver.findElement(By.id("create-account-button-id"));
//        createAccountButton.click();
//        sleep(2);
//        // Take screenshot using selenium API
//        // ...
//        driver.close();
//    }
//
//	public static WebDriver getDriver() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static void BunnyLogin_page1(String url) {
//		// TODO Auto-generated method stub
//		
//	}
//}