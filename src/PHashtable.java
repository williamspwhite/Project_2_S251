import java.util.ArrayList;
public class PHashtable {
    private ArrayList[] table;
    private int t_capacity;
    private int size;
    //set the table size to the first 
    //prime number p >= capacity
    public PHashtable (int capacity) {
        table = new ArrayList[getNextPrime(capacity)];
        t_capacity = capacity;
        size = 0;
	//TO BE COMPLETED
    }

    //return the Patient with the given name 
    //or null if the Patient is not in the table
    public Patient get(String name) {
        System.out.println(name.hashCode() % t_capacity);
        return null;
	//TO BE COMPLETED
    }

    //put Patient p into the table
    public void put(Patient p) {
        size++;
        return;
	//TO BE COMPLETED
    }

    //remove and returnthe Patient with the given name
    //from the table
    //return null if Patient doesn't exist
    public Patient remove(String name) {
        size--;
        return null;
	//TO BE COMPLETED
    }	    

    //return the number of Patients in the table
    public int size() {
        return size;
	//TO BE COMPLETED
    }

    //returns the underlying structure for testing
    public ArrayList<Patient>[] getArray() {
	return table;
    }
    
    //get the next prime number p >= num
    private int getNextPrime(int num) {
    if (num == 2 || num == 3)
        return num;
    int rem = num % 6;
    switch (rem) {
        case 0:
        case 4:
            num++;
            break;
        case 2:
            num += 3;
            break;
        case 3:
            num += 2;
            break;
    }
    while (!isPrime(num)) {
        if (num % 6 == 5) {
            num += 2;
        } else {
            num += 4;
           }
        }
        return num;
    }


    //determines if a number > 3 is prime
    private boolean isPrime(int num) {
        if(num % 2 == 0){
            return false;
        }
        
	int x = 3;
	for(int i = x; i < num; i+=2){
	    if(num % i == 0){
		    return false;
        }
    }
	return true;
    }
}
      

