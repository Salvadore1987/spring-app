package uz.salvadore.spring.app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import uz.salvadore.spring.app.beans.JdbcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// Класс для инициализации сервлета заменяет web.xml
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(JdbcConfigurer.class);

        // Manage the lifecycle of the root application context
        ctx.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(SpringConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
