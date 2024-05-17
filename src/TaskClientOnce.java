import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientOnce {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("xの階乗を求めます。xの値を入力してください(半角数字、整数のみ)");
            int number = scanner.nextInt();
            scanner.close();

            TaskObject inputNumber = new TaskObject();
            inputNumber.setExecNumber(number);

            oos.writeObject(inputNumber);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject outputNumber = (TaskObject) ois.readObject();
            System.out.println("計算結果が返ってきました。");

            number = outputNumber.number;
            System.out.println(number + "!は ");
            int result = outputNumber.getResult();
            System.out.println(result + " です。");

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
