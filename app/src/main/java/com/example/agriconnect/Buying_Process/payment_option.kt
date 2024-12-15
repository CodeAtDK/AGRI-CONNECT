package com.example.agriconnect.Buying_Process

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.commit
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.Farmer_Market.MarketPlace.Market_Place_Layout
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentPaymentOptionBinding


class payment_option : Fragment() {

    private var _binding: FragmentPaymentOptionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentPaymentOptionBinding.inflate(inflater,container,false)

//        Checkout.preload(context)
//        val co = Checkout()
//        co.setKeyID("")
        var option = 0
        binding.radioButton2.setOnClickListener(){

            option = 2

         //  Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()

            //initPayment()

        }
        binding.radioButton3.visibility = View.INVISIBLE
        binding.radioButton4.visibility = View.INVISIBLE
        binding.radioButton3.setOnClickListener(){

            Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()
        }
        binding.radioButton4.setOnClickListener(){

            Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()
        }

        binding.radioButton1.setOnClickListener(){

            option = 1
          //  Toast.makeText(context,"Order Confirm",Toast.LENGTH_SHORT).show()

//            parentFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace(
//                    R.id.fragment_container,
//                    Home::class.java,
//                    null
//                ) // Replace with your FragmentContainerView's ID and the new Fragment class
//                addToBackStack(null)
//
//            }
        }

        binding.buttontocnfirmyourorder.setOnClickListener(){

            if(option == 1){

                Toast.makeText(context,"Your Order is Succesfully placed",Toast.LENGTH_SHORT).show()

                parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Market_Place_Layout::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }


            }
            else if(option == 2) {
                val upiId = "8830448351@ybl"
                val name = "Agri CONNECT"
                val note = "Product Name"
                val amount = "10.00"
                val uri = Uri.parse("upi://pay")
                    .buildUpon()
                    .appendQueryParameter("pa", upiId)
                    .appendQueryParameter("pn", name)
                    .appendQueryParameter("tn", note)
                    .appendQueryParameter("am", amount)
                    .appendQueryParameter("cu", "INR").build()
                val intent = Intent(Intent.ACTION_VIEW, uri)
                val chooser = Intent.createChooser(intent, "Pay with")
                if (chooser.resolveActivity(requireActivity().packageManager) != null) {
                    upiPaymentResultLauncher.launch(chooser)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "No UPI app found, please install one to continue",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        return binding.root


    }

    private val upiPaymentResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> if (result.resultCode == Activity.RESULT_OK || result.resultCode == 11) {
            result.data?.getStringExtra("response")?.let {
                if (it.contains("success")) {
                    Toast.makeText(requireContext(), "Transaction successful", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(requireContext(), "Transaction failed", Toast.LENGTH_SHORT).show()
                }
            } ?: run {
                Toast.makeText(requireContext(), "Transaction cancelled", Toast.LENGTH_SHORT).show()
            }
        }
         else {
             Toast.makeText(requireContext(), "Transaction failed or cancelled", Toast.LENGTH_SHORT).show()
         }
    }

//    fun paymentSetup(){
//
//        val additionalParamsMap = HashMap<Any, Any>()
//        additionalParamsMap[PayUCheckoutProConstants.CP_UDF1] = "udf1"
//        additionalParamsMap[PayUCheckoutProConstants.CP_UDF2] = "udf2"
//        additionalParamsMap[PayUCheckoutProConstants.CP_UDF3] = "udf3"
//        additionalParamsMap[PayUCheckoutProConstants.CP_UDF4] = "udf4"
//        additionalParamsMap[PayUCheckoutProConstants.CP_UDF5] = "udf5"
//        //to show saved sodexo card
//        additionalParamsMap[PayUCheckoutProConstants.SODEXO_SOURCE_ID] = "srcid123"
//        //to show ClossedLoop Wallet
//        additionalParamsMap[PayUCheckoutProConstants.WALLET_URN] = "<Wallet URN>"
//
//        val payUPaymentParams = PayUPaymentParams.Builder()
//            .setAmount("1.0")
//            .setIsProduction(true)
//            .setKey(key)
//            .setProductInfo("Macbook Pro")
//            .setPhone("8830448351")
//            .setTransactionId(System.currentTimeMillis().toString())
//            .setFirstName("John")
//            .setEmail("khatavkardhruva@gmail.com")
//            .setSurl("https://cbjs.payu.in/sdk/success") // This URL is used for Test Only
//                .setFurl("https://cbjs.payu.in/sdk/failure ") // This URL is used for Test Only
//            .setUserCredential("$key:john@yopmail.com")
//                .setAdditionalParams(additionalParamsMap)
//                .build()
//
//        PayUCheckoutPro.open(
//            this, payUPaymentParams,
//            object : PayUCheckoutProListener {
//
//
//                override fun onPaymentSuccess(response: Any) {
//                    response as HashMap<*, *>
//                    val payUResponse = response[PayUCheckoutProConstants.CP_PAYU_RESPONSE]
//                    val merchantResponse = response[PayUCheckoutProConstants.CP_MERCHANT_RESPONSE]
//                }
//
//
//                override fun onPaymentFailure(response: Any) {
//                    response as HashMap<*, *>
//                    val payUResponse = response[PayUCheckoutProConstants.CP_PAYU_RESPONSE]
//                    val merchantResponse = response[PayUCheckoutProConstants.CP_MERCHANT_RESPONSE]
//                }
//
//
//                override fun onPaymentCancel(isTxnInitiated:Boolean) {
//                }
//
//
//                override fun onError(errorResponse: ErrorResponse) {
//                    val errorMessage: String
//                    if (errorResponse != null && errorResponse.errorMessage != null && errorResponse.errorMessage!!.isNotEmpty())
//                        errorMessage = errorResponse.errorMessage!!
//                    else
//                        errorMessage = resources.getString(R.string.some_error_occurred)
//                }
//
//                override fun setWebViewProperties(webView: WebView?, bank: Any?) {
//                    //For setting webview properties, if any. Check Customized Integration section for more details on this
//                }
//
////                override fun generateHash(
////                    valueMap: HashMap,
////                    hashGenerationListener: PayUHashGenerationListener
////                ) {
////                    if ( valueMap.containsKey(CP_HASH_STRING)
////                        && valueMap.containsKey(CP_HASH_STRING) != null
////                        && valueMap.containsKey(CP_HASH_NAME)
////                        && valueMap.containsKey(CP_HASH_NAME) != null) {
////
////                        val hashData = valueMap[CP_HASH_STRING]
////                        val hashName = valueMap[CP_HASH_NAME]
////
////                        //Do not generate hash from local, it needs to be calculated from server side only. Here, hashString contains hash created from your server side.
////                        val hash: String? = HashGenerationUtils.generateHashFromSDK(
////                            hashData.toString(),
////                            ""
////                        )
////                        if (!TextUtils.isEmpty(hash)) {
////                            val dataMap: HashMap = HashMap()
////                            dataMap[hashName!!] = hash!!
////                            hashGenerationListener.onHashGenerated(dataMap)
////                        }
////                    }
////                }
//            })
//
//    }




}