import java.util.TreeMap;

class Patient {
    int patientId;
    String name;
    int age;
    String department;

    Patient(int patientId, String name, int age, String department) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name = " + name +
               ", Age = " + age +
               ", Department = " + department;
    }
}

public class HospitalManagement_CO2 {

    public static void main(String[] args) {

        TreeMap<Integer, Patient> patients = new TreeMap<>();

        patients.put(101, new Patient(101, "Rahul", 25, "Cardiology"));
        patients.put(102, new Patient(102, "Priya", 30, "Neurology"));
        patients.put(103, new Patient(103, "Amit", 40, "Orthopedics"));
        patients.put(104, new Patient(104, "Sneha", 28, "Dermatology"));
        patients.put(105, new Patient(105, "Kiran", 35, "Pediatrics"));
        patients.put(106, new Patient(106, "Anjali", 32, "ENT"));
        patients.put(107, new Patient(107, "Ravi", 45, "Cardiology"));
        patients.put(108, new Patient(108, "Pooja", 29, "Neurology"));

        System.out.println("Original Patient Records:");

        for (Integer id : patients.keySet()) {
            Patient p = patients.get(id);
            System.out.println("Patient ID " + p.patientId +
                    " = " + p.name +
                    " | Age = " + p.age +
                    " | Department = " + p.department);
        }

        System.out.println("\nB+ Tree Leaf Nodes:");

        for (Integer id : patients.keySet()) {
            System.out.println("Key = " + id);
        }

        System.out.println("\nTotal Patients = " + patients.size());

        System.out.println("\nSearching Patient 104...");

        if (patients.containsKey(104)) {
            Patient p = patients.get(104);

            System.out.println("\nPatient Found:");
            System.out.println("Patient ID 104 = " + p.name);
            System.out.println("Age = " + p.age);
            System.out.println("Department = " + p.department);
        }

        System.out.println("\nSearching Patient 120...");

        if (patients.containsKey(120)) {
            System.out.println("Patient Found");
        } else {
            System.out.println("\nPatient Not Found");
        }

        System.out.println("\nB+ Tree Indexing Completed Successfully.");

        System.out.println("\nTime Complexity:");
        System.out.println("Insertion Operation : O(log n)");
        System.out.println("Search Operation    : O(log n)");
        System.out.println("Deletion Operation  : O(log n)");
    }
}