import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {
	private	static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("================ App on startup ===================");
		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setConfigLocation("/WEB-INF/spring/server-context.xml");
		ServletRegistration.Dynamic reDynamic = servletContext.addServlet("rootDispatcher",
				new DispatcherServlet(applicationContext));
		reDynamic.setLoadOnStartup(1);
		reDynamic.addMapping("/");
		
	}

}
