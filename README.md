# How to integrate web automation in Jenkins from GitHub
## Required Technologies and Tools
   1. [Jdk Download & Install](https://www.oracle.com/java/technologies/downloads/)
   2. [Git](https://git-scm.com/downloads)
   3. Browsers
   5. [Gradle Download & Install](https://gradle.org/install/) 
   2. [Genkins.war](https://www.jenkins.io/download/) & [Install](https://www.jenkins.io/doc/book/installing/war-file/)
   6. HTML Publisher jenkins pluging
   7. Mail pluging
   8. Selenium WebDriver
   9. TestNG
   10. Extended Report
   11. GitHub
       
 ## Jenkins configuration
 1. Email configure  from Manage jenkins > System > E-mail Notification:
 2. Email configure from from Manage jenkins > System > Extended E-mail Notification
 3. Gradle: Dashboard > Manage Jenkins > Tools
 4. Integrating Jenkins with GitHub using SSH: Dashboard > Manage Jenkins >> Credentials >> click on "(global)" >> Add Credentials
    
 ## Note
 1. Run the command from Manage jenkins > Script Console :
    ```
    System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src *");
