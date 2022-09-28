package huawei;
import java.util.*;
public class GradeSort {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),way=sc.nextInt();
        Student[]students=new Student[n];
        for(int i=0;i<n;i++){
            students[i]=new Student(i,sc.next(),sc.nextInt());
        }
        if(way==0)
            Arrays.sort(students,new Desc());
        else if(way==1)
            Arrays.sort(students,new Inc());

        for(Student student:students){
            System.out.println(student.getName()+" "+student.getGrade());
        }

    }
}
class Student {
    int id;
    String name;
    int grade;

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }

    public Student(int id,String name, int grade) {
        this.id=id;
        this.name = name;
        this.grade = grade;
    }
}
class Inc implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getGrade()!=s2.getGrade()?s1.getGrade()-s2.getGrade():s1.getId()-s2.getId();
    }
}
class Desc implements Comparator<Student>{
    @Override
    public int compare(Student s2, Student s1) {
        return s1.getGrade()!=s2.getGrade()?s1.getGrade()-s2.getGrade():s2.getId()-s1.getId();
    }
}
