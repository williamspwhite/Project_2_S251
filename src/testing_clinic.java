public class testing_clinic {
    public static void main(String[] args) {
        String clinic_capacity = "25";
        String er_threshold = "5";
        String pWalkin = "50";
        String pDocAvailable = "50";
        String pEmergency = "50";
        String pWalkout = "50";
        Part4SimTest.main(new String[]{"patient_file_1.txt", clinic_capacity, er_threshold,
                pWalkin, pDocAvailable, pEmergency, pWalkout});
    }
}
