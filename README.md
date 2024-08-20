The application is created using a three-tier software architecture with the use of FXML and CSS. 

The Person class contains all the states and behaviors characteristic of this type. These include properties that hold object states such as name, surname, email, etc., as well as methods and behaviors specific to objects of this type. 

The UI is implemented through several controls that allow for the input of data about a person. The user has the option to save the person, delete the entered content, and exit the application. 

The controller listens for user actions and takes appropriate actions on the model objects — in reality, it does not perform these actions personally but ensures that the appropriate methods of the model are called.
