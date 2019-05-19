package abc.features.search;

import abc.steps.serenity.AddStudentSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class AddStudent {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public AddStudentSteps addStudentSteps;


    @Test
    public void fill_in_a_valid_student() {

        addStudentSteps.fillStudent("1234", "Ionel", "933","eme@.com","da");
        addStudentSteps.submit();
        addStudentSteps.should_see_definition("Submitted");
    }

    @Test
    public void fill_in_a_invalid_student() {

        addStudentSteps.fillStudent("-123","A","0", "sf", "sdf");
        addStudentSteps.submit();
        addStudentSteps.should_see_definition("Submitted");

    }

}