# Kotlin_Tutorial
=====

## Description
A tutorial project for Kotlin.

## Code Tree
- Main Activity: `/app/src/main/java/com/sample/umimori/samplekotlin/MainActivity.kt`
- Main XML: `/app/src/main/AndroidManifest.xml`

## Step1: Press the Button and change the Text
```kt
val textView = findViewById<TextView>(R.id.message) as TextView
val button = findViewById<Button>(R.id.button) as Button

textView.text = "Before"
button.setOnClickListener{ v->
    textView.text = "After"
```