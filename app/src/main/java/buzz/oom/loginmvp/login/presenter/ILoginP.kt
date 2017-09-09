package buzz.oom.loginmvp.login.presenter

import buzz.oom.loginmvp.login.modle.ILoginListener
import buzz.oom.loginmvp.login.modle.LoginImpl
import buzz.oom.loginmvp.login.view.ILoginView


/**
 * Created by yuequ on 2017/9/8.
 */
class  ILoginP {

    private lateinit var login: LoginImpl

    private lateinit var loginView: ILoginView

    private var hander = android.os.Handler()


    constructor(loginView: ILoginView) {
        login = LoginImpl()
        this.loginView = loginView

    }

    fun onLogin() {
        loginView.showLoading()

        login.onLogin(loginView.getLogin(), object : ILoginListener {
            override fun onSuccess() {
                hander.post {

                    loginView.onSuccess(200)
                    loginView.hideLoading()
                }
            }

            override fun onFailed(code: Int) {
                hander.post {

                    loginView.onFailed(401)
                    loginView.hideLoading()
                }

            }

        })

    }

    fun onClear(){
        loginView.clearAccount()
        loginView.clearPassword()
    }

}