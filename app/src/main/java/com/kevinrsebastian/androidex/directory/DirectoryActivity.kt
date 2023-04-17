package com.kevinrsebastian.androidex.directory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevinrsebastian.androidex.R
import com.kevinrsebastian.androidex.databinding.ActivityDirectoryBinding
import dagger.hilt.android.AndroidEntryPoint

/** An activity that displays and redirects to the other demo activities. */
@AndroidEntryPoint
class DirectoryActivity : AppCompatActivity() {
    companion object {
        /** Temporary variable to populate the directory list. Public due to testing. */
        var directoryItems = listOf(
            "Lorem Ipsum Sit Amet",
            "Consectetur Adipiscing Elit",
            "Donec Ultricies Tincidunt Mi",
            "Nulla Tristique Metus eu Tortori Lobortis in Posuere Lorem",
            "Cras Semper",
            "Fi Mili Sans",
            "Uis Tincidunt Tempor",
            "Vestibulum Felis",
            "Quisque d Rhoncus Nisi",
            "Donec Laoreet",
            "Iiguadalia",
            "Curabitur Nisi Augue",
            "Vivamus",
            "Mauris Imperdiet",
            "Nulla Tristique Metus"
        )
    }

    private lateinit var binding: ActivityDirectoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
    }

    private fun setUpBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_directory)

        // Directory List
        binding.directoryList.layoutManager = LinearLayoutManager(this)
        binding.directoryList.adapter = DirectoryListAdapter(directoryItems)
    }
}
