import java.io.*;
import java.util.ArrayList;

// Server - handles file reading of data from CSV into a list of strings containing NodeID, YesID, NoID and Description.
// Elements are loaded into a Node object which holds the current state of the user's journey through the storyline.
// The description is the output. The user will follow instructions based on description. IDs remain hidden from user.
public class Server {

    // list - contains the IDs that the user can interact with
    // stores the IDs as a Node object
    private final ArrayList<Node> list;

    public Server() throws IOException {

        String csvFile = ".\\src\\data.csv";

        //create list object
        list = new ArrayList<>();


        BufferedReader buffRead = new BufferedReader(new FileReader(csvFile));

        // currentLine - stores one line from the csvFile at a time
        String currentLine;

        while ((currentLine = buffRead.readLine()) != null) {

            // split - separates the line into separate elements everytime a comma is encountered
            String[] currentItem = currentLine.split(",");

            // Some descriptions may have commas in them
            // The .split() function reads these additional commas and returns them as separate elements in currentItem
            // This function appends all extra items in currentItem into one string to fit into the Node parameters
            Node myNode = checkSplit(currentItem);



            // list.add - appends the line to list
            list.add(myNode);
        }
        buffRead.close();

    }

    // checkSplit - Checks if the description contains commas and concatenates any extra elements into one string
    // Else, it returns a normal node using the currentItem as it were correct
    private Node checkSplit(String[] currentItem) {
        if (currentItem.length > 4) {
            String fullDescription = "";

            // Only concatenates the description, everything else is correct
            for (int element=3; element<currentItem.length; element++) {
                fullDescription += currentItem[element];

                // Prevents the program from adding trailing commas to the end of the description
                if (element < currentItem.length) {
                    fullDescription += ",";
                }

            }

            return new Node(currentItem[0], currentItem[1], currentItem[2], fullDescription);

        } else {
            return new Node(currentItem[0], currentItem[1], currentItem[2], currentItem[3]);
        }

    }

    // findNodes - used for finding nodes in the list.
    public Node findNodes(int ID){

        // loop through each Node in list until the correct nodeID is found
        for(Node item : list) {

            if (item.getNodeID() == ID) {

                return item;

            }

        }

        // empty Node objects are used to check if a node was found in the csv
        return new Node();


    }
}
