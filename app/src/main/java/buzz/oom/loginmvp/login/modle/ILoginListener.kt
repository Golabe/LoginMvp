package buzz.oom.loginmvp.login.modle

/**
 * Created by yuequ on 2017/9/8.
 */
interface ILoginListener {

    fun onSuccess()

    fun onFailed(code:Int)
}