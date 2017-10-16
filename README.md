## Notes

This Boiler Plate is running the following stack:
-   Spring Boot
-	Java
-	MongoDB
-   Maven


## Install Locally

Follow these steps to install this app:
-   Clone this repo from GIT
-   Make sure you have JDK 1.7 or above installed and configured on your machine
-	MongoDB Setup
1) Download and install MongoDB to custom path - C:\mongodb
2) Set machines ENV VARIABLES for PATH = C:\mongodb\bin\
3) Reboot Machine for the ENV VARIABLES PATH to take effect
4) Create folders under C:\mongodb\
	a) C:\mongodb\data
	b) C:\mongodb\data\db
	c) C:\mongodb\log
5) Using command prompt as administrator key in following commands
	a) C:\mongodb\bin>mongod --directoryperdb -dbpath C:\mongodb\data\db --logpath C:\mongodb\log\mongo.log --logappend --rest --httpinterface --install		[setup MongoDB with the folders we created above]
	b) C:\mongodb\bin>net start MongoDB																															[boot up MongoDB]
	c) C:\mongodb\bin>mongo																																		[enter into mongo shell]
	


## Launch Locally

To launch the app key in this command 
-	Open cloned repo in Spring Tool Suite IDE and then just simply RunAs > Spring Boot App
-	In browser key in the URL as http://localhost:8080/hotels/all
