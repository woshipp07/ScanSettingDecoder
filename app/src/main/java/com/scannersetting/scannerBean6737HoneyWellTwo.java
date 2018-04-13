package com.scannersetting;

public class scannerBean6737HoneyWellTwo {
    private int oneorTwo;//
    private String deviceId;//
    private boolean keyShotEnable;//按键扫描模式
    private long keyShotTimeout;/////////////////////////////
    private int AccurateScan;//条码精确扫描状态
    private int scannerMode;//扫描模式
    private int  flashMode;//扫描补光模式
    private long flashLevel;//扫描亮度等级
    private long scannerInterval;//连扫间隙
    private int scannertransfertype;//数据传输模式
    private boolean scannerSoundEnable;
    private boolean scannerVibrateorEnable;
    private boolean scannerDateCopyToClipboard;//条码结果复制到剪切板
    private boolean launchBrowser;////////////////////
    private String scannerExtra;
    private boolean escapeEnable;
    private String scannerPrefix;
    private String scannerSuffix;
    private int cutStart;
    private int cutLenght;
    private boolean scannerShowType;

    public boolean isLaunchBrowser() {
        return launchBrowser;
    }

    public void setLaunchBrowser(boolean launchBrowser) {
        this.launchBrowser = launchBrowser;
    }

    @Override
    public String toString() {
        return "scannerBean6737HoneyWellTwo{" +
                "oneorTwo=" + oneorTwo +
                ", deviceId='" + deviceId + '\'' +
                ", keyShotEnable=" + keyShotEnable +
                ", keyShotTimeout=" + keyShotTimeout +
                ", AccurateScan=" + AccurateScan +
                ", scannerMode=" + scannerMode +
                ", flashMode=" + flashMode +
                ", flashLevel=" + flashLevel +
                ", scannerInterval=" + scannerInterval +
                ", scannertransfertype=" + scannertransfertype +
                ", scannerSoundEnable=" + scannerSoundEnable +
                ", scannerVibrateorEnable=" + scannerVibrateorEnable +
                ", scannerDateCopyToClipboard=" + scannerDateCopyToClipboard +
                ", launchBrowser=" + launchBrowser +
                ", scannerExtra='" + scannerExtra + '\'' +
                ", escapeEnable=" + escapeEnable +
                ", scannerPrefix='" + scannerPrefix + '\'' +
                ", scannerSuffix='" + scannerSuffix + '\'' +
                ", cutStart=" + cutStart +
                ", cutLenght=" + cutLenght +
                ", scannerShowType=" + scannerShowType +
                '}';
    }

    public long getKeyShotTimeout() {
        return keyShotTimeout;
    }

    public void setKeyShotTimeout(long keyShotTimeout) {
        this.keyShotTimeout = keyShotTimeout;
    }

    public int getOneorTwo() {
        return oneorTwo;
    }

    public void setOneorTwo(int oneorTwo) {
        this.oneorTwo = oneorTwo;
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

    public int getAccurateScan() {
        return AccurateScan;
    }

    public void setAccurateScan(int accurateScan) {
        AccurateScan = accurateScan;
    }

    public int getScannerMode() {
        return scannerMode;
    }

    public void setScannerMode(int scannerMode) {
        this.scannerMode = scannerMode;
    }

    public int getFlashMode() {
        return flashMode;
    }

    public void setFlashMode(int flashMode) {
        this.flashMode = flashMode;
    }

    public long getFlashLevel() {
        return flashLevel;
    }

    public void setFlashLevel(long flashLevel) {
        this.flashLevel = flashLevel;
    }

    public long getScannerInterval() {
        return scannerInterval;
    }

    public void setScannerInterval(long scannerInterval) {
        this.scannerInterval = scannerInterval;
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

    public boolean isScannerDateCopyToClipboard() {
        return scannerDateCopyToClipboard;
    }

    public void setScannerDateCopyToClipboard(boolean scannerDateCopyToClipboard) {
        this.scannerDateCopyToClipboard = scannerDateCopyToClipboard;
    }

    public String getScannerExtra() {
        return scannerExtra;
    }

    public void setScannerExtra(String scannerExtra) {
        this.scannerExtra = scannerExtra;
    }

    public boolean isEscapeEnable() {
        return escapeEnable;
    }

    public void setEscapeEnable(boolean escapeEnable) {
        this.escapeEnable = escapeEnable;
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

    public boolean isScannerShowType() {
        return scannerShowType;
    }

    public void setScannerShowType(boolean scannerShowType) {
        this.scannerShowType = scannerShowType;
    }
}



