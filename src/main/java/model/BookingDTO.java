package model;

import java.time.LocalDateTime;

public class BookingDTO {
	
	private int id;
	private String customerName;
	private int tableSize;
	private LocalDateTime bookingInitDate;
	private LocalDateTime bookingEndDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getTableSize() {
		return tableSize;
	}
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}
	public LocalDateTime getBookingInitDate() {
		return bookingInitDate;
	}
	public void setBookingInitDate(LocalDateTime bookingInitDate) {
		this.bookingEndDate = bookingInitDate;
	}
	public LocalDateTime getBookingEndDate() {
		return bookingEndDate;
	}
	public void setBookingEndDate(LocalDateTime bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}
	@Override
	public String toString() {
		return "id:" + id + ", customerName:" + customerName + ", tableSize:" + tableSize + ", bookingInitDate:"
				+ bookingInitDate + ", bookingEndDate:" + bookingEndDate;
	}
	
	public BookingDTO(String customerName, int tableSize, LocalDateTime bookingInitDate) {
		super();
		this.customerName = customerName;
		this.tableSize = tableSize;
		this.bookingInitDate = bookingInitDate;
	}

	public BookingDTO(int id, String customerName, int tableSize, LocalDateTime bookingInitDate, LocalDateTime bookingEndDate) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.tableSize = tableSize;
		this.bookingInitDate = bookingInitDate;
		this.bookingEndDate = bookingEndDate;
	}
	
}
