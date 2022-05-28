package blackjack;

import java.util.Scanner;

public class BlackJack {
    static Game game = new Game();
    static GUI gui = new GUI();
    static Scanner in = new Scanner(System.in);
    static int highScore=0, highScoreIndex=-1;

    public static void main(String[] args) {
        game.GenerateCardDeck();
        game.GeneratePlayers();
        gui.runGUI( game.cardDeck, game.players[0].getPlayerCard(), game.players[1].getPlayerCard(), game.players[2].getPlayerCard(), game.players[3].getPlayerCard() );

        playerTurn();
        dealerTurn();

        winnerOrPush();
    }

    public static void playerTurn(){
        //Turn for each player
        for(int i=0 ; i<3 ; i++){
            System.out.println(game.players[i].getName()+"\'s turn . . .");
            while (true){
                System.out.println("Score=" + game.players[i].getScore());
                if(game.players[i].getScore()==21){
                    System.out.println("Score=" + game.players[i].getScore() +" Blackjack");
                    break;
                }
                else if(game.players[i].getScore()>21){
                    System.out.println(game.players[i].getName()+" is Busted.  Player's hand score to "+game.players[i].getScore());
                    game.players[i].setScore(0);
                    break;
                }
                System.out.println("please enter your choice : ");
                System.out.println("1) Hit ");
                System.out.println("2) Stand ");
                int choice = in.nextInt();
                if(choice == 1 ) {//Hit
                    System.out.println("Hit! Dealer is giving the player a card. . .");
                    game.givePlayerCard(i);
                }
                else{
                    System.out.println("Stand! "+game.players[i].getName()+"\'s turn is now over. Player's hand score to "+game.players[i].getScore());
                    break;
                }
            }

            if(game.players[i].getScore()>highScore)
            {
                highScore = game.players[i].getScore();
                highScoreIndex = i;
            }
            System.out.println();
        }
    }
    
    public static void dealerTurn(){
        //Dealer turn . . .
        System.out.println(game.players[3].getName()+", the dealer is drawing cards...");
        boolean isDraw = false;
        while (game.players[3].getScore()<=highScore && game.players[3].getScore()!=21){
            game.givePlayerCard(3);
            gui.updateDealerHand(game.players[3].getPlayerCard()[game.players[3].getCardNo()-1], game.cardDeck);
            isDraw = true;
        }
        if(!isDraw){
            gui.updateDealerHand(game.players[3].getPlayerCard()[game.players[3].getCardNo()-1], game.cardDeck);
        }

        if(game.players[3].getScore()<21 ){
            System.out.println(game.players[3].getName()+"\'s turn is now over. Player's hand score to "+game.players[3].getScore());
        }
        else if(game.players[3].getScore()==21){
            System.out.println("Score=" + game.players[3].getScore() +" Blackjack");
        }
        else if(game.players[3].getScore()>21){
            System.out.println(game.players[3].getName()+" is Busted.  Player's hand score to "+game.players[3].getScore());
            game.players[3].setScore(0);
        }

        if(game.players[3].getScore()>highScore)
        {
            highScore = game.players[3].getScore();
            highScoreIndex = 3;
        }
        System.out.println();
    }
    
    
    public static void winnerOrPush(){
        //Who going to win?
        boolean push=false;
        for(int i=0 ; i<4 ; i++){
            if(game.players[i].getScore() == highScore &&  i != highScoreIndex ){
                push=true;
                break;
            }
        }

        if(push){
            System.out.println("PUSH");
        }
        else{
            System.out.println(game.players[highScoreIndex].getName());
            System.out.println("Win the game...");
        }
    }
}
