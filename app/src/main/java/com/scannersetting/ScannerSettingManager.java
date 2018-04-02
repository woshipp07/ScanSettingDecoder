package com.scannersetting;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.os.Handler;

import com.activity.MainActivity;
import com.utils.JsonUtils;
import com.zltd.industry.ScannerManager;
/**
 * Created by lipeng on 2018/3/26.
 */

public class ScannerSettingManager {
    private static ScannerSettingManager sSannerSettingManager;
    private Context mContext = null;
    private ScannerManager sScannerManager;
    private Handler mHandler;
    public static ScannerSettingManager getInstance(Context context, Handler handler) {
        if (sSannerSettingManager == null) {
            sSannerSettingManager = new ScannerSettingManager(context,handler);
        }
        return sSannerSettingManager;
    }
    private ScannerSettingManager(Context context,Handler handler){
        mContext=context;
        mHandler=handler;
        sScannerManager=ScannerManager.getInstance();
    }
    public  void SetScannerByJsonBean(String jsondata){
        scannerBean mscannerBean= JsonUtils.fromJson(jsondata,scannerBean.class);
        Log.d("lipeng", mscannerBean.toString());
        String deviceId=mscannerBean.getDeviceId();
        String model= Build.PRODUCT;
        if(deviceId==null||model==null){
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            return;
        }
        Log.d("lipeng", "deviceid="+deviceId+";"+"model"+model);
        if(!model.equals(deviceId)){
            Log.d("lipeng", "1111111111111111111111111");
         //   mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
            return ;
        }
        //设置按键扫描模式
        sScannerManager.setKeyShootEnabled(mscannerBean.isKeyShotEnable());
        //超时时间
        long keyShotTimeout=mscannerBean.getKeyShotTimeout();
        int keyShotTimeoutInt=translateFromLongtoInt(keyShotTimeout);
       sScannerManager.setKeyShootTimeout(keyShotTimeoutInt);
        //扫描头状态
        sScannerManager.scannerEnable(mscannerBean.isScannerEnable());
        //配置扫描模式
        sScannerManager.setScanMode(mscannerBean.getScannerMode());
        //配置数据传输模式
        sScannerManager.setDataTransferType(mscannerBean.getScannertransfertype());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(mscannerBean.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(mscannerBean.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(mscannerBean.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=mscannerBean.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
          //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(mscannerBean.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=mscannerBean.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=mscannerBean.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=mscannerBean.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=mscannerBean.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);

        mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_OK));
        return;
    }
    public String setScannerSettingtoJsonBean(){
        scannerBean scannerBeandata=new scannerBean();
        String model= Build.PRODUCT;

        //TelephonyManager tm =(TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
       // String model=tm.getDeviceId();
        scannerBeandata.setDeviceId(model);
        scannerBeandata.setKeyShotEnable(sScannerManager.isKeyShootEnabled());
        scannerBeandata.setKeyShotTimeout(sScannerManager.getKeyShootTimeout());
        scannerBeandata.setScannerEnable(sScannerManager.getScannerEnable());
        scannerBeandata.setScannerMode(sScannerManager.getScanMode());
        scannerBeandata.setScannertransfertype(sScannerManager.getDataTransferType());
        scannerBeandata.setScannerSoundEnable(sScannerManager.getScannerSoundEnable());
        scannerBeandata.setScannerVibrateorEnable(sScannerManager.getScannerVibratorEnable());
        scannerBeandata.setScannerDateCopyToClipboard(sScannerManager.getScanerCopyEnable());
        scannerBeandata.setScannerExtra(sScannerManager.getScannerExtra());
       // Log.d("lipeng", sScannerManager.getScannerExtra());
        scannerBeandata.setEscapeEnable(sScannerManager.getEscapeEnable());
        scannerBeandata.setScannerPrefix(sScannerManager.getScanPrefix());
        scannerBeandata.setScannerSuffix(sScannerManager.getScanSuffix());
       scannerBeandata.setCutStart(sScannerManager.getCutStart());
        scannerBeandata.setCutLenght(sScannerManager.getCutLenght());
        Log.d("lipeng", scannerBeandata.toString());
        String json=JsonUtils.toJson(scannerBeandata);
        return json;



    }
    public int translateFromLongtoInt(long longdata){
        int inta=0;
        switch ((int)longdata) {
            case 15:
                return 0;
            case 30:
                return 1;
            case 60:
                return 2;
            case 180:
                return 3;
            case 300:
                return 4;
                default:
                    return 0;

        }

    }
}
