package com.sleticalboy.learning.devices

import android.os.Bundle
import com.sleticalboy.learning.R
import com.sleticalboy.learning.base.BaseActivity
import kotlinx.android.synthetic.main.activity_devices.*

/**
 * Created on 20-2-17.
 *
 * @author sleticalboy
 * @description
 */
class DeviceAdminUI : BaseActivity() {

    private var mManager: DevicesManager? = null

    override fun prepareWork(savedInstanceState: Bundle?) {
        mManager = DevicesManager(this)
    }

    override fun layoutResId(): Int = R.layout.activity_devices

    override fun initView() {
        // activate and deactivate device admin
        activeDeviceAdmin.setOnClickListener { mManager!!.startActivate() }
        stopDeviceAdmin.setOnClickListener { mManager!!.startDeactivate() }
        // screen lock
        wayOfLock.setOnClickListener { mManager!!.setWayOfLock() }
        lockNow.setOnClickListener { mManager!!.lockScreenNow() }
        lockDelay.setOnClickListener { mManager!!.lockScreenDelay(6 * 1000) }
        // reset device
        resetDevice.setOnClickListener { mManager!!.resetDevice() }
        // forbid using camera
        forbidCamera.setOnClickListener { mManager!!.forbidCamera() }
        // reset password
        resetPassword.setOnClickListener { mManager!!.resetPassword() }
        // encrypt storage
        encryptStorage.setOnClickListener { mManager!!.encryptStorage() }
    }
}