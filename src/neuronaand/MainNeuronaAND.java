package neuronaand;
/**
 *
 * @author dizan
 */
public class MainNeuronaAND {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewNeuronaAND viewNeuronaAnd = new ViewNeuronaAND();
        viewNeuronaAnd.setVisible(true);
       ControlViewNeuronaAND controlView = new ControlViewNeuronaAND(viewNeuronaAnd);
    }
    
}
