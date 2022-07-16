/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import myhustwork.luonvuituoi.DTO.FluctuationDTO;

/**
 *
 * @author vvlalalove193
 */
public class Converter {
    
    /**
     * Convert from text format "dd/mm/yyyy" to Date
     * @param str
     * @return 
     */
    public static LocalDate toDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String date = str;

        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
    /**
     * Convert from text format "#,###" to long int
     * @param strFormat
     * @return
     * @throws ParseException 
     */
    public static long formatAmount(String strFormat) throws ParseException{
        long d = DecimalFormat.getNumberInstance().parse(strFormat).longValue();
        return d;
    }
}
