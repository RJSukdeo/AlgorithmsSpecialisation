Stanford Algorithm Specialisation - Ryan Sukdeo

Contents
1) Introduction
2) Software Requirements
3) How to run the application

1) Introduction
This repository contains the codebase I used to complete the programming assessments for the Stanford Algorithm Specialisation on Coursera. The code is written in Java and is built into an executable JAR via the Gradle build tool.

2) Software Requirements
In this section we will cover the software required to build the codebase:
  - JDK (Java Development Kit) 11.0.4
  - Gradle 6.1.1

3) How to run the application
There are two ways of interacting with this project. Either by cloning the repository and building the JAR on your machine or by running the already built JAR available in the repository.

In order to build and run the application, follow the steps below:
  - Clone the repository onto your local hard drive,
  - Using the Gradle wrapper run the assemble task (in Linux: ./gradlew assemble),
  - The JAR will be located in the AlgorithmsSpecialisation/build/libs folder,
  - In a terminal run the command "java -Xms4096m -Xmx4096m -Xss1024m -jar AlgorithmSpecialisation.jar".

In order to run the application, follow the steps below:
  - Navigate to the folder /build/libs/ located on this repository
  - Download the file AlgorithmSpecialisation.jar
  - In a terminal run the command "java -Xms4096m -Xmx4096m -Xss1024m -jar AlgorithmSpecialisation.jar".
  
