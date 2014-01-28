package com.formation.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MonActivite extends Activity {

	private static int CODE_RETOUR = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getPreferences();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.menuprincipal, menu);
       	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getItemId() == R.id.itemOptions) {
    		startActivityForResult(new Intent(this, MesPreferences.class), CODE_RETOUR);
    	}
    	
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode == CODE_RETOUR) {
			Toast.makeText(this, "Modifications terminées", Toast.LENGTH_SHORT).show();
			getPreferences();
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
    private void getPreferences() {
    	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    	((TextView)findViewById(R.id.tvLogin)).setText("Nom d'utilisateur : " + preferences.getString("login", ""));
    	((TextView)findViewById(R.id.tvPassword)).setText("Mot de passe : " + preferences.getString("password", ""));
    	((TextView)findViewById(R.id.tvRingtone)).setText("Sonnerie : " + preferences.getString("sonnerie", ""));
    	((TextView)findViewById(R.id.tvVibrate)).setText("Vibreur : " + preferences.getBoolean("vibrate", false));
    }
}