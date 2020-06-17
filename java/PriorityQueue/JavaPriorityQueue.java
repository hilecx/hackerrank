package PriorityQueue;


import java.util.*;
import java.util.stream.Collectors;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}


class Priorities{

    PriorityQueue<Student> pq = new PriorityQueue(Comparator.comparing(Student :: getCgpa).reversed().
            thenComparing(Student :: getName).thenComparing(Student :: getId));


    public List<Student> getStudents(List<String> events){
        List<Student> result = new ArrayList<Student>();
        for (String s:events){
            String[] event = s.split(" ");
            if(event.length==1){
                pq.poll();
            }else if (event.length ==4){
                Student student = new Student(Integer.valueOf(event[3]),event[1],Double.valueOf(event[2]));
                pq.add(student);
            }
//            System.out.println("================");
//            pq.forEach(sss -> System.out.println(sss.getName()));
        }

        while (pq.size()>0){
            result.add(pq.poll());
        }

        return result;
    }
}
public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}