package jar.service;

import java.util.List;
import jar.model.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student saveStudent(Student student);

    Student updateStudent(long id, Student student);

    boolean deleteStudent(long id);
}
