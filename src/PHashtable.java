import java.util.ArrayList;
public class PHashtable {
    private ArrayList<Patient>[] table;
    private int t_capacity;
    private int size;
    //set the table size to the first 
    //prime number p >= capacity
    public PHashtable (int capacity) {
        table = new ArrayList[getNextPrime(capacity)];
        t_capacity = getNextPrime(capacity);
        size = 0;
	//TO BE COMPLETED
    }

    //return the Patient with the given name 
    //or null if the Patient is not in the table
    public Patient get(String name) {
        int hash_n;
        if ((hash_n = name.hashCode() % t_capacity) < 0) {
            hash_n = hash_n + t_capacity;
        }
        if (table[hash_n] == null) {
            return  null;
        }
        for (Patient patient : table[hash_n]) {
            if ((patient.name()).compareTo(name) == 0) {
                return patient;
            }
        }
        return null;
	//TO BE COMPLETED
    }

    //put Patient p into the table
    public void put(Patient p) {
        int hash_p;
        if ((hash_p = p.name().hashCode() % t_capacity) < 0) {
            hash_p = hash_p + t_capacity;
        }
        if (get(p.name()) == null) {
            if (table[hash_p] == null) {
                table[hash_p] = new ArrayList<Patient>();
            }
            table[hash_p].add(p);
            size++;
            return;
        }

        return;
	//TO BE COMPLETED
    }

    //remove and return the Patient with the given name
    //from the table
    //return null if Patient doesn't exist
    public Patient remove(String name) {
        int hash_n;
        if ((hash_n = name.hashCode() % t_capacity) < 0) {
            hash_n = hash_n + t_capacity;
        }
        Patient return_patient = null;
        if ((return_patient = get(name)) == null) {
            return return_patient;
        } else {
            table[hash_n].remove(return_patient);
            size--;
            if (table[hash_n].size() == 0) {
                table[hash_n] = null;
            }
            return return_patient;
        }
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
      

