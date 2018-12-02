package service;

import entity.user.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
class StudentServiceTest {

    @Autowired
    StudentService service;

    @Test
    void loginTest() {
        Assertions.assertTrue(service.login(1, "123"));
        Assertions.assertFalse(service.login(1, "456"));
    }

    @Test
    void registerTest(){
        Student student = (Student) new Student()
                .setName("student1")
                .setPassword("123");
        Assertions.assertTrue(service.register(student));
        Assertions.assertTrue(service.login(student));
    }


}
