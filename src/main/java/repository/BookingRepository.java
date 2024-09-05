package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import config.H2DbConnection;
import model.BookingDTO;

public class BookingRepository {

	private H2DbConnection db;
	
	public BookingRepository(H2DbConnection db) {
		this.db = db;
	}
	
	public void insertBooking(BookingDTO booking) throws SQLException {

		String sql = "INSERT INTO Booking "
				+ "(customerName, "
				+ "customerLastName, "
				+ "tableSize,"
				+ "bookingInitDate,"
				+ "bookingEndDate)"
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, booking.getCustomerName());
			ps.setString(2, booking.getCustomerLastName());
			ps.setInt(3, booking.getTableSize());
			ps.setTimestamp(4, Timestamp.valueOf(booking.getBookingInitDate()));
			ps.setTimestamp(5, Timestamp.valueOf(booking.getBookingInitDate().plusHours(2)));

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	public List<BookingDTO> getBookingsByDate(LocalDate date) throws SQLException{
		List<BookingDTO> bookings = new ArrayList<>();

		String sql = "SELECT * FROM Booking "
				+ "WHERE bookingInitDate BETWEEN ? AND ?";
		
		LocalDateTime startOfDay = LocalDateTime.of(date, LocalTime.MIN);
		LocalDateTime endOfDay = LocalDateTime.of(date, LocalTime.MAX);
		

		try {
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, Timestamp.valueOf(startOfDay));
			ps.setTimestamp(2, Timestamp.valueOf(endOfDay));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String customerName = rs.getString("customerName");
				String customerLastName = rs.getString("customerLastName");
				int tableSize = rs.getInt("tableSize");
				LocalDateTime bookingInitDate = rs.getTimestamp("bookingInitDate").toLocalDateTime();
				LocalDateTime bookingEndDate = rs.getTimestamp("bookingEndDate").toLocalDateTime();
				bookings.add(new BookingDTO(id, customerName, customerLastName, tableSize, bookingInitDate, bookingEndDate));
			}
			
			rs.close();
			ps.close();
		}catch (SQLException e) {
			e.getStackTrace();
		}

		return bookings;

	}

}
