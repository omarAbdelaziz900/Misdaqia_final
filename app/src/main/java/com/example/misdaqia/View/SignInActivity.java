package com.example.misdaqia.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.misdaqia.Helper.MainFontButton;
import com.example.misdaqia.Helper.MainFontEdittext;
import com.example.misdaqia.Model.LoginUserResponse;
import com.example.misdaqia.R;
import com.example.misdaqia.Services.ApiClient;
import com.example.misdaqia.Services.JsonPlaceHolderApi;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    private MainFontEdittext edtemail;
    private MainFontEdittext edtpassword;
    private MainFontButton btnlogin;

    ProgressDialog progressDialog;

    JsonPlaceHolderApi jsonPlaceHolderApi;
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        initView();

        initActios();

        jsonPlaceHolderApi = ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void initActios() {

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();

                if (checkValidation() == false) {
                    return;
                } else {
                    loginUser(email, password);

                }
            }
        });
    }

    private void loginUser(String Email, final String Password) {

        progressDialog.show();

        Map<String, String> parameters = new HashMap<>();
        parameters.put("password",Password);
        parameters.put("email",Email);

        Call<LoginUserResponse> call = jsonPlaceHolderApi.Login(parameters);
        call.enqueue(new Callback<LoginUserResponse>() {
            @Override
            public void onResponse(Call<LoginUserResponse> call, Response<LoginUserResponse> response) {

                if (response.isSuccessful()){

                    LoginUserResponse userModel=response.body();
                    if (userModel.getStatus().equals("user exist")){

                        SharedPreferences.Editor edit = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                        edit.putString("email", userModel.getEmail());
                        edit.putString("password", userModel.getPassword());
                        edit.commit();

                        progressDialog.dismiss();


                        startActivity(new Intent(SignInActivity.this, MainActivity.class));


                    }else {
                        Toast.makeText(SignInActivity.this,getString(R.string.fail), Toast.LENGTH_SHORT).show();
                    }
                }else {

                    Toast.makeText(SignInActivity.this,getString(R.string.fail) , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginUserResponse> call, Throwable t) {

                if (t instanceof ConnectException) {
                    Toast.makeText(SignInActivity.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    public void goSignup(View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }


    private void initView() {
        edtemail = (MainFontEdittext) findViewById(R.id.edtemail);
        edtpassword = (MainFontEdittext) findViewById(R.id.edtpassword);
        btnlogin = (MainFontButton) findViewById(R.id.btnlogin);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.wait));
    }

    private boolean checkValidation() {

        boolean flag = false;

        if (edtemail.getText().toString().length() == 0) {
            edtemail.setError(getString(R.string.empty_email));
            edtemail.requestFocus();
            flag = false;

        } else if (edtpassword.getText().toString().length() == 0) {
            edtpassword.setError(getString(R.string.empty_password));
            edtpassword.requestFocus();
            flag = false;

        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edtemail.getText().toString().trim()).matches()) {
            edtemail.setError(getString(R.string.invalid_email));
            edtemail.requestFocus();
            flag = false;
        } else {
            flag = true;
        }

        return flag;

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.exit))
                .setMessage(getString(R.string.are_you_sure_to_exit))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }

                })
                .setNegativeButton(getString(R.string.no), null)
                .show();
    }

}
