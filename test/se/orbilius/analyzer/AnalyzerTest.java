package se.orbilius.analyzer;

import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.analyzer.MediumPriceAnalyzer;
import se.orbilius.shared.HousePriceInfoBatch;
import junit.framework.TestCase;

public class AnalyzerTest extends TestCase{
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMediumPriceAnalyzer(){
		HousePriceInfoBatch batch = HousePriceInfoTestUtil.getTestBatch();
		MediumPriceAnalyzer analyzer = new MediumPriceAnalyzer();
		double value = analyzer.analyze(batch);
		assertEquals("Medium value was not what I excpected", Math.round(value), 4144615);
	}
	
	//junit.framework.AssertionFailedError: Medium value was not what I excpected expected:<4144615> but was:<3733333>
	
	public void testMediumPricePerSquareMeter(){
		HousePriceInfoBatch batch = HousePriceInfoTestUtil.getTestBatch();
		MediumPricePerSquareMeterAnalyzer analyzer = new MediumPricePerSquareMeterAnalyzer();
		double value = analyzer.analyze(batch);
		assertEquals("Medimum price per square meter was not what I expected", Math.round(value), 29776);
	}
	
}
