public class PatientQueue {
    private Patient[] array;
    private int insert_index;
    //constructor: set variables
    //capacity = initial capacity of array 
    public PatientQueue(int capacity) {
        array = new Patient[capacity + 1];
        insert_index = 1;
	//TO BE COMPLETED
    }
    
    //insert Patient p into queue
    //return the final index at which the patient is stored
    //return -1 if the patient could not be inserted
    public int insert(Patient p) {
        if (size() == array.length) {
            return -1;
        }
        array[insert_index] = p; //inserts at last index
        return swim(insert_index); // will return -1 if unable to swim
	//TO BE COMPLETED
    }

    //remove and return the patient with the highest urgency level
    //if there are multiple patients with the same urgency level,
    //return the one who arrived first
    public Patient delMax() {

        array_swap(1, size());
        Patient return_patient = array[size()];
        array[size()] = null;
        sink(1);
        return return_patient;
	//TO BE COMPLETED
    }

    //return but do not remove the first patient in the queue
    public Patient getMax() {
        if (isEmpty()) {
            return null;
        }
        return array[1]; // first patient is at index 1
	//TO BE COMPLETED
    }

    //return the number of patients currently in the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return insert_index - 1;
    }

    //return true if the queue is empty; false else
    public boolean isEmpty() {
        if (array[1] == null) { // first patient is at index 1
            return true;
        }
        return false;
	//TO BE COMPLETED
    }

    //used for testing underlying data structure
    public Patient[] getArray() {
	    return array;
    }

    public int swim(int swimming_index) {
        if (array[swimming_index] == null) {
            assert false;
            return -1;
        }
        int parent_index = Math.floorDiv(swimming_index, 2);
        if (array[parent_index].urgency() < array[swimming_index].urgency()) {
            array_swap(parent_index, swimming_index);
            return swim(parent_index);
        }
        return swimming_index;
    }

    public int sink(int sinking_index) {
        int first_child_index = sinking_index * 2;
        int second_child_index = sinking_index * 2 + 1;
        if ((array[first_child_index].urgency() > array[sinking_index].urgency()) ||
                (array[second_child_index].urgency() > array[sinking_index].urgency())) {


            if (array[first_child_index].urgency() > array[second_child_index].urgency()) {
                array_swap(sinking_index, first_child_index);
                return sink(first_child_index);
            } else {
                array_swap(sinking_index, second_child_index);
                return sink(second_child_index);
            }
        }
        return sinking_index;
    }

    public void array_swap(int a_index, int b_index) {
        Patient temp = array[a_index];
        array[a_index] = array[b_index];
        array[b_index] = temp;
        return;
    }

}
    