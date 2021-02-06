package com.binlee.sample;

import androidx.annotation.IntDef;

/**
 * Created on 21-2-5.
 *
 * @author binlee sleticalboy@gmail.com
 */
public interface IEvent {

    int ULTRA_SCAN = 0x01;
    int REBOOT_SCAN = 0x02;
    int USB_SCAN = 0x03;
    int STOP_SCAN = 0x04;

    int ULTRA_CONNECT = 0x05;
    int REBOOT_CONNECT = 0x06;
    int USB_CONNECT = 0x07;
    int CLICK_CONNECT = 0x08;
    int CONFIG_CONNECT = 0x09;

    int CLICK_DISCONNECT = 0x10;
    int UNBIND_DISCONNECT = 0x11;
    int OTHER_DISCONNECT = 0x12;

    @IntDef({ULTRA_SCAN, REBOOT_SCAN, USB_SCAN, STOP_SCAN,
            ULTRA_CONNECT, REBOOT_CONNECT, USB_CONNECT, CLICK_CONNECT, CONFIG_CONNECT,
            CLICK_DISCONNECT, UNBIND_DISCONNECT, OTHER_DISCONNECT
    })
    @interface Type {}

    @Type
    int type();
}