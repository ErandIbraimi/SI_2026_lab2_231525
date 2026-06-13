package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {
        Library library1 = new Library();

        boolean thrown1 = false;
        try {
            library1.searchBookByTitle("");
        } catch (IllegalArgumentException e) {
            thrown1 = true;
        }
        assert thrown1;

        Library library2 = new Library();
        library2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result1 = library2.searchBookByTitle("Clean Code");

        assert result1 != null;
        assert result1.size() == 1;

        Library library3 = new Library();
        library3.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        List<Book> result2 = library3.searchBookByTitle("Clean Code");

        assert result2 == null;
    }

    @Test
    void borrowBookEveryBranchTest() {
        Library library1 = new Library();

        boolean thrown1 = false;
        try {
            library1.borrowBook("", "Robert C. Martin");
        } catch (IllegalArgumentException e) {
            thrown1 = true;
        }
        assert thrown1;

        Library library2 = new Library();

        boolean thrown2 = false;
        try {
            library2.borrowBook("Clean Code", "");
        } catch (IllegalArgumentException e) {
            thrown2 = true;
        }
        assert thrown2;

        Library library3 = new Library();
        Book book1 = new Book("Clean Code", "Robert C. Martin", "Programming");
        library3.addBook(book1);

        library3.borrowBook("Clean Code", "Robert C. Martin");

        assert book1.isBorrowed();

        Library library4 = new Library();
        Book book2 = new Book("Clean Code", "Robert C. Martin", "Programming");
        book2.setBorrowed(true);
        library4.addBook(book2);

        boolean thrown4 = false;
        try {
            library4.borrowBook("Clean Code", "Robert C. Martin");
        } catch (RuntimeException e) {
            thrown4 = true;
        }
        assert thrown4;

        Library library5 = new Library();
        library5.addBook(new Book("Other Book", "Someone", "Drama"));

        boolean thrown5 = false;
        try {
            library5.borrowBook("Clean Code", "Robert C. Martin");
        } catch (RuntimeException e) {
            thrown5 = true;
        }
        assert thrown5;
    }

    @Test
    void searchBookMultipleConditionTest() {
        Library library1 = new Library();
        library1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result1 = library1.searchBookByTitle("Clean Code");
        assert result1 != null;

        Library library2 = new Library();
        Book book2 = new Book("Clean Code", "Robert C. Martin", "Programming");
        book2.setBorrowed(true);
        library2.addBook(book2);

        List<Book> result2 = library2.searchBookByTitle("Clean Code");
        assert result2 == null;

        Library library3 = new Library();
        library3.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));

        List<Book> result3 = library3.searchBookByTitle("Clean Code");
        assert result3 == null;

        Library library4 = new Library();
        Book book4 = new Book("Effective Java", "Joshua Bloch", "Programming");
        book4.setBorrowed(true);
        library4.addBook(book4);

        List<Book> result4 = library4.searchBookByTitle("Clean Code");
        assert result4 == null;
    }

    @Test
    void borrowBookMultipleConditionTest() {
        Library library1 = new Library();

        boolean thrown1 = false;
        try {
            library1.borrowBook("", "");
        } catch (IllegalArgumentException e) {
            thrown1 = true;
        }
        assert thrown1;

        Library library2 = new Library();

        boolean thrown2 = false;
        try {
            library2.borrowBook("", "Robert C. Martin");
        } catch (IllegalArgumentException e) {
            thrown2 = true;
        }
        assert thrown2;

        Library library3 = new Library();

        boolean thrown3 = false;
        try {
            library3.borrowBook("Clean Code", "");
        } catch (IllegalArgumentException e) {
            thrown3 = true;
        }
        assert thrown3;

        Library library4 = new Library();

        boolean thrown4 = false;
        try {
            library4.borrowBook("Clean Code", "Robert C. Martin");
        } catch (RuntimeException e) {
            thrown4 = true;
        }
        assert thrown4;
    }
}