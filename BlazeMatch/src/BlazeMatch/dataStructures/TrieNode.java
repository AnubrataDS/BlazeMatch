package BlazeMatch.dataStructures;

import java.util.HashMap;

public class TrieNode {
	private HashMap<Character,TrieNode> map ;
	private boolean isEnd ;
	public TrieNode()
	{
		map = new HashMap<>();
		isEnd = false ;
	}
	public void add(char ch)
	{
		if(!map.containsKey(ch))
		{
			map.put(ch, new TrieNode());
		}
	}
	public TrieNode getChild(char ch)
	{
		return map.get(ch);
	}
	public void end()
	{
		this.isEnd = true ;
	}
	public boolean isEnd()
	{
		return this.isEnd;
	}
}
