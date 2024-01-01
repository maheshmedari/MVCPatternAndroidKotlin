package com.mahesh.mvcloginkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mahesh.mvcloginkotlin.Controller.ILoginController
import com.mahesh.mvcloginkotlin.Controller.LoginController
import com.mahesh.mvcloginkotlin.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    /*What is MVC — Model View Controller?
An MVC Pattern — stands for MODEL VIEW CONTROLLER, It is a Software Design Pattern, usually used in developing user interfaces.
MVC Architecture pattern is a way how the information or data is been presented to the user & how the user interacts/deals with the data view.
An MVC framework is nearly utilized in all development processes like Web development and portable application like android MVC and IOS MVC.*/

    /*MVC Architecture Components
It has 3 Components i.e. MODEL-VIEW-CONTROLLER.

MODEL
Here Model is nothing but a data, it directly manages the data, logic and rules of the application.
A Model is responsible for managing data of an app.
VIEW
A View in MVC is nothing but a UI design, How you can display the data to the USER screen.
A view means presentation of the data in a particular format.
CONTROLLER
A Controller is typically a piece, which control all the task/event that a user perform, Such as event handling, navigation, Communication between model & view happens in controller in MVC.
A Controller receive the input, validate it, & pass the validated input to Model.
*/

    var email: EditText? = null
    var password: EditText? = null
    var loginb: Button? = null
    var loginPresenter: ILoginController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.edtUserName)
        password = findViewById(R.id.edtPassword)
        loginb = findViewById(R.id.mButtonLogin)
        loginPresenter = LoginController(this)

        loginb?.setOnClickListener {
            (loginPresenter as LoginController).OnLogin(
                email?.text.toString(),
                password?.text.toString().trim()
            )
        }

    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}