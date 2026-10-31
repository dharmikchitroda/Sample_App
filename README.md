# Android Development Learning Project

A hands-on Android application built with Kotlin and XML to learn and implement essential Android development concepts through practical examples.

This project focuses on understanding Android components, implementing core features, and improving my practical Android development skills.

## What I Learned and Implemented

### 1. UI Development and Navigation
- Built Android screens using XML layouts and ViewBinding/DataBinding.
- Implemented Fragments and Bottom Navigation for multi-screen navigation.
- Created RecyclerView lists and grids using custom adapters.
- Practiced deep linking using custom URI schemes.

### 2. Android Architecture and Dependency Injection
- Implemented MVVM architecture using ViewModel and LiveData.
- Used the Repository pattern to separate data access from UI logic.
- Integrated Hilt for dependency injection.

### 3. Kotlin Coroutines
- Practiced asynchronous programming using Kotlin Coroutines.
- Used `viewModelScope` to manage coroutine lifecycles.
- Worked with `Dispatchers.IO`, `Dispatchers.Main`, and `Dispatchers.Default`.
- Practiced concurrent operations using `async` and `await`.

### 4. Local Data Storage
- Implemented CRUD operations using Room Database.
- Practiced database operations using SQLite and `SQLiteOpenHelper`.
- Used both Room and SQLiteOpenHelper to store and manage local data.
- Used SharedPreferences to store app preferences and theme settings.

### 5. Networking and API Integration
- Integrated REST APIs using Retrofit and OkHttp.
- Parsed JSON responses using Gson.
- Practiced API service implementation and network operations.

### 6. Background Processing and Android Services
- Implemented WorkManager for scheduled and deferred background tasks.
- Practiced foreground services for background audio playback and location tracking.
- Learned how Android Services manage background operations.
- Implemented BroadcastReceivers to handle system events and custom broadcasts.

### 7. Notifications
- Implemented notifications using NotificationManager.
- Created and configured notification channels.
- Practiced displaying notifications for background operations and service updates.

### 8. Camera and Media
- Implemented camera functionality using CameraX and camera intents.
- Used FileProvider for secure image sharing.
- Practiced image processing and handling using utility functions.

### 9. Location and Google Maps
- Implemented GPS location tracking using Google Play Services Location.
- Practiced accessing the device's current location.
- Integrated Google Maps to display location information.

### 10. Android Permissions and Validation
- Implemented runtime permissions for camera, location, and notifications.
- Practiced form validation using Android Patterns.
- Worked with Android notification channels and permission handling.

## Technologies Used

| Category | Technologies |
|---|---|
| Language | Kotlin |
| UI | XML, ViewBinding, DataBinding |
| Architecture | MVVM, Repository Pattern |
| Dependency Injection | Hilt |
| Asynchronous Programming | Kotlin Coroutines |
| Local Storage | Room, SQLite, SQLiteOpenHelper, SharedPreferences |
| Networking | Retrofit, OkHttp, Gson |
| Background Processing | WorkManager, Android Services |
| Notifications | NotificationManager, Notification Channels |
| Camera and Media | CameraX, FileProvider, Glide |
| Location and Maps | GPS, Google Play Services Location, Google Maps |
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
