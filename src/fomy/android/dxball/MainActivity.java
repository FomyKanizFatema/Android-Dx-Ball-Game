package fomy.android.dxball;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	WindowManager w;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final GameCanvas g= new GameCanvas(this);
        setContentView(g);
//        b.setOnClickListener(new View.OnClickListener() {
//			
//			public void onClick(View arg0) {
//				
//				
//			}
//		});
       
        
    }
}