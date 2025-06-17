#!/bin/sh
echo "------ Step 01: Set project path to variable -------"
project_path="/Users/xuyenchi/Documents/hybrid-nopcomerce-framework"
echo "------ Step 02: Go to project path folder -------"
cd "$project_path"
echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/libAllure/aspectjweaver-1.9.24.jar" -classpath "$project_path/out/test/hybrid-nopcomerce-framework:$project_path/libAllure/*:$project_path/libLog4J1/*:$project_path/libLog4j2/*:$project_path/libraries/*" org.testng.TestNG "$project_path/resources/testing.xml"
echo "------ Step 04: Load allure command line setting -------"
source ~/.bash_profile
echo "------ Step 05: Generate Allure HTML Report -------"
allure serve ./allure-results/

