
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Lab {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); 

        //========================== Task-1 ==========================
        // 1.Write a program to find all of the longest word in a given dictionary.

        String[] words = {"cat", "dog", "red", "is", "am"}; 
        ArrayList<String> longestWords = new ArrayList<>();
        int longestLenght = 0; 

        for(String word : words){
            int length = word.length(); 

            if(length > longestLenght){
                longestLenght = length;
                longestWords.clear();
            }
            
            if (length == longestLenght){
                longestWords.add(word); 
            }
        }
        System.out.println(longestWords);



        //========================== Task-2 ==========================
        // 2. Write a program that displays the number of occurrences of an element in the array.

        int[] originalArray = {1, 1, 1, 3, 3, 5};
        System.out.print("Enter the number to check: ");
        int number = input.nextInt();
        int count = 0;

        for(int num : originalArray){
            if(num == number){
                count++; 
            }
        }

        System.out.println(number +" occurs " + count + (count > 0 ? " times" : " time "));



        //========================== Task-3 ==========================
        // 3.Write a program to find the k largest elements in a given array. Elements in the array can be in any order.

        int[] arr = {1, 4, 17, 7, 25, 3, 100}; 

        System.out.print("Enter a number from 1 to " + arr.length + " : ");
        int largest = input.nextInt(); 
        
        int n = arr.length; 
            
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] < arr[j + 1]){
                    int step = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = step; 
                }
            }
        }

        System.out.print(largest + " largest elements of the said array are: ");
        for(int i = 0; i < largest; i++){
            System.out.print(arr[i] + " ");
        }


        //========================== Task-4 ==========================
        // 4. Create a method to reverse an array of integers. Implement the method without creating a new array.

        int[] numbers = {5, 4, 3, 2, 1};
        reverseArray(numbers);


        //========================== Task-5 ==========================
        // 5. Write a menu driven Java program with following option: 

        ArrayList<Integer> numbers = new ArrayList<>();
        int choice = 0;


        do{
            System.out.println("===============================================================");
            System.out.println("======================= menu driven ===========================");
            System.out.println("===============================================================\n");
            System.out.println(
                "1.Accept elements of an array\n" +
                "2.Display elements of an array\n" +
                "3.Search the element within array\n" +
                "4.Sort the array\n"+
                "5.To Stop\n");

            System.out.print(" -----------> Enter the number: ");
            choice = input.nextInt();
            System.out.println();

            switch(choice){
                case 1:
                    System.out.print("Input the element: ");
                    int element = input.nextInt();
                    numbers.add(element);  
                    System.out.println();
                    break;

                case 2:
                    System.out.println("========> " + numbers + " <========\n");
                    break;

                case 3:
                    System.out.print("Input the element you want to find: ");
                    int search = input.nextInt();
                    boolean found = false;  

                    for(int number : numbers){
                        if(number == search){
                            found = true;
                            break; 
                        }
                    }

                    if (found) {
                        System.out.println("Element found in the array.");
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    break; 
    
                case 4:
                    sort(numbers);
                    System.out.println("========> " + numbers + " <========\n");
                    break; 

                case 5:
                    return;
                    
                default:
                    System.out.println("( Choose one of the menu )\n");
            }
    
        }while(true); 


        //========================== Task-6 ==========================
        // 6. Create a method that generates a random number within a given range. Allow the user to specify the range and call the method to display random numbers.

        System.out.print("Enter the minimum value of the range: ");
        int min = input.nextInt(); 

        System.out.print("Enter the maximum value of the range: ");
        int max = input.nextInt();

        System.out.print("Enter the number of random numbers to generate: ");
        int randomOfNumbers = input.nextInt(); 

        if(min > max){
            System.out.println("The minimum value cannot be greater than the maximum value.");
        }else {
            System.out.println("Random numbers within the speccified range: ");
            for(int i = 0; i < randomOfNumbers; i++){
                System.out.print(randomRange(min, max));
                if(i < randomOfNumbers - 1){
                    System.out.print(" - ");
                }
            }
        }


        //========================== Task-7 ==========================
        // 7. Write a program that checks the strength of a password. Create a method that evaluates a password based on criteria like length, inclusion of special characters, and uppercase/lowercase letters.
        
        System.out.print("Enter a password: ");
        String password = input.nextLine(); 
        int totalScore = 0; 
        totalScore += checkLength(password);
        totalScore += checkSpecialCharacters(password);
        totalScore += checkUpperCaseLowerCase(password);


        if(totalScore >= 8){
            System.out.println("Password is Strong. ");
        }else if (totalScore >= 6){
            System.out.println("Password is meduim.");
        }else {
            System.out.println("Password is weak.");
        }

        //========================== Task-8 ==========================
        // 8. Create a method that generates the Fibonacci sequence up to a specified number of terms.

        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int fibonacci = input.nextInt(); 

        System.out.print("Fibonacci sequence with " + fibonacci + " terms: ");
        for(int i : fibonacci(fibonacci)){
            System.out.print(i + " ");
        }

        // ========================================= // 
    }

    public static void sort(ArrayList<Integer> arr){
        int n = arr.size();
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr.get(j) > arr.get( j + 1)){
                    int step = arr.get(j);
                    arr.set(j, arr.get(j + 1)); 
                    arr.set(j + 1,  step); 
                }
            }
        }
    }

    public static void reverseArray(int[] numbers){
        System.out.println("Original Array: " + Arrays.toString(numbers));
        for(int i = 0; i < numbers.length / 2; i++){
            int step = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1]; 
            numbers[numbers.length - i - 1] = step; 
        }
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }


    public static int[] fibonacci(int number){
        if(number <= 0) return new int[0];
        
        int[] fibonacciSequence = new int[number]; 

        fibonacciSequence[0] = 0; 
        if(number == 1) return fibonacciSequence; 

        fibonacciSequence[1] = 1; 

        for(int i = 2; i < number; i++){
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2 ]; 
        }
        return fibonacciSequence; 
    }

    public static int randomRange(int min, int max){
        Random random = new Random(); 
        return random.nextInt((max - min) + 1) + min; 
    }


    // ================================================== //
    public static int checkLength(String password){

        if(password.length() >= 8) return 3;
        else if(password.length() >= 6) return 2; 
        else return 0; 
    
    }



    public static int  checkSpecialCharacters(String password){
        String specialCharacters = "!@#$%^&*()-_=+[]{}\\|;:'\",<.>/?"; 

        for(char c : password.toCharArray()){
            if(specialCharacters.contains(String.valueOf(c))) return 2; 
        }
        return 0; 
    }


    public static int checkUpperCaseLowerCase(String password){
        boolean hasUpperCase = false;
        boolean hasLowercase = false; 

        for(char c : password.toCharArray()){

            if(Character.isUpperCase(c)) hasUpperCase = true; 
            if(Character.isLowerCase(c)) hasLowercase = true; 
        }

        if(hasUpperCase && hasLowercase) return 3; 
        else return 0; 

    }

    // ================================================== //

}
