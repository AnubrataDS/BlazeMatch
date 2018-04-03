package BlazeMatch.dataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TrieUtil {

	private int ctr ;
	private TrieNode trieRoot ;
	private ArrayList<String> tokens ;
	private HashMap<String, HashSet<Integer>> matches;
	public TrieUtil()
	{
		trieRoot = new TrieNode();
		tokens = new ArrayList<>();
		ctr = 0 ;
		matches  = new HashMap<>() ;
	}
	public void addAll(Collection<String> dictionary) {
		for(String str : dictionary)
		{
			add(str);
		}
		
	}

	public void add(String newString) {
		tokens.add(newString);
		matches.put(newString,new HashSet<Integer>());
		int l = newString.length();
		TrieNode node = trieRoot ;
		for(int i = 0 ; i<l ; i++)
		{
			char ch = newString.charAt(i);
			node.add(ch);
			node = node.getChild(ch);
		}
		//System.out.println(newString+" : "+ctr );
		node.end(ctr++);
	}
	public HashMap<String, HashSet<Integer>> search(String str) {
		HashMap<String, HashSet<Integer>> match = new HashMap<>();
		match.putAll(matches);
		ArrayList<TrieNode> nodes = new ArrayList<>();
		nodes.add(trieRoot);
		int l = str.length();
		for(int i = 0 ; i<l ; i++)
		{
			ArrayList<TrieNode> nodes2 = new ArrayList<>();
			nodes2.add(trieRoot);
			char ch = str.charAt(i);
			for(TrieNode t : nodes)
			{
				if(t.containsKey(ch))
				{
					if(t.getChild(ch).isEnd()>-1)
					{
						String matched = tokens.get(t.getChild(ch).isEnd());
						HashSet<Integer> tmp = match.get(matched);
						tmp.add(i-matched.length()+1);
						match.put(matched, tmp);
						nodes2.addAll(t.getChildren());
					}
					//nodes.remove(t);
					else
					{
						nodes2.addAll(t.getChildren());
					}
				}
			}
			nodes = nodes2 ;
		}
		
		return matches ;
	}
	public ArrayList<String> getTokens()
	{
		return tokens ;
	}
}
