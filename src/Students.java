import java.util.ArrayList;
import java.util.Comparator;

public class Students {

    private final ArrayList<Student> studentsList;

    public Students() {
        this.studentsList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

    public void addStudentAtIndex(int index, Student student) {
        this.studentsList.add(index,student);
    }

    public void removeStudent(Student student) {
        this.studentsList.remove(student);
    }

    public Student getStudent(int id) { return this.studentsList.get(id); }

    public Student getStudentById(int studentId) {
        for (Student student: this.studentsList) {
            if (student.getId() == studentId)
                return student;
        }
        return null;
    }

    public void setStudent(int index, Student student) { this.studentsList.set(index,student); }

    public void sortById() {
        this.studentsList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() > o2.getId() ? 1 : -1;
            }
        });
    }

    public int getStudentsAmount() {
        return this.studentsList.size();
    }

    @Override
    public String toString() {
        String ids = "STUDENT ID's: ";
        String GPAs = "STUDENT GPA's: ";
        for (Student student: this.studentsList) {
            ids += student.getId() + " ";
            GPAs += student.getGPA() + " ";
        }
        return ids + "\n" + GPAs;
    }

}
