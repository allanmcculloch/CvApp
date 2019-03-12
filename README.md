# CvApp

This is a simple demo Android app with the following features:

- View curriculum vitae (CV) contact information
- View professional experience, list of past roles with company images
- View photos
- Send a message

Built with the latest Android Kotlin development using:

- AndroidX
- Koin (Dependency Injection)
- MVVM / View Models
- Retrofit2 (API HTTP calls)
- Moshi (JSON serialisation)
- RxJava2
- Live Data (Architecture Component)
- Navigation (Architecture Component)
- Picasso (for loading images)

Shows unit testing using:

- JUnit
- Mockk
- Live-data testing helpers
- Core testing / instant executor rule

And UI testing using:

- Espresso
- Mockk-Android
- Drawer Actions (Espresso-contrib)

Simple backend API on Firebase with endpoints for:

- GET /contactdetails - Get contact information
- GET /jobs - Get a list of jobs 
- POST /sendmessage - Send a message
- GET /photos - get a list of photos (stored on Firebase Storage)


Future improvements / ToDos

- Improve UI styling and extract
- Use Bottom TabBar instead of drawer
- In memory mock http server for UI Tests 
- Navigate to detail fragment on jobs / pics 

