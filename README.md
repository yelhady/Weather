Weather
=======

Web application using Spring framework with some other technologies.

System Requirements:
=====================
1- JDK 7.</br>
2- Maven 3.</br>
3- Apache tomcat 7.</br>
4- MySql version 5.5.</br>

To build the project:
======================
1- Create schema 'WEATHER'.</br>
2- Run the database scripts in the DbScripts folder, they are independent so you can run them in any order.</br>
3- Update the database properties in database.xml found in Weather src/main/webapp/WEB-INF folder.</br>
4- From the command line move the Weather directory.</br>
5- Run command: mvn clean install -DskipTests=true  to skip test cases while building the project.</br>
6- Move to the target folder generated and copy the Weather.war file to webapps and start tomcat.</br>
7- Type localhost:8080/Weather in the browser.</br>

Technologies used:
===================
1- Spring MVC.</br>
2- Spring Security.</br>
3- JDBC.</br>
4- Free marke</br>r.
5- Log4j.</br>
6- MySQL.</br>
7- Junit.</br>
