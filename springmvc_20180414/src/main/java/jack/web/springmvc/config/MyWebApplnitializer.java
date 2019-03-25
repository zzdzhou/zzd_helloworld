package jack.web.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*public class MyWebApplnitializer extends AbstractAnnotationConfigDispatcherServletInitializer*//*implements WebApplicationInitializer*//* {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    *//*@Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class);
        ac.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }*//*
}*/
