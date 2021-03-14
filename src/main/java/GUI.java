import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;

public class GUI extends JFrame {


    public  GUI(ArrayList<Character> pCharacters)
    {

        //headers for the table
        String[] columns = new String[] {
                 "Nombre", "Altura", "Fecha de nacimiento"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[pCharacters.size()][];
        for (int i = 0; i < pCharacters.size(); i++){
            data[i] = pCharacters.get(i).toObjectArray();
        }
        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));
        this.setTitle("Personajes de StarWars");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
