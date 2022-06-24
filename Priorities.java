import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {
    PriorityQueue<Student> priorityQueueStudent = new PriorityQueue<>(); // Priority sınıfından Student içeren nesne üretildi.
    String[] studentStrings ; // girilen ifadeyi stringlere ayırmak için kullanılacak String dizisi
    public List<Student> getStudents(List<String> events) { // soruda istenilen getStudents içerisinde List<String> olacak şekilde ayarlandı.
        for (String event : events) { // events kullanıcının girdiği verileri temsil eder.
            try{
                if (event.equals("SERVED")) { // eğer kullanıcı SERVER kullanırsa  :
                    priorityQueueStudent.poll(); // kuyruğun başındakini uygun kurallara göre çıkar .
                } else if (event.startsWith("ENTER")) { // Kullanıcı girişi ENTER yazarak başlaması gerekiyor .
                    studentStrings = event.split(" "); // amaç başta girilen ENTER sözcüğünden  kurtulmak .
                    if(Double.parseDouble(studentStrings[2]) > 4 || Double.parseDouble(studentStrings[2]) < 0 ){
                        System.out.println("NOT ORTALAMASI HATALI");
                        // eğer not ortalaması 4 ten büyük veya negatif ise öğrenci kaydı yapılmaz .
                    }else {
                        Student student = new Student(studentStrings[1], Double.parseDouble(studentStrings[2])
                                ,Integer.parseInt(studentStrings[3])); // s[0] = ENTER olacak ve Student sınıfının Constuna göre nesne girişi yapılır .
                        priorityQueueStudent.add(student); // oluşan Student nesnesi sıraya eklenir .
                    }
                }
                else {
                    System.out.println("Hatalı girişe rastlandı .");
                }
            }catch (Exception exception){
                System.out.println("Hata oluştu  :" + exception.getLocalizedMessage()); // hata oluşursa try catch ile yakalanır
            }}
        List<Student> students = new ArrayList<Student>(); // öğrenci listesi oluşturuldu .
        while (!priorityQueueStudent.isEmpty()) {// öğrenci listesi boş olmadığı sürece döngü içinde kalır .
                students.add(priorityQueueStudent.poll()); // listeye çıkarılan eleman eklenir .
        }
        return students; // listeye eklenen elamanlar en son döndürülür .
    }

}
