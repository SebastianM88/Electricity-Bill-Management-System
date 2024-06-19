Electricity Bill Management System

This is a graphical user interface (GUI) created using Java Swing. It allows the user to perform several operations, such as:

1 The user can create his own authentication account for security. 
2 User can add customers and calculate their electricity bills. 
3 The user can pay the electricity bills. 
4 User can generate invoices.

*  The project has in its composition 11 different classes and which are recommended to be realized as follows: 

1. Signup Class
2. Login Class
3. MainScreen Class
4. DBConnection Class
5. Project Class
6. newCustomer Class
7. customerDetails Class
8. calculateBill Class
9. payBill Class
10. lastBill Class
11. genarateBill Class


 * Database (MySQL)

The database consists of 4 tables with its variables such as: 

- login table ( meter_no, username, name, password, user )
- customer table ( name, meter_no, address, city, state, email, phone )
- bill table ( meter_number, units, month, amount )
- tax table ( meter_location, meter_type, phase_code, bill_type, days, meter_rent, mcb_rent, service_rent, gts)


