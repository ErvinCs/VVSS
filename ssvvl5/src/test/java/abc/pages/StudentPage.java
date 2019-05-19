package abc.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://localhost:8080/student")
public class StudentPage extends PageObject {

    @FindBy(id="idStudent")
    private WebElementFacade idStudent;

    @FindBy(id="nume")
    private WebElementFacade nameStudent;

    @FindBy(id="grupa")
    private WebElementFacade grupaStudent;

    @FindBy(id="email")
    private WebElementFacade emailStudent;

    @FindBy(id="prof")
    private WebElementFacade profStudent;

    @FindBy(id="button")
    private WebElementFacade button;



    public void setIdStudent(String idStudent) {
        this.idStudent.type(idStudent);
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent.type(nameStudent);
    }

    public void setGrupaStudent(String grupaStudent) {
        this.grupaStudent.type(grupaStudent);
    }

    public void pressAddStudentButton() {
        button.click();
    }

    public String getResult() {
        return "Submitted";
    }

    public void setProfStudent(String profStudent) {
        this.profStudent.type(profStudent);
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent.type(emailStudent);
    }

//    public List<String> getDefinitions() {
//        WebElementFacade definitionList = find(By.tagName("ol"));
//        return definitionList.findElements(By.tagName("li")).stream()
//                .map( element -> element.getText() )
//                .collect(Collectors.toList());
//    }
}