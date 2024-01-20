package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._1Lab._02Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<Book> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < books.length;
        }

        @Override
        public Book next() {
            return books[count++];
        }
    }
}
