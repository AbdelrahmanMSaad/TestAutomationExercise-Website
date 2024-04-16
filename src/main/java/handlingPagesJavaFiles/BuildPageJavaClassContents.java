package handlingPagesJavaFiles;

import utils.Element;

public class BuildPageJavaClassContents {
    private static StringBuilder convertElementsIntoJavaText(Element[] elements) {
        StringBuilder elementsContents = new StringBuilder();
        StringBuilder defineElements = new StringBuilder("""
                \tpublic WebElement getElement(String elementKey) {
                \t\tBy elementLocator = elementsMap.get(elementKey);
                \t\tif (elementLocator != null) {
                \t\t\treturn elementKey.toLowerCase().contains("btn") ?
                \t\t\t\tautomatedActions.waitAndVisibilityActions().waitForAnElementToBeClickable(elementLocator) :
                \t\t\t\tautomatedActions.waitAndVisibilityActions().waitForAnElementToBeVisible(elementLocator);
                \t\t\t}
                \t\treturn null;
                \t}
                \s
                \tprivate void defineAllElements() {
                """);
        for (Element element : elements) {
            String elementName = element.elementName;
            String locatorMethod = element.locatorMethod;
            String locatorValue = element.locatorValue;
            elementsContents.append("""
                            \tprivate final By %s_%s = By.%s("%s");
                            \tpublic String %s = "%s";
                             \s
                            """.formatted(elementName, locatorMethod, locatorMethod, locatorValue, elementName, elementName));
            defineElements.append("""
                    \t\tthis.elementsMap.put(%s, %s_%s);
                    """.formatted(elementName, elementName, locatorMethod));
        }
        defineElements.append("""
                \t}
                \s
                """);
        elementsContents.append(defineElements);
        return elementsContents;
    }

    public static String generatePageJavaClassContent(String javaClassName, Element[] elements) {
        StringBuilder elementsContents = convertElementsIntoJavaText(elements);
        return """
                package pages.pages;
                \s
                import handlingConfigFile.Config;
                import initializers.Initializers;
                import org.openqa.selenium.By;
                import org.openqa.selenium.WebDriver;
                import org.openqa.selenium.WebElement;
                import AutomatedActions.AutomatedActions;
                                
                import java.time.Duration;
                import java.util.HashMap;
                import java.util.Map;
                                    
                public class %s {
                    public WebDriver webDriver;
                    private final Map<String,By> elementsMap = new HashMap<>();
                    private final AutomatedActions automatedActions;
                                    
                    public %s(WebDriver webDriver) {
                        this.webDriver = webDriver;
                        this.automatedActions = Initializers.initializeAutomatedActions();
                        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
                        this.defineAllElements();
                    }
                   \s
                %s
                \t//Add Other Needed Methods Here
                }
                """.formatted(javaClassName, javaClassName, elementsContents);
    }

    public static String generatePageActionsJavaClassContent(String javaClassName, Element[] elements){
        return null;
    }
}
