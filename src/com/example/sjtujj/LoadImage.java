package com.example.sjtujj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;

public class LoadImage {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(3);
	private static LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(
			(int) (Runtime.getRuntime().maxMemory() / 8)) {
		@Override
		protected void entryRemoved(boolean evicted, String key,
				Bitmap oldValue, Bitmap newValue) {
			super.entryRemoved(evicted, key, oldValue, newValue);
			if (evicted) {
				SoftReference<Bitmap> reference = new SoftReference<Bitmap>(
						oldValue);
				softCache.put(key, reference);
			}
		}

		@Override
		protected int sizeOf(String key, Bitmap value) {
			return value.getRowBytes() * value.getHeight();
		}
	};
	private static HashMap<String, SoftReference<Bitmap>> softCache = new HashMap<String, SoftReference<Bitmap>>();

	private static void loadImage(final Context context, final String path,
			final ImageView imageView) {
		final Handler handler = new Handler();
		threadPool.execute(new Runnable() {
			InputStream is = null;
			FileOutputStream fos = null;
			Bitmap bitmap;

			@Override
			public void run() {
				imageView.setTag(path);
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setConnectTimeout(5000);
					conn.connect();
					
					if (conn.getResponseCode() == 200) {
						is = conn.getInputStream();
						bitmap = BitmapFactory.decodeStream(is);
					}
					File file = getImageFile(context, path);
					fos = new FileOutputStream(file);
					final Bitmap newBitmap = BitmapCompress.compressImage(bitmap);
					newBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
					handler.post(new Runnable() {

						@Override
						public void run() {
							if (imageView.getTag().toString().equals(path)) {
								imageView.setImageBitmap(newBitmap);
							}
						}
					});
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (fos != null) {
							fos.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});
	}

	private static void loadImage2(final Context context, final String path,
			final ImageView imageView,final int height,final int width) {
		final Handler handler = new Handler();
		threadPool.execute(new Runnable() {
			InputStream is = null;
			FileOutputStream fos = null;
			Bitmap bitmap;

			@Override
			public void run() {
				imageView.setTag(path);
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setConnectTimeout(5000);
					conn.connect();
					
					if (conn.getResponseCode() == 200) {
						is = conn.getInputStream();
						bitmap = BitmapFactory.decodeStream(is);
					}
					File file = getImageFile(context, path);
					fos = new FileOutputStream(file);
					final Bitmap newBitmap = BitmapCompress.compressImage(bitmap);
					newBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
					handler.post(new Runnable() {

						@Override
						public void run() {
							if (imageView.getTag().toString().equals(path)) {
								Bitmap temp = Bitmap.createScaledBitmap(newBitmap, width, height, true);
								imageView.setImageBitmap(temp);
							}
						}
					});
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (fos != null) {
							fos.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
	}
	
	private static File getImageFile(Context context, String path) {
		File file = null;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			file = context.getExternalCacheDir();
		} else {
			file = context.getCacheDir();
		}
		String[] split = path.split("/");
		String fileName = split[split.length - 1];
		return new File(file, fileName);
	}

	public static void setImageView(Context context, String path,
			ImageView imageView) {
		Bitmap bitmap = lruCache.get(path);
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
			return;
		}

		SoftReference<Bitmap> reference = softCache.get(path);
		if (reference != null) {
			Bitmap bitmap2 = reference.get();
			if (bitmap2 != null) {
				imageView.setImageBitmap(bitmap2);
				return;
			}
		}

		File file = getImageFile(context, path);
		if (file.exists() && file != null) {
			Bitmap bitmap3 = BitmapFactory.decodeFile(file.getPath());
			imageView.setImageBitmap(bitmap3);
			lruCache.put(path, bitmap3);
			return;
		}
		
		loadImage(context, path, imageView);
	}
	public static void setImageView2(Context context, String path,
			ImageView imageView,int height,int width) {
		Bitmap bitmap = lruCache.get(path);
		if (bitmap != null) {
			Bitmap temp = Bitmap.createScaledBitmap(bitmap, width, height, true);
			imageView.setImageBitmap(temp);
			return;
		}

		SoftReference<Bitmap> reference = softCache.get(path);
		if (reference != null) {
			Bitmap bitmap2 = reference.get();
			if (bitmap2 != null) {
				Bitmap temp = Bitmap.createScaledBitmap(bitmap2, width, height, true);
				imageView.setImageBitmap(temp);
				return;
			}
		}

		File file = getImageFile(context, path);
		if (file.exists() && file != null) {
			Bitmap bitmap3 = BitmapFactory.decodeFile(file.getPath());
			Bitmap temp = Bitmap.createScaledBitmap(bitmap3, width, height, true);
			imageView.setImageBitmap(temp);
			lruCache.put(path, bitmap3);
			return;
		}
		loadImage2(context, path, imageView,height,width);
	}
}
