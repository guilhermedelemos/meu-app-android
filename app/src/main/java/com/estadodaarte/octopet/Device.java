package com.estadodaarte.octopet;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import static android.Manifest.permission.READ_PHONE_STATE;

public class Device extends BaseClass {

    private Context context;
    private TelephonyManager telephonyManager;

    public final String PHONE_TYPE_NONE = "NONE";
    public final String PHONE_TYPE_GSM  = "GSM";
    public final String PHONE_TYPE_CDMA = "CDMA";
    public final String PHONE_TYPE_SIP  = "SIP";

    public Device(Context context) {
        super();
        this.context     = context;
        telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * Returns the International Mobile Equipment Identity (IMEI) or empty string if it's not available.
     * Requires the READ_PHONE_STATE permission.
     * @return
     */
    public String getImei() {
        String result = null;
        try {
            if ( this.context.checkPermission(READ_PHONE_STATE, android.os.Process.myPid(), android.os.Process.myUid()) == android.content.pm.PackageManager.PERMISSION_GRANTED ) {
                if ( android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
                    result = this.telephonyManager.getImei();
                } else {
                    result = this.telephonyManager.getDeviceId();
                }
            }
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

    /**
     * Returns the Mobile Equipment Identifier (MEID) or empty string if it's not available.
     * Requires the READ_PHONE_STATE permission.
     * @return
     */
    public String getMEID() {
        String result = null;
        try {
            if ( this.context.checkPermission(READ_PHONE_STATE, android.os.Process.myPid(), android.os.Process.myUid()) == android.content.pm.PackageManager.PERMISSION_GRANTED ) {
                if ( android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
                    result = this.telephonyManager.getMeid();
                } else {
                    result = this.telephonyManager.getDeviceId();
                }
            }
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

    /**
     * Returns the software version number for the device or empty string otherwise.
     * Requires the READ_PHONE_STATE permission.
     * @return
     */
    public String getSoftwareVersion() {
        String result = null;
        try {
            result = this.telephonyManager.getDeviceSoftwareVersion();
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

    public String getGroup() {
        String result = null;
        try {
            if ( android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 ) {
                return this.telephonyManager.getGroupIdLevel1();
            }
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

    public String getLine() {
        String result = null;
        try {
            result = this.telephonyManager.getLine1Number();
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

    /**
     * Returns the ISO country code equivalent of the Mobile Country Code (MCC).
     * @return ISO country code or empty string.
     */
    public String getNetworkCountryIso() {
        String result = null;
        result = this.telephonyManager.getNetworkCountryIso();
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    public String getNetworkOperator() {
        String result = null;
        result = this.telephonyManager.getNetworkOperator();
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    public String getNetworkOperatorName() {
        String result = null;
        result = this.telephonyManager.getNetworkOperatorName();
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    /**
     * Returns a constant indicating the device phone type. This indicates the type of radio used to transmit voice calls.
     * @return
     */
    public int getPhoneType () {
        return this.telephonyManager.getPhoneType();
    }

    /**
     * Returns a constant indicating the device phone type. This indicates the type of radio used to transmit voice calls.
     * @return
     */
    public String getPhoneTypeName () {
        if(this.telephonyManager.getPhoneType() == this.telephonyManager.PHONE_TYPE_NONE) {
            return this.PHONE_TYPE_NONE;
        } else if(this.telephonyManager.getPhoneType() == this.telephonyManager.PHONE_TYPE_GSM) {
            return this.PHONE_TYPE_GSM;
        } else if(this.telephonyManager.getPhoneType() == this.telephonyManager.PHONE_TYPE_CDMA) {
            return this.PHONE_TYPE_CDMA;
        } else if(this.telephonyManager.getPhoneType() == this.telephonyManager.PHONE_TYPE_SIP) {
            return this.PHONE_TYPE_SIP;
        } else {
            return this.PHONE_TYPE_NONE;
        }
    }

    public String getDeviceBrand() {
        return Build.BRAND;
    }

    public String getDeviceFingerprint() {
        return Build.FINGERPRINT;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getDeviceSerial() {
        return Build.SERIAL;
    }

    public String getDeviceAndroidRelease() {
        return Build.VERSION.RELEASE;
    }

    public String getOsName() {
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.BASE) {
            return "Alpha";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.BASE_1_1) {
            return "Beta";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.CUPCAKE) {
            return "Cupcake";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.DONUT) {
            return "Donut";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR) {
            return "Eclair";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR_0_1) {
            return "Eclair";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ECLAIR_MR1) {
            return "Eclair";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.FROYO) {
            return "Froyo";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD) {
            return "Gingerbread";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD_MR1) {
            return "Gingerbread";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB) {
            return "Honeycomb";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB_MR1) {
            return "Honeycomb";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB_MR2) {
            return "Honeycomb";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return "Ice Cream Sandwich";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            return "Ice Cream Sandwich";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN) {
            return "Jelly Bean";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return "Jelly Bean";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return "Jelly Bean";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            return "KitKat";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT_WATCH) {
            return "KitKat";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            return "Lollipop";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1) {
            return "Lollipop";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            return "Marshmallow";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            return "Nougat";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
            return "Nougat";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            return "Oreo";
        } else if(Build.VERSION.SDK_INT == Build.VERSION_CODES.CUR_DEVELOPMENT) {
            return "DEVELOPMENT";
        } else {
            return "UNKNOWN";
        }
    }

    public String getSimOperator() {
        String result = null;
        if (this.telephonyManager.getSimState() == this.telephonyManager.SIM_STATE_READY) {
            result = this.telephonyManager.getSimOperator();
        }
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    public String getSimOperatorName() {
        String result = null;
        if (this.telephonyManager.getSimState() == this.telephonyManager.SIM_STATE_READY) {
            result = this.telephonyManager.getSimOperatorName();
        }
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }

    public String getSimSerialNumber() {
        String result = null;
        try {
            if ( this.context.checkPermission(READ_PHONE_STATE, android.os.Process.myPid(), android.os.Process.myUid()) == android.content.pm.PackageManager.PERMISSION_GRANTED ) {
                result = this.telephonyManager.getSimSerialNumber();
            }
            if (result == null) {
                return "";
            } else {
                return result;
            }
        } catch(SecurityException e) {
            return "";
        }
    }

}
