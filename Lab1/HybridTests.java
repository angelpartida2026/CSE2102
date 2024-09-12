import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HybridTests {

	Hybrid hybrid;

	@Before
	public void setUp() throws Exception {
		hybrid  = new Hybrid();
    }

	@Test
	public void mpgTest() {

		double miles = 11;
		double gallons = 1.2;
		double expectedMPG = miles/gallons;

		hybrid.setMilesfromGas(miles);
		hybrid.setGallonsfromGas(gallons);

		double actualMPG = hybrid.calcGasMPG();

		assertTrue(actualMPG == expectedMPG);
	}

	@Test
    public void mpgeTest() {

        double miles = 300;
        double kWh = 70;
        double expectedMPGe = (miles / kWh) * 33.7;

        hybrid.setElectricMiles(miles);
        hybrid.setTotalkWh(kWh);

        double actualMPGe = hybrid.calcMPGe();

        assertTrue(actualMPGe == expectedMPGe);
    }

	@Test
    public void gasCostTest() {

        double miles = 120;
        double gallons = 6;
        double gasCostPerGallon = 3.50;
        double expectedCost = gallons * gasCostPerGallon;

        hybrid.setMilesfromGas(miles);
        hybrid.setGallonsfromGas(gallons);

        double actualCost = hybrid.calculateGasCost(miles);

        assertTrue(actualCost == expectedCost);
    }

	@Test
    public void electricCostTest() {

        double miles = 120;
        double kWhUsed = (miles / 144.43) * 33.7;
        double electricCostPerKWh = 0.24;
        double expectedCost = kWhUsed * electricCostPerKWh;

        hybrid.setElectricMiles(miles);
        hybrid.setTotalkWh(kWhUsed / 33.7);

        double actualCost = hybrid.calculateElectricCost(miles);

        assertTrue(actualCost == expectedCost);
    }
	@Test
	public void simpleHybridCostTest() {

		double miles = 100;
		double gasFraction = 0.5;
		double expectedGasCost = 2.5 * 3.50;
		double expectedElectricCost = 15 * 0.24; 
		double expectedTotalCost = expectedGasCost + expectedElectricCost;

		hybrid.setMilesfromGas(50); 
		hybrid.setGallonsfromGas(2.5);

		hybrid.setElectricMiles(50);
		hybrid.setTotalkWh(15); 

		double actualHybridCost = hybrid.calculateHybridCost(miles, gasFraction);

		assertTrue(expectedTotalCost == actualHybridCost);
	}

	@Test
	public void averageMpgTest() {

		hybrid.setMilesfromGas(300);
		hybrid.setGallonsfromGas(15);

		hybrid.setElectricMiles(300);
		hybrid.setTotalkWh(70);

		double expectedAverageMpg = (20 + 144.43) / 2;
		double actualAverageMpg = hybrid.calculateAverageMpg();

		assertTrue(expectedAverageMpg == actualAverageMpg);
	}

}
