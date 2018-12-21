package service.impl;

import dao.UserDao;
import entity.user.BaseRole;
import entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Repository
public abstract class BaseUserServiceImpl<T extends BaseRole> implements UserService<T> {

    protected UserDao<T> dao;
    public abstract BaseUserServiceImpl setDao(UserDao<T> dao);

    @Override
    public Optional<T> get(int id) {
        return dao.get(id);
    }

    @Override
    public T login(T user) {
        Optional<T> userOptional = dao.get(user.getId());
        if (userOptional.isPresent()){
            T user1 = userOptional.get();
            if (user1.getPassword().equals(user.getPassword())) {
                return user1;
            }
        }
        return null;
    }

    @Override
    @Valid
    public boolean register(T user) {
        return dao.register(user);
    }

    @Override
    public boolean add(T user) {
        return register(user);
    }

    @Override
    public boolean delete(T user) {
        return dao.delete(user.getId());
    }

    @Override
    @Valid
    public boolean update(T user) {
        return dao.update(user);
    }


}
