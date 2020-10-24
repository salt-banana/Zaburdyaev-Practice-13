import java.lang.Math;

class Main {

    public static void main(String[] args) {

        Student a = new Student(6,87.2);
        Student b = new Student(2,93.4);
        Student x = new Student(9,64.3);
        Student y = new Student(15,73.5);
        Student z = new Student(4, 58.5);


        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        Students studentsList = new Students();
        Students anotherStudentsList = new Students();

        studentsList.addStudent(a); anotherStudentsList.addStudent(a);
        studentsList.addStudent(b); anotherStudentsList.addStudent(b);
        studentsList.addStudent(x); anotherStudentsList.addStudent(x);
        studentsList.addStudent(y); anotherStudentsList.addStudent(y);
        studentsList.addStudent(z); anotherStudentsList.addStudent(z);


        System.out.println("=== INITIAL LIST ===");
        System.out.println(studentsList);

        studentsList.sortById();

        System.out.println("\n=== SORTED BY ID ===");
        System.out.println(studentsList);

        sorter.quickSort(studentsList, 0, studentsList.getStudentsAmount()-1);

        System.out.println("\n=== SORTED BY GPA (QUICK SORT) ===");
        System.out.println(studentsList);

        sorter.mergeSort(anotherStudentsList, 0, anotherStudentsList.getStudentsAmount());

        System.out.println("\n=== SORTED BY GPA (MERGE SORT) ===");
        System.out.println(anotherStudentsList);

    }

}