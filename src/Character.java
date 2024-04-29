import java.util.Map;

/**
 * Stores the information for the Characters created by the program.
 *
 */
class Character
{
	String name = "";
	String gender = "";
	int Level = 1;
	String alignment = "";
	String race = "";
	String characterClass = "";
	Map<String,Integer> attributes;
	
	public void SetName(String _name)
	{
		name = _name;
	}
	
	public void SetRace(String _race)
	{
		race = _race;
	}
	
	public void SetClass(String _class)
	{
		characterClass = _class;
	}
	
	public void SetAlignment(String _alignment)
	{
		alignment = _alignment;
	}
	
	public void SetGender(String _gender)
	{
		gender = _gender;
	}
	
	public void IncrementStatistic(String key, int increment)
	{
		int curStat = 0;
		
		try {
			curStat = attributes.get(key);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Statistic to Increase");
			return;
		}
		
		attributes.put(key, increment + curStat);
		System.out.println(key + " is now " + attributes.get(key));
	}
}