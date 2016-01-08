package com.example.sothink.demoui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button button;
    Button btn1;
    int count = 0;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
//        //第一种方式
//        final Button Btn1 = (Button)findViewById(R.id.btnOpenPage1);//获取按钮资源
//        Btn1.setOnClickListener(new Button.OnClickListener() {//创建监听
//                                    public void onClick(View v) {
//                                    }
//                                }
//        );

        button = (Button)findViewById(R.id.btn2);
        btn1 = (Button)findViewById(R.id.btnOpenPage1);
    }

    public void BtnOpenPage1_Click(View view)
    {
        Intent intent = new Intent(this, Page1Activity.class);
        startActivity(intent);
    }
    public void Btn2_Click(View view) {
        String str = "click " + count + " time(s)";
        button.setText(str);
        count++;
        //testClipboard();
        testClipboardUri();
    }

    public void BtnCalc_Click(View view)
    {
        Intent intent = new Intent(this, CalcActivity.class);
        startActivity(intent);
    }

    public int testClipboard()
    {
        ClipboardManager clipboard = (ClipboardManager)mContext.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text", "Hello, World!");
        clipboard.setPrimaryClip(clip);

        return 0;
    }

    public void testClipboardUri()
    {
        ClipboardManager clipboard = (ClipboardManager)mContext.getSystemService(Context.CLIPBOARD_SERVICE);


        // Creates a Uri based on a base Uri and a record ID based on the contact's last name
        // Declares the base URI string
        String CONTACTS = "content://com.example.contacts";

        // Declares a path string for URIs that you use to copy data
        String COPY_PATH = "/copy";

        // Declares the Uri to paste to the clipboard
        Uri copyUri = Uri.parse(CONTACTS + COPY_PATH + "/" + "dd");

        String picPath = "/storage/emulated/0/anvSyncDroid/Picture";

        String strFileName = "haibara.jpg";

        Uri copyUri2 = Uri.parse(picPath + "/" + strFileName);

        // Creates a new URI clip object. The system uses the anonymous getContentResolver() object to
        // get MIME types from provider. The clip object's label is "URI", and its data is
        // the Uri previously created.
        ClipData clip = ClipData.newUri(getContentResolver(),"URI",copyUri2);

        clipboard.setPrimaryClip(clip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
