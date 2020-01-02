package jack.helloworld.mybatis.web.dao;

import jack.helloworld.mybatis.web.mappers.OrganizationMapper;
import jack.helloworld.mybatis.web.models.Organization;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrganizationDao {

    @Autowired
    private SqlSession sqlSession;

    public void getOrganization(String organizationId) {
        Organization organization = sqlSession.getMapper(OrganizationMapper.class).selectOrganization(organizationId);
        System.out.println("jack.helloworld.mybatis.web.dao.OrganizationDao.getOrganization " + sqlSession);
        System.out.println(organization);
    }

    @Transactional
    public void getOrganization1(String organizationId) {
        Organization organization = sqlSession.getMapper(OrganizationMapper.class).selectOrganization(organizationId);
        System.out.println("jack.helloworld.mybatis.web.dao.OrganizationDao.getOrganization " + sqlSession);
        System.out.println(organization);
    }
}
