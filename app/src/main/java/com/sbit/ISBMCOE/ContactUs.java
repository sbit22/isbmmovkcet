package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ContactUs extends AppCompatActivity {

    Button sendMessage;
    EditText ed_name,ed_mail, ed_subject, ed_message, ed_UserContactNo;
    String subject, name, message, contact_no,mail;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contact Us");

        layout = findViewById(R.id.rel);
        sendMessage = findViewById(R.id.btnSend);
        ed_name = findViewById(R.id.edUserName);
        ed_UserContactNo = findViewById(R.id.edUserContactNo);
        ed_subject = findViewById(R.id.edSubject);
        ed_message = findViewById(R.id.edMessage);
        ed_mail = findViewById(R.id.edEmailId);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ed_name.getText().toString();
                contact_no = ed_UserContactNo.getText().toString();
                subject = ed_subject.getText().toString();
                message = ed_message.getText().toString();
                mail = ed_mail.getText().toString();

                if (name.isEmpty() || contact_no.isEmpty() || subject.isEmpty() || message.isEmpty()||mail.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(layout, "All Field are Compulsory!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    sendEmail();
                }
            }
        });
    }

    private void sendEmail() {
        String msg1 = ed_message.getText().toString();
        String msg2 = ed_name.getText().toString();
        String msg3 = ed_UserContactNo.getText().toString();
        String msg4 = ed_mail.getText().toString();
        String message = "Student Name :" + msg2 + "\n " + "Mobile No. :" + msg3 + "\n " +"Email :"+msg4+" \n Message :" + msg1;

        String[] TO = {"admission.coep@isbm.ac.in"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
//        emailIntent.setData(Uri.parse("test@gmail.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "" + subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setPackage("com.google.android.gm");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            System.out.println("//Finish sending email...");

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactUs.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}