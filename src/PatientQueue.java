public class PatientQueue {
    private Patient[] array;
    private int insert_index;
    //constructor: set variables
    //capacity = initial capacity of array 
    public PatientQueue(int capacity) {
        System.out.println(capacity);
        array = new Patient[capacity + 1];
        System.out.println(array.length);
        insert_index = 1;
	//TO BE COMPLETED
    }
    
    //insert Patient p into queue
    //return the final index at which the patient is stored
    //return -1 if the patient could not be inserted
    public int insert(Patient p) {
        if (size() == array.length - 1) { //minus one because 0 isn't counted
            return -1;
        }

        array[insert_index] = p; //inserts at next open index
        insert_index++;
        int swim = swim(insert_index - 1); // swims just inserted item
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
        //System.out.println(toString());
        //System.out.println("DELETING");
        if (isEmpty()) {
            return null;
        }
        Patient return_patient = array[1];
        array_swap(1, size());
        array[size()] = null;
        insert_index--;

        for (int i = 1; i < size(); i++) {
            sink(i);
        }
        //System.out.println(toString());

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

        return insert_index - 1; // insert_index is one index above last index in array
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
        //System.out.println(toString());
        int parent_index = Math.floorDiv(swimming_index, 2);
        if (parent_index == 0) {
            //System.out.println("no swimming");
            return 1;
        }
        if ((array[swimming_index] == null)) {
            System.out.println("SWIM FAILED");
            return -1;
        }
        if (array[swimming_index].compareTo(array[parent_index]) > 0) {
            array_swap(swimming_index, parent_index);
            return swim(parent_index);
        }
        return swimming_index;
    }

    public int sink(int parent_index) {
        //System.out.println("sinking");
        int left_child_index = parent_index * 2;
        int right_child_index = parent_index * 2 + 1;
        if ((left_child_index > array.length) || (right_child_index > array.length)) {
            return parent_index;
        }

        if ((array[left_child_index] == null)) { //if first child is null, then there is no second child to check
            return parent_index;
        }
        if (array[left_child_index].compareTo(array[parent_index]) > 0) {
            array_swap(left_child_index, parent_index);
            if (array[right_child_index].compareTo(array[parent_index]) > 0) {
                array_swap(right_child_index, parent_index);
            }
        }

//        if (array[second_child_index] == null) { //if second child is null, then check if first needs to be swapped
//            if (array[first_child_index].urgency() > array[sinking_index].urgency()) {
//                array_swap(sinking_index, first_child_index);
//                return first_child_index;
//            } else if ((array[first_child_index].urgency() == array[sinking_index].urgency()) &&
//                    (array[first_child_index].time_in() < array[sinking_index].time_in())) {
//                array_swap(sinking_index, first_child_index);
//                return first_child_index;
//            } else {
//                return sinking_index;
//            }
//        }

//        if (array[left_child_index].urgency() > array[parent_index].urgency()) {
//            array_swap(left_child_index, parent_index);
//
//            return sink(left_child_index);
//
//        } else if ((array[left_child_index].urgency() == array[parent_index].urgency()) &&
//                (array[left_child_index].time_in() < array[parent_index].time_in())) {
//            array_swap(left_child_index, parent_index);
//            return sink(left_child_index);
//
//        } else if ((array[right_child_index] != null) && (array[right_child_index].urgency() > array[parent_index].urgency())) {
//            array_swap(right_child_index, parent_index);
//            return sink(right_child_index);
//
//        } else if ((array[right_child_index] != null) && (array[right_child_index].urgency() == array[parent_index].urgency()) &&
//                (array[right_child_index].time_in() < array[parent_index].time_in())) {
//            array_swap(right_child_index, parent_index);
//            return sink(right_child_index);
//
//        }

//        if ((array[first_child_index].urgency() >= array[sinking_index].urgency()) || //checks if either need to be swapped
//                (array[second_child_index].urgency() >= array[sinking_index].urgency())) {
//
//
//            if (array[first_child_index].urgency() > array[second_child_index].urgency()) { //if first child is greater than second child, must possible swap with first
//                if ((array[first_child_index].urgency() == array[sinking_index].urgency()) && // if urgency is same and sinking_index came first, return sinking_index
//                        (array[first_child_index].time_in() > array[sinking_index].time_in())) {
//                    return sinking_index;
//                } else {
//                    array_swap(sinking_index, first_child_index);
//                    return sink(first_child_index);
//                }
//            } else if (array[first_child_index].urgency() == array[second_child_index].urgency()) {
//
//                if (array[first_child_index].time_in() < array[second_child_index].time_in()) {
//                    array_swap(sinking_index, first_child_index);
//                    return sink(first_child_index);
//                } else {
//                    array_swap(sinking_index, second_child_index);
//                    return sink(second_child_index);
//                }
//            } else {
//                if ((array[second_child_index].urgency() == array[sinking_index].urgency()) && // if urgency is same and sinking_index came first, return sinking_index
//                        (array[second_child_index].time_in() > array[sinking_index].time_in())) {
//                    return sinking_index;
//                } else {
//                    array_swap(sinking_index, second_child_index);
//                    return sink(second_child_index);
//                }
//            }
//        }
        return parent_index;
    }
//    public boolean hasPriority(int a_index, int b_index) { //1 is more important, 0 equal, -1 is less important
//        if (array[a_index].urgency() > array[b_index].urgency()) {
//            return true;
//        } else if (array[a_index].urgency() == array[b_index].urgency()) {
//            if (array[a_index].time_in() < array[b_index].time_in()) {
//                return true;
//            }
//        }
//        return false;
//    }
    public void array_swap(int a_index, int b_index) {
        Patient temp = array[a_index];
        array[a_index] = array[b_index];
        array[b_index] = temp;
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
    