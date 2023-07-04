import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Load the image for the pattern
        BufferedImage patternImage = null;
        try {
            patternImage = ImageIO.read(new File("border.png")); // Replace with the path to your image
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a custom border using the image pattern
        Border imagePatternBorder = new CustomImagePatternBorder(patternImage, 10); // Replace 10 with desired border width

        // Apply the custom border to the panel
        panel.setBorder(BorderFactory.createCompoundBorder(imagePatternBorder, new EmptyBorder(10, 10, 10, 10))); // Replace 10 with desired padding

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Custom Border implementation that uses an image pattern
    private static class CustomImagePatternBorder implements Border {
        private BufferedImage image;
        private int borderWidth;

        public CustomImagePatternBorder(BufferedImage image, int borderWidth) {
            this.image = image;
            this.borderWidth = borderWidth;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            int imgWidth = image.getWidth();
            int imgHeight = image.getHeight();

            for (int i = 0; i < width; i += imgWidth) {
                for (int j = 0; j < height; j += imgHeight) {
                    g.drawImage(image, x + i, y + j, null);
                }
            }
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
}

