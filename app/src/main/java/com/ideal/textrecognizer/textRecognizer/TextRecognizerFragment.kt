package com.ideal.textrecognizer.textRecognizer

import android.net.Uri
import android.os.Bundle
import android.speech.SpeechRecognizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.ideal.textrecognizer.R
import com.ideal.textrecognizer.databinding.FragmentTextRecognizerBinding

class TextRecognizerFragment(private val uri: Uri?) :
    Fragment(R.layout.fragment_text_recognizer) {

    companion object {
        const val UriKey = "uri"
    }


    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    private var inputImage: InputImage? = null

    private var _binding: FragmentTextRecognizerBinding? = null

    private val binding: FragmentTextRecognizerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextRecognizerBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputImage = uri?.let { InputImage.fromFilePath(requireContext(), it) }
        inputImage?.let {
            recognizer.process(it).apply {
                addOnSuccessListener { text ->
                    Toast.makeText(requireContext(), text.text, Toast.LENGTH_LONG).show()
                }
                addOnFailureListener { error ->
                    Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}