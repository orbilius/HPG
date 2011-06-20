package se.orbilius.client;

import se.orbilius.client.drawer.DrawerUtil;
import junit.framework.TestCase;

public class DrawerUtilTest  extends TestCase{
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testHexColorFromPercentage(){
		String s1 = DrawerUtil.hexColor(100);
		assertEquals(s1, "ff0000");
		
		
		 s1 = DrawerUtil.hexColor(100, 100);
		assertEquals(s1, "ff0000");
		
		 s1 = DrawerUtil.hexColor(300, 300);
			assertEquals(s1, "ff0000");
		
		s1 = DrawerUtil.hexColor(3, 300);
		assertEquals(s1, "02fc00");
		
		s1 = DrawerUtil.hexColor(1);
		assertEquals(s1, "02fc00");
		
		s1 = DrawerUtil.hexColor(1, 100);
		assertEquals(s1, "02fc00");
		
		s1 = DrawerUtil.hexColor(60);
		assertEquals(s1, "996600");
		
		s1 = DrawerUtil.hexColor(60, 100);
		assertEquals(s1, "996600");
		
		s1 = DrawerUtil.hexColor(180, 300);
		assertEquals(s1, "996600");
	}
}
