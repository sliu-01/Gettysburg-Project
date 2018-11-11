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
		String word1 = "";
		String word2 = "";
		
		while (file.hasNext())
		{
			String word = file.next();
			for (int i = word.length(); i > 0; i--)
			{
				if (word.substring(i - 1,  i).equals("."))
				{
					word = word.substring(0, i - 1) + word.substring(i, word.length());
				}				
				else if (word.substring(i - 1,  i).equals(","))
				{
					word = word.substring(0, i - 1) + word.substring(i, word.length());
				}
				else if (word.substring(i - 1,  i).equals(" "))
				{
					word = word.substring(0, i - 1) + word.substring(i, word.length());
				}
				else if (word.substring(i - 1,  i).equals("-"))
				{
					if (word.substring(i - 2,  i).equals("--"))
					{
						word1 = word.substring(0, i - 2);
						word2 = word.substring(i, word.length());
						word = word.substring(0, i - 2) + " ";
					}
					else
					{
						word1 = word.substring(0, i - 1);
						word2 = word.substring(i, word.length());
						word = word.substring(0, i - 1);
					}
				}
			}
			if (word2.equals(""))
			{
				strings.add(word);
				wordCount++;
			}
			else if (!word2.equals(""))
			{
				strings.add(word1);
				word1 = "";
				strings.add(word2);
				word2 = "";
				wordCount += 2;
			}
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
		//wordCount = 0;
		//total = 0;
		//for (int i = 0; i < strings.size(); i++)
		//{
		//	System.out.println(strings.get(i));
		//	wordCount++;
		//	total += strings.get(i).length();
		//}
		System.out.println("The total number of words is " + wordCount);
		System.out.println("The total number of letters is " + total);
	}
}
	