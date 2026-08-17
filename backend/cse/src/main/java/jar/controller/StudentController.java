package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.service.StudentService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Map<String, Object> getAllStudents() {
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "Get api");
        response.put("list", studentService.getAllStudents());
        return response;
    }

    @PostMapping
    public Map<String, Object> createStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        studentService.saveStudent(student);
        response.put("msg", "Post api");
        return response;
    }
}
