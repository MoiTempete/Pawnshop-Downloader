package com.waps.pawnshop;

import com.waps.pawnshop.R;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends ActivityGroup implements
		OnCheckedChangeListener {
	private TabHost mHost;
	private Intent offerIntent;
	private Intent searchIntent;
	private Intent localIntent;
	private Intent classifyIntent;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		// 设置TabHost
		initTabs();
		initRadios();
		setupIntent();
	}

	private void initTabs() {
		mHost = (TabHost) findViewById(R.id.tabhost);
		mHost.setup(this.getLocalActivityManager());

		offerIntent = new Intent(this, OfferActivity.class);
		classifyIntent = new Intent(this, ClassifyActivity.class);
		searchIntent = new Intent(this, SearchActivity.class);
		localIntent = new Intent(this, LocalActivity.class);
	}

	private void initRadios() {
		((RadioButton) findViewById(R.id.radio_button_offer))
				.setOnCheckedChangeListener(this);
		
		((RadioButton) findViewById(R.id.radio_button_classify))
		.setOnCheckedChangeListener(this);

		((RadioButton) findViewById(R.id.radio_button_search))
				.setOnCheckedChangeListener(this);

		((RadioButton) findViewById(R.id.radio_button_local))
				.setOnCheckedChangeListener(this);
	}

	private void setupIntent() {

		mHost.addTab(buildTabSpec("offer", "AppOffer", R.drawable.icon,
				offerIntent));
		
		mHost.addTab(buildTabSpec("classify", "ClassifyApp", R.drawable.icon,
				classifyIntent));

		mHost.addTab(buildTabSpec("search", "SearchApp", R.drawable.icon,
				searchIntent));

		mHost.addTab(buildTabSpec("local", "LocalApp", R.drawable.icon,
				localIntent));
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.radio_button_offer:
				this.mHost.setCurrentTabByTag("offer");
				break;
			case R.id.radio_button_classify:
				this.mHost.setCurrentTabByTag("classify");
				break;
			case R.id.radio_button_search:
				this.mHost.setCurrentTabByTag("search");
				break;
			case R.id.radio_button_local:
				this.mHost.setCurrentTabByTag("local");
				break;
			}
		}
	}

	private TabHost.TabSpec buildTabSpec(String tag, String resLabel,
			int resIcon, final Intent content) {
		return this.mHost.newTabSpec(tag)
				.setIndicator(resLabel, getResources().getDrawable(resIcon))
				.setContent(content);
	}
}