// Assignment 4
// Writen by: William Zicha 40127016
// For COMP 248 Section S - Fall 2021
// Create a ticketbooth application with 4 separate classes


import java.util.Scanner;

public class driver {

	public static void main(String[] args) {

		Scanner var = new Scanner(System.in);

		System.out.println("===========================================================================");
		System.out.println();
		System.out.println("            Welcome to Concordia 2021 Fall Geek's Ticketbooth Application");
		System.out.println();
		System.out.println("===========================================================================");

		// 2 Ticketbooths with same ticket distribution and same number of Opus cards
		Tickets t1 = new Tickets(4, 3, 2, 1, 0); // 33.5$
		Tickets t2 = new Tickets(4, 3, 2, 1, 0);
		OPUSCard o1 = new OPUSCard("STM", "Jeff Hillis", 2025, 12);
		OPUSCard o2 = new OPUSCard("STM", "Karen Jones", 2022, 10);
		OPUSCard o3 = new OPUSCard("STM", "Geoff Write", 2025, 11);
		OPUSCard o4 = new OPUSCard("STM", "Karl Stephens", 2025, 11);
		OPUSCard[] arr1 = { o1, o2 };
		OPUSCard[] arr2 = { o3, o4 };
		Ticketbooth tb0 = new Ticketbooth(t1, arr1);
		Ticketbooth tb1 = new Ticketbooth(t2, arr2);

		// 1 ticketbooth with same total value of tickets of another ticketbooth but
		// with different configuration of tickets and  ticketbooth should have minimum 3 OPUD
		Tickets t3 = new Tickets(1, 4, 0, 2, 0); 
		OPUSCard o5 = new OPUSCard("STM", "Donald Jameson", 2022, 3);
		OPUSCard o6 = new OPUSCard("TMS", "Brent Bono", 2024, 9);
		OPUSCard o7 = new OPUSCard("MTS", "Bobby Jones", 2025, 12);
		OPUSCard o8 = new OPUSCard("MTS", "Alexander Pookie", 2022, 11);
		OPUSCard[] arr3 = { o5, o6, o7, o8 };
		Ticketbooth tb2 = new Ticketbooth(t3, arr3);

		// At least 2 Ticketbooths that have the same breakdown of tickets but
		// different from the other 3 Ticketbooths and both have no OPUS cards
		Tickets t4 = new Tickets(0, 0, 0, 30, 0);
		Tickets t5 = new Tickets(0, 0, 0, 30, 0);
		OPUSCard[] arr4 = {};
		OPUSCard[] arr5 = {};
		Ticketbooth tb3 = new Ticketbooth(t4, arr4);
		Ticketbooth tb4 = new Ticketbooth(t5, arr5);

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("\n");
			System.out.println("What would you like to do?");
			System.out.println("\t1.See the content of all Ticketbooths");
			System.out.println("\t2.See the content of one Ticketbooth");
			System.out.println("\t3.List Ticketbooths with same amount of tickets' values");
			System.out.println("\t4.List Ticketbooths with same Tickets amount");
			System.out
					.println("\t5.List Ticketbooths with same amount of tickets values and same number of OPUS cards");
			System.out.println("\t6.Add a OPUS card to an existing Ticketbooth");
			System.out.println("\t7.Remove an existing OPUS card from a Ticketbooth");
			System.out.println("\t8 Update the expiry date of an existing OPUS card");
			System.out.println("\t9.Add Tickets to a Ticketbooth");
			System.out.println("\t0.To quit");
			System.out.print("\nPlease enter your choice and press <Enter>:");
			int choice = var.nextInt();

			int tbChoice = 0;
			boolean caseValid = true;
			boolean validCard = true;

			switch (choice) {
			case 1:
				System.out.println("Content of each Ticketbooth:");
				System.out.println("-----------------------------");
				System.out.println("\nTicketbooth #1\n----------------------\n" + tb0);
				System.out.println("\nTicketbooth #2\n----------------------" + tb1);
				System.out.println("\nTicketbooth #3\n----------------------" + tb2);
				System.out.println("\nTicketbooth #4\n----------------------" + tb3);
				System.out.println("\nTicketbooth #5\n----------------------" + tb4);
				break;
			case 2:
				while (caseValid) {
					System.out
							.print("\nWhich ticketbooth would you like to see the content of? (Enter number 1 to 5):");
					tbChoice = var.nextInt() - 1;
					if (tbChoice == 0) {
						System.out.println("\nTicketbooth #1\n----------------------\n" + tb0);
						caseValid = false;
						break;
					}
					if (tbChoice == 1) {
						System.out.println("\nTicketbooth #2\n----------------------" + tb1);
						caseValid = false;
						break;
					}
					if (tbChoice == 2) {
						System.out.println("\nTicketbooth #3\n----------------------" + tb2);
						caseValid = false;
						break;
					}
					if (tbChoice == 3) {
						System.out.println("\nTicketbooth #4\n----------------------" + tb3);
						caseValid = false;
						break;
					}
					if (tbChoice == 4) {
						System.out.println("\nTicketbooth #5\n----------------------" + tb4);
						caseValid = false;
						break;
					} else {
						tbChoice++;
						System.out.println("Sorry, there is no Ticketbooth number " + tbChoice + " please try again");
					}
				}
				break;
			case 3:
				if (tb0.checkTicketAmount(tb0, tb1) == true) {
					System.out.println("Ticketbooths 1 and 2 both have $" + tb0.totalValue());
				}
				if (tb0.checkTicketAmount(tb1, tb2) == true) {
					System.out.println("Ticketbooths 2 and 3 both have $" + tb0.totalValue());
				}
				if (tb0.checkTicketAmount(tb1, tb3) == true) {
					System.out.println("Ticketbooths 2 and 4 both have $" + tb0.totalValue());
				}
				if (tb0.checkTicketAmount(tb1, tb4) == true) {
					System.out.println("Ticketbooths 2 and 5 both have $" + tb0.totalValue());
				}
				if (tb1.checkTicketAmount(tb1, tb2) == true) {
					System.out.println("Ticketbooths 2 and 3 both have $" + tb1.totalValue());
				}
				if (tb1.checkTicketAmount(tb1, tb3) == true) {
					System.out.println("Ticketbooths 2 and 4 both have $" + tb1.totalValue());
				}
				if (tb1.checkTicketAmount(tb1, tb4) == true) {
					System.out.println("Ticketbooths 2 and 5 both have $" + tb1.totalValue());
				}
				if (tb2.checkTicketAmount(tb2, tb3) == true) {
					System.out.println("Ticketbooths 3 and 4 both have $" + tb2.totalValue());
				}
				if (tb2.checkTicketAmount(tb2, tb4) == true) {
					System.out.println("Ticketbooths 3 and 5 both have $" + tb2.totalValue());
				}
				if (tb3.checkTicketAmount(tb3, tb4) == true) {
					System.out.println("Ticketbooths 4 and 5 both have $" + tb3.totalValue());
				} else {
					System.out.println("There are no two Ticketbooths that are equal in ticket value");
				}
				break;
			case 4:
				if (tb0.checkTicketAmount(tb0, tb1) == true) {
					System.out.println("Ticketbooths 1 and 2 both have " + t1);
				}
				if (tb0.checkTicketAmount(tb0, tb2) == true) {
					System.out.println("Ticketbooths 1 and 3 both have " + t1);
				}
				if (tb0.checkTicketAmount(tb0, tb3) == true) {
					System.out.println("Ticketbooths 1 and 4 both have " + t1);
				}
				if (tb0.checkTicketAmount(tb0, tb4) == true) {
					System.out.println("Ticketbooths 1 and 5 both have " + t1);
				}
				if (tb1.checkTicketAmount(tb1, tb2) == true) {
					System.out.println("Ticketbooths 2 and 3 both have " + t2);
				}
				if (tb1.checkTicketAmount(tb1, tb3) == true) {
					System.out.println("Ticketbooths 2 and 4 both have " + t2);
				}
				if (tb1.checkTicketAmount(tb1, tb4) == true) {
					System.out.println("Ticketbooths 2 and 5 both have " + t2);
				}
				if (tb2.checkTicketAmount(tb2, tb3) == true) {
					System.out.println("Ticketbooths 3 and 4 both have " + t3);
				}
				if (tb2.checkTicketAmount(tb2, tb4) == true) {
					System.out.println("Ticketbooths 3 and 5 both have " + t3);
				}
				if (tb3.checkTicketAmount(tb3, tb4) == true) {
					System.out.println("Ticketbooths 4 and 5 both have " + t4);
				} else {
					System.out.println("There are no two Ticketbooths with the same ticket distrbution");
				}
				break;
			case 5:
				if (tb0.equals(tb1, tb2) == true) {
					System.out.println(
							"Ticketbooths 2 and 3 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb0.equals(tb1, tb3) == true) {
					System.out.println(
							"Ticketbooths 2 and 4 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb0.equals(tb1, tb4) == true) {
					System.out.println(
							"Ticketbooths 2 and 5 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb0.equals(tb0, tb4) == true) {
					System.out.println(
							"Ticketbooths 1 and 5 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb1.equals(tb1, tb2) == true) {
					System.out.println(
							"Ticketbooths 2 and 3 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb1.equals(tb1, tb3) == true) {
					System.out.println(
							"Ticketbooths 2 and 4 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb1.equals(tb1, tb4) == true) {
					System.out.println(
							"Ticketbooths 2 and 5 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb2.equals(tb2, tb3) == true) {
					System.out.println(
							"Ticketbooths 3 and 4 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb2.equals(tb2, tb4) == true) {
					System.out.println(
							"Ticketbooths 3 and 5 have the same amount of Ticket values and the same number of OPUS Cards");
				}
				if (tb3.equals(tb3, tb4) == true) {
					System.out.println(
							"Ticketbooths 4 and 5 have the same amount of Ticket values and the same number of OPUS Cards");
				} else {
					System.out.println("There are no two Ticketbooths whose content are equal");
				}
				break;
			case 6:
				while (caseValid) {
					System.out.println("\nWhich Ticketbooth would you like to add an OPUS car to? (1-5)");
					tbChoice = var.nextInt() - 1;
					if (tbChoice == 0) {
						System.out.println("--->Please enter card type: ");
						String uType = var.next();
						System.out.println("--->Please enter name: ");
						String uName = var.nextLine();
						uName += var.nextLine();
						System.out.println("--->Please enter expiry year: ");
						int uExpY = var.nextInt();
						System.out.println("--->Please enter expiry month: ");
						int uExpM = var.nextInt();
						OPUSCard newO = new OPUSCard(uType, uName, uExpY, uExpM);
						int newLength = tb0.addCard(newO);
						System.out.println("Your now have " + (newLength) + " OPUS Cards");
						System.out.println(tb0.toString());
						caseValid = false;
						break;
					}
					if (tbChoice == 1) {
						System.out.println("--->Please enter card type: ");
						String uType = var.next();
						System.out.println("--->Please enter name: ");
						String uName = var.next();
						uName += var.nextLine();
						System.out.println("--->Please enter expiry year: ");
						int uExpY = var.nextInt();
						System.out.println("--->Please enter expiry month: ");
						int uExpM = var.nextInt();
						OPUSCard newO = new OPUSCard(uType, uName, uExpY, uExpM);
						int newLength = tb1.addCard(newO);
						System.out.println("You now have " + (newLength) + " OPUS Cards");
						System.out.println(tb1.toString());
						caseValid = false;
						break;
					}
					if (tbChoice == 2) {
						System.out.println("--->Please enter card type: ");
						String uType = var.next();
						System.out.println("--->Please enter name: ");
						String uName = var.next();
						uName += var.nextLine();
						System.out.println("--->Please enter expiry year: ");
						int uExpY = var.nextInt();
						System.out.println("--->Please enter expiry month: ");
						int uExpM = var.nextInt();
						OPUSCard newO = new OPUSCard(uType, uName, uExpY, uExpM);
						int newLength = tb2.addCard(newO);
						System.out.println("You now have " + (newLength) + " OPUS Cards");
						System.out.println(tb2.toString());
						caseValid = false;
						break;
					}
					if (tbChoice == 3) {
						System.out.println("--->Please enter card type: ");
						String uType = var.next();
						System.out.println("--->Please enter name: ");
						String uName = var.next();
						uName += var.nextLine();
						System.out.println("--->Please enter expiry year: ");
						int uExpY = var.nextInt();
						System.out.println("--->Please enter expiry month: ");
						int uExpM = var.nextInt();
						OPUSCard newO = new OPUSCard(uType, uName, uExpY, uExpM);
						int newLength = tb3.addCard(newO);
						System.out.println("You now have " + (newLength) + " OPUS Cards");
						System.out.println(tb3);
						caseValid = false;
						break;
					}
					if (tbChoice == 4) {
						System.out.println("--->Please enter card type: ");
						String uType = var.next();
						System.out.println("--->Please enter name: ");
						String uName = var.next();
						uName += var.nextLine();
						System.out.println("--->Please enter expiry year: ");
						int uExpY = var.nextInt();
						System.out.println("--->Please enter expiry month: ");
						int uExpM = var.nextInt();
						OPUSCard newO = new OPUSCard(uType, uName, uExpY, uExpM);
						int newLength = tb4.addCard(newO);
						System.out.println("You now have " + (newLength) + " OPUS Cards");
						System.out.println(tb4.toString());
						caseValid = false;
						break;
					} else {
						tbChoice++;
						System.out.println("Sorry, there is no Ticketbooth " + tbChoice + ", please try again");
					}
				}
				break;
			case 7:
				while (caseValid) {
					System.out.println("\nWhich Ticketbooth would you like to remove an OPUS car from? (1-5)");
					tbChoice = var.nextInt() - 1;
					if (tbChoice == 0) {
						if (tb0.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS Cards in this Ticketbooth");
							validCard = false;
							caseValid = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to remove?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb0.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								validCard = true;
								caseValid = true;
							} else {
								for (int i = 0; i < tb0.totalOpus(); i++) {
									if (cardChoice == i) {
										tb0.removeCard(cardChoice);
										System.out.println("Card was removed successfully");
										System.out.println(tb0.toString());
										validCard = false;
										caseValid = false;
										break;
									}
								}
							}
						}
						break;
					}
					if (tbChoice == 1) {
						if (tb1.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS Cards in this Ticketbooth");
							validCard = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to remove?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb1.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								validCard = true;
								caseValid = true;
							} else {
								for (int i = 0; i < tb1.totalOpus(); i++) {
									if (cardChoice == i) {
										tb1.removeCard(cardChoice);
										System.out.println("Card was removed successfully");
										System.out.println(tb1.toString());
										validCard = false;
										caseValid = false;
										break;
									}
								}
							}
						}
						break;
					}
					if (tbChoice == 2) {
						if (tb2.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS Cards in this Ticketbooth");
							validCard = false;
							caseValid = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to remove?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb2.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								validCard = true;
								caseValid = true;
							} else {
								for (int i = 0; i < tb2.totalOpus(); i++) {
									if (cardChoice == i) {
										tb2.removeCard(cardChoice);
										System.out.println("Card was removed successfully");
										System.out.println(tb2.toString());
										validCard = false;
										caseValid = false;
										break;
									}
								}
							}
						}
						break;
					}
					if (tbChoice == 3) {
						if (tb3.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS Cards in this Ticketbooth");
							validCard = false;
							caseValid = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to remove?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb3.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								validCard = true;
								caseValid = true;
							} else {
								for (int i = 0; i < tb3.totalOpus(); i++) {
									if (cardChoice == i) {
										tb3.removeCard(cardChoice);
										System.out.println("Card was removed successfully");
										System.out.println(tb3.toString());
										validCard = false;
										caseValid = false;
										break;
									}
								}
							}
						}
						break;
					}
					if (tbChoice == 4) {
						if (tb4.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS Cards in this Ticketbooth");
							validCard = false;
							caseValid = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to remove?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb4.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								validCard = true;
								caseValid = true;
							} else {
								for (int i = 0; i < tb4.totalOpus(); i++) {
									if (cardChoice == i) {
										tb4.removeCard(cardChoice);
										System.out.println("Card was removed successfully");
										System.out.println(tb4.toString());
										validCard = false;
										caseValid = false;
										break;
									}
								}
							}
						}
						break;
					} else {
						tbChoice++;
						System.out.println("Sorry, there is no Ticketbooth " + tbChoice + ", please try again");
					}
				}
				break;
			case 8:
				while (caseValid) {
					System.out.println("\nWhich Ticketbooth would you like to update? (1-5)");
					tbChoice = var.nextInt() - 1;
					if (tbChoice == 0) {
						if (tb0.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS cards in this Ticketbooth");
							caseValid = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to update?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb0.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								caseValid = true;
								validCard = true;
							} else {
								System.out.println("--->Please enter new expiry year: ");
								int newYear = var.nextInt();
								System.out.println("--->Please enter new expiry month: ");
								int newMonth = var.nextInt();
								tb0.updateOpus(newYear, newMonth, cardChoice);
								System.out.println("Expiry Date Updated Successfully");
								System.out.println("NEW tb0: " + tb0.toString());
								caseValid = false;
								validCard = false;
								break;
							}
						}
						break;
					}
					if (tbChoice == 1) {
						if (tb1.totalOpus() == 0) {
							System.out.println("Sorry, there are no OPUS cards in this Ticketbooth");
							caseValid = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to update?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb1.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								caseValid = true;
								validCard = true;
							} else {
								System.out.println("--->Please enter new expiry year: ");
								int newYear = var.nextInt();
								System.out.println("--->Please enter new expiry month: ");
								int newMonth = var.nextInt();
								tb1.updateOpus(newYear, newMonth, cardChoice);
								System.out.println("Expiry Date Updated Successfully");
								System.out.println("NEW tb1: " + tb1.toString());
								caseValid = false;
								validCard = false;
								break;
							}
						}
						break;
					}
					if (tbChoice == 2) {
						if (tb2.totalOpus() == 0) {
							System.out.println("Sorry that there are no OPUS cards in this Ticketbooth");
							caseValid = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to update?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb2.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								caseValid = true;
								validCard = true;
							} else {
								System.out.println("--->Please enter new expiry year: ");
								int newYear = var.nextInt();
								System.out.println("--->Please enter new expiry month: ");
								int newMonth = var.nextInt();
								tb2.updateOpus(newYear, newMonth, cardChoice);
								System.out.println("Expiry Date Updated Successfully");
								System.out.println("NEW tb2: " + tb2.toString());
								caseValid = false;
								validCard = false;
								break;
							}
						}
						break;
					}
					if (tbChoice == 3) {
						if (tb3.totalOpus() == 0) {
							System.out.println("Sorry that there are no OPUS cards in this Ticketbooth");
							caseValid = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to update?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb3.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								caseValid = true;
								validCard = true;
							} else {
								System.out.println("--->Please enter new expiry year: ");
								int newYear = var.nextInt();
								System.out.println("--->Please enter new expiry month: ");
								int newMonth = var.nextInt();
								tb3.updateOpus(newYear, newMonth, cardChoice);
								System.out.println("Expiry Date Updated Successfully");
								System.out.println("NEW TB3: " + tb3.toString());
								caseValid = false;
								validCard = false;
								break;
							}
						}
						break;
					}
					if (tbChoice == 4) {
						if (tb4.totalOpus() == 0) {
							System.out.println("Sorry that there are no OPUS cards in this Ticketbooth");
							caseValid = false;
							validCard = false;
							break;
						}
						while (validCard) {
							System.out.println("\nWhich card would you like to update?");
							int cardChoice = var.nextInt() - 1;
							if (cardChoice > (tb4.totalOpus() - 1)) {
								System.out.println("Card " + (cardChoice + 1) + " does not exist, please try again");
								caseValid = true;
								validCard = true;
							} else {
								System.out.println("--->Please enter new expiry year: ");
								int newYear = var.nextInt();
								System.out.println("--->Please enter new expiry month: ");
								int newMonth = var.nextInt();
								tb4.updateOpus(newYear, newMonth, cardChoice);
								System.out.println("Expiry Date Updated Successfully");
								System.out.println("NEW tb4: " + tb4.toString());
								caseValid = false;
								validCard = false;
								break;
							}
						}
						break;
					} else {
						tbChoice++;
						System.out.println("Sorry, there is no Ticketbooth " + tbChoice + ", please try again");
						caseValid = true;
					}
				}
				break;
			case 9:
				while (caseValid) {
					System.out.println("\nWhich ticketbooth would you like to add tickets to? (1-5)");
					tbChoice = var.nextInt() - 1;
					if (tbChoice == 0) {
						System.out.println("--->Please enter the number of REGULAR tickets would you like to add:");
						int uRT = var.nextInt();
						System.out.println("--->Please enter the number of JUNIOR tickets would you like to add:");
						int uJT = var.nextInt();
						System.out.println("--->Please enter the number of SENIOR tickets would you like to add:");
						int uST = var.nextInt();
						System.out.println("--->Please enter the number of DAILY tickets would you like to add:");
						int uDT = var.nextInt();
						System.out.println("--->Please enter the number of WEEKLY tickets would you like to add:");
						int uWT = var.nextInt();
						double newTotal = tb0.addTickets(uRT, uJT, uST, uDT, uWT);
						System.out.println("You now have $" + newTotal);
						caseValid = false;
						break;
					}
					if (tbChoice == 1) {
						System.out.println("--->Please enter the number of REGULAR tickets would you like to add:");
						int uRT = var.nextInt();
						System.out.println("--->Please enter the number of JUNIOR tickets would you like to add:");
						int uJT = var.nextInt();
						System.out.println("--->Please enter the number of SENIOR tickets would you like to add:");
						int uST = var.nextInt();
						System.out.println("--->Please enter the number of DAILY tickets would you like to add:");
						int uDT = var.nextInt();
						System.out.println("--->Please enter the number of WEEKLY tickets would you like to add:");
						int uWT = var.nextInt();
						double newTotal = tb1.addTickets(uRT, uJT, uST, uDT, uWT);
						System.out.println("You now have $" + newTotal);
						caseValid = false;
						break;
					}
					if (tbChoice == 2) {
						System.out.println("--->Please enter the number of REGULAR tickets would you like to add:");
						int uRT = var.nextInt();
						System.out.println("--->Please enter the number of JUNIOR tickets would you like to add:");
						int uJT = var.nextInt();
						System.out.println("--->Please enter the number of SENIOR tickets would you like to add:");
						int uST = var.nextInt();
						System.out.println("--->Please enter the number of DAILY tickets would you like to add:");
						int uDT = var.nextInt();
						System.out.println("--->Please enter the number of WEEKLY tickets would you like to add:");
						int uWT = var.nextInt();
						double newTotal = tb2.addTickets(uRT, uJT, uST, uDT, uWT);
						System.out.println("You now have $" + newTotal);
						caseValid = false;
						break;
					}
					if (tbChoice == 3) {
						System.out.println("--->Please enter the number of REGULAR tickets would you like to add:");
						int uRT = var.nextInt();
						System.out.println("--->Please enter the number of JUNIOR tickets would you like to add:");
						int uJT = var.nextInt();
						System.out.println("--->Please enter the number of SENIOR tickets would you like to add:");
						int uST = var.nextInt();
						System.out.println("--->Please enter the number of DAILY tickets would you like to add:");
						int uDT = var.nextInt();
						System.out.println("--->Please enter the number of WEEKLY tickets would you like to add:");
						int uWT = var.nextInt();
						double newTotal = tb3.addTickets(uRT, uJT, uST, uDT, uWT);
						System.out.println("You now have $" + newTotal);
						caseValid = false;
						break;
					}
					if (tbChoice == 4) {
						System.out.println("--->Please enter the number of REGULAR tickets would you like to add:");
						int uRT = var.nextInt();
						System.out.println("--->Please enter the number of JUNIOR tickets would you like to add:");
						int uJT = var.nextInt();
						System.out.println("--->Please enter the number of SENIOR tickets would you like to add:");
						int uST = var.nextInt();
						System.out.println("--->Please enter the number of DAILY tickets would you like to add:");
						int uDT = var.nextInt();
						System.out.println("--->Please enter the number of WEEKLY tickets would you like to add:");
						int uWT = var.nextInt();
						double newTotal = tb4.addTickets(uRT, uJT, uST, uDT, uWT);
						System.out.println("You now have $" + newTotal);
						caseValid = false;
						break;
					} else {
						tbChoice++;
						System.out.println("Sorry, there is no Ticketbooth " + tbChoice + ", please try again ");
					}
				}
				break;
			case 0:
				System.out.println("\nThank you for using Ticketbooth!");
				keepGoing = false;
				break;
			default:
				System.out.print("Sorry that is not a valid choice. Try again.");
				break;
			}
		}
		var.close();
	}
}