/*
 * This source code was authorized by PIS - Protonix Engineering.
 * Copyright (C) 2011 shinzo maru
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Thank you.....
 */
package ta.util.orm.query;

import org.hibernate.HibernateException;
import ta.util.orm.HibernateUtil;
import ta.util.orm.MasterQuery;
import ta.util.orm.mapping.Akses;
import ta.util.orm.mapping.Pengguna;

/**
 *
 * @author shinzo maru
 */
public class LoginQuery extends MasterQuery<Pengguna> {

    private Pengguna user = null;
    private Akses authorized = null;

    public LoginQuery() {
    }

    public boolean isRegistered(String nik, String password) {
        boolean registered = false;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        if (!nik.isEmpty() && !password.isEmpty()) {
            try {
                query = session.createQuery("from Pengguna p where p.nik = '" + nik + "'");
                user = (Pengguna) query.uniqueResult();

                if (user != null) {
                    query = session.createQuery("from Akses a where a.pengguna = " + user.getIdPengguna() + " and a.sandi = '" + password + "'");
                    authorized = (Akses) query.uniqueResult();
                    registered = (getAuthorized() != null);
                }
            } catch (HibernateException e) {
                transaction.rollback();
            } finally {
                session.close();
            }
        }

        return registered;
    }

    /**
     * @return the user
     */
    public Pengguna getUser() {
        return user;
    }

    /**
     * @return the authorized
     */
    public Akses getAuthorized() {
        return authorized;
    }

}
