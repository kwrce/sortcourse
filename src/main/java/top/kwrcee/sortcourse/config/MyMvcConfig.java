package top.kwrcee.sortcourse.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.kwrcee.sortcourse.config.component.LoginHandlerInterceptor;
import top.kwrcee.sortcourse.config.component.MyLocalResolver;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("index");
//    }
    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login","/**/*.js","/**/*.css","/webjars");
            }
        };
        return adapter;
    }

    /**
     * 使用自定义的 LocaleResolver
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
