package com.rajnish.presonalstudy
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rajnish.presonalstudy.databinding.ActivityLoginPageBinding
import com.rajnish.presonalstudy.db.UserProfile
class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>
    var selectedImageUri: String ?= null
    private lateinit var db : DatabaseReference
   private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db=FirebaseDatabase.getInstance().reference.child("User Profile")
        sharedPreferences = applicationContext.getSharedPreferences("MyPref",Context.MODE_PRIVATE)
        if (sharedPreferences.contains("emailId")){

            val intent = Intent(this,DashboardPage::class.java)
            startActivity(intent)
        }
        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                selectedImageUri = result.data?.data.toString()
               binding.imageViewProfilePic.setImageURI(result?.data?.data)
            }
        }
        binding.btnSelectProfilePic.setOnClickListener {
            openImagePicker()
        }
        binding.btnSignUp.setOnClickListener {
            addProfile()

        }
    }
    fun addProfile(){
        val firstName = binding.edFirstName.text.toString()
        val emailId = binding.edEmailId.text.toString()
        val bio = binding.editTextBio.text.toString()

        db.child(emailId).setValue(UserProfile(firstName,emailId,bio,selectedImageUri!!)).addOnSuccessListener {
            saveLoginCridential()
            val intent = Intent(this,DashboardPage::class.java)
            startActivity(intent)
        }
    }
    @SuppressLint("IntentReset")
    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        imagePickerLauncher.launch(intent)
    }
    fun saveLoginCridential(){
        val editor = sharedPreferences.edit()
        editor.putString("emailId",binding.edEmailId.text.toString())
        editor.apply()
    }

}