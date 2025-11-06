package utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Browser {

// This method is used to iterate the Timeline options(Today,yesterday,week ,month and daterange) from Timeline dropdown for Geo Tracking 
	public static void selectValueFromTimelineDropdown(WebDriver ldriver, List<WebElement> today,
			String valuetimeline) {
		List<WebElement> timeline = today;
		for (int i = 0; i < timeline.size(); i++) {
			System.out.println(timeline.get(i).getAttribute("label"));
			if (timeline.get(i).getAttribute("label").equals(valuetimeline)) {
				timeline.get(i).click();
				break;

			}

		}

	}

}
