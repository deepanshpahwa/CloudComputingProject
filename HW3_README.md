# User Interface to access the Weather Forecast Application

This application provides weather forecast data to the user. On navigating to the URL, the user is presented with a UI which takes adate input in the format of YYYYMMDD. On clicking submit, the UI fetches the information from the HW2 API and populates the data table on the right  of the input box.


The current URL of this application is: http://ec2-18-223-149-213.us-east-2.compute.amazonaws.com:8080/WeatherAPI/

## Overview
The UI is developed in HTML using some CSS and Angular. Css is used beautification where as Angular is used for the processing of the http request and the dynamic populating of the table on response from the API.

This UI is deployed on an Apache Tomcat serverdeployed on an AWS EC2 instance.The application was deployed on Tomcat bu using the deploy WAR file feature of Apache.

The URL mentioned above is of the EC2 instance with 8080 to access the default port to take the user to the application.

### Prerequisites
Internet connectivity
Web browser

### Installations required
Apache Tomcat
Java JDK

### References
Deploying Java Web Application war file on Tomcat Server running on remote machine
https://www.youtube.com/watch?v=_d-c9uGcUrU

### Author
Deepansh Pahwa
