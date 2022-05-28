package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    //Declare card deck (52 card)
    static Card []cardDeck = new Card[52];
    //Declare 4 player
    static Player []players = new Player[4];

    //initialize card deck
    void GenerateCardDeck(){
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<13 ; j++){
                int index=i*13+j;
                cardDeck[index] = new Card(i,j);
            }
        }
    }

    //initialize 4 player
    void GeneratePlayers(){
        for(int i=0 ; i<4 ; i++){
            players[i] = new Player();
            System.out.println("Enter player "+(i+1)+" name : ");
            Scanner in = new Scanner(System.in);
            String name = in.next();
            players[i].setName(name);
            //Give player[i] two cards from card deck
            givePlayerCard(i);
            givePlayerCard(i);
        }
        System.out.println("");
    }

    //Generate a random  number
    public static int randomNo(){
        Random rand = new Random();
        int randomChoice = rand.nextInt(52);
        return randomChoice;
    }

    public void givePlayerCard(int i){
        Card tempCard = new Card();
        while (true){//Card can draw only one time from card deck
            int no = randomNo();
             if(cardDeck[no] != null && cardDeck[no].getValue() > 0){
                 tempCard.copyCard(cardDeck[no]);
                 cardDeck[no]=null;
                 break;
             }
        }
        players[i].setPlayerCard(tempCard);

        GUI gui = new GUI();
        gui.updatePlayerHand(tempCard, i);
    }

}