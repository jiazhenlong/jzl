package com.shop.api.base.cfg;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;  
  

/**  
 * Druid的DataResource配置类  
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，  
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")  
 * 获取application配置文件中的变量。 这里采用第一种要方便些  
 * Created by sun on 2017-1-20.  
 */  
@Configuration  
@ServletComponentScan 
@EnableTransactionManagement  
public class DruidDataSourceConfig implements EnvironmentAware {  
  
  
    private RelaxedPropertyResolver propertyResolver;  
  
    public void setEnvironment(Environment env) {  
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");  
    }  
  
    @Bean(destroyMethod = "close", initMethod = "init")  
    public DataSource dataSource() {  
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(propertyResolver.getProperty("url"));  
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));  
        datasource.setUsername(propertyResolver.getProperty("username"));  
        datasource.setPassword(propertyResolver.getProperty("password"));  
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));  
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));  
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));  
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));  
        datasource.setMinEvictableIdleTimeMillis(  
                Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));  
        try {  
            datasource.setFilters("stat,wall");  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return datasource;  
    }  
  
    @Bean  
    public ServletRegistrationBean druidServlet() {  
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();  
        servletRegistrationBean.setServlet(new StatViewServlet());  
        servletRegistrationBean.addUrlMappings("/druid/*");  
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "192.168.2.25,127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "mayun");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;  
    }   
  
    @Bean  
    public FilterRegistrationBean filterRegistrationBean() {  
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
        filterRegistrationBean.setFilter(new WebStatFilter());  
        filterRegistrationBean.addUrlPatterns("/*");  
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");  
        return filterRegistrationBean;  
    }  
  
    // 按照BeanId来拦截配置 用来bean的监控  
    @Bean(value = "druid-stat-interceptor")  
    public DruidStatInterceptor DruidStatInterceptor() {  
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();  
        return druidStatInterceptor;  
    }  
  
    @Bean  
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {  
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();  
        beanNameAutoProxyCreator.setProxyTargetClass(true);  
        // 设置要监控的bean的id  
        //beanNameAutoProxyCreator.setBeanNames("sysRoleMapper","loginController");  
        beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");  
        return beanNameAutoProxyCreator;  
    }  
  
}  
