package com.yousi.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceActivity.Header;
import android.util.Log;
import android.widget.Toast;

public class MyHttpClient {

	public static void getJson(final String path, final NetRespondPost post,
			final String sessionID) {

		final Handler handler = new Handler();
		new Thread() {
			@Override
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				try {
					HttpClient client = new DefaultHttpClient();
					HttpGet get = new HttpGet(path);
					if (sessionID != null) {
						get.setHeader("Cookie", sessionID);
					}
					HttpResponse response;
					response = client.execute(get);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						HttpEntity entity = response.getEntity();
						if (entity != null) {

							is = entity.getContent();
							os = new ByteArrayOutputStream();
							byte[] buffer = new byte[1024];
							int len = is.read(buffer);
							while (len != -1) {
								os.write(buffer, 0, len);
								len = is.read(buffer);
							}
							os.flush();
							final String json = new String(os.toByteArray(), 0,
									os.toByteArray().length);
							handler.post(new Runnable() {

								@Override
								public void run() {
									post.netWorkOk(json);
								}
							});
						}
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
	}

	public static void postJson(final String path,
			final NetRespondPost netPost, final String sessionID) {

		final Handler handler = new Handler();
		new Thread() {
			@Override
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				try {
					HttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(path);
					post.setHeader("Cookie", sessionID);
					HttpResponse response;
					response = client.execute(post);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						HttpEntity entity = response.getEntity();
						if (entity != null) {

							is = entity.getContent();
							os = new ByteArrayOutputStream();
							byte[] buffer = new byte[1024];
							int len = is.read(buffer);
							while (len != -1) {
								os.write(buffer, 0, len);
								len = is.read(buffer);
							}
							os.flush();
							final String json = new String(os.toByteArray(), 0,
									os.toByteArray().length);
							handler.post(new Runnable() {

								@Override
								public void run() {
									netPost.netWorkOk(json);
								}
							});
						}
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public static void uploadData(final Context context, final String path,
			final String content, final String qid, final String SessionID) {
		new Thread() {
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				HttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(path);
				post.setHeader("Cookie", SessionID);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("content", content));
				params.add(new BasicNameValuePair("qid", qid));
				HttpEntity formEntity;
				try {
					formEntity = new UrlEncodedFormEntity(params);
					post.setEntity(formEntity);
					HttpResponse response = client.execute(post);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						is = response.getEntity().getContent();
						os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = is.read(buffer);
						while (len != -1) {
							os.write(buffer, 0, len);
							len = is.read(buffer);
						}
						os.flush();
						final String json = new String(os.toByteArray(), 0,
								os.toByteArray().length);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	public static void doPost1(final Context context,
			final NetRespondPost netRespondPost, final String path,
			final HashMap<String, String> map) {
		final Handler handler = new Handler();
		new Thread() {
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				HttpClient client = new DefaultHttpClient();
				final HttpPost post = new HttpPost(path);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for (String key : map.keySet()) {
					params.add(new BasicNameValuePair(key, map.get(key)));
				}
				HttpEntity formEntity;
				try {
					formEntity = new UrlEncodedFormEntity(params);
					post.setEntity(formEntity);
					HttpResponse response = client.execute(post);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

						String sessionid = "";
						org.apache.http.Header[] headers = response.getAllHeaders();
						for (int i = 0; i < headers.length; i++) {
							org.apache.http.Header header = headers[i];
							if (header.getName().equals("Set-Cookie"))
								sessionid += header.getValue() + "; ";// 获取服务器的sessionid
						}
						//写入sessionid
						//MyPath.setSessionid(sessionid);
						DB.setSessionid(context, sessionid);
						
						is = response.getEntity().getContent();
						os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = is.read(buffer);
						while (len != -1) {
							os.write(buffer, 0, len);
							len = is.read(buffer);
						}
						os.flush();
						final String json = new String(os.toByteArray(), 0,
								os.toByteArray().length);
						handler.post(new Runnable() {

							@Override
							public void run() {
								netRespondPost.netWorkOk(json);
							}
						});
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();
	}
	

	public static void doPost2(final Context context,
			final NetRespondPost netRespondPost, final String path,
			final HashMap<String, String> map, final String SessionID) {
		final Handler handler = new Handler();
		new Thread() {
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				HttpClient client = new DefaultHttpClient();
				final HttpPost post = new HttpPost(path);
				if (SessionID != null) {
					post.setHeader("Cookie", SessionID);
				}
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				for (String key : map.keySet()) {
					params.add(new BasicNameValuePair(key, map.get(key)));
				}
				HttpEntity formEntity;
				try {
					formEntity = new UrlEncodedFormEntity(params);
					post.setEntity(formEntity);
					HttpResponse response = client.execute(post);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						is = response.getEntity().getContent();
						os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = is.read(buffer);
						while (len != -1) {
							os.write(buffer, 0, len);
							len = is.read(buffer);
						}
						os.flush();
						final String json = new String(os.toByteArray(), 0,
								os.toByteArray().length);
						handler.post(new Runnable() {

							@Override
							public void run() {
								netRespondPost.netWorkOk(json);
							}
						});
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();
	}
	
	public static void doGet2(final Context context,
			final NetRespondPost netRespondPost, final String path,
			final HashMap<String, String> map, final String SessionID) {
		final Handler handler = new Handler();
		new Thread() {
			public void run() {
				InputStream is = null;
				ByteArrayOutputStream os = null;
				HttpClient client = new DefaultHttpClient();
				
				String str = "";
				for (String key : map.keySet()) {
					str  += key + "=" + map.get(key) + "&";
				}
				
				if (str.length() != 0)
					str = str.substring(0, str.length()-1);
			
				final HttpGet get = new HttpGet(path + (str.length() == 0 ? "" : "?" + str));
				if (SessionID != null) {
					get.setHeader("Cookie", SessionID);
				}
				
				HttpEntity formEntity;
				try {
					HttpResponse response = client.execute(get);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						is = response.getEntity().getContent();
						os = new ByteArrayOutputStream();
						byte[] buffer = new byte[1024];
						int len = is.read(buffer);
						while (len != -1) {
							os.write(buffer, 0, len);
							len = is.read(buffer);
						}
						os.flush();
						final String json = new String(os.toByteArray(), 0,
								os.toByteArray().length);
						handler.post(new Runnable() {

							@Override
							public void run() {
								netRespondPost.netWorkOk(json);
							}
						});
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();
	}
}
