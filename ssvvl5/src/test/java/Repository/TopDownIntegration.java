package Repository;

import org.junit.Test;

public class TopDownIntegration {

    @Test
    public void testAddStudentTopDown(){
        new AddStudentTest().checkName();
        new AddStudentTest().checkProfessor();
        new AddStudentTest().checkId();
        new AddStudentTest().checkGroup();
        new AddStudentTest().checkEmail();
        new AddStudentTest().checkDuplicates();
        new AddStudentTest().addStudent();
    }

    @Test
    public void testAddThemeTopDown(){
        testAddStudentTopDown();
        new AddTheme().addTheme();
        new AddTheme().checkDeadline();
        new AddTheme().checkDuplicates();
        new AddTheme().checkId();
        new AddTheme().checkSaptPrimire();
    }

    @Test
    public void testAddGradeTopDown(){
        testAddThemeTopDown();
        new AddGrade().addNota();
        new AddGrade().checkDeadline();
        new AddGrade().checkDuplicate();
        new AddGrade().checkMark();
        new AddGrade().checkSaptPrimire();
    }

    @Test
    public void integrationTest(){
        testAddGradeTopDown();
    }
}
