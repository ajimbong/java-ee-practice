# PHP FILE EXERCISE | 6-12-2023

### Questions
1.	Create an html form having **Fname**, **Lname**, **password**, **confirm password** and **submit**.
2.	When the user fills in the form and press submit the data should be validated with JS to ensure Lname, Fname and password are filled. Also verify that the password has at least 8 characters made up of character, special symbols, and figures(create an external JS for this)
3.	If the validation is true, the form data is submitted into php. This will be sent to a text file called SWE3.txt Information about each person should be on its line
4.	The data at the same time is collected to a database table called persons found in the database Animal. There should be php codes to validate the data again against the same specification in 2 above
5.	When the data is simultaneously submitted to the file and db, the user should be directed to a link called results which present the info in an html table that works as follows

| ID | FName | LName | Delete | Update |
| :--- | :--- | :--- | :--- | :--- |
| 1 | - | - | Delete | Update |
| 2 | - | - | Delete | Update |
| 3 | - | - | Delete | Update |


6. Write the PHP code to **Delete** and **Update** button for each item functional.
7. The page should have additional 2 links **ADD** and **FILE**. When clicked on **ADD**, the user should be directed to the form in 1. When clicked on **FILE**, the data from the file should be diplayed 