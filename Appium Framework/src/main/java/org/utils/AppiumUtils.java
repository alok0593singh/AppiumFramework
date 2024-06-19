package org.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumUtils {

	public AppiumDriverLocalService service;


//	AppiumDriver driver;
//	public AppiumUtils(AppiumDriver driver){
//		this.driver = driver;
//	}

//	public Double getFormattedAmount(String amount)
//	{
//		Double price = Double.parseDouble(amount.substring(1));
//		return price;
//
//	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		//System.getProperty("user.dir")+"//src//test//java//TestData//credentials.json"

		// convert json file content to json string

		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}

	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text" , "Cart"));
	}

//	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
//	{
//		File source = driver.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
//		FileUtils.copyFile(source, new File(destinationFile));
//		return destinationFile;
//		//1. capture and place in folder //2. extent report pick file and attach to report
//
//	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
		File reportDirectory = new File(reportsDir);
		if (!reportDirectory.exists()) {
			reportDirectory.mkdirs();
		}
		String destinationFile = reportsDir + File.separator + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}




	public enum ScrollDirection {
		UP, DOWN, LEFT, RIGHT
	}

	public static void scroll(AppiumDriver driver, ScrollDirection dir, Double scrollRatio) {
		Duration scrollDuration = Duration.ofMillis(300);
		if (scrollRatio < 0 || scrollRatio > 1) {
			throw new Error("Scroll Ratio must be between 0 and 1");
		}

		Dimension size = driver.manage().window().getSize();
		Point midPoint = new Point((int) (size.getWidth() * 0.5), (int) (size.getHeight() * 0.5));

		int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
		int top = midPoint.y - (int) (midPoint.y * scrollRatio);

		int left = midPoint.x - (int) (midPoint.x * scrollRatio);
		int right = midPoint.x + (int) (midPoint.x * scrollRatio);

		if (dir == ScrollDirection.UP) {
			swipe(driver, new Point(midPoint.x, bottom), new Point(midPoint.x, top), scrollDuration);
		} else if (dir == ScrollDirection.DOWN) {
			swipe(driver, new Point(midPoint.x, top), new Point(midPoint.x, bottom), scrollDuration);
		} else if (dir == ScrollDirection.LEFT) {
			swipe(driver, new Point(right, midPoint.y), new Point(left, midPoint.y), scrollDuration);
		} else {
			swipe(driver, new Point(left, midPoint.y), new Point(right, midPoint.y), scrollDuration);
		}
	}

	public static void swipe(AppiumDriver driver, Point start, Point end, Duration duration) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.x, start.y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(ImmutableList.of(sequence));
	}

	public static Point getCenter(WebElement element){
		Point elementCoordinates = element.getLocation();

		Dimension elementSize = element.getSize();

		return new Point(elementCoordinates.x+ elementSize.getWidth()/2, elementCoordinates.y+ elementSize.getHeight()/2);

	}

	public static void dragAndDrop(AppiumDriver driver, WebElement source, WebElement target){
		Duration scroll_duration = Duration.ofMillis(300);

		Point sourceMidPoint = getCenter(source);
		Point targetMidPoint = getCenter(target);

		swipe(driver, sourceMidPoint,targetMidPoint,scroll_duration);

	}

}


