package BlazeMatch.dataStructures;

import java.util.Collection;

public class TrieUtil {

	private TrieNode trieRoot ;
	public TrieUtil()
	{
		trieRoot = new TrieNode();
	}
	public void addAll(Collection<String> dictionary) {
		for(String str : dictionary)
		{
			add(str);
		}
		
	}

	public void add(String newString) {
		int l = newString.length();
		TrieNode node = trieRoot ;
		for(int i = 0 ; i<l ; i++)
		{
			char ch = newString.charAt(i);
			node.add(ch);
			if(i!=(l-1))
			{
				node = node.getChild(ch);
			}
		}
		node.end();
	}

}
