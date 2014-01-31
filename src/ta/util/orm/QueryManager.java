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

/**
 *
 * @author shinzo maru
 * @param <E>
 */
public interface QueryManager<E> {

    /**
     * membuat standar untuk tipe aksi yang akan digunakan gunakan pada saat
     * memproses method 'action'
     */
    static final int ADD = 0, UPDATE = 1, DELETE = 2;
    /**
     * mendefinisikan HQL query dan membuat format untuk kemudian harus
     * menggunakan method replaceAll yang terdapat di String untuk menghasilkan
     * HQL yang sesuai
     */
    String SET_TABLE = ":table", SET_FIELD = ":field", SET_DATA = ":data",
            SET_FROM = ":from", SET_TO = ":to";
    String QUERY_FROM = "from :table", QUERY_FROM_WHERE = "from :table t where t.:field = ':data'",
            QUERY_BETWEEN = "from :table t where t.:field between ':from' and ':to'",
            QUERY_WHERE_LIKE = "from :table t where t.:field like '%:data%'";

    /**
     *
     * @param table
     * @return table: merupakan tabel yang akan digunakan oleh HQL gunakan untuk
     * proses mengambil seluruh data dari tabel 'table'
     */
    List<E> getListData(String table);

    /**
     *
     * @param table
     * @param init
     * @param id
     * @return gunakan untuk proses mengambil seluruh data dari tabel 'table'
     * dengan menggunakan query WHERE memproses HQL untuk mendapatkan list objek
     * 'E' dengan menentukan rincian 'id' mengenai objek tersebut
     */
    List<E> getListData(String table, String init, String id);

    /**
     *
     * @param table
     * @param init
     * @param from
     * @param to
     * @return gunakan untuk proses mengambil seluruh data dari tabel 'table'
     * dengan menentukan jumlah data yang akan diproses init: berupa HQL untuk
     * field yang menjadi referensi from: berupa HQL untuk data awal yang akan
     * diproses to: berupa HQL untuk data akhir yang akan diproses
     */
    List<E> getListData(String table, String init, String from, String to);

    /**
     *
     * @param table
     * @return memproses HQL untuk mendapatkan objek 'E' tanpa menentukan
     * rincian mengenai objek tersebut
     */
    E detail(String table);

    /**
     *
     * @param table
     * @param init
     * @param id
     * @return memproses HQL untuk mendapatkan objek 'E' dengan menentukan
     * rincian 'id' mengenai objek tersebut
     */
    E detail(String table, String init, String id);

    /**
     *
     * @param table
     * @param init
     * @param id
     * @return memproses HQL untuk proses pencarian data
     */
    List<E> searchData(String table, String init, String id);

    /**
     *
     * @param object
     * @param operation
     * @return memproses objek 'object' dengan menentukan jenis prosesnya
     * 'operation'
     */
    boolean action(E object, int operation);
}
