package buzz.oom.loginmvp.login.modle

import buzz.oom.loginmvp.login.entity.LoginInfo

/**
 * Created by yuequ on 2017/9/8.
 */
interface ILoginModel {

    fun onLogin(loginInfo:LoginInfo,loginListener:ILoginListener)


}