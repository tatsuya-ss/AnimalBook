package com.example.animalbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animalbook.databinding.ActivityMainBinding
import com.example.animalbook.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private lateinit var title: TitleFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupButton()
        setupTitle()
    }

    override fun onResume() {
        super.onResume()
        title.setTitle("サブ画面")
    }

    private fun setupBinding() {
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupButton() {
        binding.lionButton.setOnClickListener {
            // フラグメントをアクティビティに表示するための処理
            supportFragmentManager.beginTransaction().apply {
                // フラグメントの入れ替え
                // R.idはXMLリソースファイルからのidを取得してる
                // R.id.containerにLionFragmentを格納して表示
                replace(R.id.container, LionFragment())
                // 今回のフラグメントの処理をバックスタックに追加
                // 端末の戻るボタンで１つ前の状態を表示できる
                addToBackStack(null)
                // フラグメントへの操作を確定
                commit()
            }
        }

        binding.HippoButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, HippoFragment())
                addToBackStack(null)
                commit()
            }
        }

        binding.giraffeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, GiraffeFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun setupTitle() {
        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, title)
            commit()
        }
    }

}