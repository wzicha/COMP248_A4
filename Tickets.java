// Assignment 4
// Writen by: William Zicha 40127016
// For COMP 248 Section S - Fall 2021
// Create a ticketbooth application with 4 separate classes

public class Tickets {
	final static double regularTicketPrice = 3.50, juniorTicketPrice = 2.50, seniorTicketPrice = 1,
			dailyTicketPrice = 10, weeklyTicketPrice = 40;
	int regularTicketAmount, juniorTicketAmount, seniorTicketAmount, dailyTicketAmount, weeklyTicketAmount;

	// Default constructor
	public Tickets() {
	}

	// Copy Constructor
	public Tickets(Tickets tickets) {
		this.regularTicketAmount = tickets.regularTicketAmount;
		this.juniorTicketAmount = tickets.juniorTicketAmount;
		this.seniorTicketAmount = tickets.seniorTicketAmount;
		this.dailyTicketAmount = tickets.regularTicketAmount;
		this.weeklyTicketAmount = tickets.weeklyTicketAmount;
	}

	// Constructor that allows to set amount of tickets in Ticket object
	public Tickets(int a, int b, int c, int d, int e) {
		regularTicketAmount = a;
		juniorTicketAmount = b;
		seniorTicketAmount = c;
		dailyTicketAmount = d;
		weeklyTicketAmount = e;
	}

	// Get methods
	public int getDailyTicketAmount() {
		return dailyTicketAmount;
	}

	public int getWeeklyTicketAmount() {
		return weeklyTicketAmount;
	}

	public int getRegularTicketAmount() {
		return regularTicketAmount;
	}

	public int getJuniorTicketAmount() {
		return juniorTicketAmount;
	}

	public int getSeniorTicketAmount() {
		return seniorTicketAmount;
	}

	// Set methods
	public void setRegularTicketAmount(int regularTicketAmount) {
		this.regularTicketAmount = regularTicketAmount;
	}

	public void setJuniorTicketAmount(int juniorTicketAmount) {
		this.juniorTicketAmount = juniorTicketAmount;
	}

	public void setSeniorTicketAmount(int seniorTicketAmount) {
		this.seniorTicketAmount = seniorTicketAmount;
	}

	public void setDailyTicketAmount(int dailyTicketAmount) {
		this.dailyTicketAmount = dailyTicketAmount;
	}

	public void setWeeklyTicketAmount(int weeklyTicketAmount) {
		this.weeklyTicketAmount = weeklyTicketAmount;
	}

	// Method allowing user to increase the amount of tickets
	public void addTickets(int a, int b, int c, int d, int e) {
		regularTicketAmount += a;
		juniorTicketAmount += b;
		seniorTicketAmount += c;
		dailyTicketAmount += d;
		weeklyTicketAmount += e;
	}

	// equals method compares two ticket Objects
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tickets))
			return false;

		Tickets tickets = (Tickets) o;

		if (getRegularTicketAmount() != tickets.getRegularTicketAmount())
			return false;
		if (getJuniorTicketAmount() != tickets.getJuniorTicketAmount())
			return false;
		if (getSeniorTicketAmount() != tickets.getSeniorTicketAmount())
			return false;
		if (getDailyTicketAmount() != tickets.getDailyTicketAmount())
			return false;
		if (getWeeklyTicketAmount() != tickets.getWeeklyTicketAmount())
			return false;

		return true;
	}

	// To string method prints out amount of tickets
	@Override
	public String toString() {
		return getRegularTicketAmount() + " x $" + regularTicketPrice + ", " + getJuniorTicketAmount() + " x $"
				+ juniorTicketPrice + ", " + getSeniorTicketAmount() + " x $" + seniorTicketPrice + ", "
				+ getDailyTicketAmount() + " x $" + dailyTicketPrice + ", " + getWeeklyTicketAmount() + " x $"
				+ weeklyTicketPrice;

	}

	// Return total value of tickets
	public double ticketsTotal() {
		return getDailyTicketAmount() * dailyTicketPrice + getJuniorTicketAmount() * juniorTicketPrice
				+ getRegularTicketAmount() * regularTicketPrice + getSeniorTicketAmount() * seniorTicketPrice
				+ getWeeklyTicketAmount() * weeklyTicketPrice;
	}
}