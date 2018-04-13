package com.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.google.zxing.WriterException;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.encoding.EncodingHandler;
import com.qrcodescan.R;
import com.scannersetting.ScannerSettingManager;
import com.uidialog.QrCodeDialog;
import com.utils.CommonUtil;
import com.utils.PromptUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fileImport)
    LinearLayout file_Import;
    @BindView(R.id.qrCodeImport)
    LinearLayout qrCode_Import;
    @BindView(R.id.fileEmport)
    LinearLayout file_Emport;
    @BindView(R.id.qrcodeEmport)
    LinearLayout qrcode_Emport;
    //打开扫描界面请求码
    private int REQUEST_CODE = 0x01;
    //扫描成功返回码
    private int RESULT_OK = 0xA1;
    public static final int QRCODE_IMPORT_OK=0x10;
    public static final int QRCODE_IMPORT_ERROR=0x11;
    public static final int QRCODE_IMPORT_DEVICE_MISMATCH=0x12;

    private Handler uihandler =new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case QRCODE_IMPORT_OK:
                   // PromptUtils.closeProgressDialog();
                    Log.d("lipeng", "111111111111111111111111");
                    PromptUtils.showProgressDialog(MainActivity.this,"导入设置成功",1500);
                    break;
                case QRCODE_IMPORT_ERROR:
                    //PromptUtils.closeProgressDialog();
                   PromptUtils.showProgressDialog(MainActivity.this,"导入设置失败",1500);
                   break;
                   case QRCODE_IMPORT_DEVICE_MISMATCH:
                      // PromptUtils.closeProgressDialog();
                    Log.d("lipeng", "QRCODE_IMPORT_DEVICE_MISMATCH ");
                    PromptUtils.showProgressDialog(MainActivity.this,"设备不匹配，导入失败",1500);
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults.length>=1){
                int cameraResult=grantResults[0];
                boolean cameraGranted=cameraResult==PackageManager.PERMISSION_GRANTED;
                if(cameraGranted){
                    if(CommonUtil.isCameraCanUse())
                    {
                        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "您没有授权该权限，请在设置中打开授权", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode==2){
            {
                if(grantResults.length>=1){
                    int readExternalResult=grantResults[0];
                    boolean readExternalGranted=readExternalResult==PackageManager.PERMISSION_GRANTED;
                    if(readExternalGranted){
                        fileEmport();
                        }else{
                        Toast.makeText(MainActivity.this, "您没有授权该权限，请在设置中打开授权", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }else if(requestCode==3){
            {
                if(grantResults.length>=1){
                    int writeExternalResult=grantResults[0];
                    boolean writeExternalGranted=writeExternalResult==PackageManager.PERMISSION_GRANTED;
                    if(writeExternalGranted){
                        fileImport();
                    }else{
                        Toast.makeText(MainActivity.this, "您没有授权该权限，请在设置中打开授权", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @OnClick({R.id.fileImport, R.id.qrCodeImport,R.id.fileEmport,R.id.qrcodeEmport})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qrCodeImport:
                //打开二维码扫描界面從， cC
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
                    {
                        if(CommonUtil.isCameraCanUse())
                            {
                                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                                startActivityForResult(intent, REQUEST_CODE);
                            }
                    }else{
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
                    }
                }else{
                    if(CommonUtil.isCameraCanUse())
                    {
                        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                }


                break;
            case R.id.qrcodeEmport:
                String str=ScannerSettingManager.getInstance(MainActivity.this,this.uihandler).getScannerSettingtoJsonBean();
                if(str==null){
                    PromptUtils.showProgressDialog(MainActivity.this,"设备不匹配",1500);
                    return;
                }
                if (str!=null&&!"".equals(str.trim())){
                   // Bitmap mBitmap = EncodingHandler.createQRCode(str, 500);
                    try {
                        Bitmap mBitmap=EncodingHandler.createQRCode(str,500);
                        QrCodeDialog.Builder dialogBuild=new QrCodeDialog.Builder(MainActivity.this);
                        dialogBuild.setImage(mBitmap);
                        QrCodeDialog dialog=dialogBuild.create();
                        //设置和屏幕同样的宽高
                        Window dialogWindow = dialog.getWindow();
                        WindowManager.LayoutParams lp=dialog.getWindow().getAttributes();
                        DisplayMetrics d = getResources().getDisplayMetrics();
                        lp.height=d.heightPixels;
                        lp.width=d.widthPixels;
                        dialogWindow.setAttributes(lp);

                        dialog.setCanceledOnTouchOutside(true);
                        dialog.show();
                    }catch (WriterException e){
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.fileEmport:
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                        fileEmport();
                    }else{
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
                    }
                }else{
                    fileEmport();
                }

                break;
            case R.id.fileImport:
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                        fileImport();
                    }else{
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
                    }
                }else{
                    fileImport();
                }
                break;
        }
    }
    private void fileImport(){
        String filePathImport= Environment.getExternalStorageDirectory().toString()+"/scanSettingJsonDate.json";
        final File file=new File(filePathImport);
        PromptUtils.showProgressDialog(MainActivity.this,"扫描设置正在导入");
        if(file.exists()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FileInputStream fis=null;
                    InputStreamReader isr=null;
                    BufferedReader bf=null;
                    StringBuffer sb=null;
                    try {
                        fis=new FileInputStream(file);
                        isr= new InputStreamReader(fis);
                        bf=new BufferedReader(isr);
                        String line;
                        sb=new StringBuffer();
                        while((line=bf.readLine())!=null){
                            sb.append(line);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }finally {
                        try {
                            fis.close();
                            isr.close();
                            bf.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    //  PromptUtils.showProgressDialog(MainActivity.this,"扫描设置正在导入");
                    ScannerSettingManager.getInstance(MainActivity.this,uihandler).SetScannerByJsonBean(sb.toString());
                }
            }).start();
        }else{
            PromptUtils.showProgressDialog(MainActivity.this,"导入文件不存在",1500);
        }
    }
    private void fileEmport(){
        String strFile=ScannerSettingManager.getInstance(MainActivity.this,this.uihandler).getScannerSettingtoJsonBean();
        if(strFile==null){
            PromptUtils.showProgressDialog(MainActivity.this,"设备不匹配",1500);
            return;
        }
        String filePathExport= Environment.getExternalStorageDirectory().toString()+"/scanSettingJsonDate.json";
        FileOutputStream fos=null;
         try {
             fos=new FileOutputStream(filePathExport);
            fos.write(strFile.getBytes());

            PromptUtils.showProgressDialog(MainActivity.this,"文件导出成功",1500);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
         }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            final String scanResult = bundle.getString("qr_scan_result");
           PromptUtils.showProgressDialog(MainActivity.this,"扫描设置正在导入");
            //将扫描出的信息显示出来
          //  qrCodeText.setText(scanResult);
            new Thread(new Runnable() {
                @Override
                public void run() {
                  //  PromptUtils.showProgressDialog(MainActivity.this,"扫描设置正在导入");
                    ScannerSettingManager.getInstance(MainActivity.this,uihandler).SetScannerByJsonBean(scanResult);
                }
            }).start();

        }
    }
}
