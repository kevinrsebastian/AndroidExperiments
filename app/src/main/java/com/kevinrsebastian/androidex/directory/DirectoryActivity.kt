package com.kevinrsebastian.androidex.directory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kevinrsebastian.androidex.R
import com.kevinrsebastian.androidex.databinding.ActivityDirectoryBinding
import dagger.hilt.android.AndroidEntryPoint

/** An activity that displays and redirects to the other demo activities. */
@AndroidEntryPoint
class DirectoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDirectoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_directory)
    }
}
