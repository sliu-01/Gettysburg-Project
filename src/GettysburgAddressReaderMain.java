import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GettysburgAddressReaderMain 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner file = new Scanner(new File("GettysburgAddress.txt"));
		ArrayList<String> strings = new ArrayList<String>();
		int wordCount = 0;
		int total = 0;
		int longest = 0;
		int listLength = 0;
		String printedListOfLongestWords = "";
		
		while (file.hasNext())
		{
				strings.add(file.next());
				wordCount ++;
		}
		
		ArrayList<String> longestWords = new ArrayList<String>();
		
		for (String str : strings)
		{
			total += str.length();
			if (longest < str.length())
			{
				longest = str.length();
			}
		}
		
		double average = (total * 1.0)/wordCount;
		
		for (String str : strings)
		{
			if (longest == str.length())
			{
				longestWords.add(str);
				listLength ++;
			}
		}
		
		for (int i = 0; i < listLength; i++)
		{
			printedListOfLongestWords += longestWords.get(i) + ", ";
		}
		
		System.out.println("The longest word(s) is/are: " + printedListOfLongestWords );
		System.out.println("The average word length is: " + average);
		
	}

}