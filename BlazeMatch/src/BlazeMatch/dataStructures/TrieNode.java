package BlazeMatch.dataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TrieNode {
	private HashMap<Character,TrieNode> map ;
	private int isEnd ;
	public TrieNode()
	{
		map = new HashMap<>();
		isEnd = -1 ;
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
	public Collection<TrieNode> getChildren()
	{
		return map.values();
	}
	public void end(int x)
	{
		this.isEnd = x ;
	}
	public int isEnd()
	{
		return this.isEnd;
	}
	public boolean containsKey(char key)
	{
		return map.containsKey(key);
	}
}
