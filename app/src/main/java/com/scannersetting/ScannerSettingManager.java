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
        String model= Build.PRODUCT;
        int OneOrTwo=sScannerManager.getDecoderType();
        if(OneOrTwo!=4&&OneOrTwo!=5&&OneOrTwo!=1){
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            return ;
        }
        if( model.equals("n5")){
            //如果是5.1系统的设备
            if(OneOrTwo==4){
                //一维的设备
                scannerBean6735One mscannerBean6735One= JsonUtils.fromJson(jsondata,scannerBean6735One.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6735One==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6735One.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6735One.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6735One(mscannerBean6735One);

            }else if(OneOrTwo==5){
                scannerBean6735MoteTwo mscannerBean6735MotoTwo= JsonUtils.fromJson(jsondata,scannerBean6735MoteTwo.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6735MotoTwo==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6735MotoTwo.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6735MotoTwo.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6735MotoTwo(mscannerBean6735MotoTwo);
                //二维摩托的设备

            }else if(OneOrTwo==1){
                scannerBean6735HoneyWellTwo mscannerBean6735HoneyWellTwo= JsonUtils.fromJson(jsondata,scannerBean6735HoneyWellTwo.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6735HoneyWellTwo==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6735HoneyWellTwo.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6735HoneyWellTwo.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6735HoneyWellTwo(mscannerBean6735HoneyWellTwo);
            }
            else{
                mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                return;
            }
        }else if(model.equals("n5-6737")){
            //如果是7.0系统的设备
            if(OneOrTwo==4){
                //一维的设备
                //一维的设备
                scannerBean6737One mscannerBean6737One= JsonUtils.fromJson(jsondata,scannerBean6737One.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6737One==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6737One.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6737One.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6737One(mscannerBean6737One);

            }else if(OneOrTwo==5){
                //二维摩托的设备
                scannerBean6737MoteTwo mscannerBean6737MoteTwo= JsonUtils.fromJson(jsondata,scannerBean6737MoteTwo.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6737MoteTwo==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6737MoteTwo.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6737MoteTwo.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6737MoteTwo(mscannerBean6737MoteTwo);

            }else if(OneOrTwo==1){
                //二维霍尼的设备
                scannerBean6737HoneyWellTwo mscannerBean6737HoneyWellTwo= JsonUtils.fromJson(jsondata,scannerBean6737HoneyWellTwo.class);
                //Log.d("lipeng", mscannerBean.toString());
                if (mscannerBean6737HoneyWellTwo==null){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                    return;
                }
                if(!model.equals(mscannerBean6737HoneyWellTwo.getDeviceId())){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                if(OneOrTwo!=mscannerBean6737HoneyWellTwo.getOneorTwo()){
                    mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_DEVICE_MISMATCH));
                    return;
                }
                SetScannerByJsonBean6737HoneyWellTwo(mscannerBean6737HoneyWellTwo);
            }else {
                mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
                return;
            }
        }else {
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            return;
        }
        mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_OK));
        return;
    }
    public String getScannerSettingtoJsonBean(){
        String model= Build.PRODUCT;
        int OneOrTwo=sScannerManager.getDecoderType();
        if(OneOrTwo!=4&&OneOrTwo!=5&&OneOrTwo!=1){
            return null;
        }
        if( model.equals("n5")){
            //如果是5.1系统的设备
            if(OneOrTwo==4){
                //一维的设备
                String json=getScannerSettingtoJsonBean6735One();
                return json;
            }else if(OneOrTwo==5){
                //摩托二维的设备
                String json=getScannerSettingtoJsonBean6735MotoTwo();
                return json;

            }else if(OneOrTwo==1){
                //霍尼二维的设备
                String json=getScannerSettingtoJsonBean6735HoneyWellTwo();
                return json;
            }
            }else if(model.equals("n5-6737")){
            //如果是7.0系统的设备
            if(OneOrTwo==4){
                //一维的设备
                String json=getScannerSettingtoJsonBean6737One();
                return json;

            }else if(OneOrTwo==5){
                //二维摩托的设备
                String json=getScannerSettingtoJsonBean6737MoteTwo();
                return json;

            }else if(OneOrTwo==1){
                //二维霍尼的设备
                String json=getScannerSettingtoJsonBean6737HoneyWellTwo();
                return json;
            }
        }else {
            return null;
        }
        return null;
        }

        private void SetScannerByJsonBean6737MoteTwo(scannerBean6737MoteTwo Bean6737MoteTwo){
        sScannerManager.setKeyShootEnabled(Bean6737MoteTwo.isKeyShotEnable());
        //超时时间
        long keyShotTimeout=Bean6737MoteTwo.getKeyShotTimeout();
        int keyShotTimeoutInt=translateFromLongtoInt(keyShotTimeout);
        sScannerManager.setKeyShootTimeout(keyShotTimeoutInt);
        //配置扫描模式
        sScannerManager.setScanMode(Bean6737MoteTwo.getScannerMode());

        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6737MoteTwo.getScannertransfertype());
        //设置连扫间隔时间
        sScannerManager.setScanTimeInterval(Bean6737MoteTwo.getScannerInterval());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6737MoteTwo.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6737MoteTwo.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6737MoteTwo.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6737MoteTwo.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6737MoteTwo.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6737MoteTwo.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6737MoteTwo.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6737MoteTwo.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6737MoteTwo.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
        sScannerManager.setScanShowType(Bean6737MoteTwo.isScannerShowType());
        sScannerManager.setLaunchBrowserEnable(Bean6737MoteTwo.isLaunchBrowser());
    }
    private void SetScannerByJsonBean6737HoneyWellTwo(scannerBean6737HoneyWellTwo Bean6737HoneyWellTwo){
        sScannerManager.setKeyShootEnabled(Bean6737HoneyWellTwo.isKeyShotEnable());
        //超时时间
        long keyShotTimeout=Bean6737HoneyWellTwo.getKeyShotTimeout();
        int keyShotTimeoutInt=translateFromLongtoInt(keyShotTimeout);
        sScannerManager.setKeyShootTimeout(keyShotTimeoutInt);
        //配置扫描模式
        sScannerManager.setScanMode(Bean6737HoneyWellTwo.getScannerMode());
        sScannerManager.setAccurateScan(Bean6737HoneyWellTwo.getAccurateScan());
        sScannerManager.setFlashMode(Bean6737HoneyWellTwo.getFlashMode());
        sScannerManager.setFlashLevel((int)Bean6737HoneyWellTwo.getFlashLevel());
        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6737HoneyWellTwo.getScannertransfertype());
        //设置连扫间隔时间
        sScannerManager.setScanTimeInterval(Bean6737HoneyWellTwo.getScannerInterval());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6737HoneyWellTwo.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6737HoneyWellTwo.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6737HoneyWellTwo.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6737HoneyWellTwo.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6737HoneyWellTwo.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6737HoneyWellTwo.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6737HoneyWellTwo.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6737HoneyWellTwo.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6737HoneyWellTwo.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
        sScannerManager.setScanShowType(Bean6737HoneyWellTwo.isScannerShowType());
        sScannerManager.setLaunchBrowserEnable(Bean6737HoneyWellTwo.isLaunchBrowser());
    }
    private void SetScannerByJsonBean6735HoneyWellTwo(scannerBean6735HoneyWellTwo Bean6735HoneyWellTwo){
        sScannerManager.setKeyShootEnabled(Bean6735HoneyWellTwo.isKeyShotEnable());

        //配置扫描模式
        sScannerManager.setScanMode(Bean6735HoneyWellTwo.getScannerMode());
        sScannerManager.setAccurateScan(Bean6735HoneyWellTwo.getAccurateScan());
        sScannerManager.setFlashMode(Bean6735HoneyWellTwo.getFlashMode());
        sScannerManager.setFlashLevel((int)Bean6735HoneyWellTwo.getFlashLevel());
        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6735HoneyWellTwo.getScannertransfertype());
        //设置连扫间隔时间
        sScannerManager.setScanTimeInterval(Bean6735HoneyWellTwo.getScannerInterval());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6735HoneyWellTwo.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6735HoneyWellTwo.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6735HoneyWellTwo.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6735HoneyWellTwo.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6735HoneyWellTwo.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6735HoneyWellTwo.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6735HoneyWellTwo.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6735HoneyWellTwo.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6735HoneyWellTwo.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
        sScannerManager.setScanShowType(Bean6735HoneyWellTwo.isScannerShowType());
    }

    private void SetScannerByJsonBean6735MotoTwo(scannerBean6735MoteTwo Bean6735MotoTwo){
        sScannerManager.setKeyShootEnabled(Bean6735MotoTwo.isKeyShotEnable());

        //配置扫描模式
        sScannerManager.setScanMode(Bean6735MotoTwo.getScannerMode());
        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6735MotoTwo.getScannertransfertype());
        //设置连扫间隔时间
        sScannerManager.setScanTimeInterval(Bean6735MotoTwo.getScannerInterval());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6735MotoTwo.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6735MotoTwo.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6735MotoTwo.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6735MotoTwo.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6735MotoTwo.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6735MotoTwo.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6735MotoTwo.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6735MotoTwo.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6735MotoTwo.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
        sScannerManager.setScanShowType(Bean6735MotoTwo.isScannerShowType());
    }
    private void SetScannerByJsonBean6737One(scannerBean6737One Bean6737One){
        sScannerManager.setKeyShootEnabled(Bean6737One.isKeyShotEnable());

        //超时时间
        long keyShotTimeout=Bean6737One.getKeyShotTimeout();
        int keyShotTimeoutInt=translateFromLongtoInt(keyShotTimeout);
        sScannerManager.setKeyShootTimeout(keyShotTimeoutInt);
        //扫描头状态
        sScannerManager.scannerEnable(Bean6737One.isScannerEnable());
        //配置扫描模式
        sScannerManager.setScanMode(Bean6737One.getScannerMode());
        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6737One.getScannertransfertype());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6737One.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6737One.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6737One.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6737One.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6737One.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6737One.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6737One.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6737One.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6737One.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
        sScannerManager.setLaunchBrowserEnable(Bean6737One.isLaunchBrowser());
    }
    private void SetScannerByJsonBean6735One(scannerBean6735One Bean6735One){
        sScannerManager.setKeyShootEnabled(Bean6735One.isKeyShotEnable());

        //超时时间
        long keyShotTimeout=Bean6735One.getKeyShotTimeout();
        int keyShotTimeoutInt=translateFromLongtoInt(keyShotTimeout);
        sScannerManager.setKeyShootTimeout(keyShotTimeoutInt);
        //扫描头状态
        sScannerManager.scannerEnable(Bean6735One.isScannerEnable());
        //配置扫描模式
        sScannerManager.setScanMode(Bean6735One.getScannerMode());
        //配置数据传输模式
        sScannerManager.setDataTransferType(Bean6735One.getScannertransfertype());
        //是否启动声音
        sScannerManager.setScannerSoundEnable(Bean6735One.isScannerSoundEnable());
        //是否启动震动
        sScannerManager.setScannerVibratorEnable(Bean6735One.isScannerVibrateorEnable());
        //设置是否复制到剪切板
        sScannerManager.setScanerCopyEnable(Bean6735One.isScannerDateCopyToClipboard());
        //设置添加后缀
        String scannerExtra=Bean6735One.getScannerExtra();
        if(scannerExtra==null){
            Log.d("lipeng", "2222222222222222222222222");
            mHandler.sendMessage(mHandler.obtainMessage(MainActivity.QRCODE_IMPORT_ERROR));
            //  return;
        }
        Log.d("lipeng", "333333333333");
        sScannerManager.setScannerExtra(scannerExtra);
        //设置是否启动转义字符功能
        sScannerManager.setEscapeEnable(Bean6735One.isEscapeEnable());
        //设置扫码前缀
        String scannerPrefix=Bean6735One.getScannerPrefix();
        sScannerManager.setScanPrefix(scannerPrefix);
        //设置扫码后缀
        String scannerSuffix=Bean6735One.getScannerSuffix();
        sScannerManager.setScanSuffix(scannerSuffix);
        //设置数据截取
        int dataCutStart=Bean6735One.getCutStart();
        sScannerManager.setCutStart(dataCutStart);
        int datacutLenght=Bean6735One.getCutLenght();
        sScannerManager.setCutLegnht(datacutLenght);
    }
    private String getScannerSettingtoJsonBean6737HoneyWellTwo(){
        scannerBean6737HoneyWellTwo scannerBeandata=new scannerBean6737HoneyWellTwo();
        scannerBeandata.setDeviceId("n5-6737");
        scannerBeandata.setOneorTwo(1);
        scannerBeandata.setKeyShotEnable(sScannerManager.isKeyShootEnabled());
        //超时时间
        scannerBeandata.setKeyShotTimeout(sScannerManager.getKeyShootTimeout());
        scannerBeandata.setAccurateScan(sScannerManager.getAccurateScan());
        scannerBeandata.setScannerMode(sScannerManager.getScanMode());
        scannerBeandata.setFlashMode(sScannerManager.getFlashMode());
        scannerBeandata.setFlashLevel(sScannerManager.getFlashLevel());
        scannerBeandata.setScannerInterval(sScannerManager.getScanTimeInterval());
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
        scannerBeandata.setScannerShowType(sScannerManager.getScanShowType());
        scannerBeandata.setLaunchBrowser(sScannerManager.getLaunchBrowserEnable());
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6737HoneyWellTwo=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6737HoneyWellTwo;
    }
    private String getScannerSettingtoJsonBean6737MoteTwo(){
        scannerBean6737MoteTwo scannerBeandata=new scannerBean6737MoteTwo();
        scannerBeandata.setDeviceId("n5-6737");
        scannerBeandata.setOneorTwo(5);
        scannerBeandata.setKeyShotEnable(sScannerManager.isKeyShootEnabled());
        //超时时间
        scannerBeandata.setKeyShotTimeout(sScannerManager.getKeyShootTimeout());
        scannerBeandata.setScannerMode(sScannerManager.getScanMode());
        scannerBeandata.setScannerInterval(sScannerManager.getScanTimeInterval());
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
        scannerBeandata.setScannerShowType(sScannerManager.getScanShowType());
        scannerBeandata.setLaunchBrowser(sScannerManager.getLaunchBrowserEnable());
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6737MoteTwo=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6737MoteTwo;
    }
    private String getScannerSettingtoJsonBean6737One(){
        scannerBean6737One scannerBeandata=new scannerBean6737One();
        scannerBeandata.setDeviceId("n5-6737");
        scannerBeandata.setOneorTwo(4);
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
        scannerBeandata.setLaunchBrowser(sScannerManager.getLaunchBrowserEnable());
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6737One=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6737One;
    }
    private String getScannerSettingtoJsonBean6735HoneyWellTwo(){
        scannerBean6735HoneyWellTwo scannerBeandata=new scannerBean6735HoneyWellTwo();
        scannerBeandata.setDeviceId("n5");
        scannerBeandata.setOneorTwo(1);
        scannerBeandata.setKeyShotEnable(sScannerManager.isKeyShootEnabled());
        scannerBeandata.setAccurateScan(sScannerManager.getAccurateScan());
        scannerBeandata.setScannerMode(sScannerManager.getScanMode());
        scannerBeandata.setFlashMode(sScannerManager.getFlashMode());
        scannerBeandata.setFlashLevel(sScannerManager.getFlashLevel());
        scannerBeandata.setScannerInterval(sScannerManager.getScanTimeInterval());
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
        scannerBeandata.setScannerShowType(sScannerManager.getScanShowType());
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6735HoneyWellTwo=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6735HoneyWellTwo;
    }
    private String getScannerSettingtoJsonBean6735MotoTwo(){
        scannerBean6735MoteTwo scannerBeandata=new scannerBean6735MoteTwo();
        scannerBeandata.setDeviceId("n5");
        scannerBeandata.setOneorTwo(5);
        scannerBeandata.setKeyShotEnable(sScannerManager.isKeyShootEnabled());
        scannerBeandata.setScannerMode(sScannerManager.getScanMode());
        scannerBeandata.setScannerInterval(sScannerManager.getScanTimeInterval());
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
        scannerBeandata.setScannerShowType(sScannerManager.getScanShowType());
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6735MotoTwo=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6735MotoTwo;
    }
    private String getScannerSettingtoJsonBean6735One(){
        scannerBean6735One scannerBeandata=new scannerBean6735One();
        scannerBeandata.setDeviceId("n5");
        scannerBeandata.setOneorTwo(4);
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
        Log.d("lipeng", "44444444444444444444444444444");
        //Log.d("lipeng", sScannerManager.getDecoderType()+"");
        Log.d("lipeng", scannerBeandata.toString());
        String scannerBeandata6735One=JsonUtils.toJson(scannerBeandata);
        return scannerBeandata6735One;
    }

    private int translateFromLongtoInt(long longdata){
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
