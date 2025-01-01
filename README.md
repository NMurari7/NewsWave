## NewsWave - News Application
NewsWave is a news application built with Jetpack Compose, which allows users to read and explore news articles. It fetches articles from an API, displays them in a grid layout, and allows users to view detailed articles by navigating through the app.

#### Features
- Splash Screen: Displays an animated logo during the app's launch.
- Home Screen: Displays a list of articles fetched from an API.
- Article Screen: Displays the details of a selected article.
- Navigation: Smooth navigation between screens with Jetpack Compose navigation components.
- Dynamic Content: Articles are fetched from an API and displayed in a grid layout using LazyVerticalGrid.

#### Technologies Used
- Jetpack Compose: For UI creation using declarative programming.
- Room Database: For storing articles locally on the device.
- Coroutines: For handling asynchronous tasks, including API fetching.
- Jetpack Navigation: For managing screen transitions.
- Material Design: For UI components like cards, buttons, and navigation.


#### Installation
To run this project locally, follow these steps:

Prerequisites
Android Studio installed (version 4.2 or higher).
Android SDK installed.
Kotlin version 1.5+.
Steps to Run the Project
Clone the repository:

```
git clone https://github.com/your-username/newswave.git
```
Open the project in Android Studio.

Make sure to sync the project with Gradle files.

Set up an API key in your ApiService for fetching news articles (e.g., News API).

Run the app on an emulator or physical device.










