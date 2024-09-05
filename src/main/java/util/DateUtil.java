package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

	public static LocalDate validateDate(String dateStr) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		
		try {
			return LocalDate.parse(dateStr, formatter);
		}catch (DateTimeParseException e){ 
			
			throw new Exception("Invalid Date formatter: " + dateStr);
		}
	}
	

}
