package grailscache

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import net.sf.ehcache.CacheManager
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.ehcache.EhCacheCacheManager
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean
import org.springframework.cache.interceptor.CacheResolver
import org.springframework.cache.interceptor.SimpleCacheResolver
import org.springframework.cache.jcache.JCacheCacheManager
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import org.springframework.core.io.Resource

@Configuration
@EnableCaching
@ComponentScan(basePackages = "com.tothenew.grailsCache.*")
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Primary
    @Bean
    @Scope("singleton")
    public SimpleCacheManager cacheManager() {
        println "1"
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<ConcurrentMapCache> cacheList = []
        cacheList.add(new ConcurrentMapCache("mess"))
        cacheList.add(new ConcurrentMapCache("fetchAuthorByName"))
        cacheManager.setCaches(cacheList);

        println "1 1"
        return cacheManager;

    }

//
//    @Primary
//    @Bean(name = "cacheManager")
//    @Scope("singleton")
//    public EhCacheCacheManager cacheManager(){
//        println "1"
//        return  new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
//        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
//        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
//        return cacheManager;
//    }
//
//    @Bean
//    EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        println "2"
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        Resource resource = new org.springframework.core.io.ClassPathResource("ehcache.xml")
//        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        ehCacheManagerFactoryBean.setConfigLocation(resource);
//        ehCacheManagerFactoryBean.setShared(true);
//        return ehCacheManagerFactoryBean;
//    }

//    @Bean
//    CacheResolver cacheResolver(CacheManager cacheManagerFromID) {
//        println "3"
//        return new SimpleCacheResolver(cacheManagerFromID);
//    }
}