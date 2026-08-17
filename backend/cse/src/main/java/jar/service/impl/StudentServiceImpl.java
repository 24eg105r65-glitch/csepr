package jar.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;
import jar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        if (student == null) {
            return null;
        }
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setRoll(student.getRoll());
        newStudent.setIp(student.getIp());
        return studentRepo.save(newStudent);
    }

    @Override
    public Student updateStudent(long id, Student studentDetails) {
        Student existingStudent = getStudentById(id);
        if (existingStudent == null || studentDetails == null) {
            return null;
        }

        if (studentDetails.getName() != null) {
            existingStudent.setName(studentDetails.getName());
        }
        if (studentDetails.getRoll() != null) {
            existingStudent.setRoll(studentDetails.getRoll());
        }
        if (studentDetails.getIp() != null) {
            existingStudent.setIp(studentDetails.getIp());
        }

        return studentRepo.save(existingStudent);
    }

    @Override
    public boolean deleteStudent(long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
