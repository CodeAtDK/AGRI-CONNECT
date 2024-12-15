package com.example.agriconnect.Weather_Forecast

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.New_Techniques.New_Farming_Teachniques
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentWeatherForecastBinding

import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Weather_Forecast : Fragment() {


    private var _binding: FragmentWeatherForecastBinding?=null
    private val binding get() = _binding!!

    var CITY: String = "Noida"
    val API: String = "API KEY" // Use API key

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

//        _binding = FragmentGovernmentSchemesBinding.inflate(inflater, container, false)
        _binding = FragmentWeatherForecastBinding.inflate(inflater,container,false)

//        MyViewModel.setData(binding.safsaf.text.toString())

//        MyViewMOdel.getData().observe(viewLifecycleOwner,{
//            binding.safsaf.setText(it)
//        })
//
//        binding.safsaf.setOnClickListener(){
//            Toast.makeText(this@Weather_Forecast.requireActivity(), "You clicked on item no. ", Toast.LENGTH_SHORT).show()
//
//        }


        weatherTask().execute()
        return binding.root


       // return inflater.inflate(R.layout.fragment_weather__forecast, container, false)
    }
    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
            binding.loader.visibility = View.VISIBLE
            binding.mainContainer.visibility = View.GONE
            binding.errorText.visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                Log.d("Tag City","$CITY")
                response = URL("https://api.openweathermap.org/data/2.5/forecast?q=$CITY&units=metric&appid=$API").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val list = jsonObj.getJSONArray("list")
                val main = list.getJSONObject(0).getJSONObject("main")
                val sys = jsonObj.getJSONObject("city")
                val wind = list.getJSONObject(0).getJSONObject("wind")
                val weather = list.getJSONObject(0).getJSONArray("weather").getJSONObject(0)

                val updatedAt: Long = list.getJSONObject(0).getLong("dt")
                val updatedAtText = "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                    Date(updatedAt * 1000)
                )
                val temp = main.getString("temp") + "°C"
               // val tempMin = "Min Temp: " + main.getString("temp_min") + "°C"
               // val tempMax = "Max Temp: " + main.getString("temp_max") + "°C"
                val tempMin = "Feels Like: " + main.getString("feels_like") + "°C"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")

                val sunrise: Long = sys.getLong("sunrise")
                val sunset: Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getJSONObject("city").getString("name") + ", " + sys.getString("country")
                Log.d("Tag", "$updatedAt\n $updatedAtText")
                Toast.makeText(this@Weather_Forecast.requireActivity(), "$updatedAt\n$updatedAtText", Toast.LENGTH_SHORT).show()

                for(i in 0 until list.length()){

                    println(i)

                    val day1 = list.getJSONObject(i)
                    val object1 = day1.getJSONObject("main")
                    val temp1 = object1.getString("temp") + "°C"
                    val weather1 = day1.getJSONArray("weather").getJSONObject(0)
//                    val weather1 = list.getJSONObject(i).getJSONArray("weather").getJSONObject(i)

                    val humidity1 = object1.getString("humidity")

                    val weatherdiscription1 = weather1.getString("main")

                    val date = day1.getString("dt_txt")
                    val updatedAt1 = day1.getLong("dt")
                    val time = SimpleDateFormat("hh:mm",Locale.ENGLISH).format(Date(updatedAt1*1000))
                    //val datetext = SimpleDateFormat("dd/MM",Locale.ENGLISH).format(Date(date*1000))

                    when(i){

                        0 -> {
                            binding.Temp11.text = temp1
                            binding.Time1.text = time
                            binding.humidity1.text = humidity1
                            weatherImageUpdate(weatherDescription,binding.Imageofweather)
                        }

                        1 -> {
                            binding.weather1.text = weatherdiscription1
                            binding.temp1.text = temp1
                            binding.date1.text = date

                            binding.Temp12.text = temp1
                            binding.Time2.text = time
                            binding.humidity2.text = humidity1
                            weatherImageUpdate(weatherDescription,binding.Imageofweather2)
                        }
                        2 ->{
                            binding.Temp13.text = temp1
                            binding.Time3.text = time
                            binding.humidity3.text = humidity1
                            weatherImageUpdate(weatherDescription,binding.Imageofweather3)
                        }
                        3 ->{
                            binding.Temp14.text = temp1
                            binding.Time4.text = time
                            binding.humidity4.text = humidity1
                            weatherImageUpdate(weatherDescription,binding.Imageofweather4)
                        }
                        4 ->{
                            binding.Temp15.text = temp1
                            binding.Time5.text = time
                            binding.humidity5.text = humidity1
                            weatherImageUpdate(weatherDescription,binding.Imageofweather5)
                        }
                        8 -> {
                            binding.weather2.text = weatherdiscription1
                            binding.temp2.text = temp1
                            binding.date2.text = date
                        }
                        16 -> {
                            binding.weather3.text = weatherdiscription1
                            binding.temp3.text = temp1
                            binding.date3.text = date
                        }
                        24 -> {
                            binding.weather4.text = weatherdiscription1
                            binding.temp4.text = temp1
                            binding.date4.text = date
                        }
                        32 -> {
                            binding.weather5.text = weatherdiscription1
                            binding.temp5.text = temp1
                            binding.date5.text = date
                        }
                        39 -> {
                            binding.weather6.text = weatherdiscription1
                            binding.temp6.text = temp1
                            binding.date6.text = date
                        }


                    }


//                    println(day1)
                    println(temp1)
                    println(weatherdiscription1)
//
                }


                /* Populating extracted data into our views */
                binding.address.text = address
                binding.updatedAt.text = updatedAtText
                binding.status.text = weatherDescription.capitalize()
                binding.temp.text = temp
                binding.tempMin.text = tempMin
                //binding.tempMax.text = tempMax
                //binding.tempFeelsLike.text = tempFeelsLike
                binding.sunrise.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
                binding.sunset.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
                binding.wind.text = windSpeed
                binding.pressure.text = pressure
                binding.humidity.text = humidity

                /* Views populated, Hiding the loader, Showing the main design */
                binding.loader.visibility = View.GONE
                binding.mainContainer.visibility = View.VISIBLE

            } catch (e: Exception) {
                binding.loader.visibility = View.GONE
                binding.errorText.visibility = View.VISIBLE
            }
        }

        private fun weatherImageUpdate(weatherDescription: String, imageofweather: ImageView) {


            Log.d("WeatherDescription","$weatherDescription")

            if(weatherDescription == "clear sky"){
                imageofweather.setImageResource(R.drawable.sun2)
            }else{
                imageofweather.setImageResource(R.drawable.suncloud)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){

            override fun handleOnBackPressed() {

//                if(parentFragmentManager.findFragmentById(R.id.fragment_container) is Home) {
                    Log.d("Tag","${parentFragmentManager.findFragmentById(R.id.fragment_container)}")
//
//
//                }

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        Home::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }

            }
        })
    }

}