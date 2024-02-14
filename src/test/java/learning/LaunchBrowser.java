package learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
		Browser br = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext b1 = browser.newContext();
		
		Page page = browser.newPage();
		
		page.navigate("https://testcrew.com/");
		
		
		assertThat(page).hasTitle("TestCrew");
		

		
		BrowserContext b2 = br.newContext();
		
		Page p2 = br.newPage();
		
		p2.navigate("https://www.accuweather.com/en/sa/riyadh/297030/weather-forecast/297030");
		
		assertThat(p2).hasTitle("Riyadh, Riyadh, Saudi Arabia Weather Forecast | AccuWeather");
		
	
		p2.close();
		
		playwright.close();
				
		
	}

}
