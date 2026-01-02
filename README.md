# ProID Studio – Android App

**ProID Studio** is an Android application developed using **Kotlin** and **Jetpack Compose**, designed as a smart **ID Card Generator**. The project focuses on **clean UI design**, modern Android development practices, and scalable screen architecture for creating and managing ID cards.

---

## 📸 Screenshot

![ProID Studio Screenshot]([https://github.com/Anshuman892494/ProID-Studio-ID-Card-Generator/blob/main/Screenshot.png?raw=true](https://github.com/Anshuman892494/ProID-Studio-Login-Android/blob/main/Poster.png?raw=true))

---

## ✨ Features

* ✅ Intent for navigation
* ✅ Login validation    
* ✅ Form validation for required fields    
* ✅ Data transfer from form to Dashboard  

---

## 🛠 Tech Stack

* **Kotlin**  
* **Jetpack Compose**  
* **Material Design 3**  
* **Android Studio**  

---

## 📱 Screens

### 1. Welcome Screen (`WelcomeScreen`)

* App branding with **ProID Studio** title  
* Tagline: *“Professional ID Card Generator”*  
* Call-to-action buttons:  
  * **Get Started**  

---

### 2. Login Screen (`LoginScreen`)

* Email and password input fields
* Login button with validation
* Perfect use of Toast in validation   
* Navigation to signup screen  
* Custom color scheme for modern look  

---

### 3. Signup Screen (`SignupScreen`)

* Complete user registration form  
* Input fields:  
  * Name  
  * Email  
  * Phone Number
  * Password / Confirm Password
* Radio Button for Gender
* Checkbox for Terms and Conditions  
* Back navigation to login screen  
* Fully Form validation structure
  * Name  
  * Email  
  * Phone Number
  * Password
  * Confirm Password
* Create Account button  

---

### 4. DashBoard (`DashScreen`)

* Welcome Massage
* Showing Email of User 

---

## 🎨 Design

* **Primary Colors**:  
  * Dark Green: `#04675B`  
  * Light Teal: `#09758A`  
* Minimal and modern UI  
* Rounded corners for inputs and buttons  
* Fully aligned with **Material Design 3** principles  

---

## 🗂 Project Structure

```
app/
├── src/main/java/com/example/proid_studio/
│ ├── MainActivity.kt # Entry point & welcome screen
│ ├── LoginScreen.kt # User login UI
│ ├── SignupScreen.kt # User registration UI
│ ├── IDCardScreen.kt # ID card generator UI
│ └── ForgotScreen.kt # Password recovery UI
│
├── src/main/res/
│ ├── drawable/
│ │ ├── logo.png # App logo
│ │ └── background.png # Background images
│ └── values/ # Resource files
│
├── build.gradle.kts # Module build configuration
│
ui.theme/
├── Color.kt # Color definitions
├── Theme.kt # App theme configuration
└── Type.kt # Typography settings
```
---

## 📄 License

This project is developed **for educational purposes only**. All rights are reserved by the author.  

---

## 👤 Author

**Anshuman**  
Android Developer | Kotlin | Jetpack Compose


