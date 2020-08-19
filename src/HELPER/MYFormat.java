/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MYFormat {

    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
    static NumberFormat numberFormat;

    public static String layNgayString(Date date) {
        return dateFormat.format(date);
    }

    public static Date layNgayDate(String ngay) {
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            Logger.getLogger(MYFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String soString(double so) {
        return numberFormat.getNumberInstance().format(so);
    }

    public static double soDouble(String number) {
        try {
            return numberFormat.getNumberInstance().parse(number).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(MYFormat.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
