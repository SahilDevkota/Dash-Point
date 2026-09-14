# Dash-Point
A simple dashboard mobile app for user logging in successfully, and view their data in details developed for NIT3213 Final Assignment.

The app allows users to: 
- Log in
- View Dashboard
- Log out
- Navigate through each page
- View course details

  # TECHNOLOGIES USED
  - Kotlin
  - Android Studio
  - mockk
  - Moshi
  - Retrofit
  - RecyclerView
  - Hilt
  - Couroutines

  # HOW THE APP WORKS

  ## Login
  Basically, when a user opens the app, then the user needs to enter their password and username. The app sends the login        detail to the API for authentication.

  ## Dashboard
  After successful response, the user is taken to dashboard where the list of items are displayed in a formattable way.

  ## Details
  When the user clicks any button, then the user is redirected to details page, where the user will see more details about the   course.

  # HOW TO RUN
  1. Clone the repository
  2. After, open the project in Andorid Studio.
  3. Make sure all the gradle files are synced.
  4. Once gradle running is successfull, run the app.
  5. Enter the login details

  # ERROR HANDLING
  When using API's, we get different response, sometimes 200 sometimes 401 etc. To handle this one we used try-catch block   along with Toast. Try entering wrong credentials, you will see how the error is handled.

  # AUTHOR
  Sahil Bdr. Devkota
