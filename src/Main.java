import java.util.*;
import java.awt.*;
import javax.swing.*;


/**
 * Updated version of DND Character Creator
 * @author Vy Willis, Dorian Eskridge
 * @version 3.0
 *
 *
 */

public class Main 
{
	/**
	 * I hope I do not have to explain what main does.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Character newCharacter = new Character();

		SwingUtilities.invokeLater(() -> {
            DNDGui gui = new DNDGui(newCharacter);
            gui.setVisible(true);
        });
	}

	/**
	 * Displays character information in a JFrame.
	 * @param _character holds info to display
	 */
	public static void DisplayCharacter(Character _character)
	{
		//Initialize variables for window
		JFrame w = new JFrame();
		Label nameLabel = new Label(_character.name);
		Label genderLabel = new Label("Gender: " + _character.gender);
		Label levelLabel = new Label("Lvl 1");
		Label raceLabel = new Label("Race: " + _character.race.toString());
		Label classLabel = new Label("Class: " + _character.characterClass.toString());
		
		Font headerFont = new Font("Serif", Font.BOLD, 20);
		Font levelFont = new Font("Serif", Font.ITALIC, 14);
		Font infoFont = new Font("Serif", Font.BOLD, 18);

		//Set layout of window
		w.getContentPane().setLayout(new BoxLayout(w.getContentPane(), BoxLayout.PAGE_AXIS));

		//Create Header and its content
		JPanel header = new JPanel();
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(headerFont);
		nameLabel.setAlignment(Label.CENTER);
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setAlignment(Label.CENTER);
		levelLabel.setFont(levelFont);
		header.add(nameLabel);
		header.add(Box.createRigidArea(new Dimension(30,0)));
		header.add(levelLabel);
		header.setBorder(BorderFactory.createEmptyBorder(10, 2, 2, 2));
		header.setBackground(Color.DARK_GRAY);
		w.add(header);
		
		//Create Body and its content
		JPanel body = new JPanel();
		body.setBackground(Color.GRAY);
		body.add(genderLabel);
		genderLabel.setFont(infoFont);
		genderLabel.setForeground(Color.WHITE);
		body.add(raceLabel);
		raceLabel.setFont(infoFont);
		raceLabel.setForeground(Color.WHITE);
		body.add(classLabel);
		classLabel.setFont(infoFont);
		classLabel.setForeground(Color.WHITE);
		w.add(body);
		
		// Setup window and display it
		w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		w.pack();
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		w.setBackground(Color.DARK_GRAY);
		w.setResizable(false);
	}
	
	/**
	 * Generates all stats for a D&D Character
	 * @return Map of all stats
	 */
	public static Map<String,Integer> GenerateStats() {
		
		Map<String, Integer> temp = null;
		
		// Check if attributes are null, initialize the attributes
	    if (temp == null) {
	    	temp = new HashMap<String, Integer>();
	    	temp.put("Strength", 0);
	    	temp.put("Dexterity", 0);
	    	temp.put("Constitution", 0);
	    	temp.put("Intelligence", 0);
	    	temp.put("Wisdom", 0);
	    	temp.put("Charisma", 0);
	    }    
	    
	    // Assign the values
	    for (String key : temp.keySet()) {
	        if (temp.get(key) == 0) {
	        	temp.put(key, GenerateStatValue());
	        }
	    }
	    
	    // Print the values after they have been assigned
	    for (String key : temp.keySet()) {
	        System.out.println(key + ": " + temp.get(key));
	    }
	    
	    return temp;
	}
	
	/**
	 * Generates the stat value for a D&D Character
	 * @return sum of the smallest rolls
	 */
    private static Integer GenerateStatValue() {
    	int sum = 0;
    	int[] rolls = new int[4];
    	
    	// Rolls d6 4 times and stores it in the rolls array
    	for (int i = 0; i < 4; i++)
    	{
    		rolls[i] = RollDie(6);
    		
    		// Debugging
    		//System.out.println(rolls[i]);
    	}
    	
    	//Sorts the array of rolls and puts them in descending order.
    	Arrays.sort(rolls);
    	ReverseArray(rolls);
    	
    	// adds up the lowest 3 values
        for (int i = 0; i < 3; i++) {
            sum += rolls[i];
        }
        
        // Used for debugging
        //System.out.println("Generated stat value: " + sum);
        
        return sum;
	}

    /**
     * Simulates rolling a die with any amount of sides
     * @param sides amount of sides the die has
     * @return the number rolled
     */
	public static int RollDie(int sides) {
		Random rndm = new Random();
		
		// This is a weird way to do a random range java, why are you like this
		// The plus one makes sure it is NEVER 0 and the 6 bound is to make sure it is NEVER 7
		// Why do I have to do this? Ask Oracle.
		// - V
		try
		{
			return rndm.nextInt(sides) + 1;			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "ERROR WHEN ROLLING DIE: " + e.getMessage());
			return -1;
		}
    }
	
	/**
	 * Reverses an array.
	 * @param array that is going to be reversed.
	 */
    public static void ReverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap elements at indices left and right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }
    }
}

