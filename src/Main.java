import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            new GameFrame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}



