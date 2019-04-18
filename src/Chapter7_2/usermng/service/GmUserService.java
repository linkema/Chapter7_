package Chapter7_2.usermng.service;

import Chapter7_2.usermng.dao.DaoFactory;
import Chapter7_2.usermng.dao.GMUserDao;
import Chapter7_2.usermng.domain.User;

public class GmUserService {
    private GMUserDao gmUserDao= DaoFactory.getGMDao();
    public User login (User form)throws UserException{
        User user=gmUserDao.findByUsername(form.getUsername());
        if(!user.getPassword().equals(form.getPassword())) {
            throw new UserException("密码错误！");
        }
        return user;
    }
}
