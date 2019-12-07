# Kotlin_Tutorial
=====

## Description
A tutorial project for Kotlin.

## Code Tree
- Main Activity: `/app/src/main/java/com/sample/umimori/samplekotlin/MainActivity.kt`
- Main XML: `/app/src/main/AndroidManifest.xml`

## Demo

<video src="/Users/masumi.morishige/AndroidStudioProjects/SampleKotlin/Demo.mp4"></video>

## Step1: Press the Button and change the Text
```kt
val textView = findViewById<TextView>(R.id.message) as TextView
val button = findViewById<Button>(R.id.button) as Button

textView.text = "Before"
button.setOnClickListener{ v->
    textView.text = "After"
```

## Step2: Give Parameter to the next Activity

- Main Activity

```kotlin

class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE: String = "com.sample.umimori.samplekotlin"

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                change_text.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                change_text.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                change_text.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Change the text of textView when the button pressed
        val textView = findViewById<TextView>(R.id.change_text) as TextView
        val button = findViewById<Button>(R.id.change_button) as Button

        textView.text = "Before"
        button.setOnClickListener{ v->
            textView.text = "After"
        }


    }


    fun openInfo(view: View){
        val intent: Intent = Intent(this@MainActivity,InfoActivity::class.java)
        val editText: EditText = findViewById(R.id.editText) as EditText
        val message: String = editText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}
```



- Info Activity (Target Page)

```kotlin
class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent: Intent = getIntent()
        val message: String = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
        val textView: TextView = findViewById<TextView>(R.id.text_info)
        textView.setText(message)
    }
}
```



