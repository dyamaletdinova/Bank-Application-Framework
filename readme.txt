Patterns used, and the role that they play in the solution.

Façade Pattern:

The FinCo class is the Façade Object to the whole system that encapsulates the functionality of several interfaces in the system to be called from the GUI. 


Command Pattern:
Is used to encapsulate several operations (Report, AddAccount, Transaction, Mailer, AddInterest). 

Observer Pattern:
Used in the Report command to update the UI. When the report is created, all of the observes are notified and the report is returned to the GUI. 

Abstract Factory:
Used to create accounts extended for every version of the framework to include factories for the new accounts and new customers. Default implementation is to create personal or company account. 

Party Pattern:
Is a specific pattern that is designed to provide the abstraction to define persons or organizations.

Account Pattern: 
Used to separate the logic of having entries in a particular account. 


Plug points of the framework, and how it could be used for other applications.

Plug points:
FinCo class is extended for each application and can have specific implementation. 
FincoFactory extended for creating both personal and company’s accounts to include the new account types. 
Account is extended to include the new account types specific to the applications with different functionalities. 
ReportGeneratorController can be extended to include new specific report functionalities. 
Person and Organization can be extended for specific implementation (sending emails conditions).
