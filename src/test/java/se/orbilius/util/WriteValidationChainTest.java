package se.orbilius.util;

import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.datawriter.BreakChainIfNoAddressCommand;
import se.orbilius.datawriter.BreakChainIfNoSquareMetersCommand;
import se.orbilius.datawriter.BreakChainIfNoStartPriceCommand;
import se.orbilius.shared.HousePriceInfo;

public class WriteValidationChainTest extends TestCase {
	
	public void testEmptyChain(){
		Chain chain = new ChainImpl();
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();
		
		boolean pass = chain.execute(info);
		assertTrue(pass);

	}

	public void testNoAddress(){
		
		Chain chain = new ChainImpl();
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();
		
		info.setAddress(null);
		
		chain.addCommand(new BreakChainIfNoAddressCommand());

		boolean pass = chain.execute(info);

		assertFalse("Chain should fail since address is null", pass);
		
	}

	public void testNoSqm(){

		Chain chain = new ChainImpl();
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();

		info.setSquareMeters(0);

		chain.addCommand(new BreakChainIfNoSquareMetersCommand());

		boolean pass = chain.execute(info);

		assertFalse("Chain should fail since square meters is 0", pass);
	}

	public void testNoStartPrice(){

		Chain chain = new ChainImpl();
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();

		info.setStartPrice(0);
		
		chain.addCommand(new BreakChainIfNoStartPriceCommand());

		boolean pass = chain.execute(info);

		assertFalse("Chain should fail since start price is 0", pass);
	}
}
