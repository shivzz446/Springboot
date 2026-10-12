
package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    public List<Student> users = new ArrayList<>();

    @PostMapping
    public String AddUser(@RequestBody Student u) {
        users.add(u);
        return "Added " + u.getName();
    }

    @GetMapping
    public List<Student> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable Long id) {
        for (Student u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable Long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                return "Deleted user " + id;
            }
        }
        return "User not found";
    }
}
