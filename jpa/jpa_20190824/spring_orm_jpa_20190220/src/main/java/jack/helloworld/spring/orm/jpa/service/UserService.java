package jack.helloworld.spring.orm.jpa.service;

import jack.helloworld.spring.orm.jpa.dao.RUserDao;
import jack.helloworld.spring.orm.jpa.dao.UserDao;
import jack.helloworld.spring.orm.jpa.entity.EUser;
import jack.helloworld.spring.orm.jpa.entity.remotedb.RUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-03-06
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RUserDao rUserDao;

//    @Transactional
    public void save2User(EUser eUser, RUser rUser) {
        try {
            userDao.addUser(eUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
//            rUser.setId(1);
            rUserDao.addUser(rUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
