Weather
=======

Web application using Spring framework with some other technologies.

System Requirements:
=====================
1- JDK 7.
2- Maven 3.
3- Apache tomcat 7.
4- MySql version 5.5.

To build the project:
======================
1- Create schema 'WEATHER'.
2- Run the database scripts in the DbScripts folder, they are independent so you can run them in any order.
3- Update the database properties in database.xml found in Weather src/main/webapp/WEB-INF folder.
4- From the command line move the Weather directory.
5- Run command: mvn clean install -DskipTests=true  to skip test cases while building the project.
6- Move to the target folder generated and copy the Weather.war file to webapps and start tomcat.
7- Type localhost:8080/Weather in the browser.

Technologies used:
===================
1- Spring MVC.
2- Spring Security.
3- JDBC.
4- Free marker.
5- Log4j.
6- MySQL.
7- Junit.
