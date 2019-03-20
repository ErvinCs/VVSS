package Lab2Maven;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Validator.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        assertTrue( true );
    }

    @Test
    public void addStudent() {
        List<Student> studentList = new ArrayList<>();
        Validator<Student> studentValidator = new StudentValidator();

        Student student = new Student("1","name",932,"Lemne@.com","Prof");
        if (studentValidator.validate(student).equals("")) {
                studentList.add(student);
        }
        assertEquals(1, studentList.size());

        Student student1 = new Student("1","name",1032,"Lemne","Prof");
        if (studentValidator.validate(student1).equals("")) {
            studentList.add(student);
        }
        assertEquals(1, studentList.size());
    }

    @Test
    public void addTheme() {
        List<Teme> temeList = new ArrayList<>();
        Validator<Teme> temeValidator = new TemeValidator();

        Teme teme= new Teme(123,"fgdfgd",12,12);
        if (temeValidator.validate(teme).equals("")){
            temeList.add(teme);
        }
        assertEquals(1, temeList.size());

        Teme teme1 = new Teme(1,"dfgfdgfdg",16,16);
        if (temeValidator.validate(teme1).equals("")){
            temeList.add(teme1);
        }
        assertEquals(1, temeList.size());
    }

    @Test
    public void findStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1","sgdfg",932,"e@.com","sdfdg"));
        students.add(new Student("2","sgdfg",932,"e@.com","sdfdg"));

        assertEquals(0, students.indexOf(new Student("1","sgdfg",932,"e@.com","sdfdg")));
        assertEquals(-1, students.indexOf(new Student("71","shtyjgdfg",932,"e@.com","sdfdg")));

    }
}
