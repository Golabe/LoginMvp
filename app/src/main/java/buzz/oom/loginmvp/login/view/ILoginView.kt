package buzz.oom.loginmvp.login.view

import buzz.oom.loginmvp.login.entity.LoginInfo

/**
 * Created by yuequ on 2017/9/8.
 */
interface ILoginView {

    fun isInputError():Boolean

    fun getLogin():LoginInfo

    fun clearAccount()

    fun clearPassword()

    fun showLoading()

    fun hideLoading()

    fun  onSuccess(code:Int)

    fun onFailed(code: Int)
}