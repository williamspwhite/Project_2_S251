import java.util.HashMap;

public class PatientQueue {
    private Patient[] array;
    private PHashtable hashtable;
    private int insert_index;
    private int size;

    //private PHashtable table;

    /*TO BE COMPLETED IN PART 1*/

    //constructor: set variables
    //capacity = initial capacity of array
    public PatientQueue(int capacity) { //should just be PatientQueue
        array = new Patient[capacity + 1];

        System.out.println(capacity);
        System.out.println(array.length);

        hashtable = new PHashtable(capacity);
        insert_index = 1;
        size = 0;
    }

    //insert Patient p into queue
    //return the final index at which the patient is stored
    //return -1 if the patient could not be inserted
    public int insert(Patient p) {
        if (size() == array.length - 1) { //minus one because 0 isn't counted
            System.out.println("INSERT FAILED");
            return -1;
        }

        array[insert_index] = p; //inserts at next open index
        p.setPosInQueue(insert_index);

        insert_index++;
        size++;

        int swim = swim(p); // swims just inserted item
        // will return -1 if unable to swim




        if ((p.urgency() == 6) && (p.time_in() == 294)) {
            System.out.println("INSERTING " + p.name() + ":" + insert_index);
            System.out.println("INSERTED AT: " + swim);
        } else if ((p.urgency() == 6) && (p.time_in() == 295)) {
            System.out.println("INSERTING " + p.name() + ":" + insert_index);
            System.out.println("INSERTED AT: " + swim);
        }


        return swim;
        //TO BE COMPLETED
    }

    //remove and return the patient with the highest urgency level
    //if there are multiple patients with the same urgency level,
    //return the one who arrived first
    public Patient delMax() {
        if (isEmpty()) {
            return null;
        }
        for (int i = 1; i < size() + 1; i++) {
            swim(array[i]);
        }
        Patient return_patient = array[1];
        array_swap(return_patient, array[size()]);
        array[size()] = null;
        insert_index--;
        size--;
        return_patient.setPosInQueue(-1);
        sink(array[1]);



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
            System.out.println("EMPTY");
            return 0;
        }
        return size; // insert_index is one index above last index in array
        //TO BE COMPLETED
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


    public int swim(Patient p) {
        if (p == null) {
            System.out.println("SWIM FAILED");
            return -1;
        }
        int parent_index = Math.floorDiv(p.posInQueue(), 2);
        if (parent_index == 0) {
            return 1;
        }

        if (p.compareTo(array[parent_index]) > 0) {
            array_swap(p, array[parent_index]);
            return swim(p);
        }
        return p.posInQueue();
    }

    public int sink(Patient p) {
        if (p == null) {
            System.out.println("SINK FAILED");
            return -1;
        }
        //System.out.println("sinking");
        int left_child_index = p.posInQueue() * 2;
        int right_child_index = p.posInQueue() * 2 + 1;
        if ((left_child_index > array.length) || (right_child_index > array.length)) {
            return p.posInQueue();
        }

        if ((array[left_child_index] == null)) { //if first child is null, then there is no second child to check
            return p.posInQueue();
        }
        if (array[left_child_index].compareTo(p) > 0) {
            array_swap(array[left_child_index], p);
            return sink(p);
        } else if ((array[right_child_index] != null) && (array[right_child_index].compareTo(p) > 0)) {
            array_swap(array[right_child_index], p);
            return sink(p);
        }
        return p.posInQueue();
    }
    public void array_swap(Patient a, Patient b) {

        Patient temp_patient = a;
        int temp_pos = b.posInQueue();
        array[a.posInQueue()] = array[b.posInQueue()];
        b.setPosInQueue(a.posInQueue());
        array[temp_pos] = a;
        a.setPosInQueue(temp_pos);

        return;
    }

    public String toString() {
        String return_string = "[";
        for (int i = 1; i < size() + 1; i++) {
            return_string += "(" + array[i].toString() + ")";
        }
        return_string += "]";
        return return_string;
    }

}

    