Here is below commands to execute 'testng.xml' file from command line

cd F:\Selenium\maven
java -cp F:\Selenium\maven\library\*;F:\Selenium\maven\bin org.testng.TestNG testng.xml

To run a single test:

(# mvn test -Dgroups="test1/2/3/4/5") (based on created groups in annotations)
