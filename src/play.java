import Model.Model;
import Controller.Controller;
import View.View;

public class play {
    public static void main(String[] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model);
        controller.run();
    }
}
