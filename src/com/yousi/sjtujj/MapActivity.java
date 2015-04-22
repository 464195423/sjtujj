package com.yousi.sjtujj;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.yousi.map.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MapActivity extends Activity {
private GeocodeSearch geocoderSearch;
private String addressName;
private AMap aMap;
private MapView mapView;
private Marker geoMarker;
private Marker regeoMarker;
private LatLonPoint latLonPoint;
private String place;
private String coordinate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		place = getIntent().getExtras().getString("place");
		coordinate = getIntent().getExtras().getString("coordinate");
		
		
		mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 必须要写


        String str[] = new String[2];
        str = coordinate.split(",");
        double d1 = Double.parseDouble(str[0]);
        double d2 = Double.parseDouble(str[1]);

        latLonPoint = new LatLonPoint(d1, d2);
        
        init();
        getAddress(latLonPoint);
        
        TextView tv = (TextView)findViewById(R.id.map_title);
        tv.setText(place);
        
        
        
        //左上返回键
        LinearLayout lv_up = (LinearLayout)findViewById(R.id.map_up);
        lv_up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	/**
     * 初始化AMap对象
     */
    private void init() {
    	if (aMap == null) {
			aMap = mapView.getMap();
			geoMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			regeoMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
		}
        geocoderSearch = new GeocodeSearch(this);
		geocoderSearch.setOnGeocodeSearchListener(new OnGeocodeSearchListener() {
			
			/**
			 * 地理编码查询回调
			 */
			@Override
			public void onGeocodeSearched(GeocodeResult result, int rCode) {
				if (rCode == 0) {
					if (result != null && result.getGeocodeAddressList() != null
							&& result.getGeocodeAddressList().size() > 0) {
						GeocodeAddress address = result.getGeocodeAddressList().get(0);
						aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
								AMapUtil.convertToLatLng(address.getLatLonPoint()), 15));
						geoMarker.setPosition(AMapUtil.convertToLatLng(address
								.getLatLonPoint()));
						addressName = "经纬度值:" + address.getLatLonPoint() + "\n位置描述:"
								+ address.getFormatAddress();
						//ToastUtil.show(GeocoderActivity.this, addressName);
					} else {
						//ToastUtil.show(GeocoderActivity.this, R.string.no_result);
					}

				} else if (rCode == 27) {
					//ToastUtil.show(GeocoderActivity.this, R.string.error_network);
				} else if (rCode == 32) {
					//ToastUtil.show(GeocoderActivity.this, R.string.error_key);
				} else {
					//ToastUtil.show(GeocoderActivity.this,
					//		getString(R.string.error_other) + rCode);
				}
			}

			/**
			 * 逆地理编码回调
			 */
			@Override
			public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
				if (rCode == 0) {
					if (result != null && result.getRegeocodeAddress() != null
							&& result.getRegeocodeAddress().getFormatAddress() != null) {
						addressName = result.getRegeocodeAddress().getFormatAddress()
								+ "附近";
						aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
								AMapUtil.convertToLatLng(latLonPoint), 15));
						regeoMarker.setPosition(AMapUtil.convertToLatLng(latLonPoint));
						//ToastUtil.show(MapActivity.this, addressName);
					} else {
						//ToastUtil.show(MapActivity.this, R.string.no_result);
					}
				} else if (rCode == 27) {
					//ToastUtil.show(MapActivity.this, R.string.error_network);
				} else if (rCode == 32) {
					//ToastUtil.show(MapActivity.this, R.string.error_key);
				} else {
					//ToastUtil.show(MapActivity.this,
					//		getString(R.string.error_other) + rCode);
				}
			}
		});
    }
 
    /**
	 * 响应地理编码
	 */
	public void getLatlon(final String name) {
		GeocodeQuery query = new GeocodeQuery(name, "021");// 第一个参数表示地址，第二个参数表示查询城市，中文或者中文全拼，citycode、adcode，
		geocoderSearch.getFromLocationNameAsyn(query);// 设置同步地理编码请求
	}

	/**
	 * 响应逆地理编码
	 */
	public void getAddress(final LatLonPoint latLonPoint) {
		RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,
				GeocodeSearch.AMAP);// 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
		geocoderSearch.getFromLocationAsyn(query);// 设置同步逆地理编码请求
	}


    
    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
 
    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
     
    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
 
    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
