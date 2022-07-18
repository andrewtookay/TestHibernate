package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookManager {

    protected SessionFactory sessionFactory;

    protected void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    protected void exit() {
        // code to close Hibernate Session factory
    }

    protected void create() {
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(32.59f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(book);

        session.getTransaction().commit();
        session.close();
    }

    protected void read() {
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(32.59f);

        try(Session session = sessionFactory.openSession()) {
            final var dbBook = session.get(Book.class, book);
            System.out.println(dbBook);
        }
        // code to get a book
    }

    protected void update() {
        // code to modify a book
    }

    protected void delete() {
        // code to remove a book
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.setup();
        manager.create();
        manager.exit();
    }
}