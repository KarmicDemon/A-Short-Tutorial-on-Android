# Android Tutorial for Purdue Peeps @ Wildhacks :)

### Step Chukwudi - Idk what else to put here it's 4 A.M.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We're going to be creating an Android application that delivers two kinds of calculator functionality : a remarkable, fresh take on modern calculators that will blow your mind (The God Calculator) and a bland, calculator that was "invented" in 2009 that apparently took the mathematical world by storm (The Scrub Calculator). It's going to be really simple, and I'm goign to try to get you to finish it in around two hours so I don't waste any of your time.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note: a lot of the stuff here are things that you should never, ever do. You will probably see some of these things, and Android Studio will definitely make sure to lay out in front of you with some warnings. However, for the learning process ( :D ) and to try to save time, we will be sacrificing what would be considered to be "good practices."

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;If you've never done Android before, and you reallyhave no clue where to start, this **SHORT** tutorial/guide should hopefully help  you

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I'm three Monsters in, so I will stop feeding you nonsense. Let's get started :)

### Step One - Setting Up Your Environment

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Before you do anything, I want you gusy to make sure you have Android Studio downloaded and, if you do not have an Android (but have a decent computer), download the emulator, which, iirc, can be downloaded when you download the SDK from Android Studio.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note: Some of you might have a problem when you open Android Studio for the first time and it says: "can't find this JDK shit" or something along that line. NO FEAR! Just uninstall all Java versions you have, redownload Java, and point your JAVA_HOME environment variable to the *jdk_(blank)/bin* folder.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Once you've gotten all of that set up, create a new Android porject. Here's what you're gonna fill in!

> Android Name: Android_Tutorial

> Company Name: purdue.hackers.com

> Save to wherever then click next

> Check **ONLY** Phone and Tablet, and make sure it is set to API Level 17 then click
next

> Click on **Empty Activity** which is not the same as **Blank Activity**, then click next

