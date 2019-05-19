import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.*;
import UI.UI;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import web.MServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        runCLI();
    }

    private static void runCLI() {
        String dirPath = System.getProperty("user.dir");
        //System.out.println("Present Project Directory : " + dirPath);

        StudentRepo rep = new StudentRepo(new StudentValidator(),"studenti.xml",true);
        TemeRepo repo = new TemeRepo(new TemeValidator(), "teme.xml",true);
        NoteRepo r = new NoteRepo(new NotaValidator());
        ServiceStudent srv = new ServiceStudent(rep);
        ServiceTeme serv = new ServiceTeme(repo);
        ServiceNote sv = new ServiceNote(r);
        UI ui = new UI(srv,serv,sv);
        try {
            ui.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World!" );


        Service service = new Service(rep);
//        UI consola = new UI(service);
//        consola.run();

        MServer server = new MServer(service);
        server.run();
    }
}