package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class Update {

    @Autowired
    StudentRepo db;

    @PutMapping("/update/{id}")
    public Map<Object, Object> updateStudent(@RequestBody Student dto, @PathVariable int id) {
        Map<Object, Object> res = new HashMap<>();
        
        Optional<Student> optionalStudent = db.findById((long) id);
        
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            if (dto.getName() != null) {
                existingStudent.setName(dto.getName());
            }
            if (dto.getRoll() != null) {
                existingStudent.setRoll(dto.getRoll());
            }
            if (dto.getIp() != null) {
                existingStudent.setIp(dto.getIp());
            }
            db.save(existingStudent);
            res.put("msg", "Update successful");
            res.put("student", existingStudent);
        } else {
            res.put("msg", "Student not found with id: " + id);
        }

        return res;
    }
}
