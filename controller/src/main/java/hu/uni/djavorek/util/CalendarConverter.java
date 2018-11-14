package hu.uni.djavorek.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarConverter {

    private static DatatypeFactory xmlGregorianCalendarFactory = null;

    static{
        try {
            xmlGregorianCalendarFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException();
        }
    }


    public static Calendar unmarshal(XMLGregorianCalendar xmlGregorian) {
        Date date = xmlGregorian.toGregorianCalendar().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static XMLGregorianCalendar marshal(Calendar value) {
        if (value == null) {
            return null;
        }

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(value.getTime());
        return xmlGregorianCalendarFactory.newXMLGregorianCalendar(gregorianCalendar);
    }
}
