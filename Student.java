// Student.java
public class Student implements Comparable<Student> {
    private final String name;
    private final int    idNumber;
    private final double gpa;

    public Student(String name, int idNumber, double gpa) {
        this.name     = name;
        this.idNumber = idNumber;
        this.gpa      = gpa;
    }

    public String getName()    { return name; }
    public int    getIDNumber(){ return idNumber; }
    public double getGpa()     { return gpa; }

    // Естественный порядок — по GPA по возрастанию
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', gpa=%.2f}", idNumber, name, gpa);
    }
}