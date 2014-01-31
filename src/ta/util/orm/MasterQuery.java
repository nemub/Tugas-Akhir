/*
 *  This source code was authorized by PIS - Protonix Engineering.
 *  Copyright (C) 2011 shinzo maru
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Thank you.....
 */
package ta.util.orm;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author shinzo maru
 * @param <E>
 */
public class MasterQuery<E> implements QueryManager<E> {

    protected Query query;
    protected Session session;
    protected Transaction transaction;
    private List<E> listData = null;

    public MasterQuery() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getListData(String table) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_FROM.replaceAll(SET_TABLE, table));
            listData = (List<E>) query.list();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return listData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getListData(String table, String init, String id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_FROM_WHERE.replaceAll(SET_TABLE, table).
                    replaceAll(SET_FIELD, init).replaceAll(SET_DATA, id));
            listData = (List<E>) query.list();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return listData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getListData(String table, String init, String from, String to) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_BETWEEN.replaceAll(SET_TABLE, table).
                    replaceAll(SET_FIELD, init).replaceAll(SET_FROM, from).
                    replaceAll(SET_TO, to));
            listData = (List<E>) query.list();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return listData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E detail(String table) {
        Object object = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_FROM.replaceAll(SET_TABLE, table));
            object = (E) query.uniqueResult();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return (E) object;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E detail(String table, String init, String id) {
        Object object = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_FROM_WHERE.replaceAll(SET_TABLE, table).
                    replaceAll(SET_FIELD, init).replaceAll(SET_DATA, id));
            object = (E) query.uniqueResult();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return (E) object;
    }

    @Override
    public boolean action(E object, int operation) {
        boolean isSaved = false;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            switch (operation) {
                case ADD:
                    session.save(object);
                    break;
                case UPDATE:
                    session.update(object);
                    break;
                case DELETE:
                    session.delete(object);
                    break;
            }

            transaction.commit();
            isSaved = true;
        } catch (HibernateException e) {
            isSaved = false;
            transaction.rollback();
        } finally {
            session.close();
        }

        return isSaved;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> searchData(String table, String init, String id) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            query = session.createQuery(QUERY_WHERE_LIKE.replaceAll(SET_TABLE, table).
                    replaceAll(SET_FIELD, init).replaceAll(SET_DATA, id));
            listData = (List<E>) query.list();
        } catch (HibernateException e) {
            e.getCause().getMessage();
            transaction.rollback();
        } finally {
            session.close();
        }

        return listData;
    }
}
