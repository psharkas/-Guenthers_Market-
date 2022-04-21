import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Market {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double total = 0;
		boolean cont = true;
		
		Map<String, Double> m1 = new HashMap<>();
		ArrayList<String> order = new ArrayList<String>();
		ArrayList<Double> pricing = new ArrayList<Double>();
		
		m1.put("orange", 1.99);
		m1.put("apples", 0.99);
		m1.put("pie", 4.99);
		m1.put("bread", 2.99);
		m1.put("parmesan", 7.99);
		m1.put("pizza", 1.49);
		m1.put("steak", 5.99);
		m1.put("salmon", 8.99);
		
		System.out.println("Welcome to Guenther's Market!\n");
		System.out.println("Item            Price");
		System.out.println("======================");
		
		for(String key: m1.keySet()) {
			
			String str1 = "";
			str1 += String.format("%-16s", key);
			str1 += String.format("%.2f", m1.get(key));
			System.out.println(str1);
		}
		System.out.println("\n");
				
		Scanner scnr = new Scanner(System.in);

		
		do {
			System.out.println("Enter an item that you would like.");
			String response = scnr.nextLine();
		
			if(m1.containsKey(response)){
				total += m1.get(response);
				order.add(response);
				pricing.add(m1.get(response));
				System.out.println("Adding " + response + " to the cart at $" + m1.get(response));
				System.out.println("Would you like to order anything else (y/n)?");
				
				String response2 = scnr.nextLine();
				
				if (response2.equalsIgnoreCase("n")) {
					cont = false;
					System.out.println("Thanks for your order! You ordered: ");
					
					for (int i = 0; i < order.size(); i++) {
						String str2 = "";
						str2 += String.format("%-10s", order.get(i));
						str2 += String.format("%.2f", pricing.get(i));
						System.out.println(str2);
					}
					String avg = String.format("%.2f", getAverage(pricing));
					System.out.println("The average price was: " + avg);
				}
			}
			else {
				System.out.println("Sorry, we don't have those. Please try again.");
			}
		}while(cont);
		
	}
	
	public static double getAverage(ArrayList<Double> pricing) {
		double sum = 0;
		for (double num: pricing) {
			sum += num;
		}
		return (sum/pricing.size());
	}

}