> Name the Activity **Calculator_Type_Choice_Activity**, check the box where it says **Generate Layout File** then click finish

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;After you do all of this, the gradle will build. This is really awesome because Android Studio creates a lot of files that had you had to write yourself you would have been majorly ducked. Relevence: if you go to **Run -> Run App** you will see that you have functioning Android application on your phone/emulator (if you haven't set up your emulator, do so now :) )

### Step Two - Creating your First Activity and Adding Your First Buttons
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;First when you have your application opened in project view, notice that you have a bunch of files...but two that better be hella familar: **/res/layout/activity_calculator_type_choice.xml** and **/java/com..../Calculator_Type_Choice_Activity.java**.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You can take a minute to explore all of that, but we're going to start off by deleting everything in **activity_calculator_type_choice.xml** and replacing it wit the following code snippet, which, if you look at it, should not be too different from the auto-generated code given to you.

> /res/layout/activity_calculator_type_choice.xml

```
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

</RelativeLayout>
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;So I lied. It's a little more than different. Continuing though, we're going to add a little more sustanance to our application.

> /res/layout/activity_calculator_type_choice.xml

```
<RelativeLayout ...>
    <TextView
        android:id="@+id/option_select"
        android:layout_centerHorizontal="true"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="Select your application" />

    <Button
        android:id="@+id/scrub_button"
        android:layout_below="@+id/option_select"
        android:layout_centerHorizontal="true"
        android:layout_height="wrap_content"
        android:layout_marginTop="140dp"
        android:layout_width="wrap_content"
        android:text="@string/scrub_button" />

    <Button
        android:id="@+id/god_button"
        android:layout_below="@+id/scrub_button"
        android:layout_centerHorizontal="true"
        android:layout_height="wrap_content"
        android:layout_marginTop="50dp"
        android:layout_width="wrap_content"
        android:text="@string/god_button"/>
</RelativeLayout>
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Now that we have a lot of stuff on let's examine some things. For each button, notice that you need to provide android::layout_height and android:layout_width. All views in Android can also be given the **android:id** which is always prefixed with the annotation **@+id** or **@id**.

For our first view (TextView) we did not have a string annotation in our android:text, but we did in the other two views. This just shows that there are two ways to write strings into your application. The preferred way, however, is with a string annotation, which are basically pointers to strings in the /res/values/strings.xml file. Let's go there and edit it so we can provide some context for out annotations.

> /res/values/strings.xml
```
<resources>
    ...
    <string name="god_button">God Calculator</string>
    <string name="scrub_button">Scrub Calculator</string>
</resources>
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run your app (it should be functional) and look at your buttons :)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Before we move on, we're going to create another Activity. Go to your **com.hackers.purdue.android_tutorial** folder, right click on it, and select **New->Activity->Empty Activity**.

>  Name the file Calculator_Activity, make sure generate layout file is checked, make sure Launcher Activity is NOT checked and click finish

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Once again, like last time, we're going to delete everything in the layout file and our own stuff.

> /res/layout/activity_calculator.xml
```
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_height="match_parent"
    android:layout_width="match_parent">

    <FrameLayout
        android:id="@+id/calculator_container_id"
        android:layout_height="match_parent"
        android:layout_marginTop="55dp"
        android:layout_width="match_parent" />
</RelativeLayout>
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Feel free to ask any questions about anything above. We won't focus on the itty-bitty details for now, but we want to focus on two things  AppBarLayout and FrameLayout. AppBarLayout, when inside a Coordinator Layout, gives you a lot of freedom of how to construct your toolbar. Additionally FrameLayout will be used later when we work closer on with Fragments - inside the FrameLayout is where we will inflate them :)

### Step Three - Working With Fragments and Views
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Right-click on your com.hackers.purdue.android_tutorial folder, and select **New->Fragment->Fragment(Blank)** Name it **God_Calculator_Fragment**, and make sure you have Create layout XML? checked and the other two **UNCHECKED**. We will not be needing callbacks/factory methods. Now do the exact same thing, but this time name the fragment **Scrub_Calculator_Fragment**.

*********************************Explain fragments here********************************

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Now that we have all of these things, we're going to, once again, clear and modify layouts for each of these fragments.

>/res/layout/fragment_god_calculator.xml
```
<RelativeLayout
   xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/god_calc"
        android:layout_centerHorizontal="true"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/god_calc"
        android:textSize="50sp"/>

    <TextView
        android:id="@+id/first_number_text_view"
        android:layout_below="@id/god_calc"
        android:layout_height="wrap_content"
        android:layout_marginTop="50dp"
        android:layout_width="wrap_content"
        android:text="@string/first_number"
        android:textSize="30sp"/>

    <EditText
        android:id="@+id/first_number_edit_text"
        android:layout_alignTop="@+id/first_number_text_view"
        android:layout_marginLeft="20dp"
        android:layout_marginStart="20dp"
        android:layout_toEndOf="@+id/first_number_text_view"
        android:layout_toRightOf="@+id/first_number_text_view"
        android:inputType="number"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content" />

    <TextView
        android:id="@+id/second_number_text_view"
	    android:layout_below="@id/first_number_text_view"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/second_number"
        android:textSize="30sp"/>

    <EditText
        android:id="@+id/second_number_edit_text"
        android:inputType="number"
        android:layout_alignTop="@+id/second_number_text_view"
        android:layout_marginLeft="20dp"
        android:layout_marginStart="20dp"
        android:layout_toEndOf="@+id/second_number_text_view"
        android:layout_toRightOf="@+id/second_number_text_view"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content" />

    <Spinner
        android:id="@+id/func_options_spinner"
        android:layout_below="@+id/second_number_edit_text"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:entries="@array/func_options" />

    <Button
        android:id="@+id/calculate_button"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/func_options_spinner"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/calculate"/>

    <TextView
        android:id="@+id/answer"
        android:layout_below="@id/calculate_button"
        android:layout_centerHorizontal="true"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:layout_width="wrap_content"
        android:text="@string/nan"
        android:textSize="80sp"/>
</RelativeLayout>
```

>/res/layout/fragment_scrub_calculator.xml

```
<RelativeLayout    
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_height="match_parent"
    android:layout_width="match_parent">
    <Button
        android:id="@+id/to_wolf"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/scrub"/>
</RelativeLayout>
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Now fragment_scrub_calculator seems pretty simple. However, fragment_god_calculator.xml is very verbose. Notice in fragment_god_calculator.xml we added an EditText (this is how you get input) and a Spinner (a basic drop-down menu). Before we move on, let's go to our strings.xml file and make sure all our annotations work

> /res/values/strings.xml

```
<resources>
	...
    <string name="god_calc">God Calculator</string>
    <string name="first_number">First Number</string>
    <string name="second_number">Second Number</string>
    <string name="calculate">Calculate</string>
    <string name="nan">NaN</string>
    <string name="scrub">I\'m a Scrub</string>

    <string-array name="func_options">
        <item>Add</item>
        <item>Divide</item>
        <item>Multiply</item>
        <item>Power</item>
        <item>Subtract</item>
    </string-array>
</resources>
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Notice our string-array. This is how you set up spinner options (non-dynamically) :)

