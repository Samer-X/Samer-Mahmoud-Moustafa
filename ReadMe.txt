Project Structure
1) src >> main >> java : contains all the classes
2) src >> main >> test : contains all the testng runner classes

1)a) CommonUtils Package : contain 3 classes 
    1) CommonConstants : contain the common constants used across the framework
    2) CommonHelper : contains all the methods used in the FE tcs
    3) ExcelHelper : contains the read write excel data methods

1)b) Driver : contain 1 class
    1) driverSetup : contain the driver configuration

1)c) enums : contains 1 class
    1) Enums : contains the enums

1)d) faceBookLoginPage: contains 3 classes
    1)FaceBookLoginPageConstants: contains facebook login in page constants
    2)FaceBookLoginPageHelper : contains facebook login page methods
    3)FaceBookLoginPagePo : contains facebook login page elements

1)e) faceBookRegistrationPage: contains 2 classes
    1)faceBookRegistrationPageHelper : contains facebook registration page methods
    2)FaceBookRegistrationPagePo : contains facebook registration page elements    

1)f) resources package : contains 2 files
    1) chromeDriver
    2) excel sheet containning the user data
 
2) java package : contain 3 packages each package contains the testNg runner class

- To run the test cases go to
- src >> test >> >> java >>package name >> testNg file
- right click on the file and click on "Run"

- To Check the Report after the running the TCS Open the terminal and type
allure serve allure-results