# Project 1 - Docker

In this project we are packing the web service into a Docker file for easier portbility. The purpose of the project is to be able to run the application using just the docker image, requiring no installation of java or apache tomcat by the user.

To make the docker image, we have used the AWS EC2 instance that we used to deploy Homework 2 and 3. Docker contains a standalone linux environment where libraries can be installed.

URL:http://ec2-18-223-149-213.us-east-2.compute.amazonaws.com:8080/WeatherAPI/

On navigating to the URL, the user is presented with a UI which takes adate input in the format of YYYYMMDD. On clicking submit, the UI fetches the information from the HW2 API and populates the data table on the right  of the input box.

## Overview
Create a web service and a  dynamic UI to go with it.
Creat an instance on AWS  EC2 or a remote machine provider of your choice and install Apache Tomcat server(or any other of your choice). Deploy the aforementioned java application to this instance using war file of the application. Make sure the application is running on tomcat on the instance.

Now that we have our Java JDK, APache Tomcat, and the application installed on the remote machine, we can proceed to generate the docker image.

These are the steps I followed:
1. Install Docker on Instance
2. Start the docker Services
3. Create a docker file for configuration
4. Build the docker image

Now that the Docker image is generated, you can run the docker image itself.

PS: Don't forget to shutdown your tomcat instance.

The docker image will run on the same URL as mentioned before. Proceed to commit the docker image and upload it to your docker account to share it with others.

My Docker image can be fethced using the command
`docker pull deepanshpahwa/68b4291227c3`

You can run the image by using command
'docker run -p 8080:8080 deepanshpahwa/68b4291227c3'

If you navigate to the URL mentioned in the beginning of the document, you will still see the same UI but in the backend, it is the Docker image running instead of tomcat deployted war file.

# Prerequisites
Internet connectivity
Web Browser

# Installations
Docker
Apache Tomcat
Java JDK

# References
https://docker-curriculum.com/

https://github.uc.edu/tatavag/CloudComputing2019/wiki/Docker---Hands-on

### Author
Deepansh Pahwa
