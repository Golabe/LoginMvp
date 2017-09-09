package buzz.oom.loginmvp.login.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

import buzz.oom.loginmvp.R
import buzz.oom.loginmvp.login.entity.LoginInfo
import buzz.oom.loginmvp.login.presenter.ILoginP

class LoginActivity : AppCompatActivity(), ILoginView {


    private val TAG = "LoginActivity"


    private var mLogin: Button? = null
    private var mEtAccount: EditText? = null
    private var mEtPwd: EditText? = null
    private var mProgess: ProgressBar? = null

    private var mAccountLayout: TextInputLayout? = null
    private var mPwdLayout: TextInputLayout? = null

    private var loginP = ILoginP(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = findViewById(R.id.btn_login)
        mEtAccount = findViewById(R.id.et_account)
        mEtPwd = findViewById(R.id.et_pwd)
        mProgess = findViewById(R.id.pb_progress)


        mAccountLayout = findViewById(R.id.til_account)
        mPwdLayout = findViewById(R.id.til_pwd)

        mAccountLayout!!.hint = "输入账号"

        mLogin!!.setOnClickListener {

            loginP.onLogin()


        }

        var account: EditText = mAccountLayout!!.editText!!

        account!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, p3: Int) {

                if (s!!.length < 5) {
                    mAccountLayout!!.isErrorEnabled = true
                    mAccountLayout!!.error = "用户名不能小于6位"
                } else {
                    mAccountLayout!!.isErrorEnabled = false
                }
            }
        })

        var pwd = mPwdLayout!!.editText


    }


    override fun isInputError(): Boolean {

        return false
    }

    override fun getLogin(): LoginInfo = LoginInfo(mEtAccount!!.text.toString(), mEtPwd!!.text.toString())


    override fun clearAccount() {
        mEtAccount!!.setText("")
    }

    override fun clearPassword() {
        mEtPwd!!.setText("")
    }

    override fun showLoading() {
        mProgess!!.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        mProgess!!.visibility = View.GONE
    }

    override fun onFailed(code: Int) {
        Log.d(TAG, "onFailed" + code)
    }

    override fun onSuccess(code: Int) {
        Log.d(TAG, "onSuccess" + code)
    }

}
