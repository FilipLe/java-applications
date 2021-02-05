package monarchs;

public class Main {

	public static void main(String[] args) {
		//constructing the monarch with the format (name, isMale, startYear, endYear)
		Monarch victoria = new Monarch("Victoria", false, 1837, 1901);
		
		System.out.println(victoria.lengthOfReign());

	}

}
