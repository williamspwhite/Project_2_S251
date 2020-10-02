public class Clinic {
    private NewPatientQueue pq;
    private int er_threshold;
    private int capacity;
    private int processed = 0;
    private int seenByDoctor = 0;
    private int sentToER = 0;
    private int walkedOut = 0;
    private int time_in = 0;

    public Clinic(int cap, int er_threshold) {
        er_threshold = er_threshold;
        capacity = cap;
        pq = new NewPatientQueue(cap);
	//TO BE COMPLETED
    }

    public int er_threshold() {
	return this.er_threshold;
    }

    public int capacity() {
	return this.capacity;
    }

    /*process a new patient:
     *if their urgency level is higher than the er_threshold,
     *send them directly to the emergency room and return null
     *otherwise, try to insert them into the queue
     *if the queue is full, compare their urgency to the highest
     *urgency currently in the queue; if their urgency is higher,
     *send them to the ER and return null; if the current max 
     *is higher, send the max patient to the ER, insert
     *the new patient into the queue, and return the name
     *of the max patient
     */
    public String process(String name, int urgency) {
        Patient newpatient = new Patient(name, urgency, processed++); //new patient with time_in, also iterates time_in

        if (urgency > er_threshold()) {
            sendToER(newpatient);
            return null;
        }
        if (pq.insert(newpatient) != -1) {
            return newpatient.name();
        } else {
            if (newpatient.compareTo(pq.getMax()) > 1) {
                sendToER(newpatient);
                return null;
            } else {
                sendToER(pq.delMax());
                pq.insert(newpatient);
                return pq.getMax().name();
            }
        }
	//TO BE COMPLETED
    }

    /*a doctor is available--send the patient with
     *highest urgency to be seen; return the name
     *of the Patient or null if the queue is empty*/
    public String seeNext() {
        if (pq.isEmpty()) {
            return null;
        }
        seeDoctor(pq.getMax());
        return pq.delMax().name();
	//TO BE COMPLETED
    }

    /*Patient experiences an emergency, raising their 
     *urgency level; if the urgency level exceeds the 
     *er_threshold, send them directly to the emergency room;
     *else update their urgency status in the queue;
     *return true if the Patient is removed from the queue
     *and false otherwise*/
    public boolean handle_emergency(String name, int urgency) {
        if (urgency > er_threshold()) {
            sendToER(pq.remove(name));
            return true;
        }
        pq.update(name, urgency);

        return false;
	//TO BE COMPLETED
    }

    /*Patient decides to walk out
     *remove them from the queue*/
    public void walk_out(String name) {
        pq.remove(name);
	//TO BE COMPLETED
	    walkedOut++;
	    return;
    }

    /*Indicates that Patient p has been sent to the ER*/
    private void sendToER(Patient p) {
	    System.out.println("Patient " + p + " sent to ER.");
	    sentToER++;
	    return;
    }
    /*Indicates that a patient is being seen by a doctor*/
    private void seeDoctor(Patient p) {
	    System.out.println("Patient " + p + " is seeing a doctor.");
	    seenByDoctor++;
	    return;
    }

    public int processed() {
	return processed;
    }

    public int sentToER() {
	return sentToER;
    }
    
    public int seenByDoctor() {
	return seenByDoctor;
    }
    
    public int walkedOut() {
	return walkedOut;
    }
}