import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener {
    private  int WIDTH;
    private  int HEIGHT;

    private BufferedImage backgroundImage;
    private BufferedImage snakeBodyImage;

    private static final int UNIT_SIZE = 25;
    private static final int DELAY = 200;

    private final List<Integer> snakeX;
    private final List<Integer> snakeY;
    private int appleX;
    private int appleY;
    private char direction;
    private boolean isRunning;
    private Timer timer;
    private int score;

    public GamePanel() {
        setFocusable(true);
        Dimension panelSize=getMaximumSize();
        WIDTH=(int) panelSize.getWidth()/24-20;
        HEIGHT= (int)panelSize.getHeight()/37+25;
        snakeX = new ArrayList<>();
        snakeY = new ArrayList<>();
        direction = 'R';
        isRunning = false;
        score = 0;
        setBorder(BorderFactory.createLineBorder(new Color(15, 179, 31), 10));
        try {
            snakeBodyImage = ImageIO.read(new File("src/snake.png"));
            backgroundImage = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addKeyListener(this);
        startGame();
    }


    public void startGame() {
        snakeX.clear();
        snakeY.clear();
        snakeX.add(0); // starting head position
        snakeY.add(0);
        generateApple();
        isRunning = true;
        timer = new Timer(DELAY, e -> gameLoop());
        timer.start();
//        gameLoop();
    }

    public void gameLoop() {
        if (!isRunning) {
            timer.stop();
            return;
        }
        move();
        checkCollision();
        repaint();

    }

    public void move() {
        for (int i = (snakeX.size()) - 1; i > 0; i--) {
            snakeX.set(i, snakeX.get(i - 1));
            snakeY.set(i, snakeY.get(i - 1));
        }

        switch (direction) {
            case 'U' : snakeY.set(0, snakeY.get(0) - UNIT_SIZE);
            case 'D' : snakeY.set(0, snakeY.get(0) + UNIT_SIZE);
            case 'L' : snakeX.set(0, snakeX.get(0) - UNIT_SIZE);
            case 'R' : snakeX.set(0, snakeX.get(0) + UNIT_SIZE);
        }
    }

    public void checkCollision() {
        // Check if snake collides with itself
        for (int i = 1; i < (snakeX.size()); i++) {
            if (snakeX.get(i).equals(snakeX.get(0)) && snakeY.get(i).equals(snakeY.get(0))) {
                isRunning = false;
                break;
            }
        }

        // Check if snake collides with the boundaries
        if (snakeX.get(0) < 0 || (snakeX.get(0) )>= WIDTH-5 || (snakeY.get(0)) < 0 || (snakeY.get(0))>= HEIGHT-5) {
            isRunning = false;
        }

        // Check if snake collides with the apple
        if (snakeX.get(0).equals(appleX) && snakeY.get(0).equals(appleY)) {
            // Increase the score and generate a new apple
            score++;
            generateApple();

            // Grow the snake by adding a new segment
            snakeX.add(snakeX.get(snakeX.size() - 1));
            snakeY.add(snakeY.get(snakeY.size() - 1));
        }
    }

    public void generateApple() {
//generates the position of apple
            Random random = new Random();
            appleX = random.nextInt(((WIDTH - 10) / UNIT_SIZE)) * UNIT_SIZE;
            appleY = random.nextInt(((HEIGHT - 10) / UNIT_SIZE)) * UNIT_SIZE;

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0,  WIDTH,HEIGHT, this);
        }
        for (int i = 0; i < snakeX.size(); i++) {
            if (i == 0) {
                g.drawImage(snakeBodyImage, snakeX.get(i)+10, snakeY.get(i)+10, UNIT_SIZE, UNIT_SIZE, this);
            } else {
                g.setColor(Color.green);
                g.fillRect(snakeX.get(i)+10, snakeY.get(i)+10, UNIT_SIZE, UNIT_SIZE);
            }
        }

        // Draw the apple
        if(isRunning) {
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            this.repaint();
        }
        // Game over message
        if (!isRunning && snakeX.size()>0) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over",  WIDTH / 2 - 100, HEIGHT / 2);
            this.repaint();
        }
        if(!isRunning){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 60));
            g.drawString("Start Game",  WIDTH / 2-120 , HEIGHT / 2);
            this.repaint();
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP  && direction != 'D') {
            direction = 'U';
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != 'U') {
            direction = 'D';
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != 'R') {
            direction = 'L';
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != 'L') {
            direction = 'R';
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    //starting game after user selected new game in taskbar new game button
//    public void getStart(boolean start){
//        if(start){
//            startGame();
//        }
//        else{
//            isRunning=false;
//        }
//    }
}
