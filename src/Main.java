import java.lang.Math;

class Main {

    public static Students mergeGPA(Students listA, Students listB) {

        int i = 0;
        int j = 0;

        int sizeA = listA.getStudentsAmount();
        int sizeB = listB.getStudentsAmount();

        Students mergedList = new Students();

        while (i < sizeA && j < sizeB) {

            Student studentA = listA.getStudent(i);
            Student studentB = listB.getStudent(j);

            while (studentA.getGPA() > studentB.getGPA()) {
                i++;
                mergedList.addStudent(studentA);
                if (i >= sizeA)
                    break;
                studentA = listA.getStudent(i);
            }
            while (studentB.getGPA() >= studentA.getGPA()) {
                j++;
                mergedList.addStudent(studentB);
                if (j >= sizeB)
                    break;
                studentB = listB.getStudent(j);
            }

        }

        while (i < sizeA) {
            Student studentA = listA.getStudent(i);
            mergedList.addStudent(studentA);
            i++;
        }
        while (j < sizeB) {
            Student studentB = listB.getStudent(j);
            mergedList.addStudent(studentB);
            j++;
        }

        return mergedList;

    }

    public static Students mergeID(Students listA, Students listB) {

        int i = 0;
        int j = 0;

        int sizeA = listA.getStudentsAmount();
        int sizeB = listB.getStudentsAmount();

        Students mergedList = new Students();

        while (i < sizeA && j < sizeB) {

            Student studentA = listA.getStudent(i);
            Student studentB = listB.getStudent(j);

            while (studentA.getId() < studentB.getId()) {
                i++;
                mergedList.addStudent(studentA);
                if (i >= sizeA)
                    break;
                studentA = listA.getStudent(i);
            }
            while (studentB.getId() <= studentA.getId()) {
                j++;
                mergedList.addStudent(studentB);
                if (j >= sizeB)
                    break;
                studentB = listB.getStudent(j);
            }

        }

        while (i < sizeA) {
            Student studentA = listA.getStudent(i);
            mergedList.addStudent(studentA);
            i++;
        }
        while (j < sizeB) {
            Student studentB = listB.getStudent(j);
            mergedList.addStudent(studentB);
            j++;
        }

        return mergedList;

    }

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

        Students studentsMergedGPA = mergeGPA(studentsList,anotherStudentsList);

        System.out.println("\n=== MERGED BY GPA ===");
        System.out.println(studentsMergedGPA);

        studentsList.sortById();
        anotherStudentsList.sortById();

        Students studentsMergedID = mergeID(studentsList,anotherStudentsList);

        System.out.println("\n=== MERGED BY ID ===");
        System.out.println(studentsMergedID);

    }

}