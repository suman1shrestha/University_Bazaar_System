package example.com.bazaar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import example.com.bazaar.SignInActivity;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Communication extends Home implements View.OnClickListener {
    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    //private EditText editTextSender;

    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setContentView(R.layout.activity_communication);


        //Initializing the views
        editTextEmail = (EditText) findViewById(R.id.editText5);

        editTextSubject = (EditText) findViewById(R.id.editText12);

        editTextMessage = (EditText) findViewById(R.id.editText3);

        buttonSend = (Button) findViewById(R.id.buttonSend);

        //Adding click listener
        buttonSend.setOnClickListener(this);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_communication, null, false);
        drawer.addView(contentView, 0);
    }
    private void sendEmail() {
        //Getting content for email

        SignInActivity login = new SignInActivity();
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = "University Bazaar"+"\n"+"From: " +login.getUsername()+"\n"+"\n"+ editTextMessage.getText().toString().trim();
        SendMail sm = new SendMail(this, email,  subject, message);
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
