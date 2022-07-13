/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myhustwork.luonvuituoi.Controller;

/**
 *
 * @author vvlalalove193
 */
public interface ControllerInterface<T> {
    public int add(T t);
    public int update(T t);
    public int delete(T t);
    public T get(int id);
    public T[] getAll();
}
