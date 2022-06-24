import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);
    private  static Priorities priorities = new Priorities();

    public static void main(String[] args) {

        System.out.println("Islem sayisini giriniz ");
        int totalEvents = Integer.parseInt(scanner.nextLine()); // nekadar işlem yapılacağını belirt.
        List<String> events = new ArrayList<>(); // girilen metinler
        System.out.println("Yapmak istediginiz islem: ");
        while (totalEvents != 0) { // toplam işlem sayısı 0 oluncaya kadar dön
            String event = scanner.nextLine();  // işlem sayısı kadar event al.
            events.add(event);
            totalEvents --  ;
        }
        List<Student> students = priorities.getStudents(events); // öğrenci listesini priorities nesnesinin getStudents işlemine bağla
        if (students.isEmpty()) { // liste boş ise :
            System.out.println("EMPTY");
        } else {
            for (Student st : students) { // tüm listenin ismini döndür  .
                System.out.println(st.getName());
            }
        }
    }
}


