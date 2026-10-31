# Android Development Learning Project

A hands-on Android application built with Kotlin and XML to learn and implement essential Android development concepts through practical examples.

This project documents my learning journey, covering Android architecture, local data storage, networking, background processing, camera integration, and UI development.

## What I Learned and Implemented

### 1. Android Architecture and Dependency Injection
- Implemented MVVM architecture using ViewModel and LiveData.
- Used the Repository pattern to separate data access from UI logic.
- Integrated Dagger Hilt for dependency injection using `@HiltAndroidApp`, `@AndroidEntryPoint`, and `@HiltViewModel`.

### 2. Kotlin Coroutines
- Practiced asynchronous programming using Kotlin Coroutines.
- Used `viewModelScope` to manage coroutine lifecycles.
- Learned to use `Dispatchers.IO`, `Dispatchers.Main`, and `Dispatchers.Default`.
- Practiced concurrent operations using `async` and `await`.

### 3. Local Data Storage
- Implemented database operations using Room, including Entities, DAOs, and TypeConverters.
- Practiced CRUD operations using SQLite and `SQLiteOpenHelper`.
- Used SharedPreferences to store app preferences and theme settings.

### 4. Networking and API Integration
- Integrated REST APIs using Retrofit and OkHttp.
- Parsed JSON responses using Gson.
- Learned how to structure API services and handle network operations.

### 5. Background Processing and Android Services
- Implemented WorkManager for scheduled and deferred background tasks.
- Practiced foreground services for background audio playback and location tracking.
- Learned how Android Services manage background operations.
- Implemented BroadcastReceivers to handle system events and custom broadcasts.
- Worked with notifications and notification channels.

### 6. Camera and Media
- Implemented camera functionality using CameraX and camera intents.
- Used FileProvider for secure image sharing.
- Practiced image processing and handling using utility functions.

### 7. UI Development and Navigation
- Built Android screens using XML layouts and ViewBinding/DataBinding.
- Implemented Fragments and Bottom Navigation.
- Created RecyclerView lists and grids using custom adapters.
- Practiced deep linking using custom URI schemes.

### 8. Android Permissions and Validation
- Implemented runtime permissions for camera, location, and notifications.
- Worked with notification channels.
- Practiced form validation using Android Patterns.

## Technologies Used

| Category | Technologies |
|---|---|
| Language | Kotlin |
| UI | XML, ViewBinding, DataBinding |
| Architecture | MVVM, Repository Pattern |
| Dependency Injection | Dagger Hilt |
| Asynchronous Programming | Kotlin Coroutines |
| Local Storage | Room, SQLite, SharedPreferences |
| Networking | Retrofit, OkHttp, Gson |
| Background Processing | WorkManager, Android Services |
| Camera and Media | CameraX, FileProvider, Glide |
| Location | Google Play Services Location |
| Navigation | Activities, Fragments, Bottom Navigation, Deep Links |

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/dharmikchitroda/Sample_App.git
   ```

2. Open the project in Android Studio.
3. Sync the Gradle dependencies.
4. Run the application on an Android device or emulator.

**Requirements:** Android Studio and an Android device or emulator running Android 9.0 (API 28) or higher.

## Purpose

This project is created for learning and practice. My goal is to strengthen my Android development fundamentals by implementing core concepts, understanding how Android components work, and applying them in a practical application.

## License

This project is licensed under the MIT License.
