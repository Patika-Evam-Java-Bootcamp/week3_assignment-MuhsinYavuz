public class Student  implements Comparable<Student>{
    private int id ;
    private String name ;
    private double cgpa  ; // öğrencinin not ortalaması

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public double getCgpa() {
        if(cgpa > 4 || cgpa < 0 ){
            System.out.println("Ortalama 0-4 aralığında olmalıdır .  ");

        }
        return cgpa;
    }

    public Student(String name, double cgpa,int id) { // const oluşturuldu .
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student s) {  // compareTo Override etmemiz gerekir .
        if(cgpa == s.cgpa) // ortalama eşit ise
        {
            if(name.compareTo(s.name) == 0) // isimler eşit ise
            {
                if(id == s.id) // id ler eşit ise  :
                    return 0;
                else if (id > s.id)
                    return 1;
                else
                    return -1;
            }
            else
                return name.compareTo(s.name);
        }
        else if(cgpa > s.cgpa)
            return -1;
        else
            return 1;

    }
}
