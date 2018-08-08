package SpecmatePageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Class
//Anforderungsübersicht
public class RequirementOverviewElements {

	WebDriver driver;
	
	//Elements and their locators
	By createModel = By.id("requirement-createmodel-button");
	By createProcess = By.id("requirement-createprocess-button");
	By createTestSpec = By.id("requirement-createtestspec-button");
	
	//Pop-Up Elements and their locators
	By discard = By.id("popup-accept-button");
	By cancel = By.id("popup-dismiss-button");
	
	public RequirementOverviewElements(WebDriver driver1) {
		
		this.driver = driver1; 
	}
	
	/**click on button to create new ceg-model*/
	public void createModel() {
		driver.findElement(createModel).click();
	}
	
	/**click on button to create new process*/
	public void createProcess() {
		driver.findElement(createProcess).click();
	}
	
	/**click on button to create new test specification*/
	public void createTestSpec() {
		driver.findElement(createTestSpec).click();
	}
	
	public void deleteModel(String modelName) {
		driver.findElement(By.id("requirement-" + modelName + "-deletemodel-button")).click();
		driver.findElement(discard).click();
	}
	
	public void deleteModelbutCancel(String modelName) {
		driver.findElement(By.id("requirement-" + modelName + "-deletemodel-button")).click();
		driver.findElement(cancel).click();
	}
	
	public void deleteProcess(String processName) {
		driver.findElement(By.id("requirement-" + processName + "-deleteprocess-button")).click();
	}
	
	public void deleteTestSpec(String testSpecName) {
		driver.findElement(By.id("requirement-" + testSpecName + "-deletetestspec-button")).click();
	}
	
	/**click on button to generate a test specification for a model or a process*/
	public void generateTestSpecification(String modelName) {
		driver.findElement(By.id(modelName + "-generate-testspec-button")).click();
	}
}
