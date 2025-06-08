// Name: Tyler Stroud

public class AverageGrades {
    /** recursive method **/
    public static double findAverage(int[] gradesArray, int length){
        double average, sum;
        if(length == 0){
            return 0;
        }
        else if(length == 1){
            return gradesArray[0];
        }
        // recursive call to compute sum
        else {
            sum = gradesArray[length-1] + (length-1) * findAverage(gradesArray, length-1);
        }
        average = sum / length;
        return average;
    }

    /** Main **/
    public static void main(String[] args) throws Exception {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int size = 0;
        int input = 0;
        int[] classGrades = new int[size];

        while (input != 4) {
                try{
                System.out.print("\n--------MAIN MENU-------\n" +
                        "1. Read class size\n" +
                        "2. Read class grades\n" +
                        "3. Compute class average\n" +
                        "4. Exit program\n\n" +
                        " Enter option number: ");
                input = Integer.parseInt(sc.nextLine());

                // class size
                if (input == 1) {
                    System.out.print("\nEnter the size of your class: ");
                    size = Integer.parseInt(sc.nextLine());
                    while (size < 0) {
                        try {
                            System.out.print("\nInvalid class size.\nPlease enter a valid class size: ");
                            size = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.print("\nInvalid format.");
                        }
                    }
                }

                // class grades
                else if (input == 2) {
                    int[] tempArray = new int[size];
                    if (size == 0) {
                        System.out.println("You don't have any students in your class.");
                    } else {
                        System.out.println("\nEnter the grades for each student:");
                        for (int i = 0; i < size; i++) {
                            System.out.print("Student " + (i + 1) + ": ");
                            int grade = Integer.parseInt(sc.nextLine());
                            while (grade < 0 || grade > 100) {
                                System.out.print("** Invalid grade **\nPlease enter a valid grade for student " + (i + 1) + ": ");
                                grade = Integer.parseInt(sc.nextLine());
                            }
                            tempArray[i] = grade;
                        }
                        classGrades = tempArray;
                    }
                }

                // class average (calls recursive method)
                else if (input == 3) {
                    double average = findAverage(classGrades, classGrades.length);
                    System.out.println("\nYou entered class size:\t" + size);
                    System.out.print("You entered grades:\t\t");
                    for (int i = 0; i < classGrades.length; i++) {
                        System.out.print(classGrades[i] + " ");
                    }
                    System.out.print("\nClass average:\t\t\t");
                    System.out.printf("%,.2f", average);
                    System.out.println();
                }

                // in case user inputs any option > 4
                else if (input > 4){
                    System.out.println("\nInvalid menu option. Please choose between options 1-4.");
                }
            }catch(NumberFormatException e){
                    System.out.println("\nInvalid menu option. Please choose between options 1-4.");
            }
        }
        System.out.println("\nExiting...");
    }
}
