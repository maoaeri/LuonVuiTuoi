/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myhustwork.luonvuituoi.DAO;

import java.sql.SQLException;

/**
 *
 * @author vvlalalove193
 * @param <T>
 */
public interface DAOInterface<T> {
    public void add(T t) throws SQLException ;
    public void update(T t) throws SQLException ;
    public void delete(T t)throws SQLException ;
    public T get(int id)throws SQLException ;
    public T[] getAll()throws SQLException ;
}
