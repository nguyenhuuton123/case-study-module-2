import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Teacher {
    public static void main(String[] args) {
        ArrayList<MyObject> myObjects = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("students1.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Thay thế dấu phẩy bằng dấu tương ứng trong tệp

                if (parts.length == 3) { // Đảm bảo rằng mỗi dòng có đúng số lượng trường dữ liệu
                    String field1 = parts[0].trim();
                    int field2 = Integer.parseInt(parts[1].trim());
                    double field3 = Double.parseDouble(parts[2].trim());

                    MyObject myObject = new MyObject(field1, field2, field3);
                    myObjects.add(myObject);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // In ra danh sách đối tượng
        for (MyObject obj : myObjects) {
            System.out.println(obj);
        }
    }
}

class MyObject {
    private String field1;
    private int field2;
    private double field3;

    public MyObject(String field1, int field2, double field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}
