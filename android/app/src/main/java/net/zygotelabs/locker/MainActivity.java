package net.zygotelabs.locker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment()).commit();
			
		}
	}
	
	public void onCheckboxClicked(View view){
		MainFragment fragment = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
		boolean checked = ((CheckBox) view).isChecked();
		fragment.onCheckBoxClicked(checked);
	}

	public void onSafeModeCheckboxChecked(View view){
        MainFragment fragment = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
        boolean checked = ((CheckBox) view).isChecked();
        fragment.onSafeModeCheckBoxClicked(checked);
	}
	
	public void enableProtection(View view){
		MainFragment fragment = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
		fragment.toggleLockProtection();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
