import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class Student {
    private String name;
    private boolean isOnLesson = false;
    private ArrayList<Integer> marksArray;
    public Student(String Name) {
        name = Name;
        marksArray = new ArrayList<Integer>();
    }
    public String GetName() {
        return name;
    }
    public void SetIsOnLesson(boolean flag) {
        isOnLesson = flag;
    }
    public boolean IsOnLesson() {
        return isOnLesson;
    }
    public void AddMark(int mark) {
        marksArray.add(mark);
    }
    public ArrayList<Integer> GetMarks() {
        return marksArray;
    }
    @Override
    public String toString() {
        String ans = "";
        ans += name;
        ans += (isOnLesson ? " was on lesson " : " wasn't on lesson/wasn't asked") + "; Marks:";
        for (int mark : marksArray) {
            ans += " " + mark;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Helena"));
        students.add(new Student("Alex"));
        students.add(new Student("Anna"));
        students.add(new Student("Mark"));
        students.add(new Student("Trixy"));
        students.add(new Student("Max"));
        students.add(new Student("Tom"));
        students.add(new Student("Chris"));
        students.add(new Student("Thomas"));
        System.out.println("Type /h for getting list of all commands. Type /q if you want to stop the program");
        int studentNum;
        String command, yn;
        while (true) {
            System.out.print("Print command: ");
            command = scanner.nextLine();
            if (Objects.equals(command, "/q")) {
                return;
            }
            if (!Objects.equals(command, "/h") && !Objects.equals(command, "/r") && !Objects.equals(command, "/l")) {
                System.out.println("Wrong command. Try again");
            } else {
                if (Objects.equals(command, "/h")) {
                    System.out.println("Type /r for peaking random student and answering question");
                    System.out.println("Type /l for printing all marks of all students");
                } else if (Objects.equals(command, "/r")) {
                    studentNum = random.nextInt(9);
                    System.out.println("Student " + students.get(studentNum).GetName() + " is answering:");
                    System.out.print("Is on lesson (y/<smth>): ");
                    yn = scanner.nextLine();
                    if (Objects.equals(yn, "y")) {
                        students.get(studentNum).SetIsOnLesson(true);
                        int mark;
                        while (true) {
                            System.out.print("Mark for answer: ");
                            mark = scanner.nextInt();
                            if (mark > 10 || mark < 0) {
                                System.out.println("Wrong mark. Try again");
                                continue;
                            }
                            break;
                        }
                        students.get(studentNum).AddMark(mark);
                        scanner.nextLine();
                    } else {
                        System.out.println("Mark for answer: 0");
                        students.get(studentNum).AddMark(0);
                    }
                } else {
                    for (Student student : students) {
                        System.out.println(student);
                    }
                }
            }
        }
    }
}