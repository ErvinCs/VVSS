package web;

import Service.ServiceStudent;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import Service.Service;

public class MServer {

    private final Server server;

    public static void main(String[] args)
    {
//        MServer server = new MServer(8080);
//        server.setHandler(new MServer());
//
//        server.start();
//        server.join();

//        MServer();
        return;
    }

    public MServer(Service service) {
        server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new StudentServlet()),"/student/*");
        context.addServlet(new ServletHolder(new AddStudentServlet(service)),"/addStudent/*");
        context.addServlet(new ServletHolder(new DeleteStudentServlet(service)),"/deleteStudent/*");
        context.addServlet(new ServletHolder(new ListStudentServlet(service)),"/students/*");

        server.setHandler(context);
//
//        HandlerList handlers = new HandlerList();
//
//        ResourceHandler resourceHandler = new ResourceHandler();
//        resourceHandler.setBaseResource(Resource.newResource("."));
//        handlers.setHandlers(new Handler[]
//                { resourceHandler, new DefaultHandler() });


    }

    public void run() {
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
