Spring Boot 学习
主要包括以下内容：
一、自定义登录拦截器
    必须实现HandlerInterceptor
    编写拦截逻辑
二、将拦截器放置到容器中
    定制springMVC的web功能：必须实现WebMvcConfigurer接口
    指定拦截规则
三、文件上传-单文件与多文件上传的使用
    1.文件上传form表单必须设置enctype
     <form action="/upload" method="post" enctype="multipart/form-data">
    2.必须配置上传的文件大小
    spring.servlet.multipart.max-file-size=10MB
    spring.servlet.multipart.max-request-size=100MB
四、spring boot默认错误处理
    1.默认，springboot提供/error页（By default, Spring Boot provides an /error mapping that handles all
     errors in a sensible way）
    2.自定义错误页：（error/下的4xx、5xx会被自动解析）
    (必须导入thymeleaf才能跳转到自定义页面)
    resources/
             +- public/
                 +- error/
                 |   +- 404.html
    或
     +- resources/
             +- templates/
                 +- error/
                 |   +- 5xx.ftlh
                 +- <other templates>
五、自定义异常处理
    1.  @ControllerAdvice  + @ExceptionHandler处理全局异常
        GlobalExceptionHandler（指定特定的异常调到指定页面）
        底层是ExceptionHadlerExceptionResolver支持的
    2.  @ResponseStatus + 自定义异常
        底层是ResponseStatusExceptionREsolber解析的，把responseStatus注解的信息组装成ModelAndView返回
    3.自定义异常解析器（实现HandlerExceptionResolver）
六、web原生组件注入(Servlet、Filter、Listener)
    1.使用Servlet API
        第一种方式：
            @ServletComponentScan(basePackages = "com.qsh")指定原生Servlet组件都放在哪里
            @WebServlet(urlPatterns = "/my")声明了一个Servlet，效果：直接响应，没有经过spring拦截器
            @WebFilter(urlPatterns = ["/hello","/home","css/*"])
            @WebFilter
        第二种方式：
            使用RegistrationBean
        
        
        
    
           
      
    # web02-interceptor
