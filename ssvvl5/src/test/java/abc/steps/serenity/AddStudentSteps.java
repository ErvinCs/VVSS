package abc.steps.serenity;

import abc.pages.StudentPage;
import net.thucydides.core.annotations.Step;
import org.springframework.scheduling.support.SimpleTriggerContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class AddStudentSteps {

    StudentPage studentPage;

    @Step
    public void fillStudent(String studentId, String studentName, String studentGroup, String email, String prof) {
        studentPage.setIdStudent(studentId);
        studentPage.setNameStudent(studentName);
        studentPage.setGrupaStudent(studentGroup);
        studentPage.setEmailStudent(email);
        studentPage.setProfStudent(prof);
    }


    @Step
    public void submit() {
        studentPage.pressAddStudentButton();
    }

    @Step
    public void should_see_definition(String submitted) {
        assertThat(studentPage.getResult(), containsString(submitted));
    }
}
