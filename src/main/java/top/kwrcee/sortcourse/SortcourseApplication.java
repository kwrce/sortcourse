package top.kwrcee.sortcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SortcourseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SortcourseApplication.class, args);
    }
    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}

