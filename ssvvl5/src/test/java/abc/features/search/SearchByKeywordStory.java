package abc.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import abc.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/WikiTestData.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    public String name;
    public String definition;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Issue("#WIKI-1")
    @Test
    @Ignore
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
    }

    @Issue("#WIKI-2")
    @Test
    public void searchWikiByKeywordTestDDT() {
        anna.is_the_home_page();
        anna.looks_for(getName());
        anna.should_see_definition(getDefinition());
    }

    @Test
    @Ignore
    public void searching_by_keyword_pear_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("banana");
        anna.should_see_definition("An elongated curved tropical fruit that grows in bunches and has a creamy flesh and a smooth skin.\n" +
                "(Canada, US, Britain, Ireland) Especially, the sweet, yellow fruit of the Cavendish banana cultivar.");
    }

    @Test
    public void searching_by_keyword_pineapple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pineapple");
//        addStudentSteps.should_see_definition("An elongated curved tropical fruit that grows in bunches and has a creamy flesh and a smooth skin.\n" +
//                "(Canada, US, Britain, Ireland) Especially, the sweet, yellow fruit of the Cavendish banana cultivar.");
    }

    @Pending @Test
    @Ignore
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
} 