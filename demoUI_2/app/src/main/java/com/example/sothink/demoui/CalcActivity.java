package com.example.sothink.demoui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class CalcActivity extends ActionBarActivity {

    TextView textViewResult;
    String str1, str2;
    String strOper = null;
    String strInput = null;
    String strOldOper = null;
    boolean bHasInput = false;

    public void setButtonToSquare(Button button, int width)
    {
        button.setWidth(width);
        button.setHeight(width);
//        if(height<width)
//            button.setHeight(width);
//        else
//            button.setWidth(height);
    }

    public void setAllBtnToSquare()
    {
        Button button;

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout1);
        int height = gridLayout.getHeight();
        int width = gridLayout.getWidth();
        int length = (height<width ? height : width) / 4;

        button = (Button) findViewById(R.id.button0);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button1);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button2);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button3);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button4);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button5);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button6);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button7);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button8);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.button9);setButtonToSquare(button, length);

        button = (Button) findViewById(R.id.buttonAdd);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.buttonSub);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.buttonMulti);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.buttonDivide);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.buttonPoint);setButtonToSquare(button, length);
        button = (Button) findViewById(R.id.buttonEqual);setButtonToSquare(button, length);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        str1 = "0";
        str2 = "0";
        strOper = null;
        strInput = null;
        strOldOper = null;
        bHasInput = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        //setAllBtnToSquare();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void appendToStrInput(String ch)
    {
        if(!bHasInput)
        {
            strInput = ch;
            bHasInput = true;
        }
        else if(strInput.equals("0"))
            strInput = ch;
        else
            strInput = strInput.concat(ch);

        textViewResult.setText(strInput);
    }

    public void doOper(String strNewOper)
    {
        if(strOper == null)
        {
            if(bHasInput)
                str1 = strInput;
        }
        else if(bHasInput)
        {
            str2 = strInput;

            int a1 = Integer.parseInt(str1);
            int a2 = Integer.parseInt(str2);

            if(strOper.equals("+"))
                a1 += a2;
            else if(strOper.equals("-"))
                a1 -= a2;
            else if(strOper.equals("X"))
                a1 *= a2;
            else if(strOper.equals("/")) {
                if(a2 == 0)
                {
                    textViewResult.setText("Wrong input");
                    ResetCalcData();
                    return;
                }
                else
                    a1 /= a2;
            }

            str1 = String.valueOf(a1);
            strOldOper = strOper;

            textViewResult.setText(str1);
        }

        bHasInput = false;
        strOper = strNewOper;
    }

    public void doEqual()
    {
        String strRealOper;
        if(strOper != null) strRealOper = strOper;
        else if(strOldOper != null) strRealOper = strOldOper;
        else return;

        if(bHasInput)
        {
            if(strOper != null)
                str2 = strInput;
            else
                str1 = strInput;
        }

        int a1 = Integer.parseInt(str1);
        int a2 = Integer.parseInt(str2);

        if(strRealOper.equals("+"))
            a1 += a2;
        else if(strRealOper.equals("-"))
            a1 -= a2;
        else if(strRealOper.equals("X"))
            a1 *= a2;
        else if(strRealOper.equals("/")) {
            if(a2 == 0)
            {
                textViewResult.setText("Wrong input");
                ResetCalcData();
                return;
            }
            else
                a1 /= a2;
        }

        str1 = String.valueOf(a1);
        if(strOper != null) {
            strOldOper = strOper;
            strOper = null;
        }
        bHasInput = false;

        textViewResult.setText(str1);
    }

    public void ClickBtn0(View view)
    {
        appendToStrInput("0");
    }
    public void ClickBtn1(View view)
    {
        appendToStrInput("1");
    }
    public void ClickBtn2(View view)
    {
        appendToStrInput("2");
    }
    public void ClickBtn3(View view)
    {
        appendToStrInput("3");
    }
    public void ClickBtn4(View view)
    {
        appendToStrInput("4");
    }
    public void ClickBtn5(View view)
    {
        appendToStrInput("5");
    }
    public void ClickBtn6(View view)
    {
        appendToStrInput("6");
    }
    public void ClickBtn7(View view)
    {
        appendToStrInput("7");
    }
    public void ClickBtn8(View view)
    {
        appendToStrInput("8");
    }
    public void ClickBtn9(View view)
    {
        appendToStrInput("9");
    }
    public void ClickBtnPoint(View view)
    {
        //appendToStrInput(".");
    }
    public void ClickBtnEqual(View view)
    {
        doEqual();
    }
    public void ClickBtnAdd(View view)
    {
        doOper("+");
    }
    public void ClickBtnSub(View view)
    {
        doOper("-");
    }
    public void ClickBtnMulti(View view)
    {
        doOper("X");
    }
    public void ClickBtnDivide(View view)
    {
        doOper("/");
    }

    public void ClickBtnAc(View view)
    {
        ResetCalcData();
        textViewResult.setText("0");
    }

    public void ResetCalcData()
    {
        str1 = "0";
        str2 = "0";
        strOper = null;
        strInput = null;
        strOldOper = null;
        bHasInput = false;
    }

    public void ClickBtnBackspace(View view)
    {
        if(strInput != null)
        {
            if(strInput.length() == 1)
                strInput = "0";
            else
                strInput = strInput.substring(0, strInput.length()-1);
            textViewResult.setText(strInput);
        }
    }
}