### Step Four - Adding Functionality

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We're going to now add functionality to all of our Activities and Fragments :D

> /java/com..../Calculator_Activity.java

```
package com.hackers.purdue.android_tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class Calculator_Activity extends AppCompatActivity {
    boolean isGod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Calculator");

        Bundle params = getIntent().getExtras();
        isGod = params.getBoolean("isGod");

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f;

        if (isGod) f = new God_Calculator_Fragment();
        else f = new Scrub_Calculator_Fragment();

        Log.d("TAG", String.valueOf(isGod));

        ft.add(R.id.calculator_container_id, f);
        ft.commit();
    }
}

```

Notice that we are using support fragments. You may have an error while updating this file; to fix it, just go to each of your fragments and where is says import blahblah.Fragment, replace that with android.support.v4.app.Fragment :)

>/java/com..../Calculator_Type_Choice_Activity.java

```
package com.hackers.purdue.android_tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Calculator_Type_Choice_Activity extends AppCompatActivity {
    Button god_button;
    Button scrub_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator__type__choice);
        getSupportActionBar().setTitle("Choose Calculator");

        god_button = (Button) findViewById(R.id.god_button);
        scrub_button = (Button) findViewById(R.id.scrub_button);

        god_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calculator_Activity.class);
                i.putExtra("isGod", true);
                startActivity(i);
            }
        });

        scrub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calculator_Activity.class);
                i.putExtra("isGod", false);
                startActivity(i);
            }
        });
    }
}

```

>/java/com..../God_Calculator_Fragment.java

```
package com.hackers.purdue.android_tutorial;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class God_Calculator_Fragment extends Fragment {
    Button calculate;
    EditText firstNumber;
    EditText secondNumber;
    Spinner options;
    TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_god_calculator, container, false);

        calculate = (Button) view.findViewById(R.id.calculate_button);
        firstNumber = (EditText) view.findViewById(R.id.first_number_edit_text);
        secondNumber = (EditText) view.findViewById(R.id.second_number_edit_text);
        options = (Spinner) view.findViewById(R.id.func_options_spinner);
        answer = (TextView) view.findViewById(R.id.answer);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first_int = Integer.parseInt(firstNumber.getText().toString());
                int sec_int = Integer.parseInt(secondNumber.getText().toString());

                String spin_option = options.getSelectedItem().toString();
                int new_num = 0;

                if (spin_option.equals("Add")) new_num = first_int + sec_int;
                if (spin_option.equals("Subtract")) new_num = first_int - sec_int;
                if (spin_option.equals("Multiply")) new_num = first_int * sec_int;
                if (spin_option.equals("Power")) new_num = (int) Math.pow(first_int, sec_int);
                if (spin_option.equals("Divide")) new_num = first_int / sec_int;

                answer.setText(Integer.toString(new_num));
            }
        });

        return view;
    }
}

```

>/java/com..../Scrub_Calculator_Fragment.java

```
package com.hackers.purdue.android_tutorial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Scrub_Calculator_Fragment extends Fragment {
    Button scrub_button;
    String wolf = "http://www.wolframalpha.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrub_calculator, container, false);

        scrub_button = (Button) view.findViewById(R.id.to_wolf);
        scrub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri wolfram_alpha = Uri.parse(wolf);
                Intent intent = new Intent(Intent.ACTION_VIEW, wolfram_alpha);
                startActivity(intent);
            }
        });

        return view;
    }
}

```

### Step Five - Basic Design
For the sake of time, we won't focus on design in the context of this application.
However, I will quickly show you how you can create a style so that you can make your stuff look uniform and pretty.

> /res/values/styles

```
<resources>
	...
    <style name="exhausted">
        <item name="android:textColor">#FF00</item>
    </style>
</resources>

```

Now you can go to any button in your directory and it like so

> random button

```
    <Button
        android:id="@+id/calculate_button"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/func_options_spinner"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/calculate"
        style="@style/exhausted"/>
```
