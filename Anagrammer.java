import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class Anagrammer{
	private ArrayList<String> dictionary;
  private int whichDic;
  public Anagrammer() {
    String[] tmp = null;
    try{
        tmp = readLines("dictionary.txt");
    }
    catch(IOException e){
      // Print out the exception that occurred
      System.out.println("Unable to access "+e.getMessage());              
    }
    dictionary = new ArrayList<String>(Arrays.asList(tmp));
  }
	public String[] readLines(String filename) throws IOException 
    {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
         
        while ((line = bufferedReader.readLine()) != null) 
        {
            lines.add(line);
        }
         
        bufferedReader.close();
         
        return lines.toArray(new String[lines.size()]);
    }

	public void printAnagrams(String letters, int minLength){
		for(int i=0; i<dictionary.size(); i++){
			String lets = letters;
			boolean works = true;
			String possible = dictionary.get(i);
			for(int j=0; j<possible.length(); j++){
				if(!lets.contains(possible.substring(j,j+1))){
					works = false;
				}
				else{
					lets = lets.replaceFirst(possible.substring(j,j+1), "");
				}
			}
			if(works){
				if(dictionary.get(i).length()>=minLength){
				  System.out.println(dictionary.get(i));
			  }
			}
		}
	}
}
