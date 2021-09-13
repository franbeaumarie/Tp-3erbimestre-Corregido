import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Queue < MedicalShifts > queueHospital = new QueueImplement < > ();
        queueHospital.add(new MedicalShifts("harry", 0));
        queueHospital.add(new MedicalShifts("hermione", 3));
        queueHospital.add(new MedicalShifts("ron", 1));
        queueHospital.add(new MedicalShifts("luna", 5));
        queueHospital.add(new MedicalShifts("voldemort", 8));
        System.out.println(queueHospital.peek());
        System.out.println(queueHospital.isEmpty());
        try {
            System.out.println(queueHospital.pop());
        } catch (EmptyQueueException emptyQueue) {
            System.out.println(emptyQueue.getMessage());
        }
        System.out.println(queueHospital.peek());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        queueHospital.add(new MedicalShifts("hagrid", 4));
        for (MedicalShifts shifts: queueHospital) {
            System.out.println(shifts);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        queueHospital.sort();
        for (MedicalShifts shifts: queueHospital) {
            System.out.println(shifts);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(queueHospital.min(
                new Comparator < MedicalShifts > () {
                    @Override
                    public int compare(MedicalShifts o1, MedicalShifts o2) {
                        return -String.compare(o1.toString(), o2.toString());
                     // return Integer.compare(o1.getID(), o2.getID());
                    }
                })

        );
//sisisisi
    }
}
