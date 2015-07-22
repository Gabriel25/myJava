/**
 * 
 * @author Gavriil Gavriilidis
 *
 * This program takes a given string and returns it
 * with the odd words in uppercase and the even reversed. 
 * A word is a sequence of characters separated by one or
 * more consequtive spaces. There was no requirement to 
 * handle new line characters. 
 */
public class StringUpperReverse {

	public static String oddsUpperEvenReverse(String s){
		//put the words into an array using space as the delimiter and 
		//don't omit trailing spaces
		String[] words = s.split(" ", -1);
		
		//this will hold the number of the each word in the string 
		int wordCount=0;
		for(int i=0; i<words.length; i++){
		   //don't take spaces into account when counting the words
			//and if spaces are encountered do nothing
			if(words[i].equals(""))
				continue;
			else
				wordCount++;
			//convert the odd words to upper-case
			if((wordCount)%2!=0){
				words[i] = words[i].toUpperCase();
			}
			//and reverse the even
			else{
				words[i] = reverse(words[i]);
			}
		}
		StringBuilder sb = new StringBuilder("");
		//replace the spaces that were lost since they were used as delimiters 
		for(String word: words){
			sb.append(word + " ");
		}
		//remove the last space that was not there initially
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
	//helper method to reverse the even strings
	private static String reverse(String s)
	{
		if(s.length()==0)
		return s;
		else return s.charAt(s.length()-1) + reverse(s.substring(0,s.length()-1));
	}
	
	public static void main(String args[]){
		String s = " My  name    is Gabriel   and career  cup   challenges are awesome!   ";
		System.out.println(oddsUpperEvenReverse(s));
	}
}
