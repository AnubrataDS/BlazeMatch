import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {

	private BlazeMatch blazematch ;
	private ArrayList<String> testTokens ;
	
	private boolean checkEquality(ArrayList<String> a , ArrayList<String> b)
	{
		if(a.size()!=b.size())
		{
			return false ;
		}
		else
		{
			int l = a.size();
			Collections.sort(a);
			Collections.sort(b);
			for(int i=0;i<l;i++)
			{
				if(a.get(i) != b.get(i))
					return false ;
			}
			return true ;
		}
	}
	@Before
	public void setUp() throws Exception {
		blazematch = new BlazeMatch();
		testTokens = new ArrayList<String>();
		testTokens.add("a");
		testTokens.add("andrew");
		testTokens.add("and");
		testTokens.add("bird");
		testTokens.add("baby");
	}

	@Test
	public void testSetDictionary() {
		blazematch.setDictionary(testTokens);
		assertTrue(checkEquality(testTokens,blazematch.getTokens()));
	}

	@Test
	public void testAddToDictionary() {
		blazematch.setDictionary(testTokens);
		blazematch.addToDictionary("barcelona");
		testTokens.add("barcelona");
		assertTrue(checkEquality(testTokens,blazematch.getTokens()));
	}

	@Test
	public void testSearch() {
		blazematch.setDictionary(testTokens);
		blazematch.addToDictionary("barcelona");
		testTokens.add("barcelona");
		String text = "a bird and a baby andrew can not be a car";
		HashMap<String,HashSet<Integer>> res = blazematch.search(text);
		for(String str : testTokens)
		{
			HashSet<Integer> x = res.get(str);
			System.out.print(str+" : { ");
			for(int i : x)
			{
				System.out.print(i+" ");
			}
			System.out.println("}");
		}
	}

}
