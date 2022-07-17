/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myhustwork.luonvuituoi.GUI;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author vvlalalove193
 */
public interface InforInterface<T> {
    public T getInfor() throws ParseException, SQLException;
    public void display(T t);
    public void refreshComponents();
    public void addListener(ActionListener log);
    public void updateListener(ActionListener log);
    public void deleteListener(ActionListener log);
}
