package CSC241Final.DNDCharacterFighter.src;

import javax.swing.*;
import java.awt.*;

public class DNDGui extends JFrame {
    private JTextField nameField;
    private JTextField genderField;
    private JComboBox<String> raceDropdown;
    private JComboBox<String> alignmentDropdown;
    private JComboBox<String> classDropdown;
    private JButton submitButton;

    public DNDGui(Character character) {
        setTitle("D&D Character Creator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        nameField = new JTextField(20);
        genderField = new JTextField(20);
        String[] raceOptions = {"Human", "Orc", "Dwarf", "Elf", "Halfling", "Tiefling", "Dragonborn", "Goblin"};
        raceDropdown = new JComboBox<>(raceOptions);
        String[] alignmentOptions = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
        alignmentDropdown = new JComboBox<>(alignmentOptions);
        String[] classOptions = {"Fighter", "Paladin", "Wizard", "Rogue", "Cleric"};
        classDropdown = new JComboBox<>(classOptions);
        submitButton = new JButton("Confirm");

        // Set up layout
        Container container = getContentPane();
        container.setLayout(new GridLayout(4, 4, 5, 5)); // 2 rows, 5 columns

        // Add components to the container
        container.add(new JLabel("Name:"));
        container.add(nameField);
        container.add(new JLabel("Gender:"));
        container.add(genderField);
        container.add(new JLabel("Race:"));
        container.add(raceDropdown);
        container.add(new JLabel("Alignment:"));
        container.add(alignmentDropdown);
        container.add(new JLabel("Class:"));
        container.add(classDropdown);
        container.add(new JLabel("Stats:"));
        container.add(new JLabel()); // Placeholder for stat input field
        container.add(submitButton);

        // Set up action listener for submit button
        submitButton.addActionListener(e -> {
            // Retrieve values from text fields and dropdowns
            String name = nameField.getText();
            String gender = genderField.getText();
            String race = (String) raceDropdown.getSelectedItem();
            String alignment = (String) alignmentDropdown.getSelectedItem();
            String characterClass = (String) classDropdown.getSelectedItem();

            // Set all String values
            if(name.isBlank() || gender.isBlank())
            {   
                JOptionPane.showMessageDialog(null, "ERROR: Empty values.");
                return;
            }

            character.SetName(name);
            character.SetGender(gender);
            character.SetRace(race);
            character.SetAlignment(alignment);
            character.SetClass(characterClass);

            // Generate Statistics
            character.attributes = Main.GenerateStats();
            setVisible(false);
            String desiredAttribToIncrease = new String();
            do{
                desiredAttribToIncrease = JOptionPane.showInputDialog(null, "Attributes generated, which attribute would you like to increase?"
                + "\nStrength, Charisma, Wisdom, Dexterity, Intelligence, Constitution");
    
                if(!desiredAttribToIncrease.isBlank())
                {
                    switch (desiredAttribToIncrease.toLowerCase()) {
                        case "strength":
                            character.IncrementStatistic("Strength", 2);
                            break;
                        case "charisma":
                            character.IncrementStatistic("Charisma", 2);
                            break;
                        case "wisdom":
                            character.IncrementStatistic("Wisdom", 2);
                            break;
                        case "intelligence":
                            character.IncrementStatistic("Intelligence", 2);
                            break;
                        case "dexterity":
                            character.IncrementStatistic("Dexterity", 2);
                            break;
                        case "constitution":
                            character.IncrementStatistic("Constitution", 2);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "ERROR: Invalid Key");
                            desiredAttribToIncrease = "";
                            break;
                    }
                }
            }while(desiredAttribToIncrease.isBlank());

            DisplayCharacter(container, character, this);
        });
    }

    public static void DisplayCharacter(Container container, Character character, JFrame gui)
    {
        container.removeAll();
        JLabel nameLabel = new JLabel("Name: " + character.name);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont();
        JLabel Race = new JLabel("Race: " + character.race);
        Race.setForeground(Color.white);
        JLabel Gender = new JLabel("Gender: " + character.gender);
        Gender.setForeground(Color.white);
        JLabel Class = new JLabel("Class: " + character.characterClass);
        Class.setForeground(Color.white);
        JLabel Strength = new JLabel("Strength: " + character.attributes.get("Strength"));
        Strength.setForeground(Color.white);
        JLabel Dexterity = new JLabel("Dexterity: " + character.attributes.get("Dexterity"));
        Dexterity.setForeground(Color.white);
        JLabel Constitution = new JLabel("Constiution: " + character.attributes.get("Constitution"));
        Constitution.setForeground(Color.white);
        JLabel Wisdom = new JLabel("Wisdom: " + character.attributes.get("Wisdom"));
        Wisdom.setForeground(Color.white);
        JLabel Intelligence = new JLabel("Intelligence: " + character.attributes.get("Intelligence"));
        Intelligence.setForeground(Color.white);
        JLabel Charisma = new JLabel("Charisma: " + character.attributes.get("Charisma"));
        Charisma.setForeground(Color.white);
        
        
        
        container.add(nameLabel);
        container.add(Race);
        container.add(Gender);
        container.add(Class);
        container.add(Strength);
        container.add(Dexterity);
        container.add(Constitution);
        container.add(Intelligence);
        container.add(Charisma);
        container.add(Wisdom);
        container.setBackground(Color.black);
        
        
        
        gui.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
