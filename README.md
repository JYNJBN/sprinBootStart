# SpringBoot速成小结

视频链接：
https://www.bilibili.com/video/BV1m84y1w7Tb/?p=175&spm_id_from=pageDriver&vd_source=33b877c0642e37bc533ef5f191ac881d

## 项目结构说明

``mysqlTable里面存放着数据库的表结构，nginx-1.22.0里面存放着前端的资源http://localhost:90/#/login pom.xml里面是后端的依赖文件类似于vue的yarn.lock。src里面存放的是后端的代码。``

``其中src里面的mian目录里面存放着后端的代码，test目录里面存放着后端的测试代码。``

``mian目录里面resources目录主要关注application.yml文件，里面存放着后端的配置文件。还有一个于java目录里包结构相同的mapper文件夹主要是一些处理数据库操作的xml文件。``

``最关键的就是java目录了，其中config文件里面放了拦截器的配置文件这里主要是用于定义拦截器作用的controller，interceptor里放了拦截器的操作文件，filter里面放了过滤器，它们都是用于拦截controller层的请求去做前置处理如校验JWT``

```controller层用于接受前端请求，然后调用service层进行业务处理调用mapper层，mapper层用于操作数据库，最后返回给前端```

```exception里放了异常处理类，用于处理controller层抛出的异常```

```pojo里放了实体类，用于封装数据库的表结构```
