import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteractions {

    public static void main(String[] args) throws IOException {

        // buffRead - allows the user to input choices via the terminal
        BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

        // choiceLoop - turns true whenever the user decides to exit the program
        boolean choiceLoop = false;

        // server - handles file reading
        Server server = new Server();

        // Introduce the user to the program
        Greetings();

        Node currentNode = server.findNodes(0);
        System.out.println(currentNode.getDescription());

        while (!choiceLoop) {

            String userChoice = "";

            if (currentNode.getYesID() != -1) {
                System.out.println("\n-------------------------");
                System.out.println("\nEnter your choice: ");
                userChoice = buffRead.readLine();
                System.out.println("--------------------------");
                System.out.println(" ");
            } else {
                System.out.println("\n-------------------------");
                System.out.println("\nEnter 1 to continue: ");
                userChoice = buffRead.readLine();
                System.out.println("--------------------------");
                System.out.println(" ");
            }



            // checks if the user wants to exit the program
            if (userChoice.equals("9")) {

                choiceLoop = true;

                // user enters "yes"
            } else if (userChoice.equals("1")) {

                currentNode = server.findNodes(currentNode.getYesID());


                // quits the program if the user decides to finish the session
                if (currentNode.getNodeID() == -2) {
                    //System.out.println("Press any number to contineu");
                    return;
                }

                if (!currentNode.isValid()) {
                    System.out.println("The correct node could not be found.");
                    System.out.println("The currentNode looks like: " + currentNode);
                }

                // terminates the program, otherwise, displays the next node to the user
                if (currentNode.getDescription().equals("exit")) {

                    System.out.println("\n---------------------------");
                    System.out.println("Thank you, exiting now...");
                    choiceLoop = true;

                } else {

                    System.out.println(currentNode.getDescription());

                }

                // user enters "no"
            } else if (userChoice.equals("2")) {

                currentNode = server.findNodes(currentNode.getNoID());

                // quits the program if the user decides to finish the session
                if (currentNode.getNodeID() == -2) {
                    System.out.println("\n\n---------------------------------");
                    System.out.println("Thank you for your time! Goodbye!");
                    System.out.println("---------------------------------");
                    return;
                }

                if (!currentNode.isValid()) {
                    System.out.println("The correct node could not be found. If the issue persists, exit by entering '9'.");
                    System.out.println("The currentNode looks like: " + currentNode);
                }

                // terminates the program, otherwise, displays the next node to the user
                if (currentNode.getDescription().equals("exit")) {

                    System.out.println("\nThank you, exiting now...");
                    choiceLoop = true;

                } else {

                    System.out.println(currentNode.getDescription());

                }

            } else {

                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Sorry! I didn't understand that! Make sure to enter a '1', a '2' or a '9'!");
                System.out.println("\n-------------------------------------------------------------------------");


            }
        }

    }

    private static void Greetings() {
        System.out.println("\n\n-------------------------------------------------------------------------");
        System.out.println("Hello World, this is a program to determine if I should revise or not.");
        System.out.println("Simply enter a '1' if you want to say 'yes'!");
        System.out.println("Or enter a '2' if you want to say 'no'!\n");
        System.out.println("Also, you can exit the program at any time. Just enter '9' to exit.");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");
    }
}
