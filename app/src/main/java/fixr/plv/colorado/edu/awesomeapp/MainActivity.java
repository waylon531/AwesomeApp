package fixr.plv.colorado.edu.awesomeapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import android.os.Message;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

  static protected int SEND_CODE = 1;
  static protected String MSG_KEY = "received";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
        }
      });
  }

  public int recycleItems(ViewGroup layout) {
    for (int i = 0; i < layout.getChildCount(); i++) {
      View v = layout.getChildAt(i);
      layout.removeViewAt(i);
    }

    return 0;
  }

  public int handleMessage(Handler handler) {
    Message msg = handler.obtainMessage(MainActivity.SEND_CODE,
                                        null);

    Bundle bundle = new Bundle();
    bundle.putString(MainActivity.MSG_KEY, "CODE");
    msg.setData(bundle);

//    handler.sendMsg(msg);

    return 0;
  }

  public void showDialog(Context context) {
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

    String title = "Empty Field(s)";
    String message = "Please ensure all fields are contain data";

//    dialogBuilder.setTitle(title);

    dialogBuilder.setMessage(message);

    dialogBuilder.setNegativeButton("OK",
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
      });
    dialogBuilder.setPositiveButton("Cancel",
      new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
                // continue with delete
        }
      });

    dialogBuilder.create();
    dialogBuilder.show();
  }
}
