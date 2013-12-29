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

import ta.util.orm.HibernateUtil;
import ta.util.orm.MasterQuery;
import ta.util.orm.mapping.HakAkses;

/**
 *
 * @author shinzo maru
 */
public class LoginQuery extends MasterQuery<HakAkses> {
    private HakAkses user = null;

    public LoginQuery() {
    }
    
    public boolean isRegistered(String nama, String password) {
        boolean registered = false;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        if (!nama.isEmpty() && !password.isEmpty()) {
            try {
                query = session.createQuery("from HakAkses u where u.nama = '" + nama + "' and u.password = '" + password + "'");
                user = (HakAkses) query.uniqueResult();
                
                if (user != null)
                    registered = true;
                else
                    registered = false;
            } catch (Exception e) {
                transaction.rollback();
                registered = false;
            } finally {
                session.close();
            }
        }
        
        return registered;
    }

    /**
     * @return the user
     */
    public HakAkses getUser() {
        return user;
    }
    
}
