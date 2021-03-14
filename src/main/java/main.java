import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                ArrayList<Character> characters = new ArrayList<>();
                try {
                    characters = new StarWarsAPI().getAllStarWarsCharacterAsJson();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new GUI(characters);
            }
        });
    }
}
