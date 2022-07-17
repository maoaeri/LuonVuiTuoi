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
