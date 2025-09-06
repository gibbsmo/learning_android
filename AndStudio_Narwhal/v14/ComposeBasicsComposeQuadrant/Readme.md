
This is the 3 practice activity of Compose Basics

- Reference: https://developer.android.com/codelabs/basic-android-kotlin-compose-composables-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-composables-practice-problems#3

## Modifications for Narwhal

### onCreate 

The Modifier passed is eliminated to avoid conflicting with the InfoScreen control

### InfoPanel Modifier sets background

The infoPanel (not the contained Column) sets the background.  If not the column is surrounded by a white border.