package entity.user;

import entity.Course;
import entity.collective.StudentClass;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher extends BaseRole {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> courses;

    @OneToOne(mappedBy = "headmaster", cascade = CascadeType.ALL)
    private StudentClass studentClass;

    public Teacher() {
        super();
        getUser().setRole(Role.TEACHER);
        getUser().setRoleInfo(this);
    }

    public Teacher(User user) {
        super(user);
        getUser().setRole(Role.TEACHER);
        getUser().setRoleInfo(this);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public Teacher setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
        return this;
    }
}
