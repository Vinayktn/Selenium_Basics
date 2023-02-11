package Streams_and_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

import com.google.common.collect.Streams;

public class Example_1 {

	public static void main(String[] args) 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Praveen");
		names.add("Harsha");
		names.add("rahul");
		names.add("vinay");
		names.add("adi");
		names.add("Hari");
		int count=0;

		for(int i=0; i<names.size(); i++)
		{
			if(names.get(i).startsWith("H"))
			{
				count++;
			}
		}
		System.out.println(count);
		System.out.println("---------------------------------------------------------------------------------/n");

		long d = Stream.of("Praveen", "Harsha", "rahul", "vinay", "adi", "Hari").filter(s->
		{
			s.startsWith("H");
			return true;
		}).count();
		System.out.println(d);
		System.out.println("---------------------------------------------------------------------------------/n");

		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

		System.out.println("---------------------------------------------------------------------------------/n");

		//print names which has last letter a and convert it to uppercase
		Stream.of("Abhijeetha", "Rana", "Diggu", "Darshan", "Dzinja", "Shashi").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		System.out.println("---------------------------------------------------------------------------------/n");

		//print names which has first letter as A with uppercase and sorted
		Stream.of("Abhijeetha", "ARana", "ADiggu", "AADarshan", "Dzinja", "Shashi").filter(s->s.startsWith("A"))
		.map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
				
		//Merging two streams or lists by using concat() in the streams
		ArrayList<String> vin = new ArrayList<String>();
		vin.add("undertaker");
		vin.add("jhon cenaa");
		vin.add("virat kohli");
		vin.add("rock");
		vin.add("ct fletcher");
		vin.add("rogger");
		vin.stream();
		System.out.println("---------------------------------------------------------------------------------/n");
 	
		List<String> games = Arrays.asList("kim", "pim", "bim", "Jim");
		games.stream().filter(s->s.endsWith("m")).forEach(s->System.out.println(s));
		
		Stream<String> newstrStream =  Stream.concat(vin.stream(), games.stream());
		//newstrStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newstrStream.anyMatch(s->s.equalsIgnoreCase("kim"));
		Assert.assertTrue(flag);
	}
}