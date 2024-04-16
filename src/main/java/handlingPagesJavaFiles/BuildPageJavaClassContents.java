package handlingPagesJavaFiles;

import utils.Element;

public class BuildPageJavaClassContents {
    private static StringBuilder convertElementsIntoJavaText(Element[] elements) {
        StringBuilder elementsContents = new StringBuilder();
        StringBuilder defineElements = new StringBuilder("""
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
        String javaActionsClassName = javaClassName + "Actions",
                javaActionsObjectName = javaActionsClassName.substring(0, 1).toLowerCase() + javaActionsClassName.substring(1);
        return """
                package pages.pages;
                \s
                import handlingConfigFile.Config;
                import org.openqa.selenium.By;
                import org.openqa.selenium.WebDriver;
                import pages.pagesActions.%s;
                                
                import java.time.Duration;
                import java.util.HashMap;
                import java.util.Map;
                                    
                public class %s {
                    protected WebDriver webDriver;
                    protected final Map<String,By> elementsMap = new HashMap<>();
                                    
                    public %s(WebDriver webDriver) {
                        this.webDriver = webDriver;
                        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeoutDuration));
                        this.defineAllElements();
                    }
                    
                   //Method to return the pageActions
                   public %s %s(){
                       	return new %s(this.webDriver);
                   	}
                   \s
                %s
                \t//Add Other Needed Methods Here
                }
                """.formatted(javaActionsClassName, javaClassName, javaClassName, javaActionsClassName, javaActionsObjectName, javaActionsClassName, elementsContents);
    }

    public static String generatePageActionsJavaClassContent(String javaClassName, Element[] elements) {
        return null;
    }
}
