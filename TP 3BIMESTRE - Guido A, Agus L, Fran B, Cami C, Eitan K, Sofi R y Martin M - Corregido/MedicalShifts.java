public class MedicalShifts implements  Comparable<MedicalShifts> {

    private static int ID;

    private final int number;

    private final int myID;

    private final String name;

    public MedicalShifts(String name, int i) {myID = ID++; this.name = name; this.number = i;}

    public int getNumber() {return number; }

    public int getID()
    {
        return this.myID;
    }

    @Override public String toString() {
        return name;
    }

    @Override public int compareTo(MedicalShifts o) {
        return Integer.compare(this.getNumber(), o.getNumber());
    }
}
