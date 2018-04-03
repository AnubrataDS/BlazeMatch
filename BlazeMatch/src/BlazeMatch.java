import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import BlazeMatch.dataStructures.TrieUtil;

public class BlazeMatch {

	private TrieUtil dictionary ;
	public BlazeMatch()
	{
		this.dictionary = new TrieUtil();
	}
	public BlazeMatch(Collection<String>  dictionary)
	{
		this.dictionary = new TrieUtil();
		this.dictionary.addAll(dictionary);
	}
	public void setDictionary(Collection<String> dictionary)
	{
		this.dictionary.addAll(dictionary);
	}
	public void addToDictionary(String newString)
	{
		dictionary.add(newString);
	}
	
	public HashMap<String,HashSet<Integer>> search(String str)
	{
		return dictionary.search(str);
	}
	
	protected ArrayList<String> getTokens()
	{
		return dictionary.getTokens();
	}
}
