package service.impl;

import dao.UserDao;
import entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.Collection;

@Service
@Repository
public class StudentServiceImpl extends UserServiceImpl<Student> implements StudentService {

    @Override
    @Autowired
    @Qualifier("studentDaoImpl")
    public UserServiceImpl setUserDao( UserDao<Student> userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public Collection<Student> get() {
        return userDao.get();
    }
}
