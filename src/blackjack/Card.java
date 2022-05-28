package blackjack;

public class Card {
    private int suit;
    private int rank;
    private int value;

    public Card() { //a default constructor of Card
        suit = 0;
        rank = 0;
        value = 0;
    }
    public Card(Card c) { //a default constructor of Card
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }
    public void copyCard(Card c) { //a default constructor of Card
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }
    public Card(int s, int r) { //a constructor of Card that initializes the main attributes
        suit = s;
        rank = r;
        if(r<10){
            value=r+1;
        }
        else{
            value=10;
        }
    }
    public Card(int s, int r , int v) { //a constructor of Card that initializes the main attributes
        suit = s;
        rank = r;
        value = v;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

}