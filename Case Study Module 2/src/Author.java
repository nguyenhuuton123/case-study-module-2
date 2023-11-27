public class Author {
    String name;
    int age;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Author() {

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

    public String toString() {
        return name + "_" + age;
    }

}
