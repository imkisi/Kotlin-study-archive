# IntentAct

## Overview

This Android app demonstrates various intent types in Kotlin using Jetpack Compose. It includes:

- Implicit Intent: Launching the camera and gallery apps.
- Explicit Intent: Navigating between activities within the app.
- Data Transfer: Passing data (strings) between activities.
- Object Transfer: Passing custom objects between activities.
- Activity for Result: Starting an activity to get a result and displaying it.

Code Structure

- MainActivity:
Main entry point of the app.
Contains buttons to trigger different intent actions.
- DialActivity:
Launched via implicit intent to open dial.
- SecondActivity:
Launched via explicit intent to demonstrate data and object transfer.
ResultActivity:
Launched via explicit intent to get a result from the user.
