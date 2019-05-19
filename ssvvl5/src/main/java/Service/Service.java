package Service;

import Domain.*;
import Repository.*;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Service {
    private StudentRepo studentRepo;

    public Service(StudentRepo studentXmlRepo) {
        this.studentRepo = studentXmlRepo;
    }

    public Iterable<Student> findAllStudents() { return studentRepo.findAll(); }

    public int saveStudent(String id, String nume, int grupa, String em, String prof) {
        Student student = new Student(id, nume, grupa, em, prof);
        Student result = studentRepo.save(student);

        if (result == null) {
            return 1;
        }
        return 0;
    }

    public int deleteStudent(String id) {
        Student result = studentRepo.delete(id);

        if (result == null) {
            return 0;
        }
        return 1;
    }

}
