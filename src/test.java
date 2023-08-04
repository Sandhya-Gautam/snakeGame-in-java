import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class test extends JFrame implements KeyListener {
    private static final int BOARD_SIZE = 20;
    private static final int TILE_SIZE = 20;
    private static final int GAME_SPEED = 150; // Time delay between each game update (in milliseconds)

    private ArrayList<Point> snake;
    private Point food;
    private int direction;
    private Timer timer;
    private boolean gameRunning;

    public test() {
        setTitle("Simple Snake Game");
        setSize(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);

        snake = new ArrayList<>();
        snake.add(new Point(BOARD_SIZE / 2, BOARD_SIZE / 2));
        direction = KeyEvent.VK_RIGHT; // Default direction is right

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.NORTH);

        gameRunning = false;
        timer = new Timer(GAME_SPEED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameRunning) {
                    moveSnake();
                    checkCollisions();
                    repaint();
                }
            }
        });

        generateFood();
    }

    private void startGame() {
        snake.clear();
        snake.add(new Point(BOARD_SIZE / 2, BOARD_SIZE / 2));
        direction = KeyEvent.VK_RIGHT;
        gameRunning = true;
        generateFood();
        timer.start();
        requestFocusInWindow();
    }

    private void moveSnake() {
        Point head = snake.get(0);
        Point newHead = new Point(head);
        switch (direction) {
            case KeyEvent.VK_UP:
                newHead.y--;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y++;
                break;
            case KeyEvent.VK_LEFT:
                newHead.x--;
                break;
            case KeyEvent.VK_RIGHT:
                newHead.x++;
                break;
        }

        snake.add(0, newHead);
        if (!newHead.equals(food)) {
            snake.remove(snake.size() - 1);
        } else {
            generateFood();
        }
    }

    private void generateFood() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(BOARD_SIZE);
            y = random.nextInt(BOARD_SIZE);
        } while (snake.contains(new Point(x, y)));
        food = new Point(x, y);
    }

    private boolean collides(Point p1, Point p2, int distance) {
        return Math.abs(p1.x - p2.x) < distance && Math.abs(p1.y - p2.y) < distance;
    }

    private void checkCollisions() {
        Point head = snake.get(0);
        for (int i = 1; i < snake.size(); i++) {
            if (collides(head, snake.get(i), 1)) {
                endGame();
                return;
            }
        }

        if (head.x < 0 || head.x >= BOARD_SIZE || head.y < 0 || head.y >= BOARD_SIZE) {
            endGame();
        }
    }

    private void endGame() {
        gameRunning = false;
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your Score: " + (snake.size() - 1));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Point p : snake) {
            g.setColor(Color.GREEN);
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
            direction = KeyEvent.VK_UP;
        } else if (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
            direction = KeyEvent.VK_DOWN;
        } else if (key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
            direction = KeyEvent.VK_LEFT;
        } else if (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
            direction = KeyEvent.VK_RIGHT;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            test game = new test();
            game.setVisible(true);
        });
    }
}

