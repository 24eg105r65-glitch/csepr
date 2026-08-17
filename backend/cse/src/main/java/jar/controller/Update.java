package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class Update {

    @Autowired
    private StudentService studentService;

    @PutMapping({"/update/{id}", "/api/v1/update/{id}", "/api/v1/{id}"})
    public Map<String, Object> updateStudent(@PathVariable long id, @RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent != null) {
            response.put("status", 200);
            response.put("msg", "update api");
            response.put("result", "user updated ");
        } else {
            response.put("status", 404);
            response.put("msg", "update api");
            response.put("result", "user not found");
        }

        return response;
    }
}
