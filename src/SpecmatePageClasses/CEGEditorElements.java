package SpecmatePageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Page Class
public class CEGEditorElements {
	
	WebDriver driver;
	Actions builder;
	
	//Editor Elements and their locators
	By toolbarMove = By.id("toolbar-tools.move-button");
	By toolbarNode = By.id("toolbar-tools.addCegNode-button");
	By toolbarConnection = By.id("toolbar-tools.addCegConnection-button");
	By toolbarDelete = By.id("toolbar-tools.delete-button");
	By toolbarClear = By.id("toolbar-clear-button");
	By editor = By.id("editor-field");
	
	//Property Editor Elements and their locators
	By propertiesVariable = By.id("properties-variable-textfield");
	By propertiesCondition = By.id("properties-condition-textfield");
	By propertiesName = By.id("properties-name-textfield");
	By propertiesDescription = By.id("properties-description-textfield");
	By propertiesType = By.id("properties-type-dropdown");
	By TypeAND = By.id("type-AND");
	By TypeOR = By.id("type-OR");
	
	//Pop-Up Elements and their locators
	By accept = By.id("popup-accept-button");
	By cancel = By.id("popup-dismiss-button");
	
	public CEGEditorElements(WebDriver driver, Actions builder) { //constructor
		
		this.driver = driver;
		this.builder = builder;
	}
	
	public void setModelName(String name) {
		driver.findElement(toolbarMove).click();
		driver.findElement(editor).click();
		WebElement modelName = driver.findElement(propertiesName);
		modelName.clear();
		modelName.sendKeys(name);
	}
	
	public void setModelDescription(String description) {
		driver.findElement(editor).click();
		WebElement modelDescription = driver.findElement(propertiesDescription);
		modelDescription.clear();
		modelDescription.sendKeys(description);
	}
	
	/**creates a new node with corresponding variable and condition
	 *at position x,y
	 *and returns the newly created node
	 */
	public WebElement createNode(String variable, String condition, int x, int y) {
		
		int numberOfNodes = driver.findElements(By.xpath("//*[@ceg-graphical-node]")).size();
		
		driver.findElement(toolbarNode).click();
		WebElement editorField = driver.findElement(editor);
		numberOfNodes ++;
		builder.moveToElement(editorField, x, y).click().build().perform();
		
		WebElement node = driver.findElement(By.xpath("//*[@ceg-graphical-node][" + numberOfNodes + "]"));
		WebElement variableTextfield = driver.findElement(propertiesVariable);
		WebElement conditionTextfield = driver.findElement(propertiesCondition);
		variableTextfield.clear();
		variableTextfield.sendKeys(variable);
		conditionTextfield.clear();
		conditionTextfield.sendKeys(condition);
		
		return node;
	}
	
	/**establishes a connection from node1 to node2
	*and returns the newly created connection
	*/
	public WebElement connect(WebElement node1, WebElement node2) {
		int numberOfConnections = driver.findElements(By.xpath("//*[@ceg-graphical-connection]")).size();
		
		driver.findElement(toolbarConnection).click();
		node1.click();
		node2.click();
		numberOfConnections ++;
		
		WebElement connection = driver.findElement(By.xpath("//*[@ceg-graphical-connection][" + numberOfConnections + "]"));
		return connection;
	}
	
	public void delete(WebElement element) {
		driver.findElement(toolbarDelete).click();
		element.click();
	}
	
	public void clear() {
		driver.findElement(toolbarClear).click();
		driver.findElement(accept).click();
	}
	
	public void clearButCancel() {
		driver.findElement(toolbarClear).click();
		driver.findElement(cancel).click();
	}
	
	public void changeTypeToAND(WebElement node) {
		node.click();
		driver.findElement(propertiesType).click();
		driver.findElement(TypeAND).click();		
	}
	
	public void changeTypeToOR(WebElement node) {
		node.click();
		driver.findElement(propertiesType).click();
		driver.findElement(TypeOR).click();		
	}
	
	/*
	public void move(WebElement node) {
	 
	}

	public void findNode(String variable, String condition="*"{
	
	}
	*/
}
