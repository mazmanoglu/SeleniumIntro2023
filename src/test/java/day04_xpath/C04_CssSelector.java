package day04_xpath;

public class C04_CssSelector {
    public static void main(String[] args) {
        /*
        CssSelector is the 8th locator, and very similar to XPath.
        XPath           : //tagName[@attributeName='attributeValue']
        CssSelector     : tagName[attributeName='attributeValue']

        - xpath is stronger than CssSelector
        - We can search the locators we wrote with Xpath in HTML codes, but CssSelector gives sometimes errors
        - If we use id when we create CssSelector;
        XPath           : //tagName[@id='attributeValue']
        CssSelector     : "#attributeValue"

        - or use class
        XPath           : //tagName[@class='attributeValue']
        CssSelector     : ".attributeValue"
         */
    }
}
