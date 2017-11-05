package com.mojafirma;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Main {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception{
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Books> books =
                    session.createQuery("FROM " + Books.class.getName()).list();

            for (Books book: books) {
                System.out.println(book.toString());
            }
            tx.commit();

            tx = session.beginTransaction();

            Books book = new Books();
            book.setAuthor("Anna Starmach");
            book.setCategoty("kucharska");
            book.setIsbn("22577375");
            book.setOnStock(6);
            book.setPageCount(120);
            book.setPrice(BigDecimal.valueOf(29.45));
            book.setPublished(Date.valueOf("2017-10-11"));
            book.setPublisher("Społeczny Instytut Wydawniczy Znak");
            book.setTitle("Pyszne obiady");
            session.save(book);

            Books b1;
            b1 = (Books)session.load(Books.class, 5);
            session.delete(b1);
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
 }
