package com.waps.pawnshop;

import com.waps.pawnshop.R;
import com.waps.pawnshop.gallery.GalleryFlow;
import com.waps.pawnshop.gallery.ImageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class OfferActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.offer);
		// TODO 需实现图片动态添加
		Integer[] images = getAppImages();// 获取应用图标
		int imagesCount = getAppImages().length;// 获取应用个数
 
		ImageAdapter adapter = new ImageAdapter(this, images);
		adapter.createReflectedImages();// 创建倒影效果

		GalleryFlow galleryFlow = (GalleryFlow) this
				.findViewById(R.id.OfferGallery);
		galleryFlow.setFadingEdgeLength(0);
		galleryFlow.setSpacing(-100); // 图片之间的间距
		galleryFlow.setAdapter(adapter);
		//
		galleryFlow.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						String.valueOf(position), Toast.LENGTH_SHORT).show();
			}

		});
		galleryFlow.setSelection(imagesCount - imagesCount);
	}

	private Integer[] getAppImages() {
		Integer[] appIcons = { R.drawable.img1, R.drawable.img2,
				R.drawable.img3, R.drawable.img4, R.drawable.img5 };
		return appIcons;
	}

}