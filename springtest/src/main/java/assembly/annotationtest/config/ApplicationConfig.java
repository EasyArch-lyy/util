package assembly.annotationtest.config;

import assembly.annotationtest.pojo.Role;
import assembly.annotationtest.service.impl.RoleServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.Properties;

//@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class})

@ComponentScan(basePackages = {"assembly.annotationtest.pojo", "assembly.annotationtest.service", "assembly.annotationtest.anto"})
public class ApplicationConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties prop = new Properties();
        prop.setProperty("driver", "com.mysql.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://192.168.56.3:3306/ssm");
        prop.setProperty("username", "root");
        prop.setProperty("password", "072012");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
