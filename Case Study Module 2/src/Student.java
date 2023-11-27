import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    String name;
    int age;
    double aDouble;
    ArrayList<Book> books;

    public Student(String name, int age, ArrayList<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, double aDouble) {
        this.name = name;
        this.age = age;
        this.aDouble = aDouble;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String booksStr = "";
        for (Book element : books) {
            booksStr += element.toString() + ";";
        }
        return name + "," + age + "," + booksStr;
    }

    public String toString1() {
        return "MyObject{" +
                "field1='" + name + '\'' +
                ", field2=" + age +
                ", field3=" + aDouble +
                '}';
    }

    public static void ghiDoiTuongVaoFile(List<Student> students) {
        FileWriter writer;
        try {
            writer = new FileWriter("students.txt");
            for (Student s : students) {
                writer.write(s.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("bug");
        }
    }

    public static void ghiDoiTuongVaoFile1(List<Student> students) {
        FileWriter writer;
        try {
            writer = new FileWriter("students1.txt");
            for (Student s : students) {
                writer.write(s.toString1() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("bug");
        }
    }

    public List<Student> docDoiTuongTuFile() {
        List<Student> students = new ArrayList<>();
        File file = new File("students.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] attrs = line.split(",");
            Student s = new Student();
            s.setName(attrs[0]);
            s.setAge(Integer.parseInt(attrs[1]));
            String[] bookStars = attrs[2].split(";");
            books = new ArrayList<>();
            for (String bookStr : bookStars) {
                String[] bookInfo = bookStr.split("-");
                Book book = new Book();
                book.title = bookInfo[0];
                String[] author = bookInfo[1].split("_");
                Author author1 = new Author();
                author1.name = author[0];
                author1.age = Integer.parseInt(author[1]);
                book.author = author1;
                books.add(book);
                s.setBooks(books);
            }
            students.add(s);
        }
        return students;
    }

    public static void main(String[] args) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        Author author = new Author("Nguyen Van A", 20);
        Author author1 = new Author("Nguyen Van B", 20);
        Book book = new Book("Văn", author1);
        Book book1 = new Book("Toán", author);
        bookArrayList.add(book1);
        bookArrayList.add(book);
        ArrayList<Book> bookArrayList1 = new ArrayList<>();
        Book book2 = new Book("Sử", author);
        Book book3 = new Book("Địa", author1);
        bookArrayList1.add(book2);
        bookArrayList1.add(book3);
        List<Student> doiTuongList = new ArrayList<>();
        List<Student> doiTuongList1 = new ArrayList<>();
        Student doiTuong = new Student("Nguyen Van A", 25, bookArrayList);
        Student doiTuong1 = new Student("Nguyen Van B", 25, bookArrayList1);
        Student doiTuong2 = new Student("Nguyen Van A", 25, 25.5);
        Student doiTuong3 = new Student("Nguyen Van B", 25, 25.5);
        doiTuongList.add(doiTuong);
        doiTuongList.add(doiTuong1);
        doiTuongList1.add(doiTuong2);
        doiTuongList1.add(doiTuong3);
        ghiDoiTuongVaoFile(doiTuongList);
        ghiDoiTuongVaoFile1(doiTuongList1);
        List<Student> studentList = doiTuong.docDoiTuongTuFile();
        for (Student type : studentList) {
            System.out.println(type.getName() + "     " + "age " + type.getAge() + " books " + type.getBooks());
        }
        System.out.println(studentList);
    }
}


