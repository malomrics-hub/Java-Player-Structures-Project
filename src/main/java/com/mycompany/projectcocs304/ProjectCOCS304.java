/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projectcocs304;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ProjectCOCS304 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList LinkedPlayers = new LinkedList();
        StackList StackPlayers = new StackList();
        try {
            FileReader fr = new FileReader("src/main/java/com/mycompany/projectcocs304/players (3).csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            br.readLine();//To start from the second line of reading from the CSV file;
            while ((line = br.readLine()) != null) //br.readLine()stores each line in (line variable);
            {
                int firstComma = line.indexOf(","); //Save the place of the first comma;
                int secondComma = line.lastIndexOf(",");//Save the place of the second comma;
                String name = line.substring(0, firstComma);//Save name from CSV file;
                String scoreString = line.substring(firstComma + 1, secondComma); //Save score from CSV file;
                int score = Integer.parseInt(scoreString); //Convert score from String to integer;
                String DateJoined = line.substring(secondComma + 1); //Save date joined from CSV file;
                LinkedPlayers.insrtAtEndPlayers(name, score, DateJoined);//Send to method insrtAtEndPlayers();
                StackPlayers.push(name, score, DateJoined);//Send to method push();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        while (true) //We use While to repetition until the user requests an exit;
        {
            System.out.println("********************Menu*********************************");
            System.out.println("Enter 1 if you want to add new player.");
            System.out.println("Enter 2 if you want to Remove player.");
            System.out.println("Enter 3 if you want to Update player score.");
            System.out.println("Enter 4 if you want to display all players.");
            System.out.println("Enter 5 if you want to sort players.");
            System.out.println("Enter 6 if you want to filter players.");
            System.out.println("Enter 0 if you want to exit.");
            System.out.print("Choose an option: ");
            int choose = 0;
            boolean validchoose = false; //In the event that the user is given a correct number becomes validchoose=true and the program is completed;
            while (!validchoose) 
            {
                try {
                    choose = input.nextInt();
                    validchoose = true; //If the conversion process is done, validchoose turns into true;
                } catch (Exception e) {
                    System.out.println("Invalid input please enter valid number.");
                    System.out.print("Try again: ");
                    input.nextLine(); //To remove or pick up any unwanted inputs;
                }
            }
            System.out.println("********************************************************");
            switch (choose) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = input.next();
                    System.out.print("Enter player score: ");
                    int score = 0;
                    //To ensure a correct entry from the user;
                    boolean validscore = false; //In the event that the user is given a correct number becomes validscore=true and the program is completed;
                    while (!validscore) {
                        try {
                            score = input.nextInt();
                            validscore = true; //If the conversion process is done, validscore turns into true;
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine(); //To remove or pick up any unwanted inputs;
                        }
                    }
                    //We ask the user as follows: the year of joining, the month of joining, the day of joining to ensure the entry of a correct date;
                    System.out.print("Enter the year the player joined(YYYY): ");
                    int year = 0;
                    boolean validyear = false; //In the event that the user is given a correct number becomes validyear=true and the program is completed;
                    while (!validyear) {
                        try {
                            year = input.nextInt();
                            if(year>=2019&&year<=2030)//The year of joining must be from 2019 to 2030;
                            {
                             validyear=true; //If the conversion process is done, validyear turns into true;
                            } 
                            else{
                                System.out.println("Invalid input, must be a real year number ");
                                System.out.print("Try again: ");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    System.out.print("Enter the month the player joined(MM): ");
                    int monthCheck = 0;
                    boolean validmonthCheck = false; //In the event that the user is given a correct number becomes validmonthCheck =true and the program is completed;
                    while (!validmonthCheck) {
                        try {
                            monthCheck = input.nextInt();
                            if(monthCheck>0&&monthCheck<=12) //To ensure that the given month is correct;
                            {
                             validmonthCheck=true; //If the conversion process is done, validmonthCheck turns into true;
                            } 
                            else{
                                System.out.println("Invalid input, must be a real month number ");
                                System.out.print("Try again: ");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    String month  = Integer.toString(monthCheck); //Convert month to String;
                    if (month.length() != 2) //In the event of the user, he did not add 0 before the month;
                    {
                        month = "0" + month;
                    }
                    System.out.print("Enter the day the player joined(DD): ");
                    int dayCheck = 0;
                    boolean validdayCheck = false; //In the event that the user is given a correct number becomes validdayCheck=true and the program is completed;
                    while (!validdayCheck) {
                        try {
                            dayCheck = input.nextInt();
                            if(dayCheck>0&&dayCheck<=31)  //To ensure that the given month is correct;
                            {
                             validdayCheck = true; //If the conversion process is done, validdayCheck turns into true;
                            }
                            else{
                                System.out.println("Invalid input, must be a real day number ");
                                System.out.print("Try again: ");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    String day  = Integer.toString(dayCheck); //Convert day to String;
                    if (day.length() != 2)//In the event of the user, he did not add 0 before the month;
                    {
                        day = "0" + day;
                    }
                    String DateJoined = (year + "-" + month + "-" + day); //DateJoined="YYYY-MM-DD";
                    LinkedPlayers.insrtAtEndPlayers(name, score, DateJoined); //Send to method insrtAtEndPlayers();
                    StackPlayers.push(name, score, DateJoined); //Send to method push();
                    System.out.println("Player has been successfully added: Name: " + name + " Score: " + score + " DateJoined: " + DateJoined);
                    break;
                case 2:
                    System.out.println("Are you sure you want remove player?"); //In order to make sure that the user really wants to delete a player;
                    System.out.print("Press 1 to confirm, 2 to cancel: ");
                    //To make sure that he entered a correct number, to avoid stopping the program;
                    int oneOrTwoRemove = 0;
                    boolean validoneOrTwoRemove = false; 
                    while (!validoneOrTwoRemove) {
                        try {
                            oneOrTwoRemove = input.nextInt();
                            validoneOrTwoRemove = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    if (oneOrTwoRemove == 1) {
                        System.out.print("Enter the name of the player you want to remove: ");
                        String n = input.next(); //The name of the player to be deleted;
                        LinkedPlayers.removePlayerfromLinkedList(n); //Send to method insrtAtEndPlayers();
                        StackPlayers.removePlayerFromStackList(n); //Send to method push();
                    } else {
                    }
                    break;
                case 3:
                    System.out.println("Are you sure you want Update player?"); //In order to make sure that the user really wants to Update a player;
                    System.out.print("Press 1 to confirm, 2 to cancel: ");
                    //To make sure that he entered a correct number, to avoid stopping the program;
                    int oneOrTwoUpdate = 0;
                    boolean validoneOrTwoUpdate = false;
                    while (!validoneOrTwoUpdate) {
                        try {
                            oneOrTwoUpdate = input.nextInt();
                            validoneOrTwoUpdate = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    if (oneOrTwoUpdate == 1) {
                        System.out.print("Enter the name of the player you want to Update: ");
                        String n = input.next(); //The name of the player to be Updated;
                        System.out.print("Enter the new score for the player: ");
                        int newscore = 0; //New score;
                        boolean validnewscore = false;
                        while (!validnewscore) {
                            try {
                                newscore = input.nextInt();
                                validnewscore = true;
                            } catch (Exception e) {
                                System.out.println("Invalid input please enter valid number.");
                                System.out.print("Try again: ");
                                input.nextLine();
                            }
                        }
                        LinkedPlayers.updatePlayerScoreFromLinkedList(n, newscore);//Send to method insrtAtEndPlayers();
                        StackPlayers.updatePlayerScoreFromStackList(n, newscore); //Send to method push();
                    } else {
                    }
                    break;
                case 4:
                    LinkedPlayers.printAllLinkedList(); //display all players;
                    break;
                case 5:
                    System.out.println("Enter 1 if you want to sort by name.");
                    System.out.println("Enter 2 if you want to sort by score.");
                    System.out.println("Enter 3 if you want to sort by Date Joined.");
                    System.out.print("Choose an option: ");
                    //To make sure that he entered a correct number, to avoid stopping the program;
                    int chooseDisplay = 0;
                    boolean validchooseDisplay = false;
                    while (!validchooseDisplay) {
                        try {
                            chooseDisplay = input.nextInt();
                            validchooseDisplay = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    switch (chooseDisplay) {
                        case 1:
                            StackPlayers.sortByNameAlphabetical(); //Calling the sorting function by name;
                            StackPlayers.printAllStack(); //printing;
                            break;
                        case 2:
                            StackPlayers.sortByScoreDescending(); //Calling the sorting function by score;
                            StackPlayers.printAllStack(); //printing;
                            break;
                        case 3:
                            System.out.print("Enter 1 for ascending order or 2 for descending order: "); 
                            //To make sure that he entered a correct number, to avoid stopping the program;
                            int chooseSortDateJoined = 0;
                            boolean validchooseSortDateJoined = false;
                            while (!validchooseSortDateJoined) {
                                try {
                                    chooseSortDateJoined = input.nextInt();
                                    validchooseSortDateJoined = true;
                                } catch (Exception e) {
                                    System.out.println("Invalid input please enter valid number.");
                                    System.out.print("Try again: ");
                                    input.nextLine();
                                }
                            }
                            if (chooseSortDateJoined == 1) {
                                StackPlayers.sortByDateJoinedAscending(); //Calling the sorting function by date joined of the ascending;
                                StackPlayers.printAllStack();
                            } else {
                                StackPlayers.sortByDateJoinedDescending();//Calling the sorting function by date joined of the descending;
                                StackPlayers.printAllStack();
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 6:
                   System.out.println("Enter 1 if you want to filter by Score range.");
                    System.out.println("Enter 2 if you want to filter by join Year.");
                    System.out.print("Choose an option: ");
                    //To make sure that he entered a correct number, to avoid stopping the program;
                    int chooseFilter=0;
                    boolean validchooseFilter= false;
                    while (!validchooseFilter) {
                        try {
                            chooseFilter = input.nextInt();
                            validchooseFilter = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input please enter valid number.");
                            System.out.print("Try again: ");
                            input.nextLine();
                        }
                    }
                    if(chooseFilter==1) //filter by Score range;
                    {
                        System.out.print("Enter minimum score: ");
                         //To make sure that he entered a correct number, to avoid stopping the program;
                        int minmum = 0;
                        boolean validcminmum = false;
                        while (!validcminmum) {
                            try {
                                minmum = input.nextInt();
                                validcminmum = true;
                            } catch (Exception e) {
                                System.out.println("Invalid input please enter valid number.");
                                System.out.print("Try again: ");
                                input.nextLine();
                            }
                        }
                        System.out.print("Enter maximum score: ");
                         //To make sure that he entered a correct number, to avoid stopping the program;
                        int maximum = 0;
                        boolean validmaximum = false;
                        while (!validmaximum) {
                            try {
                                maximum = input.nextInt();
                                validmaximum = true;
                            } catch (Exception e) {
                                System.out.println("Invalid input please enter valid number.");
                                System.out.print("Try again: ");
                                input.nextLine();
                            }
                        }
                        LinkedPlayers.filterPlayersByScore(minmum, maximum); //Send values to the method;
                        }
                      else if(chooseFilter==2){
                      System.out.print("Enter join year: ");
                      //To make sure that he entered a correct number, to avoid stopping the program;  
                      int yearJoin = 0;
                        boolean validyearJoin= false;
                        while (!validyearJoin) {
                            try {
                                yearJoin = input.nextInt();
                                validyearJoin = true;
                            } catch (Exception e) {
                                System.out.println("Invalid input please enter valid number.");
                                System.out.print("Try again: ");
                                input.nextLine();
                            }
                        }
                        LinkedPlayers.filterPlayersByDateJoined(yearJoin);//Send values to the method;
                    }
                    break;
                case 0:
                    System.out.println("Exiting program."); 
                    return; //We use (return) to get out of the program completely;
                default: //In the event that I enter a value outside the menu;
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        }
    }
}
