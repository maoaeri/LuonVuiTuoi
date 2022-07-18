/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myhustwork.luonvuituoi.BLL;

import java.sql.SQLException;

/**
 *
 * @author vvlalalove193
 */
public interface BLLInterface<T> {
    public T get(int id) throws SQLException;
    public T[] getAll() throws SQLException;
    public void addFromGUI(T t) throws SQLException;
    public void updateFromGUI(T t) throws SQLException;
    public void deleteFromGUI(T t) throws SQLException;
}
