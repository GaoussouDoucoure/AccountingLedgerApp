# Gaoussou's Accounting Ledger Application
A Java Command Line Interface (CLI) application to track all financial transactions for businesses or personal use. Transactions are saved in a `transactions.csv` file.

## Project Planning
The initial phase for launching this app involved leveraging GitHub’s built-in project management tools. I began by mapping out every task on a Kanban board, assigning each task to myself and creating a dedicated branch for each one. As soon as I started working on a task, I updated its status to "In Progress." Once a task was completed, merged, and pulled to GitHub, it automatically moved to the "Done" column, and the changes were pushed to my accounting-ledger-app repository using Git Bash.


- Created Tasks, Assigned them to myself, Created Branches, Added a Project Status Tracker, Project Description
  
![image](https://github.com/user-attachments/assets/62bb8103-1764-461e-80e7-f047d33783e6)

- Added a description to each task and a user story
  
![image](https://github.com/user-attachments/assets/f79c8acf-4fd0-490a-9917-189fac856ba4)

- Tasks get displayed on the board based on their status

![image](https://github.com/user-attachments/assets/c6dd6fa5-9ab6-455e-9a2a-599c6515b5d4)

- Using Git Bash in the terminal to fetch, checkout, add&commit, push, merge and pull

![image](https://github.com/user-attachments/assets/c6c836e2-6a94-46d7-82c7-6aa1d1394b29)

- Confirming pull requests on the GitHub website

![image](https://github.com/user-attachments/assets/109b5e75-5e76-4e16-b118-249787177817)


- Final product of the project

![image](https://github.com/user-attachments/assets/9e5a108b-7607-4c5b-91af-e82b5cb2f81a)



## Features:
- Add deposits
- Make payments
- View ledger entries
- Run reports

![image](https://github.com/user-attachments/assets/d567ba66-baab-4c4a-8829-cda8c68e203a)

When planning to make my project user-friendly, I focused a lot on its overall structure. As the screenshot shows, my application is now organized into four main classes:
- AccountingLedgerApp: This class serves as the entry point, housing the main method and coordinating the various screens of the app.
- CSVHandler: This class is responsible for managing all CSV file operations, ensuring efficient data input and output (Reading/Writing). 
- Screens: All the code responsible for rendering and managing the different user interface screens is contained here.
- Transaction: This class constructs and manages individual transaction objects, encapsulating all the related data.

This modular design not only simplifies maintenance and future enhancements but also ensures a smooth and intuitive user experience.

## Highlighted Code:
![image](https://github.com/user-attachments/assets/1605b246-718c-46f9-a766-125bb9d8ff7b)
I chose this block of code as my highlighted code due to its effiicient improvement for a Readable Output. By specifying fixed-width fields (%-12s, %-8s, etc.), the code ensures that, regardless of the varying length of each data field, the final output is presented in a clean, tabular format. This attention to detail greatly improves the user experience in a command-line interface.

