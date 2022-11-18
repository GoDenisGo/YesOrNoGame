/** Node - stores all the data for the current line in file. Attributes consist of:
 * <p>nodeID - specifies the current node that is being accessed.
 * <p>yesID - the next node to jump to if the user selects the "yes" option in terminal.
 * <p>noID - the next node to jump to if the user selects the "no" option in terminal.
 * <p>description - a description of the current node being accessed; provides the context for the user's next action.
 */
public class Node {
    private final int nodeID;
    private final int yesID;
    private final int noID;
    private final String description;

    public Node() {
        nodeID = -2;
        yesID = 0;
        noID = 0;
        description = "Error - node not initialised correctly.";
    }

    public Node(String node, String yes, String no, String desc) {
        this.nodeID = Integer.parseInt(node);
        this.yesID = Integer.parseInt(yes);
        this.noID = Integer.parseInt(no);
        this.description = desc;
    }

    // isValid - checks if the object is un-initialised
    // used for handling wrong situations, for example, if the correct node wasn't found in the csvFile
    public boolean isValid() {
        return nodeID != -2;
    }

    public int getNodeID() {
        return nodeID;
    }

    public int getYesID() {
        return yesID;
    }

    public int getNoID() {
        return noID;
    }

    public String getDescription() {
        return description;
    }
}
