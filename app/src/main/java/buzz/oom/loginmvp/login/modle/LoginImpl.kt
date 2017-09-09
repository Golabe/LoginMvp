package buzz.oom.loginmvp.login.modle

import buzz.oom.loginmvp.login.entity.LoginInfo

/**
 * Created by yuequ on 2017/9/8.
 */
 class LoginImpl :ILoginModel {


    override fun onLogin(loginInfo: LoginInfo, listener: ILoginListener) {

        Thread{

            kotlin.run {
                Thread.sleep(2000)
                if (loginInfo.account.equals("123456")&&loginInfo.pwd.equals("123456")){

                    listener.onSuccess()

                }   else{

                    listener.onFailed(401)
                }

            }
        }.start()



    }
}