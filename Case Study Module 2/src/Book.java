class Book {
    String title;
    Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book() {

    }

    public String toString() {
        return title + "-" + author;
    }
}
