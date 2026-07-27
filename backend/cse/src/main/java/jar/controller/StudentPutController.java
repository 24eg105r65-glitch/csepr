package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class StudentPutController {

    @Autowired
    StudentRepo db;

    @PutMapping()
    Map<Object, Object> putStudent(@RequestBody Student s) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "Put api in separate file");
        String name = s.getName();
        String roll = s.getRoll();
        String ip = s.getIp();
        Student obj = new Student();

        obj.setName(name);
        obj.setRoll(roll);
        obj.setIp(ip);

        db.save(obj);

        return res;
    }
}
