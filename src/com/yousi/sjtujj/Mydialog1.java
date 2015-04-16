package com.yousi.sjtujj;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;

public class Mydialog1 extends AlertDialog {
private Context context;
private String rid;
	protected Mydialog1(Context context, String rid) {
		super(context);
		this.context = context;
		this.rid = rid;
	}

}
