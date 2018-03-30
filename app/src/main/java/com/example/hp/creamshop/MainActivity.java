package com.example.hp.creamshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.creamshop.R;

public class MainActivity extends AppCompatActivity {
        int value_1 = 0;
        int value_2 = 0;
        int value_3 = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void con_order(View vi) {

        CheckBox creamp = (CheckBox) findViewById(R.id.panther1);
        boolean cream_p = creamp.isChecked();

    CheckBox vanillap = (CheckBox) findViewById(R.id.vanilla_p);
     boolean vanillapan = vanillap.isChecked();

     CheckBox chocop = (CheckBox) findViewById(R.id.choco_p);
     boolean chocopan = chocop.isChecked();

        EditText name = (EditText) findViewById(R.id.m_name);
        String m_name = name.getText().toString();

        EditText address = (EditText) findViewById(R.id.m_address);
        String m_address = address.getText().toString();

        EditText number = (EditText) findViewById(R.id.m_number);
        String m_number = number.getText().toString();

        int tprice = price1(cream_p) + price2(vanillapan) +  price3(chocopan);

        String messenger = dmessage(tprice, m_name , m_address, m_number, vanillapan, chocopan, cream_p);

        if(m_name.isEmpty() || m_address.isEmpty() || m_number.isEmpty()){
            Toast.makeText(this, "Please fill in all your personal information", Toast.LENGTH_SHORT).show();
            return;
        } else {


        d_message(messenger);}

    }

    public void order (View v){
        CheckBox creamp = (CheckBox) findViewById(R.id.panther1);
        boolean cream_p = creamp.isChecked();

        CheckBox vanillap = (CheckBox) findViewById(R.id.vanilla_p);
        boolean vanillapan = vanillap.isChecked();

        CheckBox chocop = (CheckBox) findViewById(R.id.choco_p);
        boolean chocopan = chocop.isChecked();

        EditText name = (EditText) findViewById(R.id.m_name);
        String m_name = name.getText().toString();

        EditText address = (EditText) findViewById(R.id.m_address);
        String m_address = address.getText().toString();

        EditText number = (EditText) findViewById(R.id.m_number);
        String m_number = number.getText().toString();

        int tprice = price1(cream_p) + price2(vanillapan) +  price3(chocopan);
        String messenger = omessage(tprice, m_name , m_address, m_number, vanillapan, chocopan, cream_p);

        if(m_name.isEmpty() || m_address.isEmpty() || m_number.isEmpty()){
            Toast.makeText(this, "Please fill in all your personal information", Toast.LENGTH_SHORT).show();
            return;}

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, messenger);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);}
    }

    public String dmessage (int g, String a, String b, String c, boolean vanillapan, boolean chocopan, boolean cream_p) {
        String message = " Name:  " + a + "\n Address:  " + b + "\n Phone Number:  " + c + "\n Number of Pizza Cake Ordered:  " + value_1
                +"\n Number of Ginger Finger Ordered:  " + value_2 + "\n Number of Chocolate Pizza Ordered:  " + value_3 +
                "\nTotal Cost:  ₦" + g +  "\nKindly click the ORDER button to send your request" +"\nThanks for your patronage" ;
        return message;
    }

    public String omessage (int g, String a, String b, String c,  boolean vanillapan, boolean chocopan, boolean cream_p) {
        String messages = "Name:  " + a  + "\nAddress:  " + b + "\nPhone Number:  " + c +"\nNumber of Pizza Cake Ordered:  " + value_1
                + "\nNumber of Ginger Finger Ordered:  " + value_2 + "\nNumber ofChocolate Pizza Ordered:  " + value_3 +
                "\nTotal Cost:  ₦" + g ;
        return messages;
    }

    public int price1(boolean cream_pa) {
       int  price = 1500;
       if(cream_pa){
           price = price;
       }
       int price_1 = price * value_1;
       return price_1;
    }

    private int price2( boolean vanillapan) {
        int  price = 2500;
        if (vanillapan){
            price = price;
        }
        int price_2 = price * value_2;
        return price_2;
    }

    private int price3( boolean chocopan) {
        int  price = 3000;
        if (chocopan){
            price = price;
        }
        int price_3 = price * value_3;
        return price_3;
    }


    // increment and decrement buttons for cream panther
    public void increment1 (View view) {
        if (value_1 == 99) {
             Toast toast = Toast.makeText(this, "You can not order for more than 99 cups of Pizza Cake", Toast.LENGTH_SHORT);
             toast.show();
             return;
         }

        value_1 = value_1 + 1;
        display(value_1);
    }

  public void decrement1 (View view){
         if( value_1 == 0){
             Toast toast1 = Toast.makeText(this, "You can not order for less than 0 cups of Pizza Cake", Toast.LENGTH_SHORT);
             toast1.show();
              return;
         }
       value_1 = value_1 - 1;
       display(value_1);
  }

    private void display (int n){
        TextView disp = (TextView) findViewById(R.id.value1);
        disp.setText("" + n);

    }

    // increment and decrement button for vanilla panther
    public void increment2 (View view) {
        if (value_2 == 99) {
            Toast toast2 = Toast.makeText(this, "You can not order for more than 99 cups of Ginger Finger", Toast.LENGTH_SHORT);
            toast2.show();
            return;
        }
        value_2 = value_2 + 1;
        display2(value_2);
    }
    public void decrement2 (View view){
        if( value_2 == 0){
            Toast toast2a = Toast.makeText(this, "You can not order for less than 0 cups of Ginger Finger", Toast.LENGTH_SHORT);
            toast2a.show();
            return;
        }
        value_2 = value_2 - 1;
        display2(value_2);
    }

    private void display2 (int n){
        TextView disp2 = (TextView) findViewById(R.id.value2);
        disp2.setText("" + n);
    }

    public void increment3 (View view) {
        if (value_3 == 99) {
            Toast toast3a = Toast.makeText(this, "You can not order for more than 99 cups of Chocolate Pizza", Toast.LENGTH_SHORT);
            toast3a.show();
            return;
        }
        value_3 = value_3 + 1;
        display3(value_3);
    }
    public void decrement3 (View view){
        if( value_3 == 0){
            Toast toast3 = Toast.makeText(this, "You can not order for less than 0 cups of Chocolate Pizza", Toast.LENGTH_SHORT);
            toast3.show();
            return;
        }
        value_3 = value_3 - 1;
        display3(value_3);
    }

    private void display3 (int n){
        TextView disp3 = (TextView) findViewById(R.id.value3);
        disp3.setText("" + n);

    }

    private void d_message (String k) {
        TextView s_message = (TextView) findViewById(R.id.confirm_message);
        s_message.setText(k);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value_1", value_1);
        outState.putInt("value_2", value_2);
        outState.putInt("value_3", value_3);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        value_1 = savedInstanceState.getInt("value_1");
        value_2 = savedInstanceState.getInt("value_2");
        value_3 = savedInstanceState.getInt("value_3");

    }
}
