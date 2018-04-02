package com.scannersetting;

/**
 * Created by lipeng on 2018/3/26.
 */

public class scannerBean {
    private String deviceId;
    private boolean keyShotEnable;
    private long keyShotTimeout;
    private boolean scannerEnable;
    private int scannerMode;
    private int scannertransfertype;
    private boolean scannerSoundEnable;
    private boolean scannerVibrateorEnable;
    private boolean scannerDateCopyToClipboard;
    private String scannerExtra;
    private boolean escapeEnable;
    private String scannerPrefix;
    private String scannerSuffix;
    private int cutStart;
    private int cutLenght;

    @Override
    public String toString() {
        return "scannerBean{" +
                "deviceId='" + deviceId + '\'' +
                ", keyShotEnable=" + keyShotEnable +
                ", keyShotTimeout=" + keyShotTimeout +
                ", scannerEnable=" + scannerEnable +
                ", scannerMode=" + scannerMode +
                ", scannertransfertype=" + scannertransfertype +
                ", scannerSoundEnable=" + scannerSoundEnable +
                ", scannerVibrateorEnable=" + scannerVibrateorEnable +
                ", scannerDateCopyToClipboard=" + scannerDateCopyToClipboard +
                ", scannerExtra='" + scannerExtra + '\'' +
                ", escapeEnable=" + escapeEnable +
                ", scannerPrefix='" + scannerPrefix + '\'' +
                ", scannerSuffix='" + scannerSuffix + '\'' +
                ", cutStart=" + cutStart +
                ", cutLenght=" + cutLenght +
                '}';
    }

    public boolean isScannerDateCopyToClipboard() {
        return scannerDateCopyToClipboard;
    }

    public void setScannerDateCopyToClipboard(boolean scannerDateCopyToClipboard) {
        this.scannerDateCopyToClipboard = scannerDateCopyToClipboard;
    }

    public int getCutStart() {
        return cutStart;
    }

    public void setCutStart(int cutStart) {
        this.cutStart = cutStart;
    }

    public int getCutLenght() {
        return cutLenght;
    }

    public void setCutLenght(int cutLenght) {
        this.cutLenght = cutLenght;
    }

    public boolean isEscapeEnable() {
        return escapeEnable;
    }

    public void setEscapeEnable(boolean escapeEnable) {
        this.escapeEnable = escapeEnable;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isKeyShotEnable() {
        return keyShotEnable;
    }

    public void setKeyShotEnable(boolean keyShotEnable) {
        this.keyShotEnable = keyShotEnable;
    }

    public long getKeyShotTimeout() {
        return keyShotTimeout;
    }

    public void setKeyShotTimeout(long keyShotTimeout) {
        this.keyShotTimeout = keyShotTimeout;
    }

    public boolean isScannerEnable() {
        return scannerEnable;
    }

    public void setScannerEnable(boolean scannerEnable) {
        this.scannerEnable = scannerEnable;
    }

    public int getScannerMode() {
        return scannerMode;
    }

    public void setScannerMode(int scannerMode) {
        this.scannerMode = scannerMode;
    }

    public int getScannertransfertype() {
        return scannertransfertype;
    }

    public void setScannertransfertype(int scannertransfertype) {
        this.scannertransfertype = scannertransfertype;
    }

    public boolean isScannerSoundEnable() {
        return scannerSoundEnable;
    }

    public void setScannerSoundEnable(boolean scannerSoundEnable) {
        this.scannerSoundEnable = scannerSoundEnable;
    }

    public boolean isScannerVibrateorEnable() {
        return scannerVibrateorEnable;
    }

    public void setScannerVibrateorEnable(boolean scannerVibrateorEnable) {
        this.scannerVibrateorEnable = scannerVibrateorEnable;
    }

    public String getScannerExtra() {
        return scannerExtra;
    }

    public void setScannerExtra(String scannerExtra) {
        this.scannerExtra = scannerExtra;
    }

    public String getScannerPrefix() {
        return scannerPrefix;
    }

    public void setScannerPrefix(String scannerPrefix) {
        this.scannerPrefix = scannerPrefix;
    }

    public String getScannerSuffix() {
        return scannerSuffix;
    }

    public void setScannerSuffix(String scannerSuffix) {
        this.scannerSuffix = scannerSuffix;
    }
}
