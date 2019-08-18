package jack.helloworld.mybatis.web.dao;

import jack.helloworld.mybatis.web.mappers.LicenseMapper;
import jack.helloworld.mybatis.web.models.License;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LicenseDao {

    @Autowired
    private SqlSession sqlSession;

    public void getLicense(String id) {
        License license = sqlSession.getMapper(LicenseMapper.class).getLicenseById(id);
        System.out.println("jack.helloworld.mybatis.web.dao.LicenseDao.getLicense " + sqlSession);
        System.out.println(license);
    }

    @Transactional
    public void getLicense1(String id) {
        License license = sqlSession.getMapper(LicenseMapper.class).getLicenseById(id);
        System.out.println("jack.helloworld.mybatis.web.dao.LicenseDao.getLicense " + sqlSession);
        System.out.println(license);
    }




}
