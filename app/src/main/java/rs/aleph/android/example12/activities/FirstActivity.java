package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.fragments.DetailFragment;
import rs.aleph.android.example12.fragments.ListFragment;
import rs.aleph.android.example12.provider.JeloProvider;

// Each activity extends Activity class
public class FirstActivity extends Activity {
	boolean landscape = false;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_first);

//		final List<String> jelaNazivi = JeloProvider.getJelaNazivi();
//		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, jelaNazivi);
//		ListView listView = (ListView) findViewById(R.id.listJela);
//
//		listView.setAdapter(dataAdapter);
//
//		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				intent.putExtra("position", position);
//				startActivity(intent);
//			}
//		});

		if (savedInstanceState == null) {
			// FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ListFragment masterFragment = new ListFragment();
			ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}

		if (findViewById(R.id.detail_view) != null) {
			landscape = true;
			getFragmentManager().popBackStack(); //ovo mozda ne treba

			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			if (detailFragment == null) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				detailFragment = new DetailFragment();
				ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

				ft.commit();
			}
		}

	}

	// onStart method is a lifecycle method called after onCreate (or after onRestart when the
	// activity had been stopped, but is now again being displayed to the user)
	@Override
	protected void onStart() {

		super.onStart();
	}

	@Override
	protected void onRestart() {

		super.onRestart();
	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	protected void onStop() {

		super.onStop();
	}

	@Override
	protected void onDestroy(){

		super.onDestroy();
	}

	@Override
	public void onItemSeleceted(int position) {

		if (landscape) {
			// If the device is in the landscape mode updates detail fragment's content.
			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			detailFragment.updateContent(position);
		} else {
			// If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
			DetailFragment detailFragment = new DetailFragment();
			detailFragment.setContent(position);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
		}

	}






//	// Called when btnStart button is clicked
//	public void btnStartActivityClicked(View view) {
//		// This is an explicit intent (class property is specified)
//        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//		// startActivity method starts an activity
//        startActivity(intent);
//	}
//
//	// Called when btnOpen is clicked
//    public void btnOpenBrowserClicked(View view) {
//		// This is an implicit intent
//        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.www_google_com)));
//		// startActivity method starts an activity
//		startActivity(i);
//    }
}
