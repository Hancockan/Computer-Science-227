package lab5;

import balloon4.Balloon;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class BalloonTests {

	private Balloon b;
	
	@Before
	public void Setup(){
		b = new Balloon(5);
	}
	
	@Test
	public void hasCorrectRadius(){
		b.blow(3);
		String msg = "The radius should be 3";
		assertEquals(msg, 3, b.getRadius());
		b.blow(2);
		String msg2 = "The radius should be 5";
		assertEquals(msg2, 5, b.getRadius());
		}
	
	@Test
	public void goesToMax(){
		b.blow(5);
		String msg = "The ballon should not be popped";
		assertFalse(msg, b.isPopped());
	}
	
	@Test
	public void popsAtMax(){
		b.blow(6);
		String msg = "The balloon should be popped";
		assertTrue(msg, b.isPopped());
	}
	
	@Test
	public void deflatesTo0(){
		b.blow(5); //blows to max 
		b.deflate();
		String msg = "The balloon should be at 0";
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test
	public void deflatesWithoutPopping(){
		b.blow(5);
		b.deflate();
		String msg = "The balloon shouldn't be popped";
		assertFalse(msg, b.isPopped());
	}
	
	@Test
	public void returnsCorrectRadius(){
		b.blow(5);
		String msg = "The radius should be 5";
		assertEquals(msg, 5, b.getRadius());
	}
	
	@Test
	public void returnsCorrectBooleanIsPopped(){
		b.blow(5);
		String msg = "The balloon shouldn't be popped";
		assertFalse(msg, b.isPopped());
	}
	
	@Test
	public void popTest(){
		b.blow(5);
		b.pop();
		String msg = "The balloon should be popped";
		assertTrue(msg, b.isPopped());
	}
	
	@Test
	public void blowTest(){
		b.blow(5);
		String msg = "The ballon should have a radius of 5";
		assertEquals(msg, 5, b.getRadius());
	}
	
	@Test
	public void blowAfterPopped(){
		b.blow(3);
		assertEquals(3, b.getRadius());
		b.pop();
		b.blow(1);
		assertEquals(0, b.getRadius());
		
	}
	@Test
	public void deflateWithoutPopping(){
		b.blow(4);
		b.deflate();
		b.blow(1);
		assertEquals(1, b.getRadius());
	}
	
}
