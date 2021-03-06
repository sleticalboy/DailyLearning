package com.sleticalboy.learning.camera.v1

import android.Manifest.permission
import android.graphics.SurfaceTexture
import android.util.Log
import android.view.TextureView
import android.widget.ImageButton
import com.sleticalboy.learning.R
import com.sleticalboy.learning.base.BaseActivity
import com.sleticalboy.learning.camera.CameraManager
import com.sleticalboy.learning.camera.CameraManager.OnPictureTakenCallback
import com.sleticalboy.learning.camera.CameraManager.SimpleSurfaceTextureListener
import java.io.File

/**
 * Created on 18-2-27.
 *
 * @author leebin
 * @version 1.0
 */
class LiveCameraActivity : BaseActivity() {

    override fun logTag(): String = "LiveCamera"

    override fun layoutResId(): Int {
        return R.layout.activity_live_camera
    }

    override fun initView() {
        val liveView = findViewById<TextureView>(R.id.mLiveView)
        liveView.surfaceTextureListener = object : SimpleSurfaceTextureListener() {
            override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
                rxPerm!!.request(permission.CAMERA)
                        .subscribe { granted: Boolean ->
                            if (granted) {
                                CameraManager.getInstance().startPreview(surface)
                            }
                        }
            }
        }
        findViewById<ImageButton>(R.id.mTakePicBtn)
                .setOnClickListener {
                    rxPerm!!.request(permission.WRITE_EXTERNAL_STORAGE,
                            permission.READ_EXTERNAL_STORAGE
                    ).subscribe { takePicture() }
                }
    }

    private fun takePicture() {
        // take photos
        CameraManager.getInstance().takePicture(getExternalFilesDirs(null)[0],
                object : OnPictureTakenCallback {
                    override fun onSuccess(picture: File) {
                        Log.d(logTag(), picture.path)
                    }

                    override fun onFailure(e: Throwable?) {
                        Log.e(logTag(), "onFailure: ", e)
                    }
                }
        )
    }
}