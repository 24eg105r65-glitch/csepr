package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.service.StudentService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class Delete {

    @Autowired
    private StudentService studentService;

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return "Student deleted ";
        }
        return "Student not found";
    }
}
