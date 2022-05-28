package blackjack;

public class Player {
    private String name ;
    private int Score;
    private Card [] playerCard = new Card[11];

    public Player() {
        name = null;
        Score = 0;
        for (int i=0 ; i<11 ; i++)
        {
            playerCard[i] = new Card();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public Card[] getPlayerCard() {
        return playerCard;
    }

    int cardNo = 0;
    public void setPlayerCard(Card tempCard ) {
        this.playerCard[cardNo] = new Card(tempCard);
        Score +=playerCard[cardNo].getValue();
        cardNo++;
    }

    public int getCardNo() {
        return cardNo;
    }
}

    
    
