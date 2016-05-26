import java.util.Scanner;

public class Tanya {

	private static Scanner read;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		read = new Scanner(System.in);

		int[] StringArray = new int[256];		 //массив для хранения количества символов
		int yahoo = 0;
        int yep = 0;
        char symbol;
		String congratulation = read.nextLine(); //текст для поздравления
		String newspaper = read.nextLine();      //текст из газеты

		for (int index = 0; index < congratulation.length(); index++) {
            StringArray[congratulation.charAt(index)]++;
        };
        
        
        boolean[] BoolArray = new boolean[newspaper.length()];
        
        for (int index = 0; index < newspaper.length(); index++) {
            if (StringArray[newspaper.charAt(index)] > 0) {
                yahoo++;
                StringArray[newspaper.charAt(index)]--;
                BoolArray[index] = true;
            }
        };
        
        for (int index = 0; index < newspaper.length(); index++) {
            
        	if (!BoolArray[index]) {
                symbol = newspaper.charAt(index);
                if (symbol <= 'Z') {
                    symbol += 32;
                }
                else {
                    symbol -= 32;
                };
                
                if (StringArray[symbol] > 0) {
                    StringArray[symbol]--;
                    yep++;
                }
            }
        };
        System.out.print(yahoo + " " + yep);
	}
}
	
	