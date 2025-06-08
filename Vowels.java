// Name: Tyler Stroud

public class Vowels {
    /** recursive count method **/
    public static int countVowels(String userInput, int index){
        int count = 0;

        // sentinel value
        if(index == userInput.length()){
            return count;
        }
        // parse for vowels, count goes up if a vowel is found
        else if(userInput.charAt(index) == 'a' || userInput.charAt(index) == 'e' || userInput.charAt(index) == 'i' || userInput.charAt(index) == 'o' || userInput.charAt(index) == 'u' ||
                userInput.charAt(index) == 'A' || userInput.charAt(index) == 'E' || userInput.charAt(index) == 'I' || userInput.charAt(index) == 'O' || userInput.charAt(index) == 'U')
        {
            count++;
        }
        // recursive call
        return count + countVowels(userInput, index+1);
    }

    /**  Main  **/
    public static void main(String[] args) throws Exception{
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int input = 0;
        String userInput = " ";

        // Menu
        while(input != 3) {
            try {
                System.out.print("\n---------MAIN MENU---------\n" +
                        "1. Read input string\n" +
                        "2. Compute number of vowels\n" +
                        "3. Exit program\n\n" +
                        " Enter option number: ");
                input = Integer.parseInt(sc.nextLine());

                // reads user input
               if(input == 1){
                    System.out.print("\nEnter input string: ");
                    userInput = sc.nextLine();
               }

               // vowel count
               else if(input == 2){
                    int vowelCount = countVowels(userInput, 0);
                    System.out.print("\nYou entered string:\t"+userInput+
                                     "\nNumber of vowels:\t"+vowelCount);
                    System.out.println();
               }

               // in case user inputs an option not on menu
               else{
                   System.out.println("Invalid menu option. Please choose between options 1-3.");
               }
            }
            // in case user inputs a non integer value
            catch (NumberFormatException e) {
                System.out.print("Invalid menu option. Please choose between options 1-3.");
            }
        }
        System.out.println("\nExiting...");
    }
}
