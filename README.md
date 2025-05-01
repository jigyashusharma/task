

 Tech Stack

- * Language: Java
- * Automation Tool :-  Selenium WebDriver
- * Browser:- Google Chrome
- * Build Tool:- None (simple `.java` file)
- * Others:-Java AWT Robot class for Zoom out


##   Features Automated

- Homepage menu hover navigation
- Login using test credentials
- Search for a keyword post login
- Dropdown menu navigation
- Logout flow

---

##  Setup Instructions

## 1. Install Java (JDK 8 )
- Download from: [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html)

## 2. Install Chrome Browser
- Make sure it's updated.

## 3. Download ChromeDriver
- Match version with your Chrome.
- Download from: [https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads)
- Add it to your system PATH or keep it in the project folder.

### 4. Add Selenium JARs to Project
- Download from: [https://www.selenium.dev/downloads/](https://www.selenium.dev/downloads/)
- Add all required `.jar` files to your project’s build path.



##  Project Structure

Practice:-
    Simple_Web_Test01.java
    chromedriver.exe (optional)
    README.md



##  How to Run the Test

##  Option 1: Using IDE (Eclipse/IntelliJ)
1. Open your IDE and create a Java project.
2. Add the `Simple_Web_Test01.java` file under the `Practice` package.
3. Add Selenium jars to the project build path.
4. Make sure `chromedriver.exe` is accessible.
5. **Run the program** as a Java Application.

### Option 2: Compile and Run via Command Line
```bash
javac -cp "path_to_selenium_jars/*" Practice/Simple_Web_Test01.java
java -cp ".;path_to_selenium_jars/*" Practice.Simple_Web_Test01
```

> Replace `path_to_selenium_jars` with the folder containing your Selenium `.jar` files.



##   Test Credentials

- **Email:neha@intervue.io`
- **Password:Ps@neha@123`


