# Compose-Animated-Expandable-Card-AnimatedVisibility-Example
How to create expandable card in compose based android app

# Animatd Card:

<img src="https://github.com/dheeraj-bhadoria/Compose-Animated-Expandable-Card-AnimatedVisibility-Example/blob/main/expandablesmallgif.gif">

# AnimatedVisibility

```kotlin
AnimatedVisibility(
                visible = expanded.value,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                // Your composable code here 
            }
```
