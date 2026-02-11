/**
 * Implement an application that support undo/redo functionality. Use a linked to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for the easy navigation.
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private final T state;
        private Node next;
        private Node previous;

        private Node (T state) {
            this.state = state;
        }
    }
    private Node currentState;

    //Undo Operation
    public T undo(){
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }
        Node previousState = currentState.previous;
        if (previousState == null) {
            System.out.println("Reached the initial stat");
        } else {
            currentState = previousState;
        }
        return currentState.state;
    }

    //perform an operation
    public void addState (T newState) {
        //create a new node for the new task
        Node newNode = new Node(newState);

        // If we add a new state after undoing, clear redo history
        if (currentState != null) {
            currentState.next = null;
        }
        //Set the link for the new Node
        newNode.previous = currentState;
        newNode.next = null;

        //update the next link for the current state
        if (currentState != null) {
            currentState.next = newNode;
        }
        //update the current to the new state
        currentState = newNode;

    }

    //REDO Method
    public T redo() {
        if (currentState == null) {
            System.out.println("No state to redo");
            return null;
        }

        Node nextState = currentState.next;

        if (nextState == null) {
            System.out.println("No further state to redo");
            return currentState.state;
        }

        currentState = nextState;
        return currentState.state;
    }



    public static void main(String[] args) {
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        undoRedoManager.addState("State 1");
        undoRedoManager.addState("State 2");
        undoRedoManager.addState("State 3");
        undoRedoManager.addState("State 4");
        undoRedoManager.addState("State 5");

        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);

        System.out.println("\n--- REDO TESTS ---");
        undoRedoManager.redo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println(" Current: " + undoRedoManager.currentState.state);

    }

}
