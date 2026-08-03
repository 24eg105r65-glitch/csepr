package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class Delete {

    @Autowired
    StudentRepo db;

    @DeleteMapping("/delete/{id}")
    public Map<Object, Object> deleteStudent(@PathVariable int id) {
        Map<Object, Object> res = new HashMap<>();
        
        Optional<Student> optionalStudent = db.findById((long) id);
        
        if (optionalStudent.isPresent()) {
            db.deleteById((long) id);
            res.put("msg", "Delete successful");
            res.put("status", 200);
        } else {
            res.put("msg", "Student not found with id: " + id);
            res.put("status", 404);
        }

        return res;
    }
}
