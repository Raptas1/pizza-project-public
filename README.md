# How to run the app locally.
1. Download Java 17 & JRE 8 (This will allow the app to run locally)
2. Download MySQLWorkbench 8.0.32 to manipulate the MySQL Database.
3. Download the Github Repo ZIP
4. Download the DDL Script found within this repo called pizzaproject.sql
5. Open MySQLWorkbench and create a schema by right-clicking within the SCHEMAS section
6. hover over "Server" then click on Data Import
7. Select Import from Self-Contained File then select the DDL Script we downloaded.
8. Press Default Target Schema and select the Schema created then click Start Import
9. Open the Repo with a code editor
10. Within the application.properties file, edit the url do "jdbc:mysql//localhost:[PORT]/[SCHEMA NAME]"
11. Replace values with Port and Schema Name, repeat with username and password of mySQL username and password.
12. Run the app by doing ./mvnw spring-boot:run

# How to test the App.
Toppings And Pizzas are two different pages, both work the same.
To create a topping or Pizza, press the create button and populate the inputs, then press create.
After creation, the newly created topping or pizza will appear in a list and then will have two buttons one to edit and one to delete. 
Pressing the edit will open a modal with existing data, and pressing the delete will open a modal with a confirmation message.
