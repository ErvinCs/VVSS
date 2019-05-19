package Repository;

import org.junit.Test;

public class BigBangIntegration {

    @Test
    public void testAddStudent(){
        new AddStudentTest().checkName();
        new AddStudentTest().checkProfessor();
        new AddStudentTest().checkId();
        new AddStudentTest().checkGroup();
        new AddStudentTest().checkEmail();
        new AddStudentTest().checkDuplicates();
        new AddStudentTest().addStudent();
    }

    @Test
    public void testAddTheme(){
        new AddTheme().addTheme();
        new AddTheme().checkDeadline();
        new AddTheme().checkDuplicates();
        new AddTheme().checkId();
        new AddTheme().checkSaptPrimire();
    }

    @Test
    public void testAddGrade(){
        new AddGrade().addNota();
        new AddGrade().checkDeadline();
        new AddGrade().checkDuplicate();
        new AddGrade().checkMark();
        new AddGrade().checkSaptPrimire();
    }

    @Test
    public void integrationTest(){
        testAddStudent();
        testAddTheme();
        testAddGrade();
    }
}
