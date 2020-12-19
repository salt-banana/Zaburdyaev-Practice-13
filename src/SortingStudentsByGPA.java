import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    public void quickSort(Students studentsList, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;
            Student midStudent = studentsList.getStudent(mid);

            int i = left;
            int j = right;

            while (i <= j) {

                Student studentA = studentsList.getStudent(i);
                Student studentB = studentsList.getStudent(j);

                while (this.compare(studentA, midStudent) > 0) {
                    i++;
                    studentA = studentsList.getStudent(i);
                }
                while (this.compare(studentB, midStudent) < 0) {
                    j--;
                    studentB = studentsList.getStudent(j);
                }

                if (i >= j)
                    break;

                studentsList.setStudent(i, studentB);
                studentsList.setStudent(j, studentA);

                i++;
                j--;

            }


            quickSort(studentsList, left, j);
            quickSort(studentsList, j + 1, right);

        }

    }

    private void merge(Students studentsList, int left, int mid, int right) {

        int i = 0;
        int j = 0;
        Students result = new Students();

        while (left + i < mid && mid + j < right) {
            Student studentA = studentsList.getStudent(left+i);
            Student studentB = studentsList.getStudent(mid+j);
            if (this.compare(studentA,studentB) > 0) {
                result.addStudentAtIndex(i+j,studentA);
                i += 1;
            }
            else {
                result.addStudentAtIndex(i+j,studentB);
                j += 1;
            }
        }

        while (left + i < mid) {
            Student studentA = studentsList.getStudent(left+i);
            result.addStudentAtIndex(i+j, studentA);
            i += 1;
        }

        while (mid + j < right) {
            Student studentB = studentsList.getStudent(mid + j);
            result.addStudentAtIndex(i+j, studentB);
            j += 1;
        }

        for (int it = 0; it < i+j; it++) {
            Student student = result.getStudent(it);
            studentsList.setStudent(left + it, student);
        }

    }

    public void mergeSort(Students studentsList, int left, int right) {
        if (left + 1 >= right)
            return;
        int mid = (left+right)/2;
        mergeSort(studentsList,left,mid);
        mergeSort(studentsList,mid,right);
        merge(studentsList,left,mid,right);
    }


    public int compare(Student a, Student b) {
        if (a.getGPA() > b.getGPA())
            return 1;
        else if (a.getGPA() < b.getGPA())
            return -1;
        return 0;
    }

}
