import java.util.*;
import java.awt.*;
import javax.swing.*;


/**
 * A very bare bones D&D Character Creator, DND Beyond was a good reference for this project.
 * @author Vy Willis
 * @version 2.0
 * 
 * The Java Swing version did not meet the requirements of the project :(
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
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to the D&D Character Creator \n");
		
		String characterName = null;
		
		// ----------- NAME -----------	
		do {
			// Ask for character name
			System.out.println("What is your name?");	
			
			characterName = scnr.nextLine();
			
			// Validate the input
			if(characterName.isBlank() || characterName.isEmpty())
			{
				System.out.println("Invalid Input: Name is blank. \n");
			}
			else if(characterName.length() > 40)
			{
				System.out.println("Name too long, try a shorter one \n");
				characterName = "";
			}
			else
			{
				newCharacter.SetName(characterName);
			}
			
		}while(newCharacter.name.isEmpty());
		
		// ----------- GENDER -----------
		do {
			System.out.println("What is your character's gender?");
			String gender = scnr.nextLine();
			
			// Validate the input
			if(characterName.isBlank() || characterName.isEmpty())
			{
				System.out.println("Invalid Input: Gender is blank. \n");
			}
			else if(characterName.length() > 40)
			{
				System.out.println("Gender too long, try a shorter one \n");
				gender = "";
			}
			else
			{
				newCharacter.SetGender(gender);
			}
			
		}while(newCharacter.gender.isEmpty());
		
		// ----------- ALIGNMENT -----------
		do {
			String alignment = "";
			
			System.out.println("\nWhat is your character's alignment?");
			System.out.println("1. Lawful Good    2. Neutral Good    3. Chaotic Good \n"
					+ "4. Lawful Neutral    5. True Neutral    6. Chaotic Neutral \n"
					+ "7. Lawful Evil    8. Neutral Evil    9. Chaotic Evil");
			
			alignment = scnr.nextLine();
			
			switch(alignment)
			{
				case "1":
					newCharacter.SetAlignment(DNDAlignment.LawfulGood);
					break;
				case "2":
					newCharacter.SetAlignment(DNDAlignment.NeutralGood);
					break;
				case "3":
					newCharacter.SetAlignment(DNDAlignment.ChaoticGood);
					break;
				case "4":
					newCharacter.SetAlignment(DNDAlignment.LawfulNeutral);
					break;
				case "5":
					newCharacter.SetAlignment(DNDAlignment.TrueNeutral);
					break;
				case "6":
					newCharacter.SetAlignment(DNDAlignment.ChaoticNeutral);
					break;
				case "7":
					newCharacter.SetAlignment(DNDAlignment.LawfulEvil);
					break;
				case "8": 
					newCharacter.SetAlignment(DNDAlignment.NeutralEvil);
					break;
				case "9":
					newCharacter.SetAlignment(DNDAlignment.ChaoticEvil);
					break;
				default:
					System.out.println("Invalid alignment.\n");
					break;
			}
			
		}while(newCharacter.alignment == DNDAlignment.Undecided);
		
		// ----------- RACE -----------
		// TODO??? Maybe I will make entering the name as well works.
		do {
			System.out.println("\nChoose your race.");
			System.out.println("1. Human    2. Orc    3. Dwarf \n"
					+ "4. Elf    5. Halfling    6. Tiefling \n"
					+ "7 Dragonborn    8. Goblin");
			
			String characterRace = scnr.nextLine();
			
			//Set the race based on the number
			switch(characterRace)
			{
				case "1":
					newCharacter.SetRace(DNDRace.Human);
					break;
				case "2":
					newCharacter.SetRace(DNDRace.Orc);
					break;
				case "3":
					newCharacter.SetRace(DNDRace.Dwarf);
					break;
				case "4":
					newCharacter.SetRace(DNDRace.Elf);
					break;
				case "5":
					newCharacter.SetRace(DNDRace.Halfling);
					break;
				case "6":
					newCharacter.SetRace(DNDRace.Tiefling);
					break;
				case "7":
					newCharacter.SetRace(DNDRace.Dragonborn);
					break;
				case "8": 
					newCharacter.SetRace(DNDRace.Goblin);
					break;
				default:
					System.out.println("Invalid race.\n");
					break;
			}
			
		}while(newCharacter.race.equals(DNDRace.Unidentified));
		
		// ----------- CLASS -----------
		// TODO???? Ditto TODO above.
		do {
			System.out.println("\nChoose your class.");
			System.out.println("1. Fighter    2. Paladin    3. Wizard \n"
					+ "4. Rogue    5. Cleric");
			
			String characterClass = scnr.nextLine();
			
			//Set the race based on the number
			switch(characterClass)
			{
				case "1":
					newCharacter.SetClass(DNDClass.Fighter);
					break;
				case "2":
					newCharacter.SetClass(DNDClass.Paladin);
					break;
				case "3":
					newCharacter.SetClass(DNDClass.Wizard);
					break;
				case "4":
					newCharacter.SetClass(DNDClass.Rogue);
					break;
				case "5":
					newCharacter.SetClass(DNDClass.Cleric);
					break;
				default:
					System.out.println("Invalid class.\n");
					break;
			}
		}while(newCharacter.characterClass.equals(DNDClass.Unidentified));
		
		
		
		// ----------- STATS -----------
		System.out.println("\nGenerating stats\n");
		
		// Generate stats
		newCharacter.attributes = GenerateStats();
		
		// TODO: Add race modifier after user chooses it.
		System.out.println("\nWhich stat would you like to increase by 2?");
		System.out.println("1. Strength    2. Dexterity    3. Constitution\n"
				+ "4. Intelligence    5. Wisdom    6. Charisma");
		
		String statIncreaseChoice = scnr.nextLine();
		boolean hasIncreasedStat = false;
		
		do {
			switch(statIncreaseChoice)
			{
				case "1":
					newCharacter.IncrementStatistic("Strength", 2);
					hasIncreasedStat = true;
					break;
				case "2":
					newCharacter.IncrementStatistic("Dexterity", 2);
					hasIncreasedStat = true;
					break;
				case "3":
					newCharacter.IncrementStatistic("Constitution", 2);	
					hasIncreasedStat = true;
					break;
				case "4":
					newCharacter.IncrementStatistic("Intelligence", 2);
					hasIncreasedStat = true;
					break;
				case "5":
					newCharacter.IncrementStatistic("Wisdom", 2);
					hasIncreasedStat = true;
					break;
				case "6":
					newCharacter.IncrementStatistic("Charisma", 2);
					hasIncreasedStat = true;
					break;
				default:
					System.out.println("Invalid stat.\n");
					break;
			}
		}while(!hasIncreasedStat);
		
		System.out.println("Now displaying character...");
		
		DisplayCharacter(newCharacter);
		
		scnr.close();
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
	private static Map<String,Integer> GenerateStats() {
		
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
			System.out.println("ERROR WHEN ROLLING DIE: " + e.getMessage());
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

