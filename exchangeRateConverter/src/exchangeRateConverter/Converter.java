package exchangeRateConverter;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
/*
 * VIDEO: https://lbry.tv/@MrCressey:e/Using-a-JSON-API-in-your-app:0?r=CGM9Aoxw5oq2MPfiCj9qgtVutruoUFXo 
 */
public class Converter {
	final String coinGecko = "https://api.coingecko.com/api/v3/exchange_rates";
	double usdPerBtc;
	
	Converter(){
		//Method to read URL 
		try {
			
			//Try opening this link
			URL url = new URL(coinGecko);
			
			//Read data from the website
			InputStream stream = url.openStream();
			
			//Parser to read in JSON data
			JsonObject allData = Json.createReader(stream).readObject();
						
			/*
			 * IN JSON, OBJECTS ARE THINGS BETWEEN {}
			 */
			//Object that contains all the exchange rates
			JsonObject rates = allData.getJsonObject("rates");
			
			//Object that contains USD exchange rates
			JsonObject usdRate = rates.getJsonObject("usd");
			
			//Numerical value of how many USD to a Bitcoin
			JsonNumber usdValue = usdRate.getJsonNumber("value");
			
			//Reads no of usd in btc and stores it in usdPerBtc
			usdPerBtc = usdValue.doubleValue();
			
			System.out.println(usdRate);
			
		} catch (Exception e) {
			
			//If there is an error opening the link, crash the program 
			throw new RuntimeException(e);
			
		}
	}
	double btcToUsd(double btc) 
	{
		//multiply by exchange rate to get no. of US dollars
		return btc * usdPerBtc;
	}
}
