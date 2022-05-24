/**
 * The program uses loops and conditions to add 'ub'
 * if there is a vowel and do nothing if there is the 
 * character is not a vowel. If the vowel is repeated 
 * then the program does not add 'ub' it just prints
 * what the character typed. 
 * 
 *
 * Zoyace Shrestha 
 * CS -120 Section 2
 * Fall 2019
 * 
 * Programming Assignment 4
 * 16th October 2019
 * 
 */
import java.awt.Color;

import javax.swing.*;

public class UbbiDubbiGenerator
{
    private JTextField input;
    private JLabel output;

    /**
     * Simple main: creates the Driver object, and then runs its methods to do
     * the actual heavy lifting.
     * 
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        UbbiDubbiGenerator d = new UbbiDubbiGenerator();
        d.createWindow();
    }

    /**
     * Creates the graphical window and its contents.
     */
    public void createWindow()
    {
        // Window Creation
    	int graphicHeight = 25;
        int windowWidth = 800;
        int windowHeight = 9 * graphicHeight;
        
        JFrame win = new JFrame();
        win.setBounds( 25, 25,  windowWidth, windowHeight );
        win.setTitle( "Whubat dubid yubou subay?" );
        Color grey = new Color( 204, 204, 204 );
        win.getContentPane().setBackground( grey );
        win.setLayout( null );
        win.setResizable( false );
        win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        win.setVisible( true );
        
        // User Input Label and space
        JLabel inLabel = new JLabel( "Input :" );
        inLabel.setBounds( 30, graphicHeight, 105, graphicHeight );
        inLabel.setHorizontalAlignment( SwingConstants.LEFT );
        win.add( inLabel,0 );
        
        input = new JTextField();
        input.setBounds( 110, graphicHeight, windowWidth - 125,
                        graphicHeight );
        win.add( input,0 );
        
        // Output Label and space
        JLabel outLabel = new JLabel( "Ubbi Dubbi :" );
        outLabel.setBounds( 15, graphicHeight +55, 105, graphicHeight - 10 );
        outLabel.setHorizontalAlignment( SwingConstants.LEFT );
        win.add( outLabel,0 );
        
        output = new JLabel();
        output.setBounds( 110, graphicHeight * 3, windowWidth - 125,
                             graphicHeight );
        output.setBackground( Color.white );
        output.setOpaque( true );
        win.add( output,0 );
        
        // Translate button
        EventButton tranButton = new EventButton( this );
        tranButton.setLocation( 330, graphicHeight * 6 );
        tranButton.setSize( 105, graphicHeight );
        tranButton.setText( "Translate" );
        win.add( tranButton,0 );

        
        win.repaint();
    }

    /**
     * When a related EventButton is pressed, it will call this method.
     * 
     * The code will read in user input and translate to Ubbi Dubbi.
     */
    public void buttonPressed()
    {
        
    	//Variable Initialization
    	String inp = input.getText();
    	String out = "";
    	inp = inp.toLowerCase();
    	char currchar;
    	
    	//Loop for Ubbi Dubbi Conversion
    	for ( int i = 0 ; i < inp.length() ; i++ ) 
    	{
    			
    		currchar = inp.charAt(i);
    		
    		//Detecting Range for Loop
    		 if (inp.charAt(i) >= 'a' &&  inp.charAt(i) <= 'z' )
    		 {	 
    			 	//Loop for detecting a vowel and adding 'ub' if needed 
    			 	if ( currchar == 'a' || currchar == 'e' || currchar == 'i' || currchar == 'o' || currchar == 'u' ) 
    			 	{
    			
    			 		out = out + "ub" + currchar ;
    			
    			 			//Loop if the vowel repeats
    			 			while (( i < inp.length()) && (currchar == 'a' || currchar == 'e' || currchar == 'i' || currchar == 'o' || currchar == 'u')) 
    			 			{
    			 				
    			 				i++; 
    			 				
    			 				if ( i < inp.length() ) 
    			 				{
    			 				currchar = inp.charAt(i);
    			 				out = out + currchar;	
    			 				}
    			 			
    			 			}
    			 			
    			 	}
    			 	
    			 	//Detection for characters which are not vowels
    			 	else if (!(currchar == 'a' || currchar == 'e' || currchar == 'i' || currchar == 'o' || currchar == 'u'))
    			 	{
    			 		out = out + currchar;		
    			 	}
    			 
    			 	//Detection if there is blank space
    			 	else if (currchar == ' ')
    			 	{
    			 		out = out + ' ';
    			 	}
    			 			
    		 }
    			 	
    		 		//Detection loop if the characters are not letters
    		 		else  
    		 		{
    			 		out = out + currchar;
    			 	}
    		
    		}
    	
    	//Set out put to the window
    	output.setText(out);
    	
    }
}
