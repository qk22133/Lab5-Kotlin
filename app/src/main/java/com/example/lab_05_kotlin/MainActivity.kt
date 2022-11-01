package com.example.lab_05_kotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //連接button元件
        val btn = findViewById<Button>(R.id.button)
        //btn點擊事件
        btn.setOnClickListener(){
            val dialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消", DialogInterface.OnClickListener{ dialog, which ->
                    Toast.makeText(this,"dialog關閉", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("自定義Toast", DialogInterface.OnClickListener{ dialog, which ->
                    showToast()
                })
                .setPositiveButton("顯示list", DialogInterface.OnClickListener{ dialog, i ->
                    showListDialog()
                })
                .show()
        }
    }

    private fun showToast(){

        val layout = this.layoutInflater.inflate(
            R.layout.custom_toast,
            this.findViewById(R.id.custom_toast_root)
        )
        val toast = Toast.makeText(this,"test",Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,50)
        toast.view = layout
        toast.show()


    }

    private fun showListDialog(){
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
            .setTitle("使用LIST呈現")
            .setItems(list,DialogInterface.OnClickListener { dialog, i ->
                Toast.makeText(this,"你選的是"+list[i],Toast.LENGTH_SHORT).show()
            })
            .show()
    }
}