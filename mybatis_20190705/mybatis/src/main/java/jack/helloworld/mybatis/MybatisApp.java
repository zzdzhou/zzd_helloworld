package jack.helloworld.mybatis;

import jack.helloworld.mybatis.mappers.LicenseMapper;
import jack.helloworld.mybatis.mappers.OrganizationMapper;
import jack.helloworld.mybatis.models.License;
import jack.helloworld.mybatis.models.Organization;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.rmi.dgc.Lease;

public class MybatisApp {

    public static void main(String[] args) {

    }

    private static SqlSession sqlSession;
    private static final String mybatisConfigLocation = "mybatis-config.xml";

    private static SqlSession getSqlSession() throws IOException {
        if (sqlSession == null) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(mybatisConfigLocation));
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }

    @Test
    public void selectOrganization() throws IOException {
        String id = "442adb6e-fa58-47f3-9ca2-ed1fecdfe86c";
        Organization organization = getSqlSession().getMapper(OrganizationMapper.class).selectOrganization(id);
        System.out.println(organization);
    }

    @Test
    public void selectLicense() throws IOException {
        String id = "08dbe05-606e-4dad-9d33-90ef10e334f9";
        License license = getSqlSession().getMapper(LicenseMapper.class).getLicenseById(id);
        System.out.println(license);
    }

    @Test
    public void selectLicenseWithOrganization() throws IOException {
        String licenseId = "08dbe05-606e-4dad-9d33-90ef10e334f9";
        License license = getSqlSession().getMapper(LicenseMapper.class).selectLicenseWithOrganization(licenseId);

        System.out.println(license.getProductName());
//        System.out.println(license.getOrganizationId().getContactEmail());
        System.out.println(license.getOrganizationId());
    }

}
