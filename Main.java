import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main extends javax.swing.JFrame {
    @Override
    public void setBackground(Color bgColor) {
        super.setBackground(Color.CYAN); 
    }

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        BlackJackGame = new javax.swing.JButton();
        CardGuessingGame = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BlackJackGame.setFont(new java.awt.Font("Tahoma", 1, 18));
        BlackJackGame.setBackground(Color.CYAN);
        BlackJackGame.setText("Play BackJack Game");
        BlackJackGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                BlackJackGameActionPerformed(evt);
            }
        });

        CardGuessingGame.setFont(new java.awt.Font("Tahoma", 1, 18));
        CardGuessingGame.setBackground(Color.RED);
        CardGuessingGame.setText("Play CardGuessing Game");
        CardGuessingGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                try {
					CardGuessingGameActionPerformed(evt);
				} catch (final IOException e) {
					
					e.printStackTrace();
				}
            }
        });
        

        close.setText("Exit");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });


        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardGuessingGame)
                            .addComponent(BlackJackGame, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(BlackJackGame, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(CardGuessingGame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(close)
                .addContainerGap())
        );

        pack();
    }

    //Button click action of BalckjackButton
    private void BlackJackGameActionPerformed(final java.awt.event.ActionEvent evt) {
        this.setVisible(false); //this Jfame will close
      //Dialogbox
        JOptionPane.showMessageDialog(null,"Blackjack instructions! \nThe goal of blackjack is to beat the dealer's hand without going over 21.\n" + 
            "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n" + 
            "Each player starts with two cards, one of the dealer's cards is hidden until the end.\n" + 
            "To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n" + 
            "Going over 21 will result in a bust, and the dealer wins.\n" + 
            "If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n" +  
            "Dealer will hit until his/her cards total 17 or higher.\n", "IT211 FINAL // Pierre Nguyen",JOptionPane.INFORMATION_MESSAGE);
        final Game blackjack = new Game();
        blackjack.setVisible(true);  //Blackjack game window will open
        
        
    }
    
  //Button click action of CardGuessingGameA
    private void CardGuessingGameActionPerformed(final java.awt.event.ActionEvent evt) throws IOException {

    	this.setVisible(false); //this Jfame will close
    	//Dialogbox
      JOptionPane.showMessageDialog(null,"Card guessing game instructions!\nThe goal of the game is to get as many correct guesses as possible\n before the deck of cards runs out."
      + " To play you just simply select any card,\n and see if your card matches the random card that will be drawn out of the deck.\n"
      + " Every correct guess results in 1 win. After every guess  a new random card will be\n generated from the deck.","IT211 FINAL // Pierre Nguyen",JOptionPane.INFORMATION_MESSAGE);
      final guessGame obj = new guessGame();
      final String[] args = {};
    	obj.main(args);  //call the main method of carGame class to start the cardGuessing game.
    }

    private void closeActionPerformed(final java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(final String args[]) {

        try {
            for (final javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (final ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

   //Three buttons two for two games and one for close the project
    private javax.swing.JButton BlackJackGame;
    private javax.swing.JButton CardGuessingGame;
    private javax.swing.JButton close;
}
