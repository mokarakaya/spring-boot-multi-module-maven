# spring-boot-multi-module-maven
This project is a multi module maven project. Modules are api and web.

Steps to run;

First please navigate to webDemoProject folder and build the project as;
 webDemoProject>mvn clean install

If everything works fine navigate to web folder and run spring boot project as;
 webDemoProject>cd web
 webDemoProject/web>mvn spring-boot:run

Then go to; localhost:8080

This project has 2 spring boot projects; api, web.
When web project runs it creates itself and it also creates api project. So, both modules run in single tomcat server.
Additionally, api module can run by itself since it's not dependent to web module.


