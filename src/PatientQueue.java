public class PatientQueue {
    private Patient[] array;
    
    //constructor: set variables
    //capacity = initial capacity of array 
    public PatientQueue(int capacity) {
	//TO BE COMPLETED
    }
    
    //insert Patient p into queue
    //return the final index at which the patient is stored
    //return -1 if the patient could not be inserted
    public int insert(Patient p) {
        return 0;
	//TO BE COMPLETED
    }

    //remove and return the patient with the highest urgency level
    //if there are multiple patients with the same urgency level,
    //return the one who arrived first
    public Patient delMax() {
        return NULL;
	//TO BE COMPLETED
    }

    //return but do not remove the first patient in the queue
    public Patient getMax() {
        return NULL;
	//TO BE COMPLETED
    }

    //return the number of patients currently in the queue
    public int size() {
        return 0;
	//TO BE COMPLETED
    }

    //return true if the queue is empty; false else
    public boolean isEmpty() {
        return false;
	//TO BE COMPLETED
    }

    //used for testing underlying data structure
    public Patient[] getArray() {
	return array;
    }
}
    