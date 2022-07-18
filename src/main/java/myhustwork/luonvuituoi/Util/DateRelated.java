/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Util;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author vvlalalove193
 */
public class DateRelated {
    
    /**
     * Get last day of month for given date
     * @param date
     * @return 
     */
    public static LocalDate getLastDayOfMonth(LocalDate givenDate) {
 
        // Get last day of month for given date
        LocalDate lastDayOfMonth  = givenDate.withDayOfMonth(givenDate.getMonth().length(givenDate.isLeapYear()));
        return lastDayOfMonth;
    }
    
    public static LocalDate getLastDayOfMonth(int month, int year) {
 
        // Get last day of month for given month and date
        LocalDate date = getFirstDayOfMonth(month, year);
        LocalDate lastDayOfMonth  = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        return lastDayOfMonth;
    }
    
    public static LocalDate getLastDayOfLastMonth(int month, int year){
        return getFirstDayOfMonth(month, year).minusDays(1);
    }
    
    public static LocalDate getFirstDayOfMonth(int month, int year){
        return LocalDate.of(year, month, 1);
    }
    
    public static LocalDate getFirstDayOfMonth(LocalDate date){
        return date.withDayOfMonth(1);
    }
    
    public static LocalDate getFirstDayOfYear(int year){
        return LocalDate.of(year, 1, 1);
    }
    
    public static LocalDate getLastDayOfYear(int year){
        return LocalDate.of(year, 12, 31);
    }
}
