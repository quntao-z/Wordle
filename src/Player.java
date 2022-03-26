/**
 * This class represents a Player object
 *
 * @author Quntao Zheng
 */
public class Player {
    /** The name of the player */
    private String name;
    /** The score of the player */
    private int score;

    /**
     * Instantiates a Player object
     * @param name The name of the player
     */
    public Player(String name){
        this.name = name;
        score = 0;
    }

    /**
     * Return the player's name
     * @return The name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Return the player's score
     * @return The score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player
     * @param score The new score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }
}
