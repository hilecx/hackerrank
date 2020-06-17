
import java.lang.annotation.ElementType;
import java.util.*;

class Student1 {
    private int id;
    private String fname;
    private double cgpa;

    public Student1(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student1> student1List = new ArrayList<Student1>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student1 st = new Student1(id, fname, cgpa);
            student1List.add(st);

            testCases--;
        }
//
//        student1List.sort(new Comparator<Student1>() {
//            @Override
//            public int compare(Student1 o1, Student1 o2) {
//                if (o1.getCgpa() == o2.getCgpa()){
//                    if(o1.getName().equals(o2.getName())){
//                        return o1.getId()-o2.getId();
//                    }else {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                }else if(o1.getCgpa() - o2.getCgpa()>0){
//                    return -1;
//                }else{
//                    return 1;
//                }
//            }
//        });

//        jdk8 rules
        Collections.sort(student1List,  Comparator.comparing(Student1 :: getCgpa).reversed().
                thenComparing(Student1 :: getFname).thenComparing(Student1 :: getId));

        for (Student1 st : student1List) {
            System.out.println(st.getFname());
        }
    }
}



