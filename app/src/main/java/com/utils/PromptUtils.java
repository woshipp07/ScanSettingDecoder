/**
 * File Name:PromptUtils.java
 */

package com.utils;
import com.application.AppCtx;
import com.qrcodescan.R;

import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 */
public final class PromptUtils {
	private static final String TAG = "PromptUtils";

	public static final int TYPE_TOAST = 1;
	public static final int TYPE_DIALOG = 2;

	public static final int THRESHOLD_TIME = 100;

	private static AlertDialog sAlertDialog;
	private static ProgressDialog sProgressDialog;
	private static Timer sTimer;

	private static int sIconId = R.drawable.query_dialog_icon;
	private static int sTitleId = R.string.zltd_prompt;
	private static int sOkBtnStringId = R.string.zltd_prompt_ok;
	private static int sCancelBtnStringId = R.string.zltd_prompt_cancel;
	private static int sPrgrsTitleId = R.string.zltd_prompt;

	private static int sWarnType = TYPE_DIALOG;
	private static int sPromptType = TYPE_DIALOG;
	private static int sToastDuration = Toast.LENGTH_SHORT;

	public static void showWarn(int textResId, Context context) {
		showWarn(context.getString(textResId), context);
	}

	public static void showWarn(int textResId, Context context, long maxWaitTime) {
		showWarn(context.getString(textResId), context, null, maxWaitTime);
	}

	public static void showWarn(String msg, Context context) {
		showAlertDialog(context, msg, null);
	}

	public static void showWarn(String msg, Context context, long maxWaitTime) {
		showWarn(msg, context, null, maxWaitTime);
	}

	public static void showWarn(int textResId, Context context,
			DialogInterface.OnClickListener listener) {
		showWarn(context.getString(textResId), context, listener);
	}

	public static void showWarn(String msg, Context context,
			DialogInterface.OnClickListener listener) {
		showWarn(msg, context, listener, 0);
	}

	public static void showWarn(String msg, Context context,
			DialogInterface.OnClickListener listener, long maxWaitTime) {
		if (TYPE_TOAST == sWarnType) {
			showToast(msg, context);
		} else if (TYPE_DIALOG == sWarnType) {
			showAlertDialog(context, msg, listener);

			if (maxWaitTime > THRESHOLD_TIME) {
				sTimer = new Timer();
				sTimer.schedule(new TimerTask() {
					@Override
					public void run() {
						closeAlertDialog();
					}
				}, maxWaitTime);
			}
		}
	}

	public static void showPrompts(int textResId, Context context) {
		showPrompts(context.getString(textResId), context);
	}

	public static void showPrompts(String msg, Context context) {
		showPrompts(msg, context, null);
	}

	public static void showPrompts(int textResId, Context context,
			DialogInterface.OnClickListener listener) {
		showPrompts(context.getString(textResId), context, listener);
	}

	public static void showPrompts(String msg, Context context,
			DialogInterface.OnClickListener listener) {
		showPrompts(msg, context, listener, 0);
	}

	public static void showPrompts(String msg, Context context,
			DialogInterface.OnClickListener listener, long maxWaitTime) {
		if (TYPE_TOAST == sPromptType) {
			showToast(msg, context);
		} else if (TYPE_DIALOG == sPromptType) {
			showAlertDialog(context, msg, listener);

			if (maxWaitTime > THRESHOLD_TIME) {
				sTimer = new Timer();
				sTimer.schedule(new TimerTask() {
					@Override
					public void run() {
						closeAlertDialog();
					}
				}, maxWaitTime);
			}
		}
	}

	public static void closePrompt() {
		closeAlertDialog();
	}

	public static void closeAlertDialog() {
		if (sAlertDialog != null && sAlertDialog.isShowing()) {
			sAlertDialog.dismiss();
			sAlertDialog = null;

		}
	}

	public static void showAlertDialog(Context context, int textResId,
			final DialogInterface.OnClickListener positiveListener) {
		showAlertDialog(context, context.getString(textResId), positiveListener);
	}

