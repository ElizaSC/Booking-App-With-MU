package muserver;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import repository.BookingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import config.H2DbConnection;
import model.BookingDTO;

public class MuServerBooking {
	
	private static final String BOOKING = "/booking";
	private static final String BOOKINGS = "/bookings";
	private static final Integer PORT = 8080;
	
	public static void main(String[] args) {
		H2DbConnection db = new H2DbConnection();
		BookingRepository bookingRepository = new BookingRepository(db);

		db.initH2Database();
		
        MuServer server = MuServerBuilder.httpServer()
        	.withHttpPort(PORT)
            .addHandler(Method.POST, BOOKING, (request, response, pathParams) -> {
            	JsonObject body = new Gson().fromJson(request.readBodyAsString(), JsonObject.class);            	
            	String customerName = body.get("customerName").getAsString();
            	LocalDateTime bookingInitDate = LocalDateTime.parse(body.get("bookingInitDate").getAsString());
            	int tableSize = body.get("tableSize").getAsInt();
            	
            	BookingDTO booking = new BookingDTO(customerName, tableSize, bookingInitDate);
            	bookingRepository.insertBooking(booking);
            	response.write("Booking created for " + customerName);
            })
            .addHandler(Method.GET, BOOKINGS, (request, response, pathParams) -> {
            	String dateStr = request.query().get("bookingDate");
            	LocalDate date = LocalDate.parse(dateStr);
            	List<BookingDTO> bookings = bookingRepository.getBookingsByDate(date);
            	StringBuilder resp = new StringBuilder("Bookings on "+ dateStr + ": " + bookings.size() + "\n");
            	for (BookingDTO booking : bookings) {
            		resp.append(booking + "\n");
				}
        		response.write(resp.toString());
            })
            .start();
        
        System.out.println("Started server at " + server.uri());
    }
}
