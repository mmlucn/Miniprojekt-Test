package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.ControlPayStation;
import controllayer.IllegalCoinException;
import modellayer.Currency;

public class TestAddPayment {
	ControlPayStation ps;


	@Before
	public void setUp() throws Exception {
		ps = new ControlPayStation();
	}


	@Test
	public void testAddPayment() throws IllegalCoinException {
		//Arrange
		int expectedParkingTime = 1;
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 1 minute for 1 cent",expectedParkingTime, ps.readDisplay());
	}
	@After
	public void cleanUp() {
		ps.setReady();
	}	
	@Test
	public void testAddPaymentDifferentCurrency() throws IllegalCoinException {
		//Arrange
		int expectedParkingTime = 6;
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		//Assert
		assertEquals("Should display 6 minutes for 1 krone",expectedParkingTime, ps.readDisplay());
	}

	@After
	public void cleanUp2() {
	ps.setReady();
	}
	@Test
	public void testAddPaymentTwoCoinTypes() throws IllegalCoinException {
		//Arrange
		int expectedParkingTime = 7;
;		int coinValue = 1;
		int coinValueE = 2;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrencyE = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinTypeE = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.addPayment(coinValueE, coinCurrencyE, coinTypeE);
		//Assert
		assertEquals("Should display 7 minutes for 1 krone and 2 cents",expectedParkingTime, ps.readDisplay());
	}
	@After
	public void cleanUp3() {
	ps.setReady();
	}
	@Test
	public void testAddPaymentManyCoins() throws IllegalCoinException {
		//Arrange
		int expectedParkingTime = 9;
;		int coinValue = 1;
		int coinValueE = 2;
		int coinValueDKK = 50;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		Currency.ValidCurrency coinCurrencyE = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinTypeE = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrencyDKK = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinTypeDKK = Currency.ValidCoinType.FRACTION;
		//Act
		ps.addPayment(coinValue, coinCurrency, coinType);
		ps.addPayment(coinValueE, coinCurrencyE, coinTypeE);
		ps.addPayment(coinValueDKK, coinCurrencyDKK, coinTypeDKK);
		//Assert
		assertEquals("Should display 9 minutes",expectedParkingTime, ps.readDisplay());
	}

		@After
		public void cleanUp4() {
				ps.setReady();
		}
		@Test(expected = IllegalCoinException.class)
		
public void testAddPaymentIllegalCoin() throws IllegalCoinException {
	//Arrange
	int expectedParkingTime = 0;
;		int coinValue = 50;
	
	Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
	Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
	
	//Act
	ps.addPayment(coinValue, coinCurrency, coinType);
	
	//Assert
	assertEquals(expectedParkingTime, ps.readDisplay());
}
		@After
		public void cleanUp5() {
				ps.setReady();
		}
		@Test(expected = IllegalCoinException.class)
		public void testAddPaymentUnknownEuroCoin() throws IllegalCoinException {
			// Arrange
					int expectedParkingTime = 0;
					int coinValue = 3;
					Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
					Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
					
					// Act
					ps.addPayment(coinValue, coinCurrency, coinType);
						
					// Assert
					assertEquals("Should display 0 min.", expectedParkingTime, ps.readDisplay());
		}
		@After
		public void cleanUp6() {
				ps.setReady();
		}
		@Test(expected = IllegalCoinException.class)
		public void testAddPaymentSmallAmount() throws IllegalCoinException {
			// Arrange
					int expectedParkingTime = 0;
					int coinValue = 25;
					Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
					Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
					
					// Act
					ps.addPayment(coinValue, coinCurrency, coinType);
						
					// Assert
					assertEquals("Should display 0 min.", expectedParkingTime, ps.readDisplay());
		}
		@After
		public void cleanUp7() {
				ps.setReady();
		}
		@Test(expected = IllegalCoinException.class)
		public void testAddPaymentAmountOutOfRange() throws IllegalCoinException {
			// Arrange
					int expectedParkingTime = 0;
					int coinValue = 50;
					Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
					Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
					
					// Act
					ps.addPayment(coinValue, coinCurrency, coinType);
						
					// Assert
					assertEquals("Should display 0 min.", expectedParkingTime, ps.readDisplay());
		}

@After
public void cleanUp8() {
		ps.setReady();
}
@Test(expected = IllegalCoinException.class)
public void testAddPaymentDifferentCoins() throws IllegalCoinException {
	// Arrange
			int expectedParkingTime = 7;
			int coinValue = 1;
			int coinValueE = 2;
			int coinValueNOK = 1;
			Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
			Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
			Currency.ValidCurrency coinCurrencyE = Currency.ValidCurrency.EURO;
			Currency.ValidCoinType coinTypeE = Currency.ValidCoinType.FRACTION;
			Currency.ValidCurrency coinCurrencyNOK = Currency.ValidCurrency.NOK;
			Currency.ValidCoinType coinTypeNOK = Currency.ValidCoinType.INTEGER;
			
			// Act
			ps.addPayment(coinValue, coinCurrency, coinType);
			ps.addPayment(coinValueE, coinCurrencyE, coinTypeE);
			ps.addPayment(coinValueNOK, coinCurrencyNOK, coinTypeNOK);
				
			// Assert
			assertEquals("Should display 0 min.", expectedParkingTime, ps.readDisplay());
}
}

