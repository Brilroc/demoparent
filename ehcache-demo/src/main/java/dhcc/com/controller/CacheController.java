package dhcc.com.controller;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * Created by wangpenghui on 2020/1/3
 */
@RestController
public class CacheController {

    @RequestMapping("cache")
    public String CacheTest() {
        String path = System.getProperty("user.dir");
        //1.创建缓存管理器
        CacheManager cacheManager = CacheManager.create(path+"/ehcache-demo/src/main/resources/ehcache.xml");

        //2.获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        //3.创建元素
        Element element = new Element("name", "dayu");

        //4.将元素添加到缓存
        cache.put(element);

        //5.获取缓存
        Element value = cache.get("name");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        //6.删除元素
        cache.remove("name");

        System.out.println(cache.getSize());

        Element element2 = new Element("age", "18");
        Element element3 = new Element("age2", "18");
        Element element4 = new Element("age3", "18");
        cache.put(element2);
        cache.put(element3);
        cache.put(element4);

        //7.刷新缓存
        cache.flush();

        //8.关闭缓存管理器
        cacheManager.shutdown();

        return "success";
    }
}