	public static void showAlertDialog(Context context, String msg,
			final DialogInterface.OnClickListener positiveListener) {
		try {
			closeAlertDialog();

			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(sIconId);
			//builder.setIcon(R.drawable.query_dialog_icon);
			builder.setTitle(sTitleId);
			builder.setMessage(msg);
			builder.setPositiveButton(sOkBtnStringId, positiveListener);
			builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					closeAlertDialog();
				}
			});

			builder.setOnKeyListener(new OnKeyListener() {
				@Override
				public boolean onKey(DialogInterface dialog, int keyCode,
						KeyEvent event) {
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
							|| keyCode == KeyEvent.KEYCODE_ENTER) {
						if (event != null
								&& event.getAction() == KeyEvent.ACTION_UP) {
							if (positiveListener != null) {
								positiveListener.onClick(sAlertDialog,
										AlertDialog.BUTTON_POSITIVE);
							}

							Log.d("dialog listener", "close dialog");
							Log.d("dialog listener",
									"Action:" + event.getAction());
							Log.d("dialog listener", "keyCode:" + keyCode);
							closeAlertDialog();
						}
						return true;
					}
					return false;
				}
			});
			sAlertDialog = builder.create();
			sAlertDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showCannotCloseAlertDialog(Context context, String msg,
			final DialogInterface.OnClickListener positiveListener) {
		try {
			closeAlertDialog();

			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(sIconId);
			builder.setTitle(sTitleId);
			builder.setMessage(msg);
			builder.setPositiveButton(sOkBtnStringId, positiveListener);
			builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					// closeAlertDialog();
					return;
				}
			});

			builder.setOnKeyListener(new OnKeyListener() {
				@Override
				public boolean onKey(DialogInterface dialog, int keyCode,
						KeyEvent event) {
					return true;
				}
			});

			sAlertDialog = builder.create();
			sAlertDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAlertDialog(Context context, int textResId,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {
		showAlertDialog(context, context.getString(textResId),
				positiveListener, negativeListener);
	}

	public static void showAlertDialog(Context context, String msg,
			final DialogInterface.OnClickListener positiveListener,
			final DialogInterface.OnClickListener negativeListener) {
		try {
			closeAlertDialog();
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setIcon(sIconId);
			builder.setTitle(sTitleId);
			builder.setMessage(msg);
			builder.setPositiveButton(sOkBtnStringId, positiveListener);
			builder.setNegativeButton(sCancelBtnStringId, negativeListener);
			builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					closeAlertDialog();
				}
			});

			sAlertDialog = builder.create();
			sAlertDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showProgressDialog(Context context, int msgId) {
		Log.d(TAG, "showProgressDialog");
		showProgressDialog(context, context.getString(msgId));
	}

	public static void showProgressDialog(Context context, String msg) {
		showProgressDialog(context, msg, -1);
	}

	public static void showProgressDialog(Context context, int msgId,
			long maxWaitTime) {
		showProgressDialog(context, context.getString(msgId), maxWaitTime);
	}

	public static void showProgressDialog(Context context, String msg,
			long maxWaitTime) {
		if (isProgressDialogShowing()) {
			setProgressMsg(msg);
		} else {
			try {

				sProgressDialog = ProgressDialog.show(context,
						context.getString(sPrgrsTitleId), msg, false, false);

				if (maxWaitTime > THRESHOLD_TIME) {
					sTimer = new Timer();
					sTimer.schedule(new TimerTask() {
						@Override
						public void run() {
							closeProgressDialog();
						}
					}, maxWaitTime);
				}
			} catch (Exception e) {
				// LogUtils.d(TAG, "showProgressDialog", e);
			}
		}
	}

	public static void setProgressMsg(String msg) {
		if (sProgressDialog != null) {
			sProgressDialog.setMessage(msg);
		}
	}

	public static void setProgressMsg(Context context, int textResId) {
		if (sProgressDialog != null) {
			sProgressDialog.setMessage(context.getString(textResId));
		}
	}

	public static void closeProgressDialog() {
		Log.d(TAG, "closeProgressDialog");
		try {
			if (sProgressDialog != null) {
				sProgressDialog.dismiss();
				sProgressDialog = null;
			}

			if (sTimer != null) {
				sTimer.cancel();
				sTimer = null;
			}
		} catch (Exception e) {
			// LogUtils.e(TAG, "close Progress Dialog:" + e.toString(), e);
		}
	}

	public static boolean isProgressDialogShowing() {
		return (sProgressDialog != null && sProgressDialog.isShowing());
	}

	public static boolean isAlertDialogShowing() {
		return (sAlertDialog != null && sAlertDialog.isShowing());
	}

	public static boolean isDialogShowing() {
		return (sProgressDialog != null && sProgressDialog.isShowing())
				|| (sAlertDialog != null && sAlertDialog.isShowing());
	}

	public static void setDlgIcon(int sIconId) {
		PromptUtils.sIconId = sIconId;
	}

	public static void setsDigTitle(int sTitleId) {
		PromptUtils.sTitleId = sTitleId;
	}

	public static void setPositiveBtnId(int sPositiveStringId) {
		PromptUtils.sOkBtnStringId = sPositiveStringId;
	}

	public static void setNegativeBtnId(int sNegativeStringId) {
		PromptUtils.sCancelBtnStringId = sNegativeStringId;
	}

	public static void setWarnType(int warnType) {
		PromptUtils.sWarnType = warnType;
	}

	public static void setToastDuration(int toastDuration) {
		PromptUtils.sToastDuration = toastDuration;
	}

	/**
	 * @param msg
	 * @param context
	 */
	private static void showToast(String msg, Context context) {
		Toast.makeText(context, msg, sToastDuration).show();
	}

	private static PromptUtils sIntance;
	private static Context mContext;

	public static PromptUtils getInstance() {
		if (sIntance == null) {
			sIntance = new PromptUtils();
		}
		mContext = AppCtx.getInstance();
		return sIntance;
	}
}
