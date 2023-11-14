package uz.asadbek.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.asadbek.myapplication.models.CourseData
import uz.asadbek.myapplication.models.CurrencyResponse
import uz.asadbek.myapplication.networking.ApiClient
import uz.asadbek.myapplication.networking.ApiService
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tv:TextView = findViewById(R.id.tv)
        val et:EditText = findViewById(R.id.et)
        val btn: Button = findViewById(R.id.btn)

        val tv2:TextView = findViewById(R.id.tv2)
        val et2:EditText = findViewById(R.id.et2)
        val btn2: Button = findViewById(R.id.btn2)

        val client = ApiClient
        val apiService = client.createApiService()



        val call: Call<List<CourseData>> = apiService.getAllCourse2()
        call.enqueue(object : Callback<List<CourseData>> {
            override fun onResponse(
                call: Call<List<CourseData>>,
                response: Response<List<CourseData>>
            ) {

                val currencyData = response.body()

                Log.d("leyla", currencyData?.find { it.Ccy == "USD" }.toString())

                val usdData = currencyData?.find { it.Ccy == "USD" };

//                val currencyNameUz = currencyData?.currencyNameUZ

                btn.setOnClickListener {
                    if (et.text != null) {
                        var sum = et.text.toString().toInt()
                        val usz = sum / usdData?.Rate!!.toDouble()
                        val decimalFormat = DecimalFormat("#.##")
                        tv.text = decimalFormat.format(usz)
                    }
                }

                btn2.setOnClickListener {
                    if (et2.text != null) {
                        var sum2 = et2.text.toString().toInt()
                        val usd = sum2 * usdData?.Rate!!.toDouble()
                        val decimalFormat = DecimalFormat("#.00")
                        tv2.text = decimalFormat.format(usd)
                    }
                }


            }

            override fun onFailure(
                call: Call<List<CourseData>>,
                t: Throwable
            ) {

            }

        })

    }
}