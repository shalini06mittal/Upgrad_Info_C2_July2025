package database;

import java.util.List;

public class TestDB {

	public static void main(String[] args) {
		//MyConnection.connect();
		
		CustomerDatabase database = new CustomerDatabase();
		//database.insertCustomer(new Customer("Divya","divya@gmail.com","divya123"));
		//database.insertCustomerPreparedStatement(new Customer("Shivam","shivam@gmail.com","shivam123"));
		//System.out.println(database.getLastInsertedCustomer());
		List<Customer> list = database.getCustomers();
		for(Customer cust : list) {
			System.out.println(cust);
		}
		

	}

}
