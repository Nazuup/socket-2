import java.io.Serializable;

public class TaskObject implements Serializable, ITask {

    int number = 0;
    int result = 1;
    
    @Override
    public void setExecNumber(int x){ // クライアントで最初に計算させる数字を入力しておく関数
        number = x;
    }

    @Override
    public void exec(){ // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。
        for(int i = 1; i<=number; i++){
            result *= i;
        }
    }

    @Override
    public int getResult(){// クライアントで結果を取り出す関数
        return result;
    }
}